package taskmanager.demo.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import taskmanager.demo.domain.Task;

public interface TaskRepository extends JpaRepository<Task, Long> {
}
