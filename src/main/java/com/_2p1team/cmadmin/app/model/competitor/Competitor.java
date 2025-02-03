package com._2p1team.cmadmin.app.model.competitor;

import lombok.AccessLevel;
import lombok.Data;
import lombok.Getter;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Data
public class Competitor {

    private Long id;
    private String name;
    private String club;
    @Getter(AccessLevel.NONE)
    private String birthDate;

    public Competitor(Long id, String name, String club, String birthDate) {
        this.id = id;
        this.name = name;
        this.club = club;
        this.birthDate = birthDate;
    }

    public LocalDate getBirthDate() {
        return LocalDate.parse(birthDate, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
    }

    public String getBirthDateAsString() {
        return this.birthDate;
    }

}