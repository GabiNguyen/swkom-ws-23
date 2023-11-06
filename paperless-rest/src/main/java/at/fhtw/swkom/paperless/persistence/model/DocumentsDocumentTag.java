package at.fhtw.swkom.paperless.persistence.model;

import javax.persistence.*;

@Entity
@Table(name = "documents_document_tags")
public class DocumentsDocumentTag {
    @Id
    @Column(name = "id", nullable = false)
    private Integer id;

    @javax.validation.constraints.NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "document_id", nullable = false)
    private DocumentsDocument document;

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

    public DocumentsDocument getDocument() {
        return document;
    }

    public void setDocument(DocumentsDocument document) {
        this.document = document;
    }

    public DocumentsTag getTag() {
        return tag;
    }

    public void setTag(DocumentsTag tag) {
        this.tag = tag;
    }

}