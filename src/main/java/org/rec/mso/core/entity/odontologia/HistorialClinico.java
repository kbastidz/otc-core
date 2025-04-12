import jakarta.persistence.*;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "historial_clinico")
public class HistorialClinico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_historial")
    private Integer idHistorial;

    @OneToOne
    @JoinColumn(name = "id_paciente", unique = true, nullable = false)
    private Paciente paciente;

    @OneToMany(mappedBy = "historialClinico", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<RegistroConsulta> registros;

    // Constructores
    public HistorialClinico() {
    }

    public HistorialClinico(Paciente paciente) {
        this.paciente = paciente;
    }

}