package ml.work.main.security.JWT;

import ml.work.main.service.UserDetailsServiceImpl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


public class JwtTokenFilter extends OncePerRequestFilter {

    private static  final Logger logger = LoggerFactory.getLogger(JwtTokenFilter.class);

    @Autowired
    JwtProvider jwtProvider;

    @Autowired
    UserDetailsServiceImpl userDetailsServiceImpl;

    @Override
    protected void doFilterInternal(HttpServletRequest req, HttpServletResponse res, FilterChain filterChain) throws ServletException, IOException {
        
    	//verifica usuario y token, obtiene el usuario y luego añade el filtro
    	try {
            String token = getToken(req);
            
            if(StringUtils.hasText(token) && jwtProvider.validateToken(token)){
            	
                String nombreUsuario = jwtProvider.getNombreUsuarioFromToken(token);
               
                UserDetails userDetails = userDetailsServiceImpl.loadUserByUsername(nombreUsuario);
                
                UsernamePasswordAuthenticationToken auth = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
                //ver si funciona o no
                auth.setDetails(new WebAuthenticationDetailsSource().buildDetails(req));
                
                SecurityContextHolder.getContext().setAuthentication(auth);
    		}
            
        }catch (Exception e){
            logger.error("fallo en realizar el filtro " + e.getMessage());
        }
        filterChain.doFilter(req, res);
    }

    //obtiene el token
    private String getToken(HttpServletRequest request){
    	
    	 String bearerToken = request.getHeader("Authorization");
         
    	 if (StringUtils.hasText(bearerToken) && bearerToken.startsWith("Bearer ")) {
             return bearerToken.substring(7, bearerToken.length());
         }
    	 
         return null;
    }
	
	
}
