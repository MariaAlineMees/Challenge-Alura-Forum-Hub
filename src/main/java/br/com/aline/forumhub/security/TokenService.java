package br.com.aline.forumhub.security;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import jakarta.annotation.PostConstruct;
import java.util.Base64;
import java.util.Date;
import javax.crypto.spec.SecretKeySpec;
import java.security.Key;

@Service
public class TokenService {

    @Value("${api.security.token.secret}")
    private String secret;

    private Key secretKey;

    private static final long EXPIRATION = 1000 * 60 * 60 * 24; // 24 horas

    @PostConstruct
    public void init() {
        byte[] keyBytes = Base64.getEncoder().encode(secret.getBytes());
        this.secretKey = new SecretKeySpec(keyBytes, SignatureAlgorithm.HS256.getJcaName());
    }

    public String gerarToken(Authentication authentication) {
        var usuario = authentication.getPrincipal();
        return Jwts.builder()
                .setSubject(((br.com.aline.forumhub.domain.Usuario) usuario).getEmail())
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION))
                .signWith(secretKey)
                .compact();
    }

    public String validarToken(String token) {
        return Jwts.parserBuilder()
                .setSigningKey(secretKey)
                .build()
                .parseClaimsJws(token)
                .getBody()
                .getSubject();
    }
}
