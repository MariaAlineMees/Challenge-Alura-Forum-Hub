package br.com.aline.forumhub.controller;

import br.com.aline.forumhub.dto.DadosLogin;
import br.com.aline.forumhub.security.TokenService;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/login")
public class AutenticacaoController {

    private final AuthenticationManager authManager;
    private final TokenService tokenService;

    public AutenticacaoController(AuthenticationManager authManager, TokenService tokenService) {
        this.authManager = authManager;
        this.tokenService = tokenService;
    }

    @PostMapping
    public String autenticar(@RequestBody DadosLogin dados) {
        Authentication authentication = new UsernamePasswordAuthenticationToken(dados.email(), dados.senha());
        Authentication autenticado = authManager.authenticate(authentication);
        return tokenService.gerarToken(autenticado);
    }
}