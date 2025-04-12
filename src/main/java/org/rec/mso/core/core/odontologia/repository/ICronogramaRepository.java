import org.rec.mso.core.entity.models.odontologia.Cronograma;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ICronogramaRepository extends JpaRepository<Cronograma, Integer> {
}