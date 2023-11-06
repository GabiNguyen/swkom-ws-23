package at.fhtw.swkom.paperless.persistence.model;

import javax.persistence.*;

@Entity
@Table(name = "paperless_mail_mailrule")
public class PaperlessMailMailrule {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @javax.validation.constraints.Size(max = 256)
    @javax.validation.constraints.NotNull
    @Column(name = "name", nullable = false, length = 256)
    private String name;

    @javax.validation.constraints.Size(max = 256)
    @javax.validation.constraints.NotNull
    @Column(name = "folder", nullable = false, length = 256)
    private String folder;

    @javax.validation.constraints.Size(max = 256)
    @Column(name = "filter_from", length = 256)
    private String filterFrom;

    @javax.validation.constraints.Size(max = 256)
    @Column(name = "filter_subject", length = 256)
    private String filterSubject;

    @javax.validation.constraints.Size(max = 256)
    @Column(name = "filter_body", length = 256)
    private String filterBody;

    @javax.validation.constraints.NotNull
    @Column(name = "maximum_age", nullable = false)
    private Integer maximumAge;

    @javax.validation.constraints.NotNull
    @Column(name = "action", nullable = false)
    private Integer action;

    @javax.validation.constraints.Size(max = 256)
    @Column(name = "action_parameter", length = 256)
    private String actionParameter;

    @javax.validation.constraints.NotNull
    @Column(name = "assign_title_from", nullable = false)
    private Integer assignTitleFrom;

    @javax.validation.constraints.NotNull
    @Column(name = "assign_correspondent_from", nullable = false)
    private Integer assignCorrespondentFrom;

    @javax.validation.constraints.NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "account_id", nullable = false)
    private PaperlessMailMailaccount account;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "assign_correspondent_id")
    private DocumentsCorrespondent assignCorrespondent;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "assign_document_type_id")
    private DocumentsDocumenttype assignDocumentType;

    @javax.validation.constraints.NotNull
    @Column(name = "\"order\"", nullable = false)
    private Integer order;

    @javax.validation.constraints.NotNull
    @Column(name = "attachment_type", nullable = false)
    private Integer attachmentType;

    @javax.validation.constraints.Size(max = 256)
    @Column(name = "filter_attachment_filename", length = 256)
    private String filterAttachmentFilename;

    @javax.validation.constraints.NotNull
    @Column(name = "consumption_scope", nullable = false)
    private Integer consumptionScope;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "owner_id")
    private AuthUser owner;

    @javax.validation.constraints.Size(max = 256)
    @Column(name = "filter_to", length = 256)
    private String filterTo;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFolder() {
        return folder;
    }

    public void setFolder(String folder) {
        this.folder = folder;
    }

    public String getFilterFrom() {
        return filterFrom;
    }

    public void setFilterFrom(String filterFrom) {
        this.filterFrom = filterFrom;
    }

    public String getFilterSubject() {
        return filterSubject;
    }

    public void setFilterSubject(String filterSubject) {
        this.filterSubject = filterSubject;
    }

    public String getFilterBody() {
        return filterBody;
    }

    public void setFilterBody(String filterBody) {
        this.filterBody = filterBody;
    }

    public Integer getMaximumAge() {
        return maximumAge;
    }

    public void setMaximumAge(Integer maximumAge) {
        this.maximumAge = maximumAge;
    }

    public Integer getAction() {
        return action;
    }

    public void setAction(Integer action) {
        this.action = action;
    }

    public String getActionParameter() {
        return actionParameter;
    }

    public void setActionParameter(String actionParameter) {
        this.actionParameter = actionParameter;
    }

    public Integer getAssignTitleFrom() {
        return assignTitleFrom;
    }

    public void setAssignTitleFrom(Integer assignTitleFrom) {
        this.assignTitleFrom = assignTitleFrom;
    }

    public Integer getAssignCorrespondentFrom() {
        return assignCorrespondentFrom;
    }

    public void setAssignCorrespondentFrom(Integer assignCorrespondentFrom) {
        this.assignCorrespondentFrom = assignCorrespondentFrom;
    }

    public PaperlessMailMailaccount getAccount() {
        return account;
    }

    public void setAccount(PaperlessMailMailaccount account) {
        this.account = account;
    }

    public DocumentsCorrespondent getAssignCorrespondent() {
        return assignCorrespondent;
    }

    public void setAssignCorrespondent(DocumentsCorrespondent assignCorrespondent) {
        this.assignCorrespondent = assignCorrespondent;
    }

    public DocumentsDocumenttype getAssignDocumentType() {
        return assignDocumentType;
    }

    public void setAssignDocumentType(DocumentsDocumenttype assignDocumentType) {
        this.assignDocumentType = assignDocumentType;
    }

    public Integer getOrder() {
        return order;
    }

    public void setOrder(Integer order) {
        this.order = order;
    }

    public Integer getAttachmentType() {
        return attachmentType;
    }

    public void setAttachmentType(Integer attachmentType) {
        this.attachmentType = attachmentType;
    }

    public String getFilterAttachmentFilename() {
        return filterAttachmentFilename;
    }

    public void setFilterAttachmentFilename(String filterAttachmentFilename) {
        this.filterAttachmentFilename = filterAttachmentFilename;
    }

    public Integer getConsumptionScope() {
        return consumptionScope;
    }

    public void setConsumptionScope(Integer consumptionScope) {
        this.consumptionScope = consumptionScope;
    }

    public AuthUser getOwner() {
        return owner;
    }

    public void setOwner(AuthUser owner) {
        this.owner = owner;
    }

    public String getFilterTo() {
        return filterTo;
    }

    public void setFilterTo(String filterTo) {
        this.filterTo = filterTo;
    }

}