package com._2p1team.cmadmin.app.dto.competitor;

import lombok.Data;

@Data
public final class CompetitorTransferClass {

    private Long id;
    private String name;
    private String club;
    private String birthDate;
    private int index;
    private int placement;

    public CompetitorTransferClass(final CompetitorTransferModel model) {
        this.id = model.id();
        this.name = model.name();
        this.club = model.club();
        this.birthDate = model.birthDate();
        this.index = model.index();
        this.placement = model.placement();
    }

}