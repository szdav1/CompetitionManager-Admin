package com._2p1team.cmadmin.app.control.components.modal.addcompetitor;

import com._2p1team.cmadmin.app.control.AbstractKeyController;
import com._2p1team.cmadmin.app.view.components.modals.AddCompetitorModal;
import com._2p1team.cmadmin.app.view.frame.FrameManager;

import javax.swing.AbstractAction;
import javax.swing.JComponent;
import javax.swing.KeyStroke;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

public final class AddCompetitorModalKeyController extends AbstractKeyController {

    private final AddCompetitorModal addCompetitorModal;
    private final AddCompetitorModalController controller;

    public AddCompetitorModalKeyController(final AddCompetitorModal keyControlledComponent, final AddCompetitorModalController controller) {
        super(keyControlledComponent);

        this.addCompetitorModal = keyControlledComponent;
        this.controller = controller;

        this.addCompetitorModal.getTopPanel().getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW)
            .put(KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), "CloseAddCompetitorModalAction");

        this.addCompetitorModal.getTopPanel().getActionMap()
            .put("CloseAddCompetitorModalAction", new CloseAddCompetitorModalAction());

        this.addCompetitorModal.getTopPanel().getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW)
            .put(KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0), "AddCompetitorAction");

        this.addCompetitorModal.getTopPanel().getActionMap()
            .put("AddCompetitorAction", new AddCompetitorAction());
    }

    private static final class CloseAddCompetitorModalAction extends AbstractAction {

        @Override
        public void actionPerformed(ActionEvent e) {
            FrameManager.hideOpenedModal();
        }

    }

    private final class AddCompetitorAction extends AbstractAction {

        @Override
        public void actionPerformed(ActionEvent e) {
            AddCompetitorModalKeyController.this.controller.addCompetitor();
        }

    }

}