package com._2p1team.cmadmin.app.dto.competition;

import java.time.LocalDate;

public record Competition(
    String name,
    String location,
    LocalDate date
) {

    public Competition(String name, String location) {
        this(name, location, LocalDate.now());
    }

    public Competition() {
        this("", "", LocalDate.now());
    }

}