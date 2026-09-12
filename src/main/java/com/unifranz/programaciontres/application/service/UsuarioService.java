package com.unifranz.programaciontres.application.service;

import com.unifranz.programaciontres.application.dto.UsuarioDto;
<<<<<<< HEAD

import java.util.List;

public interface UsuarioService {
    UsuarioDto guardar (UsuarioDto usuarioDto);
    List<UsuarioDto> listar();
    List<UsuarioDto> listarActivos();
    UsuarioDto guardarAdmin (UsuarioDto usuarioDto);
}
=======
import java.util.List;

public interface UsuarioService {
    UsuarioDto guardar(UsuarioDto usuarioDto);
    List<UsuarioDto> listar();
    List<UsuarioDto> listarActivos();
    UsuarioDto guardarAdmin(UsuarioDto usuarioDto);

    UsuarioDto actualizar(Long id, UsuarioDto usuarioDto);
    void eliminarFisico(Long id);
    void eliminarLogico(Long id);
}
>>>>>>> a6a74f8158b1ef712ecb06837602362d7330ff4e
