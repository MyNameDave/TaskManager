package taskmanager.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import taskmanager.demo.domain.Task;
import taskmanager.demo.dto.TaskDTO;
import taskmanager.demo.repo.TaskRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TaskServicelmpl implements TaskService {
    private final TaskRepository repository;

    @Autowired
    public TaskServicelmpl(TaskRepository repository){
        this.repository = repository;
    }

    @Override
    public List<TaskDTO> getTasks() {
        return repository.findAll().stream().map(t -> {
            TaskDTO dto = new TaskDTO();
            dto.setTitle(t.getTitle());
            dto.setDescription(t.getDescription());
            dto.setDueDate(t.getDueDate());
            return dto;
        }).collect(Collectors.toList());
    }

    @Override
    public Task getTask(Long id) {
        for (Task t : repository.findAll()) {
            if (t.getId().equals(id)){
                return t;
            }
        }
        return null;
    }

    @Override
    public void addTask(TaskDTO taskDTO) {
        Task task = new Task();
        task.setTitle(taskDTO.getTitle());
        task.setDescription(taskDTO.getDescription());
        task.setDueDate(taskDTO.getDueDate());
        repository.save(task);
    }
}
