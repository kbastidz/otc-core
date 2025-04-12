
package org.rec.mso.core.service.impl;

import lombok.NonNull;
import lombok.extern.log4j.Log4j2;
import org.rec.mso.core.entity.models.Cita;
import org.rec.mso.core.repository.ICitaRepository;
import org.rec.mso.core.service.CitaService;

import org.rec.mso.core.exeptions.*;

import org.rec.mso.core.utils.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Log4j2
@Service
public class CitaServiceImpl implements CitaService {

    @Autowired
    private ICitaRepository repository;

    @Transactional(readOnly = true)
    @Override
    public List<Cita> getAll() {
        return repository.findAll();
    }

    @Transactional(readOnly = true)
    @Override
    public Cita getForId(@NonNull Integer id) {
        return repository.findById(id).orElseThrow(() -> new NotFoundProductExeptions(Message.NOT_FOUND_PRODUCT, HttpStatus.NOT_FOUND.value(), HttpStatus.NOT_FOUND));
    }

    @Transactional
    @Override
    public RsTrxService register(Cita body) {
        try {
            Optional<Cita> isVerify = p_repository.findByCedula(body.getPersona().getCedula());
            if(isVerify.isPresent()) {
                log.info("Registro duplicado.");
                return new RsTrxService(StatusCode.CONFLICT, 409, Message.ALREADY_EXISTS);
            }

            repository.save(body);
            log.info("Registro exitoso.");
            return new RsTrxService(StatusCode.SUCCESS, 0, "OK");
        } catch (Exception e) {
            log.error("Error al registrar: {}", e.getMessage());
            new RsTrxService(StatusCode.INTERNAL_SERVER_ERROR, 0, e.getCause().getMessage());
            throw new BusinessException(new RsTrxService(StatusCode.INTERNAL_SERVER_ERROR, 0, e.getCause().getMessage()));
        }
    }

    @Transactional
    @Override
    public RsTrxService update(Cita body) {
        try {
            repository.save(body);
            log.info("Actualización exitosa.");
            return new RsTrxService(StatusCode.SUCCESS, 0, "Actualización exitosa.");
        } catch (Exception e) {
            log.error("Error al actualizar: {}", e.getMessage());
            throw new BusinessException(new RsTrxService(StatusCode.INTERNAL_SERVER_ERROR, 0, e.getMessage()));
        }
    }
}