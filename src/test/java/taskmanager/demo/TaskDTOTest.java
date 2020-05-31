package taskmanager.demo;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import taskmanager.demo.domain.Task;
import taskmanager.demo.dto.TaskDTO;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class TaskDTOTest {
    TaskDTO testTaskDTO = new TaskDTO();

    @BeforeEach
    public void setup(){
        testTaskDTO.setTitle("Testing Task");
        testTaskDTO.setDescription("Checking if Task works as planned");
        testTaskDTO.setDueDate(LocalDateTime.of(2020, 6, 30, 23, 59));
    }

    @Test
    public void testSetTaskDTO(){
        Task testTask = new Task();
        testTask.setTitle("Testing Task Check");
        testTask.setDescription("Checking if Task works as planned, good");
        testTask.setDueDate(LocalDateTime.of(2020, 7, 30, 23, 59));
        testTaskDTO.setTaskDTO(testTask);

        assertEquals(testTask.getTitle(), testTaskDTO.getTitle());
        assertEquals(testTask.getDescription(), testTaskDTO.getDescription());
        assertEquals(testTask.getDueDate(), testTaskDTO.getDueDate());
    }
}
