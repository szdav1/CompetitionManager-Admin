package com._2p1team.cmadmin.app.view.frame.parts;

import com._2p1team.cmadmin.app.view.interfaces.ComplexComponent;
import com._2p1team.cmadmin.support.util.AppearanceRepository;
import com._2p1team.cmadmin.swing.override.components.panel.Panel;

import java.awt.Dimension;

public final class CenterPanel extends Panel implements ComplexComponent {

    public CenterPanel() {
        super(new Dimension(), null, AppearanceRepository.CENTER_PANEL_APPEARANCE);

        this.setUpComponent();
    }

    @Override
    public void setUpComponent() {
    }
}