package com._2p1team.cmadmin.app.dto.competitor;

public record CompetitorTransferModel(
    Long id,
    String name,
    String club,
    String birthDate,
    int poulePlace
) {

}