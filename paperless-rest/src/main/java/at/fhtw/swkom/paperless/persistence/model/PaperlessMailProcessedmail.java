package at.fhtw.swkom.paperless.persistence.model;

import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.time.OffsetDateTime;

@Entity
@Table(name = "paperless_mail_processedmail")
public class PaperlessMailProcessedmail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @javax.validation.constraints.Size(max = 256)
    @javax.validation.constraints.NotNull
    @Column(name = "folder", nullable = false, length = 256)
    private String folder;

    @javax.validation.constraints.Size(max = 256)
    @javax.validation.constraints.NotNull
    @Column(name = "uid", nullable = false, length = 256)
    private String uid;

    @javax.validation.constraints.Size(max = 256)
    @javax.validation.constraints.NotNull
    @Column(name = "subject", nullable = false, length = 256)
    private String subject;

    @javax.validation.constraints.NotNull
    @Column(name = "received", nullable = false)
    private OffsetDateTime received;

    @javax.validation.constraints.NotNull
    @Column(name = "processed", nullable = false)
    private OffsetDateTime processed;

    @javax.validation.constraints.Size(max = 256)
    @javax.validation.constraints.NotNull
    @Column(name = "status", nullable = false, length = 256)
    private String status;

    @Column(name = "error")
    @Type(type = "org.hibernate.type.TextType")
    private String error;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "owner_id")
    private AuthUser owner;

    @javax.validation.constraints.NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "rule_id", nullable = false)
    private PaperlessMailMailrule rule;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFolder() {
        return folder;
    }

    public void setFolder(String folder) {
        this.folder = folder;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public OffsetDateTime getReceived() {
        return received;
    }

    public void setReceived(OffsetDateTime received) {
        this.received = received;
    }

    public OffsetDateTime getProcessed() {
        return processed;
    }

    public void setProcessed(OffsetDateTime processed) {
        this.processed = processed;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public AuthUser getOwner() {
        return owner;
    }

    public void setOwner(AuthUser owner) {
        this.owner = owner;
    }

    public PaperlessMailMailrule getRule() {
        return rule;
    }

    public void setRule(PaperlessMailMailrule rule) {
        this.rule = rule;
    }

}