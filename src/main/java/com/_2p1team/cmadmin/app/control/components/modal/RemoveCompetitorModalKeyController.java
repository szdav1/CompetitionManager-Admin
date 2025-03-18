package com._2p1team.cmadmin.app.control.components.modal;

import com._2p1team.cmadmin.app.control.AbstractKeyController;
import com._2p1team.cmadmin.app.view.components.modals.RemoveCompetitorModal;
import com._2p1team.cmadmin.app.view.frame.FrameManager;

import javax.swing.AbstractAction;
import javax.swing.JComponent;
import javax.swing.KeyStroke;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

public final class RemoveCompetitorModalKeyController extends AbstractKeyController {

    private final RemoveCompetitorModal removeCompetitorModal;
    private final RemoveCompetitorModalController controller;

    public RemoveCompetitorModalKeyController(final RemoveCompetitorModal keyControlledComponent, final RemoveCompetitorModalController controller) {
        super(keyControlledComponent);

        this.removeCompetitorModal = keyControlledComponent;
        this.controller = controller;

        this.removeCompetitorModal.getTitleLabel()
            .getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW)
            .put(KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), "HideRemoveCompetitorModalAction");

        this.removeCompetitorModal.getTitleLabel()
            .getActionMap()
            .put("HideRemoveCompetitorModalAction", new HideRemoveCompetitorModalAction());

        this.removeCompetitorModal.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW)
            .put(KeyStroke.getKeyStroke(KeyEvent.VK_A, KeyEvent.CTRL_DOWN_MASK), "SelectAllCompetitorsAction");

        this.removeCompetitorModal.getActionMap()
            .put("SelectAllCompetitorsAction", new SelectAllCompetitorsAction());

        this.removeCompetitorModal.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW)
            .put(KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, KeyEvent.ALT_DOWN_MASK), "DeleteSelectedCompetitorsAction");

        this.removeCompetitorModal.getActionMap()
            .put("DeleteSelectedCompetitorsAction", new DeleteSelectedCompetitorsAction());
    }

    private static final class HideRemoveCompetitorModalAction extends AbstractAction {

        @Override
        public void actionPerformed(ActionEvent e) {
            FrameManager.hideOpenedModal();
        }

    }

    private final class SelectAllCompetitorsAction extends AbstractAction {

        @Override
        public void actionPerformed(ActionEvent e) {
            RemoveCompetitorModalKeyController.this.controller.getRemoveCompetitorModal()
                .getCompetitorDisplays()
                .forEach(competitorDisplay -> competitorDisplay.getCheckbox().toggleChecked());
        }

    }

    private final class DeleteSelectedCompetitorsAction extends AbstractAction {

        @Override
        public void actionPerformed(ActionEvent e) {
            RemoveCompetitorModalKeyController.this.controller.deleteSelectedCompetitors();
        }

    }

}