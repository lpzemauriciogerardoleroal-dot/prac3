<<<<<<< HEAD
package com.unifranz.programaciontres.infrastructure.web.controller;

import com.unifranz.programaciontres.application.dto.UsuarioDto;
import com.unifranz.programaciontres.application.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
=======
package com.unifranz.programaciontres.infrastructure.controller;

import com.unifranz.programaciontres.application.dto.UsuarioDto;
import com.unifranz.programaciontres.application.service.UsuarioService;
import lombok.RequiredArgsConstructor;
>>>>>>> a6a74f8158b1ef712ecb06837602362d7330ff4e
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
<<<<<<< HEAD
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @PostMapping
    public ResponseEntity<UsuarioDto> guardar (@RequestBody UsuarioDto usuarioDto){
        UsuarioDto usuario = usuarioService.guardar(usuarioDto);
        return ResponseEntity.ok(usuario);
    }

    @GetMapping
    public ResponseEntity<List<UsuarioDto>> listarUsuarios(){
        return ResponseEntity.ok(usuarioService.listar());
    }

    @GetMapping("/listarUsuarios")
    public ResponseEntity<List<UsuarioDto>> listarUsuariosActivos(){
        return ResponseEntity.ok(usuarioService.listarActivos());
    }

    @PostMapping("/guardarAdmin")
    public ResponseEntity<UsuarioDto> guardarAdmin (@RequestBody UsuarioDto usuarioDto){
        UsuarioDto usuario = usuarioService.guardarAdmin(usuarioDto);
        return ResponseEntity.ok(usuario);
    }
}
=======
@RequestMapping("/api/usuarios")
@RequiredArgsConstructor
public class UsuarioController {

    private final UsuarioService usuarioService;

    @PostMapping
    public ResponseEntity<UsuarioDto> crear(@RequestBody UsuarioDto usuarioDto) {
        return ResponseEntity.ok(usuarioService.guardar(usuarioDto));
    }

    @GetMapping
    public ResponseEntity<List<UsuarioDto>> listarTodos() {
        return ResponseEntity.ok(usuarioService.listar());
    }

    @GetMapping("/activos")
    public ResponseEntity<List<UsuarioDto>> listarActivos() {
        return ResponseEntity.ok(usuarioService.listarActivos());
    }

    @PutMapping("/{id}")
    public ResponseEntity<UsuarioDto> actualizar(@PathVariable Long id, @RequestBody UsuarioDto usuarioDto) {
        return ResponseEntity.ok(usuarioService.actualizar(id, usuarioDto));
    }

    @DeleteMapping("/fisico/{id}")
    public ResponseEntity<Void> eliminarFisico(@PathVariable Long id) {
        usuarioService.eliminarFisico(id);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/logico/{id}")
    public ResponseEntity<Void> eliminarLogico(@PathVariable Long id) {
        usuarioService.eliminarLogico(id);
        return ResponseEntity.noContent().build();
    }
}
>>>>>>> a6a74f8158b1ef712ecb06837602362d7330ff4e
