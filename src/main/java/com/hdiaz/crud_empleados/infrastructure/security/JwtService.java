package com.hdiaz.crud_empleados.infrastructure.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import javax.crypto.SecretKey;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

@Service
public class JwtService {

    private static final String SECRET_KEY= "mihijoquerido19humbertomanjarres22kkkoaysdkasdh7220inon";

    public String generateToken(UserDetails userDetails){
        return generateToken(new HashMap<>(), userDetails);
    }

    public String generateToken(Map<String,Object> extraClaims, UserDetails userDetails){
        return Jwts.builder()
                .claims(extraClaims)
                .subject(userDetails.getUsername())
                .issuedAt(new Date(System.currentTimeMillis()))/*TODO: fecha en que se genera el token*/
                .expiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 24))/*TODO: fecha en que expirará el token - 24 horas*/
                .header()
                .type("JWT").and()
                .signWith(generateKey(), Jwts.SIG.HS256)/*TODO: llave codificada y algoritmo de la firma*/
                .compact();
    }

    public String getUserName(String token) {
        return getClaim(token, Claims::getSubject);
    }

    public <T> T getClaim(String token, Function<Claims,T> claimsResolver) {
        final Claims claims = getAllClaims(token);
        return claimsResolver.apply(claims);
    }

    private Claims getAllClaims(String token) {
        return Jwts.parser().verifyWith(generateKey()).build().parseSignedClaims(token).getPayload();
    }

    private SecretKey generateKey() {
        byte[] passwordDecoded = Decoders.BASE64.decode(SECRET_KEY);//decodificando un BASE64
        System.out.println("passwordDecoded => " + new String(passwordDecoded));
        return Keys.hmacShaKeyFor(passwordDecoded);
    }

    public boolean validateToken(String token, UserDetails userDetails) {

        final String username = getUserName(token);

        return (username.equals(userDetails.getUsername()) && !isTokenExpired(token));
    }

    private boolean isTokenExpired(String token) {
        return getExpiration(token).before(new Date());
    }

    private Date getExpiration(String token) {
        return getClaim(token,Claims::getExpiration);
    }

}
