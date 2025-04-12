import jakarta.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name = "registros_consultas")
public class RegistroConsulta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_registro")
    private Integer idRegistro;

    @ManyToOne
    @JoinColumn(name = "id_historial", nullable = false)
    private HistorialClinico historialClinico;

    @Column(name = "fecha_consulta", nullable = false)
    private LocalDateTime fechaConsulta;

    @ManyToOne
    @JoinColumn(name = "id_doctor", nullable = false)
    private Doctor doctor;

    @Column(name = "diagnostico", columnDefinition = "TEXT")
    private String diagnostico;

    @Column(name = "tratamiento", columnDefinition = "TEXT")
    private String tratamiento;

    @Column(name = "notas_adicionales", columnDefinition = "TEXT")
    private String notasAdicionales;

    public RegistroConsulta() {
    }

    public RegistroConsulta(HistorialClinico historialClinico, LocalDateTime fechaConsulta, Doctor doctor, String diagnostico, String tratamiento, String notasAdicionales) {
        this.historialClinico = historialClinico;
        this.fechaConsulta = fechaConsulta;
        this.doctor = doctor;
        this.diagnostico = diagnostico;
        this.tratamiento = tratamiento;
        this.notasAdicionales = notasAdicionales;
    }
}