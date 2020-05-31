package taskmanager.demo;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import taskmanager.demo.domain.Task;
import taskmanager.demo.dto.TaskDTO;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class TaskTest {
    Task testTask = new Task();

    @BeforeEach
    public void setup(){
        testTask.setTitle("Testing Task");
        testTask.setDescription("Checking if Task works as planned");
        testTask.setDueDate(LocalDateTime.of(2020, 6, 30, 23, 59));
    }

    @Test
    public void testTask(){
        assertNotNull(testTask);
        assertEquals("Testing Task", testTask.getTitle());
        assertEquals("Checking if Task works as planned", testTask.getDescription());
        assertEquals(LocalDateTime.of(2020, 6, 30, 23, 59), testTask.getDueDate());
    }

    @Test
    public void testTextFormat(){
        assertEquals("Testing Task: due June 30 2020 at 11 pm", testTask.getTextFormat());
    }
}
