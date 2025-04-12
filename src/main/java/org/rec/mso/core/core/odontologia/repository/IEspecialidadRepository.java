
import org.rec.mso.core.entity.models.odontologia.EspecialidadMedica;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IEspecialidadesRepository extends JpaRepository<EspecialidadMedica, Integer> {
}