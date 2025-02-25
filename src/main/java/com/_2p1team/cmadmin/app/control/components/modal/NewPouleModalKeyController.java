package com._2p1team.cmadmin.app.control.components.modal;

import com._2p1team.cmadmin.app.control.AbstractKeyController;
import com._2p1team.cmadmin.app.view.components.modals.NewPouleModal;
import com._2p1team.cmadmin.app.view.frame.FrameManager;
import com._2p1team.cmadmin.support.constants.states.FrameState;

import javax.swing.AbstractAction;
import javax.swing.JComponent;
import javax.swing.KeyStroke;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

public class NewPouleModalKeyController extends AbstractKeyController {

    private final NewPouleModal newPouleModal;
    private final NewPouleModalController controller;

    public NewPouleModalKeyController(final NewPouleModal keyControlledComponent, final NewPouleModalController controller) {
        super(keyControlledComponent);
        this.newPouleModal = keyControlledComponent;
        this.controller = controller;

        this.newPouleModal.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW)
            .put(KeyStroke.getKeyStroke(KeyEvent.VK_A, KeyEvent.CTRL_DOWN_MASK), "HighlightAllCompetitors");

        this.newPouleModal.getActionMap()
            .put("HighlightAllCompetitors", new HighlightAllCompetitors());

        this.newPouleModal.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW)
            .put(KeyStroke.getKeyStroke(KeyEvent.VK_A, KeyEvent.ALT_DOWN_MASK), "HighlightAllParticipatingCompetitors");

        this.newPouleModal.getActionMap()
            .put("HighlightAllParticipatingCompetitors", new HighlightAllParticipatingCompetitors());

        this.newPouleModal.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW)
            .put(KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0), "SearchForCompetitorAction");

        this.newPouleModal.getActionMap()
            .put("SearchForCompetitorAction", new SearchForCompetitorAction());

        this.newPouleModal.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW)
            .put(KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, KeyEvent.ALT_DOWN_MASK), "AddSelectedCompetitorsToParticipatingList");

        this.newPouleModal.getActionMap()
            .put("AddSelectedCompetitorsToParticipatingList", new AddSelectedCompetitorsToParticipatingList());

        this.newPouleModal.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW)
            .put(KeyStroke.getKeyStroke(KeyEvent.VK_DELETE, 0), "DeleteParticipatingCompetitorAction");

        this.newPouleModal.getActionMap()
            .put("DeleteParticipatingCompetitorAction", new DeleteParticipatingCompetitorAction());
    }

    private final class HighlightAllCompetitors extends AbstractAction {

        @Override
        public void actionPerformed(ActionEvent e) {
            NewPouleModalKeyController.this.controller.highlightAllCompetitors();
        }

    }

    private final class HighlightAllParticipatingCompetitors extends AbstractAction {

        @Override
        public void actionPerformed(ActionEvent e) {
            NewPouleModalKeyController.this.controller.highlightParticipatingCompetitors();
        }

    }

    private final class SearchForCompetitorAction extends AbstractAction {

        @Override
        public void actionPerformed(ActionEvent e) {
            if (FrameManager.getState() == FrameState.MODAL_OPENED)
                NewPouleModalKeyController.this.controller.searchForCompetitors();
        }

    }

    private final class AddSelectedCompetitorsToParticipatingList extends AbstractAction {

        @Override
        public void actionPerformed(ActionEvent e) {
            NewPouleModalKeyController.this.controller.addCompetitorToParticipatingList();
        }

    }

    private final class DeleteParticipatingCompetitorAction extends AbstractAction {

        @Override
        public void actionPerformed(ActionEvent e) {
            if (FrameManager.getState() == FrameState.MODAL_OPENED)
                NewPouleModalKeyController.this.controller.removeCompetitorFromParticipatingList();
        }

    }

}