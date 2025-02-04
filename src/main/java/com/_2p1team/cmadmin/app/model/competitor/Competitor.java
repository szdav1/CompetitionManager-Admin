package com._2p1team.cmadmin.app.model.competitor;

import lombok.Data;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Data
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