package com._2p1team.cmadmin.app.view.frame.parts;

import com._2p1team.cmadmin.app.view.interfaces.ComplexComponent;
import static com._2p1team.cmadmin.support.constants.SizeData.TITLE_SIZE;
import static com._2p1team.cmadmin.support.constants.SizeData.TITLE_TEXT_SIZE;
import com._2p1team.cmadmin.support.util.AppearanceRepository;
import com._2p1team.cmadmin.swing.override.components.label.Label;
import com._2p1team.cmadmin.swing.override.components.panel.Panel;

import java.awt.FlowLayout;

public final class FooterPanel extends Panel implements ComplexComponent {

    private final Label versionLabel;

    public FooterPanel() {
        super(TITLE_SIZE, new FlowLayout(FlowLayout.CENTER), AppearanceRepository.TITLE_BAR_APPEARANCE);

        this.versionLabel = new Label(TITLE_TEXT_SIZE, "Version 1.0 - Open Beta", AppearanceRepository.TITLE_TEXT_APPEARANCE);

        this.setUpComponent();
    }

    @Override
    public void setUpComponent() {
        this.addComponent(this.versionLabel);
    }

}