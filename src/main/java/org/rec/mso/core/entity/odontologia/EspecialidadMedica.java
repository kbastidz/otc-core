import jakarta.persistence.*;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "especialidades_medicas")
public class EspecialidadMedica {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_especialidad")
    private Integer idEspecialidad;

    @Column(name = "nombre_especialidad", unique = true, nullable = false, length = 100)
    private String nombreEspecialidad;

    @Column(name = "descripcion", columnDefinition = "TEXT")
    private String descripcion;

    @OneToMany(mappedBy = "especialidad")
    private List<Doctor> doctores;

    // Constructores
    public EspecialidadMedica() {
    }

    public EspecialidadMedica(String nombreEspecialidad, String descripcion) {
        this.nombreEspecialidad = nombreEspecialidad;
        this.descripcion = descripcion;
    }

    
}