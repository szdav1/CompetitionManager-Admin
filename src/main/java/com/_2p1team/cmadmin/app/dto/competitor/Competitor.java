package com._2p1team.cmadmin.app.dto.competitor;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Data
@AllArgsConstructor
public final class Competitor {

    private Long id;
    private String name;
    private String club;
    private String birthDate;

    public LocalDate getBirthDate() {
        return LocalDate.parse(birthDate, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
    }

    public String getBirthDateAsString() {
        return this.birthDate;
    }

}