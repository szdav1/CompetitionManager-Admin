package com._2p1team.cmadmin.app.view.frame.parts;

import com._2p1team.cmadmin.app.view.interfaces.ComplexComponent;
import static com._2p1team.cmadmin.support.constants.SizeData.SCREEN_HEIGHT;
import static com._2p1team.cmadmin.support.constants.SizeData.SCREEN_WIDTH;
import com._2p1team.cmadmin.support.util.AppearanceRepository;
import com._2p1team.cmadmin.swing.override.components.label.Label;
import com._2p1team.cmadmin.swing.override.components.panel.Panel;
import com._2p1team.cmadmin.swing.override.constants.Position;

import java.awt.Dimension;
import java.awt.Rectangle;

public final class CenterPanel extends Panel implements ComplexComponent {
    private final Label backgroundLabel;

    public CenterPanel() {
        super(new Dimension(), null, AppearanceRepository.CENTER_PANEL_APPEARANCE);

        this.backgroundLabel = new Label(new Rectangle(0, 0, SCREEN_WIDTH, SCREEN_HEIGHT), "", AppearanceRepository.CENTER_PANEL_APPEARANCE);

        this.setUpComponent();
    }

    @Override
    public void setUpComponent() {
        this.addComponent(this.backgroundLabel, Position.BACKGROUND);
    }
}