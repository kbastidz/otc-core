package org.rec.mso.core.odontologia.service;

import lombok.NonNull;
import org.rec.mso.core.entity.models.Cita;
import org.rec.mso.core.utils.RsTrxService;

import java.util.List;

public interface CronogramaService {
    List<Cita> getAll();

    Cita getForId(@NonNull Integer id);

    RsTrxService register(Cita body);

    RsTrxService update(Cita body);
}
