
package org.rec.mso.core.odontologia.service;

import lombok.NonNull;
import org.rec.mso.core.entity.models.HistorialClinico;
import org.rec.mso.core.utils.RsTrxService;

import java.util.List;

public interface HistorialClinicoService {
    List<HistorialClinico> getAll();

    HistorialClinico getForId(@NonNull Integer id);

    RsTrxService register(HistorialClinico body);

    RsTrxService update(HistorialClinico body);
}
