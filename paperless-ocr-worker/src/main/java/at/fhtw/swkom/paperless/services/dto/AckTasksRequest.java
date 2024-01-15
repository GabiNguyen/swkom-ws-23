package at.fhtw.swkom.paperless.services.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeName;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.annotation.Generated;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * AckTasksRequest
 */

@JsonTypeName("AckTasks_request")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2023-09-23T13:24:46.925443Z[Etc/UTC]")
public class AckTasksRequest {

  @Valid
  private List<Integer> tasks = new ArrayList<>();

  public AckTasksRequest() {
    super();
  }

  /**
   * Constructor with only required parameters
   */
  public AckTasksRequest(List<Integer> tasks) {
    this.tasks = tasks;
  }

  public AckTasksRequest tasks(List<Integer> tasks) {
    this.tasks = tasks;
    return this;
  }

  public AckTasksRequest addTasksItem(Integer tasksItem) {
    if (this.tasks == null) {
      this.tasks = new ArrayList<>();
    }
    this.tasks.add(tasksItem);
    return this;
  }

  /**
   * Get tasks
   * @return tasks
  */
  @NotNull 
  @Schema(name = "tasks", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("tasks")
  public List<Integer> getTasks() {
    return tasks;
  }

  public void setTasks(List<Integer> tasks) {
    this.tasks = tasks;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    AckTasksRequest ackTasksRequest = (AckTasksRequest) o;
    return Objects.equals(this.tasks, ackTasksRequest.tasks);
  }

  @Override
  public int hashCode() {
    return Objects.hash(tasks);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class AckTasksRequest {\n");
    sb.append("    tasks: ").append(toIndentedString(tasks)).append("\n");
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

