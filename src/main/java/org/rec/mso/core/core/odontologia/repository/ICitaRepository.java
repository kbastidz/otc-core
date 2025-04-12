import org.rec.mso.core.entity.models.odontologia.Cita;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ICitaRepository extends JpaRepository<Cita, Integer> {
}