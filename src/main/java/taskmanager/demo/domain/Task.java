package taskmanager.demo.domain;

import org.springframework.format.annotation.DateTimeFormat;
import taskmanager.demo.dto.TaskDTO;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.TextStyle;
import java.util.Locale;

@Entity
public class Task {
    @Id
    @GeneratedValue
    private Long id;

    @NotEmpty
    @Size(min = 2)
    private String title;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private LocalDateTime dueDate;

    private String description;
    private String textFormat;
    private String dueDateText;

    public LocalDateTime getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDateTime dueDate) {
        this.dueDate = dueDate;
    }

    public String getTextFormat() {
        return title + ": due " + getDueDateText();
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

    public String getDueDateText() {
        if (dueDate.getHour() >= 12) return dueDate.getMonth().getDisplayName(TextStyle.FULL, Locale.US) + " " + dueDate.getDayOfMonth() + " " + dueDate.getYear() + " at " + (dueDate.getHour() % 12) + " pm";
        else return dueDate.getMonth().getDisplayName(TextStyle.FULL, Locale.US) + " " + dueDate.getDayOfMonth() + " " + dueDate.getYear() + " at " + (dueDate.getHour() % 12) + " am";
    }

    public void setTask(Task task){
        this.title = task.getTitle();
        this.description = task.getDescription();
        this.dueDate = task.getDueDate();
    }

    public void setTask(TaskDTO task){
        this.title = task.getTitle();
        this.description = task.getDescription();
        this.dueDate = task.getDueDate();
    }
}
