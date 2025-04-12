package org.rec.mso.core.service;

import lombok.NonNull;
import org.rec.mso.core.entity.models.Usuario;
import org.rec.mso.core.utils.RsTrxService;

import java.util.List;

public interface PersonUserService {
    List<Usuario> getAllUsers();

    Usuario getPersonForId(@NonNull Integer id);

    RsTrxService registerUser(Usuario body);

    RsTrxService updateUser(Usuario body);

}
