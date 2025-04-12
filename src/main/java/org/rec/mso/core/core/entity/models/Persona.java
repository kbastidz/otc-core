package org.rec.mso.core.entity.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@Entity
@Table(name = "Persona")
public class Persona implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, length = 100)
    private String nombres;

    @Column(nullable = false, length = 100)
    private String primerApellido;

    @Column(nullable = false, length = 100)
    private String segundoApellido;

    @Column(nullable = false, length = 20, unique = true)
    private String cedula;

    @Column(length = 20)
    private String telefono;

    @Column(length = 100)
    private String email;

    @Column(length = 255)
    private String direccion;

    @Column(length = 100)
    private String contacto;

    @Column(length = 100)
    private String pais;

    @OneToOne(mappedBy = "persona", cascade = CascadeType.ALL)
    @JsonIgnore
    private Usuario usuario;

}
