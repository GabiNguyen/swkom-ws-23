package at.fhtw.swkom.paperless.services.dto;

import java.net.URI;
import java.util.Objects;
import at.fhtw.swkom.paperless.services.dto.GetCorrespondents200ResponseResultsInnerPermissions;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonTypeName;
import org.openapitools.jackson.nullable.JsonNullable;
import java.time.OffsetDateTime;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.*;
import jakarta.annotation.Generated;

/**
 * GetCorrespondents200ResponseResultsInner
 */

@JsonTypeName("GetCorrespondents_200_response_results_inner")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2023-09-23T13:24:46.925443Z[Etc/UTC]")
public class GetCorrespondents200ResponseResultsInner {

  private Integer id;

  private String slug;

  private String name;

  private String match;

  private Integer matchingAlgorithm;

  private Boolean isInsensitive;

  private Integer documentCount;

  private String lastCorrespondence;

  private Integer owner;

  private GetCorrespondents200ResponseResultsInnerPermissions permissions;

  public GetCorrespondents200ResponseResultsInner() {
    super();
  }

  /**
   * Constructor with only required parameters
   */
  public GetCorrespondents200ResponseResultsInner(Integer id, String slug, String name, String match, Integer matchingAlgorithm, Boolean isInsensitive, Integer documentCount, String lastCorrespondence, Integer owner, GetCorrespondents200ResponseResultsInnerPermissions permissions) {
    this.id = id;
    this.slug = slug;
    this.name = name;
    this.match = match;
    this.matchingAlgorithm = matchingAlgorithm;
    this.isInsensitive = isInsensitive;
    this.documentCount = documentCount;
    this.lastCorrespondence = lastCorrespondence;
    this.owner = owner;
    this.permissions = permissions;
  }

  public GetCorrespondents200ResponseResultsInner id(Integer id) {
    this.id = id;
    return this;
  }

