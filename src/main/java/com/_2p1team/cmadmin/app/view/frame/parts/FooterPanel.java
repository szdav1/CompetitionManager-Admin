package com._2p1team.cmadmin.app.view.frame.parts;

import static com._2p1team.cmadmin.support.appdata.SizeData.TITLE_SIZE;
import static com._2p1team.cmadmin.support.appdata.SizeData.TITLE_TEXT_SIZE;
import com._2p1team.cmadmin.support.util.AppearanceRepository;
import com._2p1team.cmadmin.swing.override.components.label.Label;
import com._2p1team.cmadmin.swing.override.components.panel.Panel;

import java.awt.FlowLayout;

public final class FooterPanel extends Panel {
    public FooterPanel() {
        super(TITLE_SIZE, new FlowLayout(FlowLayout.CENTER), AppearanceRepository.TITLE_BAR_APPEARANCE);

        Label versionLabel = new Label(TITLE_TEXT_SIZE, "Version 1.0 - Open Beta", AppearanceRepository.TITLE_TEXT_APPEARANCE);

        this.addComponent(versionLabel);
    }
}