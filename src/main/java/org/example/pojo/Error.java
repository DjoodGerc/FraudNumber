package org.example.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.http.HttpStatus;

@Data
@AllArgsConstructor
public class Error {
    private int code;
    private String reason;

    public Error(HttpStatus httpStatus) {
        this.code = httpStatus.value();
        this.reason = httpStatus.getReasonPhrase();
    }
}