  /**
   * Get id
   * @return id
  */
  @NotNull 
  @Schema(name = "id", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("id")
  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public GetCorrespondents200ResponseResultsInner slug(String slug) {
    this.slug = slug;
    return this;
  }

  /**
   * Get slug
   * @return slug
  */
  @NotNull 
  @Schema(name = "slug", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("slug")
  public String getSlug() {
    return slug;
  }

  public void setSlug(String slug) {
    this.slug = slug;
  }

  public GetCorrespondents200ResponseResultsInner name(String name) {
    this.name = name;
    return this;
  }

  /**
   * Get name
   * @return name
  */
  @NotNull 
  @Schema(name = "name", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("name")
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public GetCorrespondents200ResponseResultsInner match(String match) {
    this.match = match;
    return this;
  }

  /**
   * Get match
   * @return match
  */
  @NotNull 
  @Schema(name = "match", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("match")
  public String getMatch() {
    return match;
  }

  public void setMatch(String match) {
    this.match = match;
  }

  public GetCorrespondents200ResponseResultsInner matchingAlgorithm(Integer matchingAlgorithm) {
    this.matchingAlgorithm = matchingAlgorithm;
    return this;
  }

  /**
   * Get matchingAlgorithm
   * @return matchingAlgorithm
  */
  @NotNull 
  @Schema(name = "matching_algorithm", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("matching_algorithm")
  public Integer getMatchingAlgorithm() {
    return matchingAlgorithm;
  }

  public void setMatchingAlgorithm(Integer matchingAlgorithm) {
    this.matchingAlgorithm = matchingAlgorithm;
  }

  public GetCorrespondents200ResponseResultsInner isInsensitive(Boolean isInsensitive) {
    this.isInsensitive = isInsensitive;
    return this;
  }

  /**
   * Get isInsensitive
   * @return isInsensitive
  */
  @NotNull 
  @Schema(name = "is_insensitive", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("is_insensitive")
  public Boolean getIsInsensitive() {
    return isInsensitive;
  }

  public void setIsInsensitive(Boolean isInsensitive) {
    this.isInsensitive = isInsensitive;
  }

  public GetCorrespondents200ResponseResultsInner documentCount(Integer documentCount) {
    this.documentCount = documentCount;
    return this;
  }

  /**
   * Get documentCount
   * @return documentCount
  */
  @NotNull 
  @Schema(name = "document_count", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("document_count")
  public Integer getDocumentCount() {
    return documentCount;
  }

  public void setDocumentCount(Integer documentCount) {
    this.documentCount = documentCount;
  }

  public GetCorrespondents200ResponseResultsInner lastCorrespondence(String lastCorrespondence) {
    this.lastCorrespondence = lastCorrespondence;
    return this;
  }

  /**
   * Get lastCorrespondence
   * @return lastCorrespondence
  */
  @NotNull 
  @Schema(name = "last_correspondence", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("last_correspondence")
  public String getLastCorrespondence() {
    return lastCorrespondence;
  }

  public void setLastCorrespondence(String lastCorrespondence) {
    this.lastCorrespondence = lastCorrespondence;
  }

  public GetCorrespondents200ResponseResultsInner owner(Integer owner) {
    this.owner = owner;
    return this;
  }

  /**
   * Get owner
   * @return owner
  */
  @NotNull 
  @Schema(name = "owner", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("owner")
  public Integer getOwner() {
    return owner;
  }

  public void setOwner(Integer owner) {
    this.owner = owner;
  }

  public GetCorrespondents200ResponseResultsInner permissions(GetCorrespondents200ResponseResultsInnerPermissions permissions) {
    this.permissions = permissions;
    return this;
  }

  /**
   * Get permissions
   * @return permissions
  */
  @NotNull @Valid 
  @Schema(name = "permissions", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("permissions")
  public GetCorrespondents200ResponseResultsInnerPermissions getPermissions() {
    return permissions;
  }

  public void setPermissions(GetCorrespondents200ResponseResultsInnerPermissions permissions) {
    this.permissions = permissions;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    GetCorrespondents200ResponseResultsInner getCorrespondents200ResponseResultsInner = (GetCorrespondents200ResponseResultsInner) o;
    return Objects.equals(this.id, getCorrespondents200ResponseResultsInner.id) &&
        Objects.equals(this.slug, getCorrespondents200ResponseResultsInner.slug) &&
        Objects.equals(this.name, getCorrespondents200ResponseResultsInner.name) &&
        Objects.equals(this.match, getCorrespondents200ResponseResultsInner.match) &&
        Objects.equals(this.matchingAlgorithm, getCorrespondents200ResponseResultsInner.matchingAlgorithm) &&
        Objects.equals(this.isInsensitive, getCorrespondents200ResponseResultsInner.isInsensitive) &&
        Objects.equals(this.documentCount, getCorrespondents200ResponseResultsInner.documentCount) &&
        Objects.equals(this.lastCorrespondence, getCorrespondents200ResponseResultsInner.lastCorrespondence) &&
        Objects.equals(this.owner, getCorrespondents200ResponseResultsInner.owner) &&
        Objects.equals(this.permissions, getCorrespondents200ResponseResultsInner.permissions);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, slug, name, match, matchingAlgorithm, isInsensitive, documentCount, lastCorrespondence, owner, permissions);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class GetCorrespondents200ResponseResultsInner {\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    slug: ").append(toIndentedString(slug)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    match: ").append(toIndentedString(match)).append("\n");
    sb.append("    matchingAlgorithm: ").append(toIndentedString(matchingAlgorithm)).append("\n");
    sb.append("    isInsensitive: ").append(toIndentedString(isInsensitive)).append("\n");
    sb.append("    documentCount: ").append(toIndentedString(documentCount)).append("\n");
    sb.append("    lastCorrespondence: ").append(toIndentedString(lastCorrespondence)).append("\n");
    sb.append("    owner: ").append(toIndentedString(owner)).append("\n");
    sb.append("    permissions: ").append(toIndentedString(permissions)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}

