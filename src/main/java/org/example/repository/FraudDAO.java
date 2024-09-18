package org.example.repository;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.OffsetDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FraudDAO {
    private Integer id;
    private Long number;
    private boolean flagOfBlocking;

    public FraudDAO(Long number) {
        this.number = number;
    }

    private OffsetDateTime timeOfBlocking;
}
