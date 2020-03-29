package taskmanager.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import taskmanager.demo.domain.SubTask;
import taskmanager.demo.dto.SubTaskDTO;
import taskmanager.demo.repo.SubTaskRepository;

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
    public void addSubTask(SubTaskDTO subtaskDTO) {
        SubTask subTask = new SubTask();
        subTask.setTitle(subtaskDTO.getTitle());
        subTask.setDescription(subtaskDTO.getDescription());
        subTask.setIdMainTask(subtaskDTO.getIdMainTask());
    }
}
