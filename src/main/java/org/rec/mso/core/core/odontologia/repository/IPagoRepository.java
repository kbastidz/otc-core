
import org.rec.mso.core.entity.models.odontologia.Pago;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IPagoRepository extends JpaRepository<Pago, Integer> {
}