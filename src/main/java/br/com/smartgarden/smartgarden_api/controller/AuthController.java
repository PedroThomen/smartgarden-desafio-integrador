package br.com.smartgarden.smartgarden_api.controller;

import br.com.smartgarden.smartgarden_api.entity.Usuario;
import br.com.smartgarden.smartgarden_api.repository.UsuarioRepository;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final UsuarioRepository repository;

    public AuthController(UsuarioRepository repository) {
        this.repository = repository;
    }

    @PostMapping("/register")
    public Usuario cadastrar(@RequestBody Usuario usuario) {
        return repository.save(usuario);
    }

    @PostMapping("/login")
    public String login(@RequestBody Usuario usuario) {

        Usuario usuarioBanco =
                repository.findByEmail(usuario.getEmail()).orElse(null);

        if (usuarioBanco == null) {
            return "Usuário não encontrado";
        }

        if (!usuarioBanco.getSenha().equals(usuario.getSenha())) {
            return "Senha incorreta";
        }

        return "Login realizado com sucesso";
    }
}