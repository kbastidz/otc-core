
import org.rec.mso.core.entity.models.odontologia.RegistroConsulta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IConsultaRepository extends JpaRepository<RegistroConsulta, Integer> {
}