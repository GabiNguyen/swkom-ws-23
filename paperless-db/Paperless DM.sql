create table auth_group
(
    id   serial
        primary key,
    name varchar(150) not null
        unique
);

alter table auth_group
    owner to paperless;

create index auth_group_name_a6ea08ec_like
    on auth_group (name varchar_pattern_ops);



create table auth_user
(
    id           serial
        primary key,
    password     varchar(128)             not null,
    last_login   timestamp with time zone,
    is_superuser boolean                  not null,
    username     varchar(150)             not null
        unique,
    first_name   varchar(150)             not null,
    last_name    varchar(150)             not null,
    email        varchar(254)             not null,
    is_staff     boolean                  not null,
    is_active    boolean                  not null,
    date_joined  timestamp with time zone not null
);

alter table auth_user
    owner to paperless;

create index auth_user_username_6821ab7c_like
    on auth_user (username varchar_pattern_ops);



create table auth_user_groups
(
    id       serial
        primary key,
    user_id  integer not null
        constraint auth_user_groups_user_id_6a12ed8b_fk_auth_user_id
            references auth_user
            deferrable initially deferred,
    group_id integer not null
        constraint auth_user_groups_group_id_97559544_fk_auth_group_id
            references auth_group
            deferrable initially deferred,
    constraint auth_user_groups_user_id_group_id_94350c0c_uniq
        unique (user_id, group_id)
);

alter table auth_user_groups
    owner to paperless;

create index auth_user_groups_user_id_6a12ed8b
    on auth_user_groups (user_id);

create index auth_user_groups_group_id_97559544
    on auth_user_groups (group_id);


create table documents_log
(
    id      serial
        primary key,
    "group" uuid,
    message text                     not null,
    level   integer                  not null
        constraint documents_log_level_check
            check (level >= 0),
    created timestamp with time zone not null
);

alter table documents_log
    owner to paperless;



create table documents_correspondent
(
    id                 serial
        constraint documents_sender_pkey
            primary key,
    name               varchar(128) not null,
    match              varchar(256) not null,
    matching_algorithm integer      not null
        constraint documents_correspondent_matching_algorithm_check
            check (matching_algorithm >= 0),
    is_insensitive     boolean      not null,
    owner_id           integer
        constraint documents_correspondent_owner_id_078f7f8a_fk_auth_user_id
            references auth_user
            deferrable initially deferred,
    constraint documents_correspondent_unique_name_owner
        unique (name, owner_id)
);

alter table documents_correspondent
    owner to paperless;

create index documents_sender_name_18997c37_like
    on documents_correspondent (name varchar_pattern_ops);

create index documents_correspondent_owner_id_078f7f8a
    on documents_correspondent (owner_id);

create unique index documents_correspondent_name_uniq
    on documents_correspondent (name)
    where (owner_id IS NULL);



create table documents_documenttype
(
    id                 serial
        primary key,
    name               varchar(128) not null,
    match              varchar(256) not null,
    matching_algorithm integer      not null
        constraint documents_documenttype_matching_algorithm_check
            check (matching_algorithm >= 0),
    is_insensitive     boolean      not null,
    owner_id           integer
        constraint documents_documenttype_owner_id_a19f201d_fk_auth_user_id
            references auth_user
            deferrable initially deferred,
    constraint documents_documenttype_unique_name_owner
        unique (name, owner_id)
);

alter table documents_documenttype
    owner to paperless;

create index documents_documenttype_owner_id_a19f201d
    on documents_documenttype (owner_id);

create unique index documents_documenttype_name_uniq
    on documents_documenttype (name)
    where (owner_id IS NULL);



