
import org.rec.mso.core.entity.models.odontologia.HistorialClinico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IHistorialClinicoRepository extends JpaRepository<HistorialClinico, Integer> {
}