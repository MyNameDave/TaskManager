package taskmanager.demo.dto;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class SubTaskDTO {
    @NotEmpty
    @Size(min = 2)
    private String title;

    @NotNull
    private Long idMainTask;

    private String description;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Long getIdMainTask() {
        return idMainTask;
    }

    public void setIdMainTask(Long idMainTask) {
        this.idMainTask = idMainTask;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
