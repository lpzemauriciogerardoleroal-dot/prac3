package com.unifranz.programaciontres.infrastructure.persistence;

<<<<<<< HEAD
import com.unifranz.programaciontres.application.dto.UsuarioDto;
import com.unifranz.programaciontres.domain.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {



    @Query("SELECT new com.unifranz.programaciontres.application.dto.UsuarioDto(u)"+
            " FROM Usuario u" +
            " WHERE u.eliminado = false")
    List<UsuarioDto> listarActivos();
}
=======
import com.unifranz.programaciontres.domain.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    List<Usuario> findByEliminadoFalse();
}
>>>>>>> a6a74f8158b1ef712ecb06837602362d7330ff4e
