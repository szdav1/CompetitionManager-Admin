package com._2p1team.cmadmin.app.control.components.modal;

import com._2p1team.cmadmin.app.control.AbstractKeyController;
import com._2p1team.cmadmin.app.dto.competition.Competition;
import com._2p1team.cmadmin.app.view.components.modals.NewTableModal;
import com._2p1team.cmadmin.app.view.frame.FrameManager;
import com._2p1team.cmadmin.support.constants.states.FrameState;

import javax.swing.AbstractAction;
import javax.swing.JComponent;
import javax.swing.KeyStroke;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

public final class NewTableModalKeyController extends AbstractKeyController {

    private final NewTableModal newTableModal;

    public NewTableModalKeyController(final NewTableModal keyControlledComponent) {
        super(keyControlledComponent);

        this.newTableModal = keyControlledComponent;

        this.newTableModal.getCenterPanel()
            .getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW)
            .put(KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), "CloseNewTableModalAction");

        this.newTableModal.getCenterPanel()
            .getActionMap()
            .put("CloseNewTableModalAction", new CloseNewTableModalAction());

        this.newTableModal.getCenterPanel()
            .getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW)
            .put(KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0), "CreateNewTableAction");

        this.newTableModal.getCenterPanel()
            .getActionMap()
            .put("CreateNewTableAction", new CreateNewTableAction());
    }

    private static final class CloseNewTableModalAction extends AbstractAction {

        @Override
        public void actionPerformed(ActionEvent e) {
            if (FrameManager.getState() == FrameState.MODAL_OPENED)
                FrameManager.hideOpenedModal();
        }

    }

    private final class CreateNewTableAction extends AbstractAction {

        @Override
        public void actionPerformed(ActionEvent e) {
            String competitionName = NewTableModalKeyController.this.newTableModal.getCompetitionNameInput().getText();
            String competitionLocation = NewTableModalKeyController.this.newTableModal.getCompetitionLocationInput().getText();

            if (!competitionName.isBlank() && !competitionLocation.isBlank()) {
                boolean validationPassed = NewTableModalKeyController.this.newTableModal.validateInputData();

                if (!validationPassed)
                    return;

                FrameManager.setCurrentCompetition(new Competition(competitionName, competitionLocation));
                FrameManager.hideOpenedModal();
                FrameManager.displayTableCompetitionPanel();
            }
        }

    }

}