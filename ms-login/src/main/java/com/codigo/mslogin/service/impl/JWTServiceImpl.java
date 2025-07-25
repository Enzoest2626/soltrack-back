package com.codigo.mslogin.service.impl;
import com.codigo.mslogin.service.JWTService;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import java.security.Key;
import java.util.*;
import java.util.function.Function;

@Service

public class JWTServiceImpl implements JWTService {
    public String generateToken(UserDetails userDetails){
        List<String> roles = new ArrayList<>();
        Map<String, Object> rolesClaim = new HashMap<>();
        userDetails.getAuthorities().forEach(a -> roles.add(a.getAuthority()));
        rolesClaim.put("roles", roles);

        return Jwts.builder().setSubject(userDetails.getUsername())     //le brindamos el usuario
                .setIssuedAt(new Date(System.currentTimeMillis())) //fecha de creacion
                .setExpiration(new Date(System.currentTimeMillis() + 12000000000L))
                .addClaims(rolesClaim)
                //fecha de expiración
                .signWith(getSignKey(), SignatureAlgorithm.HS256) // la firma
                .compact();  //para construcción
    }




    public boolean validateToken(String token, UserDetails userDetails){
        final String username = extractUserName(token);
        return (username.equals(userDetails.getUsername()) && !isTokenExpired(token));
    }

    public String extractUserName(String token){
        return extractClaims(token, Claims::getSubject);
    }

    private <T> T extractClaims(String token, Function<Claims, T> claimsResolver){
        final Claims claims = extractAllClaims(token);
        return claimsResolver.apply(claims);
    }

    private Claims extractAllClaims(String token){
        return Jwts.parserBuilder().setSigningKey(getSignKey()).build().parseClaimsJws(token).getBody();
    }

    private Key getSignKey(){
        byte[] key =Decoders.BASE64.decode("85732b878c0f544da4a863804775ef3914e8ccb82b08820a278302c5b826e291");
        return Keys.hmacShaKeyFor(key);
    }

    public boolean isTokenExpired(String token){
        return extractClaims(token, Claims::getExpiration).before(new Date());
    }
}
