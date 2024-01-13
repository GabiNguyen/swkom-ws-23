package at.fhtw.swkom.paperless.persistence.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.io.InputStream;
import java.time.OffsetDateTime;
import java.util.Set;

@Entity
@Table(name = "documents")
public class Document {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer id;

    @Size(max = 128)
    @Column(name = "title", length = 128)
    private String title;

    @Column(name = "content")
    private String content;

    @Column(name = "created")
    private OffsetDateTime created;

    @Column(name = "modified")
    private OffsetDateTime modified;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "correspondent_id")
    private DocumentCorrespondent correspondent;

    // @Size(max = 32)
    // @NotNull
    // @Column(name = "checksum", nullable = false, length = 32)
    // private String checksum;

    @Column(name = "added", nullable = false)
    private OffsetDateTime added = OffsetDateTime.now();

    @Size(max = 11)
    @Column(name = "storage_type", length = 11)
    private String storageType;

    @Size(max = 1024)
    @Column(name = "filename", length = 1024)
    private String filename;

    @Column(name = "archive_serial_number")
    private Integer archiveSerialNumber;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "document_type_id")
    private DocumentType documentType;

    // @ManyToMany
    // @JoinTable(name = "document_to_tags",
    //         joinColumns = @JoinColumn(name = "document_id"),
    //         inverseJoinColumns = @JoinColumn(name = "document_tag_id"))
    // private Set<DocumentTag> documentTags;

    @Size(max = 256)
    // @NotNull
    @Column(name = "mime_type", length = 256)
    private String mimeType;

    // @Size(max = 32)
    // @Column(name = "archive_checksum", length = 32)
    // private String archiveChecksum;

    // @Size(max = 1024)
    // @Column(name = "archive_filename", length = 1024)
    // private String archiveFilename;

    // @Size(max = 1024)
    // @Column(name = "original_filename", length = 1024)
    // private String originalFilename;



    public Document(String originalFilename, String contentType) {
        this.title = originalFilename;
        this.mimeType = contentType;
        // this.inputStream = inputStream;
    }

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

    public DocumentCorrespondent getCorrespondent() {
        return correspondent;
    }

    public void setCorrespondent(DocumentCorrespondent correspondent) {
        this.correspondent = correspondent;
    }

    // public String getChecksum() {
    //     return checksum;
    // }

    // public void setChecksum(String checksum) {
    //     this.checksum = checksum;
    // }

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

    public DocumentType getDocumentType() {
        return documentType;
    }

    public void setDocumentType(DocumentType documentType) {
        this.documentType = documentType;
    }

    // public Set<DocumentTag> getDocumentTags() {
    //     return documentTags;
    // }

    // public void setDocumentTags(Set<DocumentTag> documentTags) {
    //     this.documentTags = documentTags;
    // }

    public String getMimeType() {
        return mimeType;
    }

    public void setMimeType(String mimeType) {
        this.mimeType = mimeType;
    }

    // public String getArchiveChecksum() {
    //     return archiveChecksum;
    // }

    // public void setArchiveChecksum(String archiveChecksum) {
    //     this.archiveChecksum = archiveChecksum;
    // }

    // public String getArchiveFilename() {
    //     return archiveFilename;
    // }

    // public void setArchiveFilename(String archiveFilename) {
    //     this.archiveFilename = archiveFilename;
    // }

    // public String getOriginalFilename() {
    //     return originalFilename;
    // }

    // public void setOriginalFilename(String originalFilename) {
    //     this.originalFilename = originalFilename;
    // }

}