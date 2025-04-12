import jakarta.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "doctores")
public class Doctor extends Persona {

    @Id
    @Column(name = "id_doctor")
    private Integer idDoctor;

    @Column(name = "numero_colegiado", unique = true, nullable = false, length = 50)
    private String numeroColegiado;

    @ManyToOne
    @JoinColumn(name = "id_especialidad", nullable = false)
    private EspecialidadMedica especialidad;

    @OneToOne
    @JoinColumn(name = "id_doctor")
    @MapsId
    private Persona persona;

    public Doctor() {
    }

    public Doctor(Persona persona, String numeroColegiado, EspecialidadMedica especialidad) {
        super(persona.getNombres(), persona.getApellidos(), persona.getTipoDocumento(), persona.getNumeroDocumento(), persona.getFechaNacimiento(), persona.getDireccion(), persona.getTelefono(), persona.getEmail());
        this.persona = persona;
        this.idDoctor = persona.getIdPersona(); 
        this.numeroColegiado = numeroColegiado;
        this.especialidad = especialidad;
    }
}