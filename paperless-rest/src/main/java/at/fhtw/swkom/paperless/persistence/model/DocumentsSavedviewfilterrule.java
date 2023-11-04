package at.fhtw.swkom.paperless.persistence.model;

import javax.persistence.*;

@Entity
@Table(name = "documents_savedviewfilterrule")
public class DocumentsSavedviewfilterrule {
    @Id
    @Column(name = "id", nullable = false)
    private Integer id;

    @javax.validation.constraints.NotNull
    @Column(name = "rule_type", nullable = false)
    private Integer ruleType;

    @javax.validation.constraints.Size(max = 255)
    @Column(name = "value")
    private String value;

    @javax.validation.constraints.NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "saved_view_id", nullable = false)
    private DocumentsSavedview savedView;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getRuleType() {
        return ruleType;
    }

    public void setRuleType(Integer ruleType) {
        this.ruleType = ruleType;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public DocumentsSavedview getSavedView() {
        return savedView;
    }

    public void setSavedView(DocumentsSavedview savedView) {
        this.savedView = savedView;
    }

}