package com.si.korisnici.service;

import com.si.korisnici.domain.Korisnik;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class TokenService {

    @Value("${jwt.secret}")
    private String jwtSecret;

    public String generate(Korisnik korisnik) {
        Claims claims = Jwts.claims();
        claims.put("sifraKorisnika", korisnik.getSifraKorisnika());
        claims.put("privilegije", korisnik.getPrivilegije());

        return Jwts.builder()
                .setClaims(claims)
                .signWith(SignatureAlgorithm.HS512, jwtSecret)
                .compact();
    }

    public Claims parseToken(String jwt) {
        Claims claims = null;
        try {
            claims = Jwts.parser()
                    .setSigningKey(jwtSecret)
                    .parseClaimsJws(jwt)
                    .getBody();
        } catch (Exception e) {
            return null;
        }
        return claims;
    }


}
