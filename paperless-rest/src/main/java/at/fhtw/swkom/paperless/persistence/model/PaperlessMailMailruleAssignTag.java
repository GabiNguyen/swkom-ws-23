package at.fhtw.swkom.paperless.persistence.model;

import javax.persistence.*;

@Entity
@Table(name = "paperless_mail_mailrule_assign_tags")
public class PaperlessMailMailruleAssignTag {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @javax.validation.constraints.NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "mailrule_id", nullable = false)
    private PaperlessMailMailrule mailrule;

    @javax.validation.constraints.NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "tag_id", nullable = false)
    private DocumentsTag tag;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public PaperlessMailMailrule getMailrule() {
        return mailrule;
    }

    public void setMailrule(PaperlessMailMailrule mailrule) {
        this.mailrule = mailrule;
    }

    public DocumentsTag getTag() {
        return tag;
    }

    public void setTag(DocumentsTag tag) {
        this.tag = tag;
    }

}