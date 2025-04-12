import jakarta.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name = "citas")
public class Cita {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_cita")
    private Integer idCita;

    @ManyToOne
    @JoinColumn(name = "id_paciente", nullable = false)
    private Paciente paciente;

    @ManyToOne
    @JoinColumn(name = "id_doctor", nullable = false)
    private Doctor doctor;

    @Column(name = "fecha_hora", nullable = false)
    private LocalDateTime fechaHora;

    @Column(name = "motivo_cita", columnDefinition = "TEXT")
    private String motivoCita;

    @Column(name = "estado", nullable = false, length = 20)
    private String estado;

    @OneToOne(mappedBy = "cita")
    private Pago pago;

    public Cita() {
    }

    public Cita(Paciente paciente, Doctor doctor, LocalDateTime fechaHora, String motivoCita, String estado) {
        this.paciente = paciente;
        this.doctor = doctor;
        this.fechaHora = fechaHora;
        this.motivoCita = motivoCita;
        this.estado = estado;
    }
}