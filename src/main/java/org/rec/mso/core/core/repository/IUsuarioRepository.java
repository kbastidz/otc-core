package org.rec.mso.core.repository;

import org.rec.mso.core.entity.models.Users;
import org.rec.mso.core.entity.models.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IUsuarioRepository extends JpaRepository<Usuario, Integer> {
    Optional<Usuario> findByUsername(String username);
    //Optional<Usuario> findByIdUsername(Long id);
    boolean existsByUsername(String username);
}