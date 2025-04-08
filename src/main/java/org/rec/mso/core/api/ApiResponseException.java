package org.rec.mso.core.api;

import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

import java.io.Serial;
import java.io.Serializable;

@Getter
@Setter
public class ApiResponseException implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;
    private String message;
    private int code;
    private HttpStatus http;

    public ApiResponseException() {
    }

    public ApiResponseException(String message, int code, HttpStatus http) {
        this.message = message;
        this.code = code;
        this.http = http;
    }
}
