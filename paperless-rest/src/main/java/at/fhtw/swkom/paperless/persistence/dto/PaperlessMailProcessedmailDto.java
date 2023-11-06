package at.fhtw.swkom.paperless.persistence.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.time.OffsetDateTime;
import java.util.Objects;

/**
 * DTO for {@link at.fhtw.swkom.paperless.persistence.model.PaperlessMailProcessedmail}
 */
public class PaperlessMailProcessedmailDto implements Serializable {
    private final Integer id;
    @NotNull
    @Size(max = 256)
    private final String folder;
    @NotNull
    @Size(max = 256)
    private final String uid;
    @NotNull
    @Size(max = 256)
    private final String subject;
    @NotNull
    private final OffsetDateTime received;
    @NotNull
    private final OffsetDateTime processed;
    @NotNull
    @Size(max = 256)
    private final String status;
    private final String error;
    private final AuthUserDto owner;
    @NotNull
    private final PaperlessMailMailruleDto rule;

    public PaperlessMailProcessedmailDto(Integer id, String folder, String uid, String subject, OffsetDateTime received, OffsetDateTime processed, String status, String error, AuthUserDto owner, PaperlessMailMailruleDto rule) {
        this.id = id;
        this.folder = folder;
        this.uid = uid;
        this.subject = subject;
        this.received = received;
        this.processed = processed;
        this.status = status;
        this.error = error;
        this.owner = owner;
        this.rule = rule;
    }

    public Integer getId() {
        return id;
    }

    public String getFolder() {
        return folder;
    }

    public String getUid() {
        return uid;
    }

    public String getSubject() {
        return subject;
    }

    public OffsetDateTime getReceived() {
        return received;
    }

    public OffsetDateTime getProcessed() {
        return processed;
    }

    public String getStatus() {
        return status;
    }

    public String getError() {
        return error;
    }

    public AuthUserDto getOwner() {
        return owner;
    }

    public PaperlessMailMailruleDto getRule() {
        return rule;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PaperlessMailProcessedmailDto entity = (PaperlessMailProcessedmailDto) o;
        return Objects.equals(this.id, entity.id) &&
                Objects.equals(this.folder, entity.folder) &&
                Objects.equals(this.uid, entity.uid) &&
                Objects.equals(this.subject, entity.subject) &&
                Objects.equals(this.received, entity.received) &&
                Objects.equals(this.processed, entity.processed) &&
                Objects.equals(this.status, entity.status) &&
                Objects.equals(this.error, entity.error) &&
                Objects.equals(this.owner, entity.owner) &&
                Objects.equals(this.rule, entity.rule);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, folder, uid, subject, received, processed, status, error, owner, rule);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "id = " + id + ", " +
                "folder = " + folder + ", " +
                "uid = " + uid + ", " +
                "subject = " + subject + ", " +
                "received = " + received + ", " +
                "processed = " + processed + ", " +
                "status = " + status + ", " +
                "error = " + error + ", " +
                "owner = " + owner + ", " +
                "rule = " + rule + ")";
    }
}