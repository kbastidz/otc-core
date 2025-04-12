package org.rec.mso.core.controller;

import jakarta.validation.Valid;
import org.rec.mso.core.entity.dto.AuthenticationRequest;
import org.rec.mso.core.entity.dto.AuthenticationResponse;
import org.rec.mso.core.service.AuthenticationService;
import org.rec.mso.core.utils.RsTrxService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Validated
//@CrossOrigin(origins = "http://localhost:4200", methods = { RequestMethod.POST, RequestMethod.OPTIONS }, allowedHeaders = "*", allowCredentials = "true")
@RestController
@RequestMapping("/api/v1/OTC/authentication")
public class AuthenticationController {
    @Autowired
    private AuthenticationService service;
    @PostMapping("/login")
    public ResponseEntity<RsTrxService> login(@RequestBody @Valid AuthenticationRequest request){
        return ResponseEntity.ok(service.login(request));

    }
    @PostMapping("/sign")
    public ResponseEntity<AuthenticationResponse> sign(@RequestBody @Valid AuthenticationRequest request){
        return ResponseEntity.ok(service.sign(request));
    }

}
