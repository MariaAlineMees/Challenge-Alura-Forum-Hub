package br.com.aline.forumhub.controller;

import br.com.aline.forumhub.domain.Topico;
import br.com.aline.forumhub.dto.*;
import br.com.aline.forumhub.repository.*;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/topicos")
public class TopicoController {

    private final TopicoRepository topicoRepo;
    private final CursoRepository cursoRepo;
    private final UsuarioRepository usuarioRepo;

    public TopicoController(TopicoRepository topicoRepo, CursoRepository cursoRepo, UsuarioRepository usuarioRepo) {
        this.topicoRepo = topicoRepo;
        this.cursoRepo = cursoRepo;
        this.usuarioRepo = usuarioRepo;
    }

    @GetMapping
    public List<Topico> listar() {
        return topicoRepo.findAll();
    }

    @PostMapping
    public Topico criar(@RequestBody DadosTopico dados) {
        var curso = cursoRepo.findByNome(dados.curso())
                .orElseThrow(() -> new RuntimeException("Curso não encontrado"));
        var autor = usuarioRepo.findById(1L)
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado")); // fixo para exemplo
        var topico = new Topico(null, dados.titulo(), dados.mensagem(), curso, autor, true);
        return topicoRepo.save(topico);
    }

    @PutMapping("/{id}")
    public Topico atualizar(@PathVariable Long id, @RequestBody AtualizacaoTopico dados) {
        var topico = topicoRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Tópico não encontrado"));
        topico.setTitulo(dados.titulo());
        topico.setMensagem(dados.mensagem());
        return topicoRepo.save(topico);
    }

    @DeleteMapping("/{id}")
    public void excluir(@PathVariable Long id) {
        var topico = topicoRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Tópico não encontrado"));
        topico.setAtivo(false);
        topicoRepo.save(topico);
    }
}