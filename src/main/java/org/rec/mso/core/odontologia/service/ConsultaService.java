package org.rec.mso.core.odontologia.service;

import lombok.NonNull;
import org.rec.mso.core.entity.models.RegistroConsulta;
import org.rec.mso.core.utils.RsTrxService;

import java.util.List;

public interface ConsultaService {
    List<RegistroConsulta> getAll();

    RegistroConsulta getForId(@NonNull Integer id);

    RsTrxService register(RegistroConsulta body);

    RsTrxService update(RegistroConsulta body);
}
