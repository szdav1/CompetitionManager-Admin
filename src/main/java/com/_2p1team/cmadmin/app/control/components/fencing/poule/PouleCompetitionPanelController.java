package com._2p1team.cmadmin.app.control.components.fencing.poule;

import com._2p1team.cmadmin.app.control.AbstractController;
import com._2p1team.cmadmin.app.view.components.fencing.poule.PouleCompetitionPanel;
import com._2p1team.cmadmin.app.view.frame.FrameManager;
import com._2p1team.cmadmin.swing.override.components.button.Button;

import java.awt.event.ActionEvent;

public final class PouleCompetitionPanelController extends AbstractController {

    private final PouleCompetitionPanel panel;
    private final Button closeButton;
    private final Button finishButton;
    private final Button resultsButton;
    private final Button bottomCloseButton;
    private final Button continueButton;

    public PouleCompetitionPanelController(final PouleCompetitionPanel component) {
        super(component);

        this.panel = component;
        this.closeButton = this.panel.getCloseButton();
        this.finishButton = this.panel.getFinishButton();
        this.resultsButton = this.panel.getResultsButton();
        this.bottomCloseButton = this.panel.getBottomCloseButton();
        this.continueButton = this.panel.getContinueButton();

        this.addListeners();
        new PouleCompetitionPanelKeyController(this.panel);
    }

    private void addListeners() {
        this.closeButton.addActionListener(this);
        this.finishButton.addActionListener(this);
        this.resultsButton.addActionListener(this);
        this.bottomCloseButton.addActionListener(this);
        this.continueButton.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(this.closeButton) || e.getSource().equals(this.bottomCloseButton))
            FrameManager.hidePouleCompetitionPanel();

        else if (e.getSource().equals(this.finishButton))
            this.panel.finishPoules();

        else if (e.getSource().equals(this.resultsButton))
            this.panel.showResults();

        else if (e.getSource().equals(this.continueButton)) {
            FrameManager.hidePouleCompetitionPanel();
            FrameManager.displayTableCompetitionPanel();
        }
    }

}