package at.fhtw.swkom.paperless.persistence.dto;

import at.fhtw.swkom.paperless.persistence.entity.Document;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.io.Serializable;
import java.time.OffsetDateTime;
import java.util.Objects;

/**
 * DTO for {@link Document}
 */
public class DocumentDto implements Serializable {
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
    @NotNull
    @Size(max = 256)
    private final String mimeType;
    @Size(max = 32)
    private final String archiveChecksum;
    @Size(max = 1024)
    private final String archiveFilename;
    @Size(max = 1024)
    private final String originalFilename;

    public DocumentDto(Integer id, String title, String content, OffsetDateTime created, OffsetDateTime modified, String checksum, OffsetDateTime added, String storageType, String filename, Integer archiveSerialNumber, String mimeType, String archiveChecksum, String archiveFilename, String originalFilename) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.created = created;
        this.modified = modified;
        this.checksum = checksum;
        this.added = added;
        this.storageType = storageType;
        this.filename = filename;
        this.archiveSerialNumber = archiveSerialNumber;
        this.mimeType = mimeType;
        this.archiveChecksum = archiveChecksum;
        this.archiveFilename = archiveFilename;
        this.originalFilename = originalFilename;
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

    public String getMimeType() {
        return mimeType;
    }

    public String getArchiveChecksum() {
        return archiveChecksum;
    }

    public String getArchiveFilename() {
        return archiveFilename;
    }

    public String getOriginalFilename() {
        return originalFilename;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DocumentDto entity = (DocumentDto) o;
        return Objects.equals(this.id, entity.id) &&
                Objects.equals(this.title, entity.title) &&
                Objects.equals(this.content, entity.content) &&
                Objects.equals(this.created, entity.created) &&
                Objects.equals(this.modified, entity.modified) &&
                Objects.equals(this.checksum, entity.checksum) &&
                Objects.equals(this.added, entity.added) &&
                Objects.equals(this.storageType, entity.storageType) &&
                Objects.equals(this.filename, entity.filename) &&
                Objects.equals(this.archiveSerialNumber, entity.archiveSerialNumber) &&
                Objects.equals(this.mimeType, entity.mimeType) &&
                Objects.equals(this.archiveChecksum, entity.archiveChecksum) &&
                Objects.equals(this.archiveFilename, entity.archiveFilename) &&
                Objects.equals(this.originalFilename, entity.originalFilename);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, content, created, modified, checksum, added, storageType, filename, archiveSerialNumber, mimeType, archiveChecksum, archiveFilename, originalFilename);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "id = " + id + ", " +
                "title = " + title + ", " +
                "content = " + content + ", " +
                "created = " + created + ", " +
                "modified = " + modified + ", " +
                "checksum = " + checksum + ", " +
                "added = " + added + ", " +
                "storageType = " + storageType + ", " +
                "filename = " + filename + ", " +
                "archiveSerialNumber = " + archiveSerialNumber + ", " +
                "mimeType = " + mimeType + ", " +
                "archiveChecksum = " + archiveChecksum + ", " +
                "archiveFilename = " + archiveFilename + ", " +
                "originalFilename = " + originalFilename + ", ";
    }
}