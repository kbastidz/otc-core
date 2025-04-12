package org.rec.mso.core.odontologia.service;

import lombok.NonNull;
import org.rec.mso.core.entity.models.Comprobante;
import org.rec.mso.core.utils.RsTrxService;

import java.util.List;

public interface ComprobanteService {
    List<Comprobante> getAll();

    Comprobante getForId(@NonNull Integer id);

    RsTrxService register(Comprobante body);

    RsTrxService update(Comprobante body);
}
