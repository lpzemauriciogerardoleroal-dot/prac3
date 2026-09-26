package com.unifranz.programaciontres.infrastructure.web.controller;

import com.unifranz.programaciontres.application.dto.UsuarioDto;
import com.unifranz.programaciontres.application.service.UsuarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/usuarios")
@RequiredArgsConstructor
public class UsuarioController {

    private final UsuarioService usuarioService;

    @PostMapping
    public ResponseEntity<UsuarioDto> crear(@RequestBody UsuarioDto usuarioDto) {
        return ResponseEntity.ok(usuarioService.registrar(usuarioDto));
    }

    @GetMapping
    public ResponseEntity<List<UsuarioDto>> listarTodos() {
        return ResponseEntity.ok(usuarioService.obtenerTodos());
    }

    @GetMapping("/activos")
    public ResponseEntity<List<UsuarioDto>> listarActivos() {
        return ResponseEntity.ok(usuarioService.obtenerActivos());
    }

    @PutMapping("/{id}")
    public ResponseEntity<UsuarioDto> actualizar(@PathVariable Long id, @RequestBody UsuarioDto usuarioDto) {
        return ResponseEntity.ok(usuarioService.modificar(id, usuarioDto));
    }

    @DeleteMapping("/fisico/{id}")
    public ResponseEntity<Void> eliminarFisico(@PathVariable Long id) {
        usuarioService.borrarFisico(id);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/logico/{id}")
    public ResponseEntity<Void> eliminarLogico(@PathVariable Long id) {
        usuarioService.borrarLogico(id);
        return ResponseEntity.noContent().build();
    }
}