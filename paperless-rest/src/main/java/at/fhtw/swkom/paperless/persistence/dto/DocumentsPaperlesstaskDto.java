package at.fhtw.swkom.paperless.persistence.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.time.OffsetDateTime;
import java.util.Objects;

/**
 * DTO for {@link at.fhtw.swkom.paperless.persistence.model.DocumentsPaperlesstask}
 */
public class DocumentsPaperlesstaskDto implements Serializable {
    private final Integer id;
    @NotNull
    @Size(max = 255)
    private final String taskId;
    @NotNull
    private final Boolean acknowledged;
    private final OffsetDateTime dateCreated;
    private final OffsetDateTime dateDone;
    private final OffsetDateTime dateStarted;
    private final String result;
    @NotNull
    @Size(max = 30)
    private final String status;
    @Size(max = 255)
    private final String taskFileName;
    @Size(max = 255)
    private final String taskName;

    public DocumentsPaperlesstaskDto(Integer id, String taskId, Boolean acknowledged, OffsetDateTime dateCreated, OffsetDateTime dateDone, OffsetDateTime dateStarted, String result, String status, String taskFileName, String taskName) {
        this.id = id;
        this.taskId = taskId;
        this.acknowledged = acknowledged;
        this.dateCreated = dateCreated;
        this.dateDone = dateDone;
        this.dateStarted = dateStarted;
        this.result = result;
        this.status = status;
        this.taskFileName = taskFileName;
        this.taskName = taskName;
    }

    public Integer getId() {
        return id;
    }

    public String getTaskId() {
        return taskId;
    }

    public Boolean getAcknowledged() {
        return acknowledged;
    }

    public OffsetDateTime getDateCreated() {
        return dateCreated;
    }

    public OffsetDateTime getDateDone() {
        return dateDone;
    }

    public OffsetDateTime getDateStarted() {
        return dateStarted;
    }

    public String getResult() {
        return result;
    }

    public String getStatus() {
        return status;
    }

    public String getTaskFileName() {
        return taskFileName;
    }

    public String getTaskName() {
        return taskName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DocumentsPaperlesstaskDto entity = (DocumentsPaperlesstaskDto) o;
        return Objects.equals(this.id, entity.id) &&
                Objects.equals(this.taskId, entity.taskId) &&
                Objects.equals(this.acknowledged, entity.acknowledged) &&
                Objects.equals(this.dateCreated, entity.dateCreated) &&
                Objects.equals(this.dateDone, entity.dateDone) &&
                Objects.equals(this.dateStarted, entity.dateStarted) &&
                Objects.equals(this.result, entity.result) &&
                Objects.equals(this.status, entity.status) &&
                Objects.equals(this.taskFileName, entity.taskFileName) &&
                Objects.equals(this.taskName, entity.taskName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, taskId, acknowledged, dateCreated, dateDone, dateStarted, result, status, taskFileName, taskName);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "id = " + id + ", " +
                "taskId = " + taskId + ", " +
                "acknowledged = " + acknowledged + ", " +
                "dateCreated = " + dateCreated + ", " +
                "dateDone = " + dateDone + ", " +
                "dateStarted = " + dateStarted + ", " +
                "result = " + result + ", " +
                "status = " + status + ", " +
                "taskFileName = " + taskFileName + ", " +
                "taskName = " + taskName + ")";
    }
}