package taskmanager.demo.service;

import taskmanager.demo.domain.SubTask;
import taskmanager.demo.dto.SubTaskDTO;

import java.util.List;

public interface SubTaskService {
    List<SubTaskDTO> getSubTasks();

    List<SubTaskDTO> getSubTasksFromIdMainTask(Long idMainTask);

    void addSubTask(SubTaskDTO subtask);
}
