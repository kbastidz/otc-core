package org.rec.mso.core.odontologia.service;

import lombok.NonNull;
import org.rec.mso.core.entity.models.Doctor;
import org.rec.mso.core.utils.RsTrxService;

import java.util.List;

public interface DoctorService {
    List<Doctor> getAll();

    Doctor getForId(@NonNull Integer id);

    RsTrxService register(Doctor body);

    RsTrxService update(Doctor body);
}
