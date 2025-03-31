package com._2p1team.cmadmin.app.control.components.modal.updatecompetitor;

import com._2p1team.cmadmin.app.control.AbstractKeyController;
import com._2p1team.cmadmin.app.view.components.modals.UpdateCompetitorModal;
import com._2p1team.cmadmin.app.view.frame.FrameManager;

import javax.swing.AbstractAction;
import javax.swing.JComponent;
import javax.swing.KeyStroke;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

public final class UpdateCompetitorModalKeyController extends AbstractKeyController {

    private final UpdateCompetitorModal updateCompetitorModal;
    private final UpdateCompetitorModalController controller;

    public UpdateCompetitorModalKeyController(final UpdateCompetitorModal keyControlledComponent, final UpdateCompetitorModalController controller) {
        super(keyControlledComponent);

        this.updateCompetitorModal = keyControlledComponent;
        this.controller = controller;

        this.updateCompetitorModal.getCloseButton()
            .getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW)
            .put(KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), "HideUpdateCompetitorModal");

        this.updateCompetitorModal.getCloseButton()
            .getActionMap()
            .put("HideUpdateCompetitorModal", new HideUpdateCompetitorModal());

        this.updateCompetitorModal.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW)
            .put(KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, KeyEvent.ALT_DOWN_MASK), "UpdateSelectedCompetitor");

        this.updateCompetitorModal.getActionMap()
            .put("UpdateSelectedCompetitor", new UpdateSelectedCompetitor());

        this.updateCompetitorModal.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW)
            .put(KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0), "SearchForCompetitor");

        this.updateCompetitorModal.getActionMap()
            .put("SearchForCompetitor", new SearchForCompetitor());
    }

    private static final class HideUpdateCompetitorModal extends AbstractAction {

        @Override
        public void actionPerformed(ActionEvent e) {
            FrameManager.hideOpenedModal();
        }

    }

    private final class UpdateSelectedCompetitor extends AbstractAction {

        @Override
        public void actionPerformed(ActionEvent e) {
            UpdateCompetitorModalKeyController.this.controller.updateCompetitor();
        }

    }

    private final class SearchForCompetitor extends AbstractAction {

        @Override
        public void actionPerformed(ActionEvent e) {
            UpdateCompetitorModalKeyController.this.controller.searchCompetitor();
        }

    }

}