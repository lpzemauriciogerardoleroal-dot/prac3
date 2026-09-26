package com.unifranz.programaciontres.application.service.Impl;

import com.unifranz.programaciontres.application.dto.UsuarioDto;
import com.unifranz.programaciontres.application.service.UsuarioService;
import com.unifranz.programaciontres.domain.Usuario;
import com.unifranz.programaciontres.domain.UsuarioAdmin;
import com.unifranz.programaciontres.infrastructure.persistence.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UsuarioServiceImpl implements UsuarioService {

    private final UsuarioRepository usuarioRepository;

    @Override
    public UsuarioDto registrar(UsuarioDto usuarioDto) {
        Usuario usuario;

        if (usuarioDto.getRol() != null && usuarioDto.getRol().equalsIgnoreCase("ADMIN")) {
            usuario = new UsuarioAdmin();
            usuario.setRol("ADMIN");
        } else {
            usuario = new Usuario();
            usuario.setRol(usuarioDto.getRol() == null ? "NORMAL" : usuarioDto.getRol().toUpperCase());
        }

        usuario.setNombre(usuarioDto.getNombre());
        usuario.setEmail(usuarioDto.getEmail());

        Usuario guardar = usuarioRepository.save(usuario);
        return new UsuarioDto(guardar);
    }

    @Override
    public List<UsuarioDto> obtenerTodos() {
        return usuarioRepository.findAll()
                .stream()
                .map(UsuarioDto::new)
                .collect(Collectors.toList());
    }

    @Override
    public List<UsuarioDto> obtenerActivos() {
        return usuarioRepository.findByEliminadoFalse()
                .stream()
                .map(UsuarioDto::new)
                .collect(Collectors.toList());
    }

    @Override
    public UsuarioDto registrarAdministrador(UsuarioDto usuarioDto) {
        return registrar(usuarioDto);
    }

    @Override
    public UsuarioDto modificar(Long id, UsuarioDto usuarioDto) {
        Usuario usuarioExistente = usuarioRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));

        usuarioExistente.setNombre(usuarioDto.getNombre());
        usuarioExistente.setEmail(usuarioDto.getEmail());

        if (usuarioDto.getRol() != null) {
            usuarioExistente.setRol(usuarioDto.getRol().toUpperCase());
        }

        Usuario actualizado = usuarioRepository.save(usuarioExistente);
        return new UsuarioDto(actualizado);
    }

    @Override
    public void borrarFisico(Long id) {
        usuarioRepository.deleteById(id);
    }

    @Override
    public void borrarLogico(Long id) {
        Usuario usuarioExistente = usuarioRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));

        usuarioExistente.setEliminado(true);
        usuarioRepository.save(usuarioExistente);
    }
}