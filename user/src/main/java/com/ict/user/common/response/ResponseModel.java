package com.ict.user.common.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@Getter
@Setter
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ResponseModel {

    private int code;
    private String status;
    private Object data;
    private String message;
    private Object errors;

    public static ResponseModel createResponse(HttpStatus status, String message, Object data, Object errors){
        return ResponseModel.builder()
                .code(status.value())
                .status(status.getReasonPhrase())
                .data(data)
                .message(message)
                .errors(errors)
                .build();
    }
}
