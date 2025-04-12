package org.rec.mso.core.odontologia.service;

import lombok.NonNull;
import org.rec.mso.core.entity.models.Pago;
import org.rec.mso.core.utils.RsTrxService;

import java.util.List;

public interface PagoService {
    List<Pago> getAll();

    Pago getForId(@NonNull Integer id);

    RsTrxService register(Pago body);

    RsTrxService update(Pago body);
}
