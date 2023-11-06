package at.fhtw.swkom.paperless.persistence.model;

import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.time.OffsetDateTime;

@Entity
@Table(name = "documents_document")
public class DocumentsDocument {
    @Id
    @Column(name = "id", nullable = false)
    private Integer id;

    @javax.validation.constraints.Size(max = 128)
    @javax.validation.constraints.NotNull
    @Column(name = "title", nullable = false, length = 128)
    private String title;

    @javax.validation.constraints.NotNull
    @Column(name = "content", nullable = false)
    @Type(type = "org.hibernate.type.TextType")
    private String content;

    @javax.validation.constraints.NotNull
    @Column(name = "created", nullable = false)
    private OffsetDateTime created;

    @javax.validation.constraints.NotNull
    @Column(name = "modified", nullable = false)
    private OffsetDateTime modified;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "correspondent_id")
    private DocumentsCorrespondent correspondent;

    @javax.validation.constraints.Size(max = 32)
    @javax.validation.constraints.NotNull
    @Column(name = "checksum", nullable = false, length = 32)
    private String checksum;

    @javax.validation.constraints.NotNull
    @Column(name = "added", nullable = false)
    private OffsetDateTime added;

    @javax.validation.constraints.Size(max = 11)
    @javax.validation.constraints.NotNull
    @Column(name = "storage_type", nullable = false, length = 11)
    private String storageType;

    @javax.validation.constraints.Size(max = 1024)
    @Column(name = "filename", length = 1024)
    private String filename;

    @Column(name = "archive_serial_number")
    private Integer archiveSerialNumber;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "document_type_id")
    private DocumentsDocumenttype documentType;

    @javax.validation.constraints.Size(max = 256)
    @javax.validation.constraints.NotNull
    @Column(name = "mime_type", nullable = false, length = 256)
    private String mimeType;

    @javax.validation.constraints.Size(max = 32)
    @Column(name = "archive_checksum", length = 32)
    private String archiveChecksum;

    @javax.validation.constraints.Size(max = 1024)
    @Column(name = "archive_filename", length = 1024)
    private String archiveFilename;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "storage_path_id")
    private DocumentsStoragepath storagePath;

    @javax.validation.constraints.Size(max = 1024)
    @Column(name = "original_filename", length = 1024)
    private String originalFilename;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "owner_id")
    private AuthUser owner;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public OffsetDateTime getCreated() {
        return created;
    }

    public void setCreated(OffsetDateTime created) {
        this.created = created;
    }

    public OffsetDateTime getModified() {
        return modified;
    }

    public void setModified(OffsetDateTime modified) {
        this.modified = modified;
    }

    public DocumentsCorrespondent getCorrespondent() {
        return correspondent;
    }

    public void setCorrespondent(DocumentsCorrespondent correspondent) {
        this.correspondent = correspondent;
    }

    public String getChecksum() {
        return checksum;
    }

    public void setChecksum(String checksum) {
        this.checksum = checksum;
    }

    public OffsetDateTime getAdded() {
        return added;
    }

    public void setAdded(OffsetDateTime added) {
        this.added = added;
    }

    public String getStorageType() {
        return storageType;
    }

    public void setStorageType(String storageType) {
        this.storageType = storageType;
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public Integer getArchiveSerialNumber() {
        return archiveSerialNumber;
    }

    public void setArchiveSerialNumber(Integer archiveSerialNumber) {
        this.archiveSerialNumber = archiveSerialNumber;
    }

    public DocumentsDocumenttype getDocumentType() {
        return documentType;
    }

    public void setDocumentType(DocumentsDocumenttype documentType) {
        this.documentType = documentType;
    }

    public String getMimeType() {
        return mimeType;
    }

    public void setMimeType(String mimeType) {
        this.mimeType = mimeType;
    }

    public String getArchiveChecksum() {
        return archiveChecksum;
    }

    public void setArchiveChecksum(String archiveChecksum) {
        this.archiveChecksum = archiveChecksum;
    }

    public String getArchiveFilename() {
        return archiveFilename;
    }

    public void setArchiveFilename(String archiveFilename) {
        this.archiveFilename = archiveFilename;
    }

    public DocumentsStoragepath getStoragePath() {
        return storagePath;
    }

    public void setStoragePath(DocumentsStoragepath storagePath) {
        this.storagePath = storagePath;
    }

    public String getOriginalFilename() {
        return originalFilename;
    }

    public void setOriginalFilename(String originalFilename) {
        this.originalFilename = originalFilename;
    }

    public AuthUser getOwner() {
        return owner;
    }

    public void setOwner(AuthUser owner) {
        this.owner = owner;
    }

}