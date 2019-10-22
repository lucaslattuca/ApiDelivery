package ml.work.main.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import ml.work.main.security.JWT.JwtEntryPoint;
import ml.work.main.security.JWT.JwtTokenFilter;
import ml.work.main.service.UserDetailsServiceImpl;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurity extends WebSecurityConfigurerAdapter{

	@Autowired
    UserDetailsServiceImpl userDetailsServiceImpl;

    @Autowired
    JwtEntryPoint jwtEntryPoint;

    @Bean
    public JwtTokenFilter jwtTokenFilter(){
        return new JwtTokenFilter();
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

	
    @Override
    @Bean
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    
    @Override
    protected AuthenticationManager authenticationManager() throws Exception {
        return super.authenticationManager();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
    	auth.userDetailsService(userDetailsServiceImpl)
    	.passwordEncoder(passwordEncoder());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.cors().and().csrf().disable()
            .authorizeRequests()
                .antMatchers("/api/v1/**").permitAll()
                .antMatchers("/api/v1/auth/**").permitAll()
                //.antMatchers("/api/v1/articulos/lista/**","/api/articulos/detalle/**").permitAll()
                //.antMatchers("/api/v1/manufacturados/lista/**","/api/v1/manufacturados/detalle/**").permitAll()
                .antMatchers("/api/v1/articulos/**").permitAll()
                .antMatchers("/api/v1/manufacturados/**").permitAll()
                .antMatchers("/api/v1/pedidos/**").permitAll()
                .antMatchers("/api/v1/cargos/**").permitAll()
                .antMatchers("/api/v1/categorias/**").permitAll()
                .antMatchers("/api/v1/recetas/**").permitAll()
                .antMatchers("/api/v1/detalles_factura/**").permitAll()
                .antMatchers("/api/v1/Distritos/**").permitAll()
                .antMatchers("/api/v1/domicilios/**").permitAll()
                .antMatchers("/api/v1/localidades/**").permitAll()
                .antMatchers("/api/v1/empleados/**").permitAll()
                .antMatchers("/api/v1/clientes/**").permitAll()
                .antMatchers("/api/v1/facturas/**").permitAll()
                .antMatchers("/api/v1/medidas/**").permitAll();
                //.anyRequest().authenticated()
                //.and()
	        //.exceptionHandling()
				//.authenticationEntryPoint(jwtEntryPoint)
				//.and()
			//.sessionManagement()
				//.sessionCreationPolicy(SessionCreationPolicy.STATELESS);
        //añadir propio filtro de seguridad        
       // http.addFilterBefore(jwtTokenFilter(), UsernamePasswordAuthenticationFilter.class);
    }

}
