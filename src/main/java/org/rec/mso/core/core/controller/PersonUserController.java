package org.rec.mso.core.controller;

import org.rec.mso.core.entity.models.Usuario;
import org.rec.mso.core.service.PersonUserService;
import org.rec.mso.core.utils.RsTrxService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Validated
@RestController
@RequestMapping("/api/v1/personuser")
public class PersonUserController {

    @Autowired
    private PersonUserService service;

    @GetMapping("/consultPerson")
    public ResponseEntity<List<Usuario>> getAll(){
        return ResponseEntity.ok((service.getAllUsers()));
    }

    @GetMapping("/consultPersonId/{id}")
    public ResponseEntity<Usuario> getId(@PathVariable Integer id){
        return ResponseEntity.ok(service.getPersonForId(id));
    }

    @PostMapping("/registerUser")
    public ResponseEntity<RsTrxService> insert(@RequestBody Usuario body){
        return ResponseEntity.status(HttpStatus.CREATED).body(service.registerUser(body));
    }

    @PutMapping("/updateUser")
    public ResponseEntity<RsTrxService> update(@RequestBody Usuario body){
        return ResponseEntity.ok(service.updateUser(body));
    }
}
