package ml.work.main.security.JWT;

import io.jsonwebtoken.*;
import ml.work.main.security.UsuarioPrincipal;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import java.util.Date;


@Component
public class JwtProvider{

	private static  final Logger logger = LoggerFactory.getLogger(JwtProvider.class);

    @Value("${jwt.secret}")
    private String secret;

    @Value("${jwt.expiration}")
    private int expiration;
    
    

    //se genera el token y se asignan fecha de creacion, expiracion y se firma
    public String generateToken(Authentication authentication) {
        UsuarioPrincipal usuarioPrincipal = (UsuarioPrincipal) authentication.getPrincipal();
        return Jwts.builder().setSubject(usuarioPrincipal.getUsername())
                .setIssuedAt(new Date())
                .setExpiration(new Date(new Date().getTime() + expiration * 1000))
                .signWith(SignatureAlgorithm.HS512, secret)
                .compact();
    }

    public String getNombreUsuarioFromToken(String token){
        return Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody().getSubject();
    }
    
    public Long getUserIdFromJWT(String token) {
        Claims claims = Jwts.parser()
                .setSigningKey(secret)
                .parseClaimsJws(token)
                .getBody();

        return Long.parseLong(claims.getSubject());
    }

    //Valodacion del token generado
    public boolean validateToken(String token) {
        try {
            Jwts.parser().setSigningKey(secret).parseClaimsJws(token);
            return true;
        } catch (MalformedJwtException e) {
            logger.error("token no formado " +e.getMessage());
        } catch (UnsupportedJwtException e) {
            logger.error("token no soportado " +e.getMessage());
        } catch (ExpiredJwtException e) {
            logger.error("token expirado " +e.getMessage());
        } catch (IllegalArgumentException e) {
            logger.error("token mal declarado" +e.getMessage());
        } catch (SignatureException e) {
            logger.error("error en la firma " +e.getMessage());
        }
        return false;
    }
	
}
