package com.elias.usuarios_api.controller;

import com.elias.usuarios_api.model.Usuario;
import com.elias.usuarios_api.service.UsuarioService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

import java.util.List;

@Tag(name = "Usuário", description = "Operações relacionadas a usuários")
@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    private final UsuarioService service;

    public UsuarioController(UsuarioService service) {
        this.service = service;
    }

    @Operation(summary = "1 - Listar todos os usuários")
    @GetMapping
    public List<Usuario> listar() {
        return service.listar();
    }

    @Operation(summary = "2 - Buscar usuário por ID")
    @GetMapping("/{id}")
    public ResponseEntity<Usuario> buscarPorId(@PathVariable Long id) {
        Usuario usuario = service.buscarPorId(id);
        return ResponseEntity.ok(usuario);
    }

    @Operation(summary = "3 - Criar novo usuário")
    @PostMapping
    public Usuario criar(@RequestBody Usuario usuario) {
        return service.salvar(usuario);
    }

    @Operation(summary = "4 - Atualizar usuário através do ID")
    @PutMapping("/{id}")
    public Usuario atualizar(@PathVariable Long id, @RequestBody Usuario usuario) {
        return service.atualizar(id, usuario);
    }

    @Operation(summary = "5 - Deletar usuário pelo ID")
    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        service.deletar(id);
    }
}
