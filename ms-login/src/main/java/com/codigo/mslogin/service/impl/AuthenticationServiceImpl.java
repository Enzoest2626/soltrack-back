package com.codigo.mslogin.service.impl;

import com.codigo.mslogin.entity.Usuario;
import com.codigo.mslogin.repository.ClienteRepository;
import com.codigo.mslogin.repository.UsuarioRepository;
import com.codigo.mslogin.request.SignInRequest;
import com.codigo.mslogin.request.SignUpRequest;
import com.codigo.mslogin.response.AuthenticationResponse;
import com.codigo.mslogin.service.AuthenticationService;
import com.codigo.mslogin.service.JWTService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationServiceImpl implements AuthenticationService {

    private final UsuarioRepository usuarioRepository;
    private final AuthenticationManager authenticationManager;
    private final JWTService jwtService;
    private final ClienteRepository clienteRepository;


    @Override
    public Usuario signUpUser(SignUpRequest signUpRequest) {
        Usuario usuario = new Usuario();
        usuario.setNombres(signUpRequest.getNombres());
        usuario.setApellidoPaterno(signUpRequest.getApellidoPaterno());
        usuario.setApellidoMaterno(signUpRequest.getApellidoMaterno());
        usuario.setEmail(signUpRequest.getEmail());
        usuario.setRole("CLIENTE");
        usuario.setPassword(new BCryptPasswordEncoder().encode(signUpRequest.getPassword()));
        usuario.setCliente(clienteRepository.findByRazonSocial(signUpRequest.getCliente()));
        usuario.setDni(signUpRequest.getDni());
        usuario.setEstado(1);
        return usuarioRepository.save(usuario);
    }

    @Override
    public Usuario signUpAdmin(SignUpRequest signUpRequest) {
        Usuario usuario = new Usuario();
        usuario.setNombres(signUpRequest.getNombres());
        usuario.setApellidoPaterno(signUpRequest.getApellidoPaterno());
        usuario.setApellidoMaterno(signUpRequest.getApellidoMaterno());
        usuario.setEmail(signUpRequest.getEmail());
        usuario.setRole("ANALISTA");
        usuario.setCliente(clienteRepository.findByRazonSocial(signUpRequest.getCliente()));
        usuario.setPassword(new BCryptPasswordEncoder().encode(signUpRequest.getPassword()));
        usuario.setDni(signUpRequest.getDni());
        usuario.setEstado(1);
        return usuarioRepository.save(usuario);
    }


    //metodo de login
    @Override
    public AuthenticationResponse signIn(SignInRequest signInRequest) {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                signInRequest.getEmail(), signInRequest.getPassword())
        );
        var user = usuarioRepository.findByEmail(signInRequest.getEmail())
                .orElseThrow(() -> new IllegalArgumentException("Email no valido"));
        var jwt = jwtService.generateToken(user);

        AuthenticationResponse authenticationResponse =  new AuthenticationResponse();
        authenticationResponse.setToken(jwt);
        return authenticationResponse;
    }
}
