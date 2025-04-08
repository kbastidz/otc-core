package org.rec.mso.core.service;

import org.rec.mso.core.entity.dto.AuthenticationRequest;
import org.rec.mso.core.entity.dto.AuthenticationResponse;

public interface AuthenticationService {
    AuthenticationResponse login(AuthenticationRequest authentication);
    AuthenticationResponse sign(AuthenticationRequest authentication);
}