create table documents_storagepath
(
    id                 serial
        primary key,
    name               varchar(128) not null,
    match              varchar(256) not null,
    matching_algorithm integer      not null
        constraint documents_storagepath_matching_algorithm_check
            check (matching_algorithm >= 0),
    is_insensitive     boolean      not null,
    path               varchar(512) not null,
    owner_id           integer
        constraint documents_storagepath_owner_id_c8f01fe8_fk_auth_user_id
            references auth_user
            deferrable initially deferred,
    constraint documents_storagepath_unique_name_owner
        unique (name, owner_id)
);

alter table documents_storagepath
    owner to paperless;

create index documents_storagepath_owner_id_c8f01fe8
    on documents_storagepath (owner_id);

create unique index documents_storagepath_name_uniq
    on documents_storagepath (name)
    where (owner_id IS NULL);



create table documents_tag
(
    id                 serial
        primary key,
    name               varchar(128) not null,
    match              varchar(256) not null,
    matching_algorithm integer      not null
        constraint documents_tag_matching_algorithm_check
            check (matching_algorithm >= 0),
    is_insensitive     boolean      not null,
    is_inbox_tag       boolean      not null,
    color              varchar(7)   not null,
    owner_id           integer
        constraint documents_tag_owner_id_f0875d77_fk_auth_user_id
            references auth_user
            deferrable initially deferred,
    constraint documents_tag_unique_name_owner
        unique (name, owner_id)
);

alter table documents_tag
    owner to paperless;

create index documents_tag_owner_id_f0875d77
    on documents_tag (owner_id);

create unique index documents_tag_name_uniq
    on documents_tag (name)
    where (owner_id IS NULL);


create table documents_uisettings
(
    id       serial
        primary key,
    settings jsonb,
    user_id  integer not null
        unique
        constraint documents_uisettings_user_id_2df2adc2_fk_auth_user_id
            references auth_user
            deferrable initially deferred
);

alter table documents_uisettings
    owner to paperless;



create table documents_paperlesstask
(
    id             serial
        primary key,
    task_id        varchar(255) not null
        constraint documents_paperlesstask_task_id_24b393f9_uniq
            unique,
    acknowledged   boolean      not null,
    date_created   timestamp with time zone,
    date_done      timestamp with time zone,
    date_started   timestamp with time zone,
    result         text,
    status         varchar(30)  not null,
    task_file_name varchar(255),
    task_name      varchar(255)
);

alter table documents_paperlesstask
    owner to paperless;

create index documents_paperlesstask_task_id_24b393f9_like
    on documents_paperlesstask (task_id varchar_pattern_ops);



create table documents_savedview
(
    id                serial
        primary key,
    name              varchar(128) not null,
    show_on_dashboard boolean      not null,
    show_in_sidebar   boolean      not null,
    sort_field        varchar(128),
    sort_reverse      boolean      not null,
    owner_id          integer
        constraint documents_savedview_owner_id_2df222ee_fk_auth_user_id
            references auth_user
            deferrable initially deferred
);

alter table documents_savedview
    owner to paperless;

create index documents_savedview_user_id_48baf272
    on documents_savedview (owner_id);



create table documents_savedviewfilterrule
(
    id            serial
        primary key,
    rule_type     integer not null
        constraint documents_savedviewfilterrule_rule_type_check
            check (rule_type >= 0),
    value         varchar(255),
    saved_view_id integer not null
        constraint documents_savedviewf_saved_view_id_038e2c89_fk_documents
            references documents_savedview
            deferrable initially deferred
);

alter table documents_savedviewfilterrule
    owner to paperless;

create index documents_savedviewfilterrule_saved_view_id_038e2c89
    on documents_savedviewfilterrule (saved_view_id);



create sequence documents_sender_id_seq;

alter sequence documents_sender_id_seq owner to paperless;

alter sequence documents_sender_id_seq owned by documents_correspondent.id;


