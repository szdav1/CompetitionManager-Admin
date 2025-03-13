package com._2p1team.cmadmin.app.view.components.competition;

import com._2p1team.cmadmin.app.dto.competition.Competition;
import com._2p1team.cmadmin.app.view.interfaces.ComplexComponent;
import static com._2p1team.cmadmin.support.constants.SizeData.*;
import com._2p1team.cmadmin.support.util.AppearanceRepository;
import com._2p1team.cmadmin.swing.override.components.label.Label;
import com._2p1team.cmadmin.swing.override.components.panel.Panel;
import com._2p1team.cmadmin.swing.override.graphics.Appearance;

import java.awt.Dimension;
import java.awt.FlowLayout;

public final class CompetitionDisplay extends Panel implements ComplexComponent {

    private final Label nameLabel;
    private final Label locationLabel;
    private final Label dateLabel;

    public CompetitionDisplay(final Competition competition) {
        super(new Dimension(BUTTON_WIDTH*3, BUTTON_HEIGHT), new FlowLayout(FlowLayout.CENTER, 0, 0), AppearanceRepository.COMPETITION_DISPLAY_APPEARANCE);

        this.nameLabel = new Label(BUTTON_SIZE, competition.name(), new Appearance(AppearanceRepository.LABELED_INPUT_APPEARANCE));
        this.locationLabel = new Label(BUTTON_SIZE, competition.location(), new Appearance(AppearanceRepository.LABELED_INPUT_APPEARANCE));
        this.dateLabel = new Label(BUTTON_SIZE, String.valueOf(competition.date()), new Appearance(AppearanceRepository.LABELED_INPUT_APPEARANCE));

        this.setUpComponent();
    }

    @Override
    public void setUpComponent() {
        this.addComponent(this.nameLabel);
        this.addComponent(this.locationLabel);
        this.addComponent(this.dateLabel);
    }

}