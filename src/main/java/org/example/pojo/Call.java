package org.example.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.time.OffsetDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Call {
    private Integer id;

    private Long callerPhoneNumber; //->long

    private Long calledPhoneNumber; //->long

    private Long callDuration;

    private OffsetDateTime callDate;

    private Boolean is_spam;

    private Boolean is_roaming;

    private String roaming_country;

    private Boolean is_fraud;
}