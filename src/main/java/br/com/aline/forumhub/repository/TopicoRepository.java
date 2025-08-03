package br.com.aline.forumhub.repository;

import br.com.aline.forumhub.domain.Topico;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TopicoRepository extends JpaRepository<Topico, Long> {
}