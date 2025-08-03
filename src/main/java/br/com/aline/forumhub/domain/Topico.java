package br.com.aline.forumhub.domain;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Topico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String titulo;
    private String mensagem;

    @ManyToOne
    private Curso curso;

    @ManyToOne
    private Usuario autor;

    private Boolean ativo = true;

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }
}

