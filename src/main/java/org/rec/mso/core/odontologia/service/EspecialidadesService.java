

package org.rec.mso.core.odontologia.service;

import lombok.NonNull;
import org.rec.mso.core.entity.models.EspecialidadMedica;
import org.rec.mso.core.utils.RsTrxService;

import java.util.List;

public interface EspecialidadesService {
    List<EspecialidadMedica> getAll();

    EspecialidadMedica getForId(@NonNull Integer id);

    RsTrxService register(EspecialidadMedica body);

    RsTrxService update(EspecialidadMedica body);
}
