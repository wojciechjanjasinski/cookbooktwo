package cb.cookbook.repository;

import cb.cookbook.modell.Step;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StepRepository extends JpaRepository<Step, Long> {
}
