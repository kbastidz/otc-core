import jakarta.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "pacientes")
public class Paciente extends Persona {

    @Id
    @Column(name = "id_paciente")
    private Integer idPaciente;

    @Column(name = "numero_historia_clinica", unique = true, nullable = false)
    private Integer numeroHistoriaClinica;

    @Column(name = "grupo_sanguineo", length = 5)
    private String grupoSanguineo;

    @Column(name = "alergias", columnDefinition = "TEXT")
    private String alergias;

    @OneToOne
    @JoinColumn(name = "id_paciente")
    @MapsId
    private Persona persona;

    public Paciente() {
    }

    public Paciente(Persona persona, Integer numeroHistoriaClinica, String grupoSanguineo, String alergias) {
        super(persona.getNombres(), persona.getApellidos(), persona.getTipoDocumento(), persona.getNumeroDocumento(), persona.getFechaNacimiento(), persona.getDireccion(), persona.getTelefono(), persona.getEmail());
        this.persona = persona;
        this.idPaciente = persona.getIdPersona(); // Asegurar que el ID coincida
        this.numeroHistoriaClinica = numeroHistoriaClinica;
        this.grupoSanguineo = grupoSanguineo;
        this.alergias = alergias;
    }

    
}