create table paperless_mail_mailaccount
(
    id            serial
        primary key,
    name          varchar(256)  not null
        unique,
    imap_server   varchar(256)  not null,
    imap_port     integer,
    imap_security integer       not null
        constraint paperless_mail_mailaccount_imap_security_check
            check (imap_security >= 0),
    username      varchar(256)  not null,
    password      varchar(2048) not null,
    character_set varchar(256)  not null,
    owner_id      integer
        constraint paperless_mail_mailaccount_owner_id_a894e5ee_fk_auth_user_id
            references auth_user
            deferrable initially deferred,
    is_token      boolean       not null
);

alter table paperless_mail_mailaccount
    owner to paperless;

create index paperless_mail_mailaccount_name_6af0ff82_like
    on paperless_mail_mailaccount (name varchar_pattern_ops);

create index paperless_mail_mailaccount_owner_id_a894e5ee
    on paperless_mail_mailaccount (owner_id);



create table documents_document
(
    id                    serial
        primary key,
    title                 varchar(128)             not null,
    content               text                     not null,
    created               timestamp with time zone not null,
    modified              timestamp with time zone not null,
    correspondent_id      integer
        constraint documents_document_correspondent_id_6164eb0c_fk_documents
            references documents_correspondent
            deferrable initially deferred,
    checksum              varchar(32)              not null
        constraint documents_document_checksum_75209391_uniq
            unique,
    added                 timestamp with time zone not null,
    storage_type          varchar(11)              not null,
    filename              varchar(1024)
        constraint documents_document_filename_3ee5ad97_uniq
            unique,
    archive_serial_number integer
        unique
        constraint documents_document_archive_serial_number_550aa63f_check
            check (archive_serial_number >= 0),
    document_type_id      integer
        constraint documents_document_document_type_id_1f88b50c_fk_documents
            references documents_documenttype
            deferrable initially deferred,
    mime_type             varchar(256)             not null,
    archive_checksum      varchar(32),
    archive_filename      varchar(1024)
        unique,
    storage_path_id       integer
        constraint documents_document_storage_path_id_07d27bdb_fk_documents
            references documents_storagepath
            deferrable initially deferred,
    original_filename     varchar(1024),
    owner_id              integer
        constraint documents_document_owner_id_04d2b723_fk_auth_user_id
            references auth_user
            deferrable initially deferred
);

alter table documents_document
    owner to paperless;

create index documents_document_title_6b08e02a
    on documents_document (title);

create index documents_document_title_6b08e02a_like
    on documents_document (title varchar_pattern_ops);

create index documents_document_sender_id_950512b2
    on documents_document (correspondent_id);

create index documents_document_created_bedd0818
    on documents_document (created);

create index documents_document_modified_2eae15bc
    on documents_document (modified);

create index documents_document_checksum_75209391_like
    on documents_document (checksum varchar_pattern_ops);

create index documents_document_added_28cfa360
    on documents_document (added);

create index documents_document_document_type_id_1f88b50c
    on documents_document (document_type_id);

create index documents_document_filename_3ee5ad97_like
    on documents_document (filename varchar_pattern_ops);

create index documents_document_archive_filename_fc3cb023_like
    on documents_document (archive_filename varchar_pattern_ops);

create index documents_document_storage_path_id_07d27bdb
    on documents_document (storage_path_id);

create index documents_document_owner_id_04d2b723
    on documents_document (owner_id);



create table documents_note
(
    id          serial
        constraint documents_comment_pkey
            primary key,
    note        text                     not null,
    created     timestamp with time zone not null,
    document_id integer
        constraint documents_comment_document_id_3f5d21c7_fk_documents_document_id
            references documents_document
            deferrable initially deferred,
    user_id     integer
        constraint documents_comment_user_id_c281d4d5_fk_auth_user_id
            references auth_user
            deferrable initially deferred
);

alter table documents_note
    owner to paperless;

create index documents_comment_created_dd512b3b
    on documents_note (created);

create index documents_comment_document_id_3f5d21c7
    on documents_note (document_id);

create index documents_comment_user_id_c281d4d5
    on documents_note (user_id);



