package com._2p1team.cmadmin.app.control.components.modal;

import com._2p1team.cmadmin.app.control.AbstractKeyController;
import com._2p1team.cmadmin.app.view.components.modals.DeleteCompetitorModal;
import com._2p1team.cmadmin.app.view.frame.FrameManager;

import javax.swing.AbstractAction;
import javax.swing.JComponent;
import javax.swing.KeyStroke;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

public final class DeleteCompetitorModalKeyController extends AbstractKeyController {

    private final DeleteCompetitorModal deleteCompetitorModal;
    private final DeleteCompetitorModalController controller;

    public DeleteCompetitorModalKeyController(final DeleteCompetitorModal keyControlledComponent, final DeleteCompetitorModalController controller) {
        super(keyControlledComponent);

        this.deleteCompetitorModal = keyControlledComponent;
        this.controller = controller;

        this.deleteCompetitorModal.getHeader()
            .getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW)
            .put(KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), "HideUpdateCompetitorModal");

        this.deleteCompetitorModal.getHeader()
            .getActionMap()
            .put("HideUpdateCompetitorModal", new HideUpdateCompetitorModalAction());

        this.deleteCompetitorModal.getHeader()
            .getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW)
            .put(KeyStroke.getKeyStroke(KeyEvent.VK_A, KeyEvent.CTRL_DOWN_MASK), "SelectAllCompetitorsAction");

        this.deleteCompetitorModal.getHeader()
            .getActionMap()
            .put("SelectAllCompetitorsAction", new SelectAllCompetitorsAction());

        this.deleteCompetitorModal.getHeader()
            .getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW)
            .put(KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, KeyEvent.ALT_DOWN_MASK), "DeleteSelectedCompetitors");

        this.deleteCompetitorModal.getHeader()
            .getActionMap()
            .put("DeleteSelectedCompetitors", new DeleteSelectedCompetitorsAction());

        this.deleteCompetitorModal.getHeader()
            .getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW)
            .put(KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0), "SearchForCompetitor");

        this.deleteCompetitorModal.getHeader()
            .getActionMap()
            .put("SearchForCompetitor", new SearchForCompetitorAction());
    }

    private static final class HideUpdateCompetitorModalAction extends AbstractAction {

        @Override
        public void actionPerformed(ActionEvent e) {
            FrameManager.hideOpenedModal();
        }

    }

    private final class SelectAllCompetitorsAction extends AbstractAction {

        @Override
        public void actionPerformed(ActionEvent e) {
            DeleteCompetitorModalKeyController.this.controller.selectAllCompetitors();
        }

    }

    private final class DeleteSelectedCompetitorsAction extends AbstractAction {

        @Override
        public void actionPerformed(ActionEvent e) {
            DeleteCompetitorModalKeyController.this.controller.deleteCompetitors();
        }

    }

    private final class SearchForCompetitorAction extends AbstractAction {

        @Override
        public void actionPerformed(ActionEvent e) {
            DeleteCompetitorModalKeyController.this.controller.searchCompetitor();
        }

    }

}