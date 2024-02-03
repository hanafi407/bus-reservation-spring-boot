package com.example.reservationbus.security;

import com.example.reservationbus.model.ReservationApiException;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import io.jsonwebtoken.security.UnsupportedKeyException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import java.util.Date;

@Component
public class JwtTokenProvider
{
    @Value("${app.jwt.secret}")
    private String jwtSecretKey;


    @Value("${app.jwt.expiration-token}")
    private  Long expiredToken;

    private SecretKey key(){
        return Keys.hmacShaKeyFor(Decoders.BASE64.decode(jwtSecretKey));
    }

    public String generateToken(Authentication authentication){
        String userName=authentication.getName();
        Date expireDate=new Date(new Date().getTime()+expiredToken);

        return Jwts.builder()
                .subject(userName)
                .issuedAt(new Date())
                .expiration(expireDate)
                .signWith(key())
                .compact();
    }

    public String getUserName(String token){
        Claims claims = Jwts.parser()
                .verifyWith(key())
                .build()
                .parseSignedClaims(token)
                .getPayload();
        return claims.getSubject();
    }

    public boolean verifyToken(String token){
        try {
            Jwts.parser().verifyWith(key()).build().parse(token);
            return true;
        }catch (MalformedJwtException e){
            throw new ReservationApiException(HttpStatus.BAD_REQUEST,"Invalid token");
        }catch (ExpiredJwtException e){
            throw new ReservationApiException(HttpStatus.BAD_REQUEST,"Expired token");
        }catch (UnsupportedKeyException e){
            throw new ReservationApiException(HttpStatus.BAD_REQUEST,"Unsupported token");
        }catch (IllegalArgumentException e){
            throw new ReservationApiException(HttpStatus.BAD_REQUEST,"Illegal token");
        }
    }
}
