package com.unifranz.programaciontres.application.service;

import com.unifranz.programaciontres.application.dto.UsuarioDto;

import java.util.List;

public interface UsuarioService {
    UsuarioDto registrar(UsuarioDto usuarioDto);
    List<UsuarioDto> obtenerTodos();
    List<UsuarioDto> obtenerActivos();
    UsuarioDto registrarAdministrador(UsuarioDto usuarioDto);
    UsuarioDto modificar(Long id, UsuarioDto usuarioDto);
    void borrar(Long id);
}