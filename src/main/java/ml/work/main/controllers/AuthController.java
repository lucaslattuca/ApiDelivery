package ml.work.main.controllers;

import ml.work.main.dtos.JwtDTO;
import ml.work.main.dtos.LoginUsuarioDTO;
import ml.work.main.dtos.MensajeDTO;
import ml.work.main.dtos.NuevoUsuarioDTO;
import ml.work.main.entities.Usuario;
import ml.work.main.entities.Rol;
import ml.work.main.enums.RolNombre;
import ml.work.main.security.JWT.JwtProvider;
import ml.work.main.service.RolService;
import ml.work.main.service.UsuarioService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.HashSet;
import java.util.Set;

@RestController
@CrossOrigin(origins = "*") 
@RequestMapping(path = "/api/v1/auth")
public class AuthController {
	
	@Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    UsuarioService usuarioService;

    @Autowired
    RolService rolService;

    @Autowired
    JwtProvider jwtProvider;

    @PostMapping("nuevo")
    public ResponseEntity<?> nuevo(@Valid @RequestBody NuevoUsuarioDTO nuevoUsuario, BindingResult bindingResult){
        if(bindingResult.hasErrors())
            return new ResponseEntity(new MensajeDTO("campos vacíos o email inválido"), HttpStatus.BAD_REQUEST);
        if(usuarioService.existePorNombre(nuevoUsuario.getNombreUsuario()))
            return new ResponseEntity(new MensajeDTO("ese nombre ya existe"), HttpStatus.BAD_REQUEST);
        if(usuarioService.existePorEmail(nuevoUsuario.getEmail()))
            return new ResponseEntity(new MensajeDTO("ese email ya existe"), HttpStatus.BAD_REQUEST);
        Usuario usuario =
                new Usuario(nuevoUsuario.getNombre(), nuevoUsuario.getNombreUsuario(), nuevoUsuario.getEmail(),
                        passwordEncoder.encode(nuevoUsuario.getPassword()), nuevoUsuario.getTelefono());
        Set<String> rolesStr = nuevoUsuario.getRoles();
        Set<Rol> roles = new HashSet<>();
        for (String rol : rolesStr) {
            switch (rol) {
                case "admin":
                    Rol rolAdmin = rolService.getByRolNombre(RolNombre.ROLE_ADMIN).get();
                    roles.add(rolAdmin);
                    break;
                case "empleado":
                    Rol rolEmpleado = rolService.getByRolNombre(RolNombre.ROLE_EMPLEADO).get();
                    roles.add(rolEmpleado);
                    break;
                default:
                    Rol rolUser = rolService.getByRolNombre(RolNombre.ROLE_USER).get();
                    roles.add(rolUser);
            }
        }
        usuario.setRoles(roles);
        usuarioService.guardar(usuario);
        return new ResponseEntity(new MensajeDTO("usuario guardado"), HttpStatus.CREATED);
    }
    
    
    @PostMapping("/login")
    public ResponseEntity<JwtDTO> login(@Valid @RequestBody LoginUsuarioDTO loginUsuario, BindingResult bindingResult){
        if(bindingResult.hasErrors())
            return new ResponseEntity(new MensajeDTO("campos vacíos o email inválido"), HttpStatus.BAD_REQUEST);
    	Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginUsuario.getNombreUsuario(), loginUsuario.getPassword())
        );
        
        SecurityContextHolder.getContext().setAuthentication(authentication);
        
        String jwt = jwtProvider.generateToken(authentication);
        
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        
        JwtDTO jwtDTO = new JwtDTO(jwt, userDetails.getUsername(), userDetails.getAuthorities());
        
        return new ResponseEntity<JwtDTO>(jwtDTO, HttpStatus.OK);
        
    }

}
