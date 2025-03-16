package com._2p1team.cmadmin.app.dto.competition;

import java.time.LocalDate;

public record Competition(
    String name,
    String location,
    String date
) {

    public Competition(String name, String location) {
        this(name, location, String.valueOf(LocalDate.now()));
    }

    public Competition() {
        this("", "", String.valueOf(LocalDate.now()));
    }

}