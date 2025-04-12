import jakarta.persistence.*;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;
import java.time.LocalDateTime;
import java.util.Map;

@Getter
@Setter
@Entity
@Table(name = "comprobantes")
public class Comprobante {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_comprobante")
    private Integer idComprobante;

    @OneToOne
    @JoinColumn(name = "id_pago", unique = true, nullable = false)
    private Pago pago;

    @Column(name = "fecha_generacion", nullable = false, updatable = false)
    private LocalDateTime fechaGeneracion = LocalDateTime.now();

    @Column(name = "ruta_archivo", length = 255)
    private String rutaArchivo;

    @JdbcTypeCode(SqlTypes.JSON)
    @Column(name = "detalles", columnDefinition = "jsonb")
    private Map<String, Object> detalles;

    public Comprobante() {
    }

    public Comprobante(Pago pago, String rutaArchivo, Map<String, Object> detalles) {
        this.pago = pago;
        this.rutaArchivo = rutaArchivo;
        this.detalles = detalles;
    }
}