package org.rec.mso.core.utils;

import lombok.Data;
import org.rec.mso.core.utils.enums.StatusCode;

@Data
public class RsTrxService {

    private StatusCode status;
    private int code;
    private String message;
    private String token;
    private String datoAdicional;

    public RsTrxService() {
    }

    public RsTrxService(StatusCode status, int code, String message) {
        this.status = status;
        this.code = code;
        this.message = message;
    }

    public RsTrxService(StatusCode status, int code, String message, String datoAdicional) {
        this.status = status;
        this.code = code;
        this.message = message;
        this.datoAdicional = datoAdicional;
    }
}
