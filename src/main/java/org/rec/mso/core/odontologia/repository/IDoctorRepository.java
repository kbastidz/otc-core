import org.rec.mso.core.entity.models.odontologia.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IDoctorRepository extends JpaRepository<Doctor, Integer> {
}