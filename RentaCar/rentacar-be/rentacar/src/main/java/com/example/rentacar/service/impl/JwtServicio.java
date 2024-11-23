package com.example.rentacar.service.impl;

import java.util.Date;

import javax.crypto.SecretKey;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import com.example.rentacar.entity.Usuario;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;

@Service
public class JwtServicio {
    private final String USUARIO_CLAIM = "usuario";
    private final String EXPIRACION_CLAIM = "exp";

    @Value("${jwt.secret}")
    private String secreto;


    public String extraerUsuario(String jwtToken) {
        final Claims claims = extraerTodosClaims(jwtToken);
        return claims.get(USUARIO_CLAIM, String.class);
    }

    private Claims extraerTodosClaims(String jwtToken) {
        return Jwts.parser().verifyWith(obtenerClaveDeFirma()).build().parseSignedClaims(jwtToken).getPayload();
    }

    private SecretKey obtenerClaveDeFirma() {
        byte[] bytes = Decoders.BASE64.decode(secreto);
        return Keys.hmacShaKeyFor(bytes);
    }

    public boolean validarToken(String jwtToken, UserDetails detalleUsuario) {
        String usuario = extraerUsuario(jwtToken);
        return usuario.equals(detalleUsuario.getUsername()) && !esTokenExpirado(jwtToken);
    }

    private boolean esTokenExpirado(String jwtToken) {
        return extraerExpiracionToken(jwtToken).before(new Date());
    }

    private Date extraerExpiracionToken(String jwtToken) {
        Claims claims = extraerTodosClaims(jwtToken);
        return claims.get(EXPIRACION_CLAIM, Date.class);
    }

    public String generarToken(Usuario usuario) {
        return crearToken(usuario);
    }

    private String crearToken(Usuario usuario) {
        return Jwts.builder().claim(USUARIO_CLAIM, usuario.getUsuario())
                .issuedAt(new Date(System.currentTimeMillis()))
                .expiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 10))
                .signWith(obtenerClaveDeFirma())
                .compact();
    }
}
