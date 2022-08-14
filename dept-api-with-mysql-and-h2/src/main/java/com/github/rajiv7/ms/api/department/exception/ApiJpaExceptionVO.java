package com.github.rajiv7.ms.api.department.exception;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(content = JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties (ignoreUnknown = true)
public class ApiJpaExceptionVO {
    public String getErrorCode() {
        return errorCode;
    }

    private String errorCode;

    public String getMessage() {
        return message;
    }

    private String message;

    public ApiJpaExceptionVO(String errorCode, String message) {
        super();
        this.errorCode = errorCode;
        this.message = message;
    }
}
