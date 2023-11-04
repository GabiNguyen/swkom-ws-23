package at.fhtw.swkom.paperless.persistence.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.time.OffsetDateTime;
import java.util.Objects;

/**
 * DTO for {@link at.fhtw.swkom.paperless.persistence.model.DocumentsDocument}
 */
public class DocumentsDocumentDto implements Serializable {
    private final Integer id;
    @NotNull
    @Size(max = 128)
    private final String title;
    @NotNull
    private final String content;
    @NotNull
    private final OffsetDateTime created;
    @NotNull
    private final OffsetDateTime modified;
    private final DocumentsCorrespondentDto correspondent;
    @NotNull
    @Size(max = 32)
    private final String checksum;
    @NotNull
    private final OffsetDateTime added;
    @NotNull
    @Size(max = 11)
    private final String storageType;
    @Size(max = 1024)
    private final String filename;
    private final Integer archiveSerialNumber;
    private final DocumentsDocumenttypeDto documentType;
    @NotNull
    @Size(max = 256)
    private final String mimeType;
    @Size(max = 32)
    private final String archiveChecksum;
    @Size(max = 1024)
    private final String archiveFilename;
    private final DocumentsStoragepathDto storagePath;
    @Size(max = 1024)
    private final String originalFilename;
    private final AuthUserDto owner;

    public DocumentsDocumentDto(Integer id, String title, String content, OffsetDateTime created, OffsetDateTime modified, DocumentsCorrespondentDto correspondent, String checksum, OffsetDateTime added, String storageType, String filename, Integer archiveSerialNumber, DocumentsDocumenttypeDto documentType, String mimeType, String archiveChecksum, String archiveFilename, DocumentsStoragepathDto storagePath, String originalFilename, AuthUserDto owner) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.created = created;
        this.modified = modified;
        this.correspondent = correspondent;
        this.checksum = checksum;
        this.added = added;
        this.storageType = storageType;
        this.filename = filename;
        this.archiveSerialNumber = archiveSerialNumber;
        this.documentType = documentType;
        this.mimeType = mimeType;
        this.archiveChecksum = archiveChecksum;
        this.archiveFilename = archiveFilename;
        this.storagePath = storagePath;
        this.originalFilename = originalFilename;
        this.owner = owner;
    }

    public Integer getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

    public OffsetDateTime getCreated() {
        return created;
    }

    public OffsetDateTime getModified() {
        return modified;
    }

    public DocumentsCorrespondentDto getCorrespondent() {
        return correspondent;
    }

    public String getChecksum() {
        return checksum;
    }

    public OffsetDateTime getAdded() {
        return added;
    }

    public String getStorageType() {
        return storageType;
    }

    public String getFilename() {
        return filename;
    }

    public Integer getArchiveSerialNumber() {
        return archiveSerialNumber;
    }

    public DocumentsDocumenttypeDto getDocumentType() {
        return documentType;
    }

    public String getMimeType() {
        return mimeType;
    }

    public String getArchiveChecksum() {
        return archiveChecksum;
    }

    public String getArchiveFilename() {
        return archiveFilename;
    }

    public DocumentsStoragepathDto getStoragePath() {
        return storagePath;
    }

    public String getOriginalFilename() {
        return originalFilename;
    }

    public AuthUserDto getOwner() {
        return owner;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DocumentsDocumentDto entity = (DocumentsDocumentDto) o;
        return Objects.equals(this.id, entity.id) &&
                Objects.equals(this.title, entity.title) &&
                Objects.equals(this.content, entity.content) &&
                Objects.equals(this.created, entity.created) &&
                Objects.equals(this.modified, entity.modified) &&
                Objects.equals(this.correspondent, entity.correspondent) &&
                Objects.equals(this.checksum, entity.checksum) &&
                Objects.equals(this.added, entity.added) &&
                Objects.equals(this.storageType, entity.storageType) &&
                Objects.equals(this.filename, entity.filename) &&
                Objects.equals(this.archiveSerialNumber, entity.archiveSerialNumber) &&
                Objects.equals(this.documentType, entity.documentType) &&
                Objects.equals(this.mimeType, entity.mimeType) &&
                Objects.equals(this.archiveChecksum, entity.archiveChecksum) &&
                Objects.equals(this.archiveFilename, entity.archiveFilename) &&
                Objects.equals(this.storagePath, entity.storagePath) &&
                Objects.equals(this.originalFilename, entity.originalFilename) &&
                Objects.equals(this.owner, entity.owner);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, content, created, modified, correspondent, checksum, added, storageType, filename, archiveSerialNumber, documentType, mimeType, archiveChecksum, archiveFilename, storagePath, originalFilename, owner);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "id = " + id + ", " +
                "title = " + title + ", " +
                "content = " + content + ", " +
                "created = " + created + ", " +
                "modified = " + modified + ", " +
                "correspondent = " + correspondent + ", " +
                "checksum = " + checksum + ", " +
                "added = " + added + ", " +
                "storageType = " + storageType + ", " +
                "filename = " + filename + ", " +
                "archiveSerialNumber = " + archiveSerialNumber + ", " +
                "documentType = " + documentType + ", " +
                "mimeType = " + mimeType + ", " +
                "archiveChecksum = " + archiveChecksum + ", " +
                "archiveFilename = " + archiveFilename + ", " +
                "storagePath = " + storagePath + ", " +
                "originalFilename = " + originalFilename + ", " +
                "owner = " + owner + ")";
    }
}