package com._2p1team.cmadmin.app.control.components.modal;

import com._2p1team.cmadmin.app.control.AbstractKeyController;
import com._2p1team.cmadmin.app.view.frame.FrameManager;
import com._2p1team.cmadmin.app.view.interfaces.KeyControlledComponent;
import com._2p1team.cmadmin.support.constants.states.FrameState;

import javax.swing.AbstractAction;
import javax.swing.JComponent;
import javax.swing.KeyStroke;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

public final class ModalKeyController extends AbstractKeyController {
    public ModalKeyController(KeyControlledComponent keyControlledComponent) {
        super(keyControlledComponent);

        this.getKeyControlledComponent()
            .getKeyControls()
            .getFirst()
            .getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW)
            .put(KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), "CloseAction");

        this.getKeyControlledComponent()
            .getKeyControls()
            .getFirst()
            .getActionMap()
            .put("CloseAction", new CloseAction());
    }

    private static class CloseAction extends AbstractAction {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (FrameManager.getState() == FrameState.MODAL_OPENED)
                FrameManager.hideOpenedModal();
        }
    }
}