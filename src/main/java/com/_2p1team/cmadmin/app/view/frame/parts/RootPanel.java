package com._2p1team.cmadmin.app.view.frame.parts;

import com._2p1team.cmadmin.app.view.interfaces.ComplexComponent;
import static com._2p1team.cmadmin.support.constants.SizeData.FRAME_HEIGHT;
import static com._2p1team.cmadmin.support.constants.SizeData.FRAME_WIDTH;
import com._2p1team.cmadmin.support.util.AppearanceRepository;
import com._2p1team.cmadmin.swing.override.components.label.Label;
import com._2p1team.cmadmin.swing.override.components.panel.Panel;
import com._2p1team.cmadmin.swing.override.constants.Position;

import java.awt.Rectangle;

public final class RootPanel extends Panel implements ComplexComponent {

    private final Label backgroundLabel;

    public RootPanel() {
        this(FRAME_WIDTH, FRAME_HEIGHT);
    }

    public RootPanel(int width, int height) {
        super(new Rectangle(0, 0, width, height), null, AppearanceRepository.ROOT_PANEL_APPEARANCE);

        this.backgroundLabel = new Label(this.getBounds(), AppearanceRepository.BACKGROUND_LABEL_APPEARANCE);

        this.setUpComponent();
    }

    @Override
    public void setUpComponent() {
        this.addComponent(this.backgroundLabel, Position.BACKGROUND);
    }

}