package taskmanager.demo.service;

import taskmanager.demo.domain.SubTask;
import taskmanager.demo.dto.SubTaskDTO;

import java.util.List;

public interface SubTaskService {
    List<SubTaskDTO> getSubTasks();

    void addSubTask(SubTaskDTO subtask);
}
