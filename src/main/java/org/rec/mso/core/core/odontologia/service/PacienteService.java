
package org.rec.mso.core.odontologia.service;

import lombok.NonNull;
import org.rec.mso.core.entity.models.Paciente;
import org.rec.mso.core.utils.RsTrxService;

import java.util.List;

public interface PacienteService {
    List<Paciente> getAll();

    Paciente getForId(@NonNull Integer id);

    RsTrxService register(Paciente body);

    RsTrxService update(Paciente body);
}
