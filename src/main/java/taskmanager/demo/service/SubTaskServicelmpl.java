package taskmanager.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import taskmanager.demo.domain.SubTask;
import taskmanager.demo.domain.Task;
import taskmanager.demo.dto.SubTaskDTO;
import taskmanager.demo.repo.SubTaskRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class SubTaskServicelmpl implements SubTaskService {
    private final SubTaskRepository repository;

    @Autowired
    public SubTaskServicelmpl(SubTaskRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<SubTaskDTO> getSubTasks() {
        return repository.findAll().stream().map(s -> {
            SubTaskDTO dto = new SubTaskDTO();
            dto.setTitle(s.getTitle());
            dto.setDescription(s.getDescription());
            dto.setIdMainTask(s.getIdMainTask());
            return dto;
        }).collect(Collectors.toList());
    }

    @Override
    public List<SubTaskDTO> getSubTasksFromIdMainTask(Long idMainTask) {
        List<SubTaskDTO> subtasks = new ArrayList<>();
        for (SubTask s : repository.findAll()) {
            if (s.getIdMainTask().equals(idMainTask)){
                SubTaskDTO dto = new SubTaskDTO();
                dto.setTitle(s.getTitle());
                dto.setDescription(s.getDescription());
                dto.setIdMainTask(s.getIdMainTask());
                subtasks.add(dto);
            }
        }
        return subtasks;
    }

    @Override
    public void addSubTask(SubTaskDTO subtaskDTO) {
        SubTask subTask = new SubTask();
        subTask.setTitle(subtaskDTO.getTitle());
        subTask.setDescription(subtaskDTO.getDescription());
        subTask.setIdMainTask(subtaskDTO.getIdMainTask());
        repository.save(subTask);
    }
}