create table paperless_mail_mailrule
(
    id                         serial
        primary key,
    name                       varchar(256) not null
        constraint paperless_mail_mailrule_name_ee9b53bd_uniq
            unique,
    folder                     varchar(256) not null,
    filter_from                varchar(256),
    filter_subject             varchar(256),
    filter_body                varchar(256),
    maximum_age                integer      not null
        constraint paperless_mail_mailrule_maximum_age_check
            check (maximum_age >= 0),
    action                     integer      not null
        constraint paperless_mail_mailrule_action_check
            check (action >= 0),
    action_parameter           varchar(256),
    assign_title_from          integer      not null
        constraint paperless_mail_mailrule_assign_title_from_check
            check (assign_title_from >= 0),
    assign_correspondent_from  integer      not null
        constraint paperless_mail_mailrule_assign_correspondent_from_check
            check (assign_correspondent_from >= 0),
    account_id                 integer      not null
        constraint paperless_mail_mailr_account_id_461903f4_fk_paperless
            references paperless_mail_mailaccount
            deferrable initially deferred,
    assign_correspondent_id    integer
        constraint paperless_mail_mailr_assign_correspondent_d2651486_fk_documents
            references documents_correspondent
            deferrable initially deferred,
    assign_document_type_id    integer
        constraint paperless_mail_mailr_assign_document_type_cb809476_fk_documents
            references documents_documenttype
            deferrable initially deferred,
    "order"                    integer      not null,
    attachment_type            integer      not null
        constraint paperless_mail_mailrule_attachment_type_check
            check (attachment_type >= 0),
    filter_attachment_filename varchar(256),
    consumption_scope          integer      not null
        constraint paperless_mail_mailrule_consumption_scope_check
            check (consumption_scope >= 0),
    owner_id                   integer
        constraint paperless_mail_mailrule_owner_id_05d1c50f_fk_auth_user_id
            references auth_user
            deferrable initially deferred,
    filter_to                  varchar(256)
);

alter table paperless_mail_mailrule
    owner to paperless;

create index paperless_mail_mailrule_account_id_461903f4
    on paperless_mail_mailrule (account_id);

create index paperless_mail_mailrule_assign_correspondent_id_d2651486
    on paperless_mail_mailrule (assign_correspondent_id);

create index paperless_mail_mailrule_assign_document_type_id_cb809476
    on paperless_mail_mailrule (assign_document_type_id);

create index paperless_mail_mailrule_name_ee9b53bd_like
    on paperless_mail_mailrule (name varchar_pattern_ops);

create index paperless_mail_mailrule_owner_id_05d1c50f
    on paperless_mail_mailrule (owner_id);



create sequence documents_comment_id_seq;

alter sequence documents_comment_id_seq owner to paperless;

alter sequence documents_comment_id_seq owned by documents_note.id;



create table documents_document_tags
(
    id          serial
        primary key,
    document_id integer not null
        constraint documents_document_t_document_id_006f35a8_fk_documents
            references documents_document
            deferrable initially deferred,
    tag_id      integer not null
        constraint documents_document_tags_tag_id_4f4a71e9_fk_documents_tag_id
            references documents_tag
            deferrable initially deferred,
    constraint documents_document_tags_document_id_tag_id_07e90502_uniq
        unique (document_id, tag_id)
);

alter table documents_document_tags
    owner to paperless;

create index documents_document_tags_document_id_006f35a8
    on documents_document_tags (document_id);

create index documents_document_tags_tag_id_4f4a71e9
    on documents_document_tags (tag_id);



create table auth_permission
(
    id              serial
        primary key,
    name            varchar(255) not null,
    content_type    varchar(100) not null,
    codename        varchar(100) not null,
    constraint auth_permission_content_type_id_codename_01ab375a_uniq
        unique (content_type, codename)
);

alter table auth_permission
    owner to paperless;

create index auth_permission_content_type_id_2f476e4b
    on auth_permission (content_type);


