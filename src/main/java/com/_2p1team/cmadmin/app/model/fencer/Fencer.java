package com._2p1team.cmadmin.app.model.fencer;

import lombok.AccessLevel;
import lombok.Data;
import lombok.Getter;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Data
public class Fencer {

    private Long id;
    private String name;
    private String club;
    @Getter(AccessLevel.NONE)
    private String birthDateString;

    public Fencer(Long id, String name, String club, String birthDateString) {
        this.id = id;
        this.name = name;
        this.club = club;
        this.birthDateString = birthDateString;
    }

    public Fencer(String name, String club, String birthDateString) {
        this.name = name;
        this.club = club;
        this.birthDateString = birthDateString;
    }

    public LocalDate getBirthDate() {
        return LocalDate.parse(birthDateString, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
    }

}