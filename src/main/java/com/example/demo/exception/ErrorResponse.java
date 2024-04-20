package com.example.demo.exception;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class ErrorResponse implements Serializable {
    private String field;
    private Object data;
    private String message;

    @Override
    public String toString() {
        return "ErrorResponse{" +
                "field='" + field + '\'' +
                ", data=" + data +
                ", message='" + message + '\'' +
                '}';
    }
}