create table auth_group_permissions
(
    id            serial
        primary key,
    group_id      integer not null
        constraint auth_group_permissions_group_id_b120cbf9_fk_auth_group_id
            references auth_group
            deferrable initially deferred,
    permission_id integer not null
        constraint auth_group_permissio_permission_id_84c5c92e_fk_auth_perm
            references auth_permission
            deferrable initially deferred,
    constraint auth_group_permissions_group_id_permission_id_0cd325b0_uniq
        unique (group_id, permission_id)
);

alter table auth_group_permissions
    owner to paperless;

create index auth_group_permissions_group_id_b120cbf9
    on auth_group_permissions (group_id);

create index auth_group_permissions_permission_id_84c5c92e
    on auth_group_permissions (permission_id);


create table auth_user_user_permissions
(
    id            serial
        primary key,
    user_id       integer not null
        constraint auth_user_user_permissions_user_id_a95ead1b_fk_auth_user_id
            references auth_user
            deferrable initially deferred,
    permission_id integer not null
        constraint auth_user_user_permi_permission_id_1fbb5f2c_fk_auth_perm
            references auth_permission
            deferrable initially deferred,
    constraint auth_user_user_permissions_user_id_permission_id_14a6b632_uniq
        unique (user_id, permission_id)
);

alter table auth_user_user_permissions
    owner to paperless;

create index auth_user_user_permissions_user_id_a95ead1b
    on auth_user_user_permissions (user_id);

create index auth_user_user_permissions_permission_id_1fbb5f2c
    on auth_user_user_permissions (permission_id);


create table authtoken_token
(
    key     varchar(40)              not null
        primary key,
    created timestamp with time zone not null,
    user_id integer                  not null
        unique
        constraint authtoken_token_user_id_35299eff_fk_auth_user_id
            references auth_user
            deferrable initially deferred
);

alter table authtoken_token
    owner to paperless;

create index authtoken_token_key_10f0b77e_like
    on authtoken_token (key varchar_pattern_ops);


create table paperless_mail_processedmail
(
    id        serial
        primary key,
    folder    varchar(256)             not null,
    uid       varchar(256)             not null,
    subject   varchar(256)             not null,
    received  timestamp with time zone not null,
    processed timestamp with time zone not null,
    status    varchar(256)             not null,
    error     text,
    owner_id  integer
        constraint paperless_mail_processedmail_owner_id_63d8ece4_fk_auth_user_id
            references auth_user
            deferrable initially deferred,
    rule_id   integer                  not null
        constraint paperless_mail_proce_rule_id_55bb3322_fk_paperless
            references paperless_mail_mailrule
            deferrable initially deferred
);

alter table paperless_mail_processedmail
    owner to paperless;

create index paperless_mail_processedmail_owner_id_63d8ece4
    on paperless_mail_processedmail (owner_id);

create index paperless_mail_processedmail_rule_id_55bb3322
    on paperless_mail_processedmail (rule_id);



create table paperless_mail_mailrule_assign_tags
(
    id          serial
        primary key,
    mailrule_id integer not null
        constraint paperless_mail_mailr_mailrule_id_80d0b16c_fk_paperless
            references paperless_mail_mailrule
            deferrable initially deferred,
    tag_id      integer not null
        constraint paperless_mail_mailr_tag_id_4d0ac8d5_fk_documents
            references documents_tag
            deferrable initially deferred,
    constraint paperless_mail_mailrule__mailrule_id_tag_id_0960fdac_uniq
        unique (mailrule_id, tag_id)
);

alter table paperless_mail_mailrule_assign_tags
    owner to paperless;

create index paperless_mail_mailrule_assign_tags_mailrule_id_80d0b16c
    on paperless_mail_mailrule_assign_tags (mailrule_id);

create index paperless_mail_mailrule_assign_tags_tag_id_4d0ac8d5
    on paperless_mail_mailrule_assign_tags (tag_id);


