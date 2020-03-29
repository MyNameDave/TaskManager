package taskmanager.demo.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import taskmanager.demo.domain.SubTask;

public interface SubTaskRepository extends JpaRepository<SubTask, Long> {
}
