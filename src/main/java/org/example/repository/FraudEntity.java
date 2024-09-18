package org.example.repository;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.OffsetDateTime;

@Data
@Entity
@AllArgsConstructor
@Table(name= "fraud_numbers")
@NoArgsConstructor
public class FraudEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "number")
    private Long number;
    @Column(name= "flag_of_blocking")
    private boolean flagOfBlocking;
    @Column(name="time_of_blocking")
    private OffsetDateTime timeOfBlocking;
}
