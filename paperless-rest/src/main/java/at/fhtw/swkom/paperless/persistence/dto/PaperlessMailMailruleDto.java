package at.fhtw.swkom.paperless.persistence.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Objects;

/**
 * DTO for {@link at.fhtw.swkom.paperless.persistence.model.PaperlessMailMailrule}
 */
public class PaperlessMailMailruleDto implements Serializable {
    private final Integer id;
    @NotNull
    @Size(max = 256)
    private final String name;
    @NotNull
    @Size(max = 256)
    private final String folder;
    @Size(max = 256)
    private final String filterFrom;
    @Size(max = 256)
    private final String filterSubject;
    @Size(max = 256)
    private final String filterBody;
    @NotNull
    private final Integer maximumAge;
    @NotNull
    private final Integer action;
    @Size(max = 256)
    private final String actionParameter;
    @NotNull
    private final Integer assignTitleFrom;
    @NotNull
    private final Integer assignCorrespondentFrom;
    @NotNull
    private final PaperlessMailMailaccountDto account;
    private final DocumentsCorrespondentDto assignCorrespondent;
    private final DocumentsDocumenttypeDto assignDocumentType;
    @NotNull
    private final Integer order;
    @NotNull
    private final Integer attachmentType;
    @Size(max = 256)
    private final String filterAttachmentFilename;
    @NotNull
    private final Integer consumptionScope;
    private final AuthUserDto owner;
    @Size(max = 256)
    private final String filterTo;

    public PaperlessMailMailruleDto(Integer id, String name, String folder, String filterFrom, String filterSubject, String filterBody, Integer maximumAge, Integer action, String actionParameter, Integer assignTitleFrom, Integer assignCorrespondentFrom, PaperlessMailMailaccountDto account, DocumentsCorrespondentDto assignCorrespondent, DocumentsDocumenttypeDto assignDocumentType, Integer order, Integer attachmentType, String filterAttachmentFilename, Integer consumptionScope, AuthUserDto owner, String filterTo) {
        this.id = id;
        this.name = name;
        this.folder = folder;
        this.filterFrom = filterFrom;
        this.filterSubject = filterSubject;
        this.filterBody = filterBody;
        this.maximumAge = maximumAge;
        this.action = action;
        this.actionParameter = actionParameter;
        this.assignTitleFrom = assignTitleFrom;
        this.assignCorrespondentFrom = assignCorrespondentFrom;
        this.account = account;
        this.assignCorrespondent = assignCorrespondent;
        this.assignDocumentType = assignDocumentType;
        this.order = order;
        this.attachmentType = attachmentType;
        this.filterAttachmentFilename = filterAttachmentFilename;
        this.consumptionScope = consumptionScope;
        this.owner = owner;
        this.filterTo = filterTo;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getFolder() {
        return folder;
    }

    public String getFilterFrom() {
        return filterFrom;
    }

    public String getFilterSubject() {
        return filterSubject;
    }

    public String getFilterBody() {
        return filterBody;
    }

    public Integer getMaximumAge() {
        return maximumAge;
    }

    public Integer getAction() {
        return action;
    }

    public String getActionParameter() {
        return actionParameter;
    }

    public Integer getAssignTitleFrom() {
        return assignTitleFrom;
    }

    public Integer getAssignCorrespondentFrom() {
        return assignCorrespondentFrom;
    }

    public PaperlessMailMailaccountDto getAccount() {
        return account;
    }

    public DocumentsCorrespondentDto getAssignCorrespondent() {
        return assignCorrespondent;
    }

    public DocumentsDocumenttypeDto getAssignDocumentType() {
        return assignDocumentType;
    }

    public Integer getOrder() {
        return order;
    }

    public Integer getAttachmentType() {
        return attachmentType;
    }

    public String getFilterAttachmentFilename() {
        return filterAttachmentFilename;
    }

    public Integer getConsumptionScope() {
        return consumptionScope;
    }

    public AuthUserDto getOwner() {
        return owner;
    }

    public String getFilterTo() {
        return filterTo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PaperlessMailMailruleDto entity = (PaperlessMailMailruleDto) o;
        return Objects.equals(this.id, entity.id) &&
                Objects.equals(this.name, entity.name) &&
                Objects.equals(this.folder, entity.folder) &&
                Objects.equals(this.filterFrom, entity.filterFrom) &&
                Objects.equals(this.filterSubject, entity.filterSubject) &&
                Objects.equals(this.filterBody, entity.filterBody) &&
                Objects.equals(this.maximumAge, entity.maximumAge) &&
                Objects.equals(this.action, entity.action) &&
                Objects.equals(this.actionParameter, entity.actionParameter) &&
                Objects.equals(this.assignTitleFrom, entity.assignTitleFrom) &&
                Objects.equals(this.assignCorrespondentFrom, entity.assignCorrespondentFrom) &&
                Objects.equals(this.account, entity.account) &&
                Objects.equals(this.assignCorrespondent, entity.assignCorrespondent) &&
                Objects.equals(this.assignDocumentType, entity.assignDocumentType) &&
                Objects.equals(this.order, entity.order) &&
                Objects.equals(this.attachmentType, entity.attachmentType) &&
                Objects.equals(this.filterAttachmentFilename, entity.filterAttachmentFilename) &&
                Objects.equals(this.consumptionScope, entity.consumptionScope) &&
                Objects.equals(this.owner, entity.owner) &&
                Objects.equals(this.filterTo, entity.filterTo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, folder, filterFrom, filterSubject, filterBody, maximumAge, action, actionParameter, assignTitleFrom, assignCorrespondentFrom, account, assignCorrespondent, assignDocumentType, order, attachmentType, filterAttachmentFilename, consumptionScope, owner, filterTo);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "id = " + id + ", " +
                "name = " + name + ", " +
                "folder = " + folder + ", " +
                "filterFrom = " + filterFrom + ", " +
                "filterSubject = " + filterSubject + ", " +
                "filterBody = " + filterBody + ", " +
                "maximumAge = " + maximumAge + ", " +
                "action = " + action + ", " +
                "actionParameter = " + actionParameter + ", " +
                "assignTitleFrom = " + assignTitleFrom + ", " +
                "assignCorrespondentFrom = " + assignCorrespondentFrom + ", " +
                "account = " + account + ", " +
                "assignCorrespondent = " + assignCorrespondent + ", " +
                "assignDocumentType = " + assignDocumentType + ", " +
                "order = " + order + ", " +
                "attachmentType = " + attachmentType + ", " +
                "filterAttachmentFilename = " + filterAttachmentFilename + ", " +
                "consumptionScope = " + consumptionScope + ", " +
                "owner = " + owner + ", " +
                "filterTo = " + filterTo + ")";
    }
}