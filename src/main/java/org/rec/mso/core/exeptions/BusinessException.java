package org.rec.mso.core.exeptions;

import org.rec.mso.core.utils.RsTrxService;

public class BusinessException extends RuntimeException {
    private final RsTrxService response;

    public BusinessException(RsTrxService response) {
        super(response.getMessage());
        this.response = response;
    }

    public RsTrxService getResponse() {
        return response;
    }
}
