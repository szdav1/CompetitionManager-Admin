package com._2p1team.cmadmin.app.dto.competition;

import java.time.LocalDate;

public record Competition(
    String name,
    String location,
    LocalDate date
) {

}