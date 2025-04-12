import jakarta.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name = "pagos")
public class Pago {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_pago")
    private Integer idPago;

    @OneToOne
    @JoinColumn(name = "id_cita", unique = true, nullable = false)
    private Cita cita;

    @Column(name = "fecha_pago", nullable = false)
    private LocalDateTime fechaPago;

    @Column(name = "metodo_pago", nullable = false, length = 50)
    private String metodoPago;

    @Column(name = "monto", nullable = false, precision = 10, scale = 2)
    private Double monto;

    @Column(name = "estado_pago", nullable = false, length = 20)
    private String estadoPago;

    @Column(name = "referencia_pago", length = 255)
    private String referenciaPago;

    @OneToOne(mappedBy = "pago")
    private Comprobante comprobante;

    public Pago() {
    }

    public Pago(Cita cita, LocalDateTime fechaPago, String metodoPago, Double monto, String estadoPago, String referenciaPago) {
        this.cita = cita;
        this.fechaPago = fechaPago;
        this.metodoPago = metodoPago;
        this.monto = monto;
        this.estadoPago = estadoPago;
        this.referenciaPago = referenciaPago;
    }

}