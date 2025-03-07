package com._2p1team.cmadmin.app.control.components.modal;

import com._2p1team.cmadmin.app.control.AbstractKeyController;
import com._2p1team.cmadmin.app.view.components.modals.NewTableModal;
import com._2p1team.cmadmin.app.view.frame.FrameManager;
import com._2p1team.cmadmin.support.constants.states.FrameState;

import javax.swing.AbstractAction;
import javax.swing.JComponent;
import javax.swing.KeyStroke;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

public final class NewTableModalKeyController extends AbstractKeyController {

    public NewTableModalKeyController(final NewTableModal keyControlledComponent) {
        super(keyControlledComponent);

        keyControlledComponent.getCenterPanel()
            .getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW)
            .put(KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), "CloseNewTableModalAction");

        keyControlledComponent.getCenterPanel()
            .getActionMap()
            .put("CloseNewTableModalAction", new CloseNewTableModalAction());
    }

    private static final class CloseNewTableModalAction extends AbstractAction {

        @Override
        public void actionPerformed(ActionEvent e) {
            if (FrameManager.getState() == FrameState.MODAL_OPENED)
                FrameManager.hideOpenedModal();
        }

    }

}