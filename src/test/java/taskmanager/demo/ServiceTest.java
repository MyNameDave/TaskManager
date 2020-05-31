package taskmanager.demo;

import org.h2.util.Task;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import taskmanager.demo.dto.SubTaskDTO;
import taskmanager.demo.dto.TaskDTO;
import taskmanager.demo.service.SubTaskService;
import taskmanager.demo.service.TaskService;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@Transactional
@SpringBootTest
public class ServiceTest {
    @Autowired
    TaskService testTaskService;
    @Autowired
    SubTaskService testSubTaskService;
    TaskDTO testTaskDTO = new TaskDTO();
    SubTaskDTO testSubTaskDTO = new SubTaskDTO();

    @BeforeEach
    public void setup() {
        testTaskDTO.setTitle("Run Tests");
        testTaskDTO.setDueDate(LocalDateTime.of(2020, 6, 30, 23, 59));
        testTaskDTO.setDescription("Running all created tests");
        testTaskService.addTask(testTaskDTO);
        Long idMainTask = testTaskDTO.getId();
        testSubTaskDTO.setTitle("Run Tests of Service");
        testSubTaskDTO.setIdMainTask(testTaskService.getTasks().get(0).getId());
        testSubTaskDTO.setDescription("Running all created tests for Service");
        testSubTaskService.addSubTask(testSubTaskDTO);
    }

    @Test
    public void testServiceGetAllTasks() {
        assertEquals(1, testTaskService.getTasks().size());
    }

    @Test
    public void testServiceGetTask() {
        TaskDTO getTaskDTO = testTaskService.getTaskDTO(testTaskService.getTasks().get(0).getId());
        assertEquals("Run Tests", getTaskDTO.getTitle());
        assertEquals("Running all created tests", getTaskDTO.getDescription());
    }

    @Test
    public void testAddTask(){
        TaskDTO testTaskDTO2 = new TaskDTO();
        testTaskDTO2.setTitle("Run Some More Tests");
        testTaskDTO2.setDueDate(LocalDateTime.of(2020, 6, 30, 23, 59));
        testTaskDTO2.setDescription("Running all created tests");
        testTaskService.addTask(testTaskDTO);
        assertEquals(2, testTaskService.getTasks().size());
    }

    @Test
    public void testServiceGetAllSubTasks(){
        assertEquals(1, testSubTaskService.getSubTasks().size());
    }
}
