package org.rec.mso.core.service.impl;

import org.rec.mso.core.configuration.jwt.JwtService;
import org.rec.mso.core.entity.dto.AuthenticationRequest;
import org.rec.mso.core.entity.dto.AuthenticationResponse;
import org.rec.mso.core.entity.models.Users;
import org.rec.mso.core.entity.models.Usuario;
import org.rec.mso.core.exeptions.UsernameAlreadyExistsException;
import org.rec.mso.core.repository.IUsersRepository;
import org.rec.mso.core.repository.IUsuarioRepository;
import org.rec.mso.core.service.AuthenticationService;
import org.rec.mso.core.utils.Message;
import org.rec.mso.core.utils.RsTrxService;
import org.rec.mso.core.utils.enums.Role;
import org.rec.mso.core.utils.enums.StatusCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AuthenticationServiceImpl implements AuthenticationService {
    //@Autowired
    //private IUsersRepository repository;
    @Autowired
    private IUsuarioRepository repository;
    @Autowired
    private AuthenticationManager manager;
    @Autowired
    private JwtService jwtService;
    @Autowired
    private PasswordEncoder encoder;
    @Override
    @Transactional
    public RsTrxService login(AuthenticationRequest authentication) {
        UsernamePasswordAuthenticationToken autToken = new UsernamePasswordAuthenticationToken(
                authentication.getUsername(), authentication.getPassword());
        manager.authenticate(autToken);
        Usuario user = repository.findByUsername(authentication.getUsername())
                .orElseThrow(( ) -> new UsernameNotFoundException("Not found username " + authentication.getUsername()));
        String jwtDto = jwtService.generateToken(user, jwtService.generateExtraClaims(user));
        //AuthenticationResponse jwt = new AuthenticationResponse(jwtDto);
        RsTrxService jwt = new RsTrxService();
        jwt.setCode(user.getId());
        jwt.setMessage(user.getUsername());
        jwt.setDatoAdicional(user.getRol());
        jwt.setToken(jwtDto);
        jwt.setStatus(StatusCode.SUCCESS);
        return  jwt;
    }

    @Override
    @Transactional
    public AuthenticationResponse sign(AuthenticationRequest authentication) {
        /*String username = authentication.getUsername();
        String password = authentication.getPassword();
        if(repository.existsByUsername(username)){
           throw  new UsernameAlreadyExistsException(Message.USERNAME_ALREADY_EXISTS
           , HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST);
        }
        Users user = new Users();
        user.setUsername(username);
        user.setPassword(encoder.encode(password));
        user.setRole(Role.CUSTOMER);
        repository.save(user);
        String jwtDto = jwtService.generateToken(user, jwtService.generateExtraClaims(user));
        AuthenticationResponse jwt = new AuthenticationResponse(jwtDto);*/
        AuthenticationResponse jwt = new AuthenticationResponse("");
        return jwt;
    }


}
