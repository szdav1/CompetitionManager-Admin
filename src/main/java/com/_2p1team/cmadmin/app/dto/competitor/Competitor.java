package com._2p1team.cmadmin.app.dto.competitor;

import com._2p1team.cmadmin.app.view.components.competitor.CompetitorDisplay;
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

    public Competitor(final CompetitorDisplay competitorDisplay) {
        this.id = Long.parseLong(competitorDisplay.getIdLabel().getText());
        this.name = competitorDisplay.getNameLabel().getText();
        this.club = competitorDisplay.getClubLabel().getText();
        this.birthDate = competitorDisplay.getBirthDateLabel().getText();
    }

    public LocalDate getBirthDate() {
        return LocalDate.parse(birthDate, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
    }

    public String getBirthDateAsString() {
        return this.birthDate;
    }

}