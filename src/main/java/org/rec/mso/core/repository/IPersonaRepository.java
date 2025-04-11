package org.rec.mso.core.repository;

import org.rec.mso.core.entity.models.Persona;
import org.rec.mso.core.entity.models.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IPersonaRepository extends JpaRepository<Persona, Long> {
    Optional<Persona> findByCedula(String cedula);
}