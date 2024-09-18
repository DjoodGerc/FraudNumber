package org.example.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;
import java.time.OffsetDateTime;

@Data
@AllArgsConstructor
public class Status {
    private OffsetDateTime timeOfBlocking;
    private String Status;
}
