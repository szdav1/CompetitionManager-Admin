package com._2p1team.cmadmin.app.control.components.modal;

import com._2p1team.cmadmin.app.control.AbstractController;
import com._2p1team.cmadmin.app.dto.competition.Competition;
import com._2p1team.cmadmin.app.view.components.fencing.Box;
import com._2p1team.cmadmin.app.view.components.modals.NewTableModal;
import com._2p1team.cmadmin.app.view.frame.FrameManager;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

public final class NewTableModalController extends AbstractController {

    private final NewTableModal newTableModal;

    public NewTableModalController(final NewTableModal component) {
        super(component);

        this.newTableModal = component;

        this.addListeners();
        new NewTableModalKeyController(this.newTableModal);
    }

    private void addListeners() {
        this.newTableModal.getCreateButton().addActionListener(this);
        this.newTableModal.getNumberInput().addKeyListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String competitionName = this.newTableModal.getCompetitionNameInput().getText();
        String competitionLocation = this.newTableModal.getCompetitionLocationInput().getText();

        if (e.getSource().equals(this.newTableModal.getCreateButton()) && !competitionName.isBlank() && !competitionLocation.isBlank()) {
            boolean validationPassed = this.newTableModal.validateInputData();

            if (!validationPassed)
                return;

            FrameManager.setCurrentCompetition(new Competition(competitionName, competitionLocation));
            FrameManager.hideOpenedModal();
            FrameManager.displayTableCompetitionPanel();
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        if (e.getSource().equals(this.newTableModal.getNumberInput()))
            this.newTableModal.getNumberInput().setBackground(Box.DEFAULT_BACKGROUND);
    }

}