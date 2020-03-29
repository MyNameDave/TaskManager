package taskmanager.demo.dto;

import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.TextStyle;
import java.util.Locale;

public class TaskDTO {
    @NotEmpty
    @Size(min = 2)
    private String title;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private LocalDateTime dueDate;

    private String description;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public LocalDateTime getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDateTime dueDate){
        this.dueDate = dueDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    private String getTextFormat() {
        return title + ": due " + getDueDateText();
    }

    private String getDueDateText() {
        if (dueDate.getHour() >= 12) return dueDate.getMonth().getDisplayName(TextStyle.FULL, Locale.US) + " " + dueDate.getDayOfMonth() + " " + dueDate.getYear() + " at " + (dueDate.getHour() % 12) + " pm";
        else return dueDate.getMonth().getDisplayName(TextStyle.FULL, Locale.US) + " " + dueDate.getDayOfMonth() + " " + dueDate.getYear() + " at " + (dueDate.getHour() % 12) + " am";
    }

    public String toString(){
        return getTextFormat();
    }
}
