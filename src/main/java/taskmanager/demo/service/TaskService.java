package taskmanager.demo.service;

import taskmanager.demo.domain.Task;
import taskmanager.demo.dto.TaskDTO;

import java.util.List;

public interface TaskService {
    List<TaskDTO> getTasks();

    Task getTask(Long id);

    void addTask(TaskDTO task);

    void  updateTask(Long id, TaskDTO newTask);
}
