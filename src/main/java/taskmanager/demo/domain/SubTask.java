package taskmanager.demo.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
public class SubTask {
    @Id
    @GeneratedValue
    private Long id;

    @NotEmpty
    @Size(min = 2)
    private String title;

    @NotEmpty
    private Long idMainTask;

    private String description;
    private String textFormat;

    public String getTextFormat() {
        return title;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setTask(SubTask subtask){
        this.title = subtask.getTitle();
        this.description = subtask.getDescription();
    }

    public Long getIdMainTask() {
        return idMainTask;
    }

    public void setIdMainTask(Long idMainTask) {
        this.idMainTask = idMainTask;
    }
}
