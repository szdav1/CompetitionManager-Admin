package com._2p1team.cmadmin.app.control.components.fencing.poule;

import com._2p1team.cmadmin.app.control.AbstractController;
import com._2p1team.cmadmin.app.view.components.fencing.poule.PouleCompetitionPanel;
import com._2p1team.cmadmin.app.view.components.fencing.poule.PouleCompetitionPanelKeyController;
import com._2p1team.cmadmin.app.view.frame.FrameManager;
import com._2p1team.cmadmin.swing.override.components.button.Button;

import java.awt.event.ActionEvent;

public final class PouleCompetitionPanelController extends AbstractController {

    private final PouleCompetitionPanel panel;
    private final Button closeButton;

    public PouleCompetitionPanelController(final PouleCompetitionPanel component) {
        super(component);

        this.panel = component;
        this.closeButton = this.panel.getCloseButton();

        this.addListeners();
        new PouleCompetitionPanelKeyController(this.panel);
    }

    private void addListeners() {
        this.closeButton.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(this.closeButton))
            FrameManager.hidePouleCompetitionPanel();
    }

}