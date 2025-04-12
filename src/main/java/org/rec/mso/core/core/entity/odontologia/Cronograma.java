import jakarta.persistence.*;
import java.time.LocalDateTime;


@Getter
@Setter
@Entity
@Table(name = "cronograma")
public class Cronograma {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_cronograma")
    private Integer idCronograma;

    @ManyToOne
    @JoinColumn(name = "id_doctor", nullable = false)
    private Doctor doctor;

    @Column(name = "fecha_hora_inicio", nullable = false)
    private LocalDateTime fechaHoraInicio;

    @Column(name = "fecha_hora_fin", nullable = false)
    private LocalDateTime fechaHoraFin;

    @Column(name = "disponible", nullable = false)
    private boolean disponible = true;

    public Cronograma() {
    }

    public Cronograma(Doctor doctor, LocalDateTime fechaHoraInicio, LocalDateTime fechaHoraFin, boolean disponible) {
        this.doctor = doctor;
        this.fechaHoraInicio = fechaHoraInicio;
        this.fechaHoraFin = fechaHoraFin;
        this.disponible = disponible;
    }

}