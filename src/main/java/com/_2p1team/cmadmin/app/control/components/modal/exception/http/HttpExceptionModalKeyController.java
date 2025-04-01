package com._2p1team.cmadmin.app.control.components.modal.exception.http;

import com._2p1team.cmadmin.app.control.AbstractKeyController;
import com._2p1team.cmadmin.app.view.components.modals.HttpExceptionModal;
import com._2p1team.cmadmin.app.view.frame.FrameManager;
import com._2p1team.cmadmin.general.constants.states.FrameState;

import javax.swing.AbstractAction;
import javax.swing.JComponent;
import javax.swing.KeyStroke;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

public final class HttpExceptionModalKeyController extends AbstractKeyController {

    public HttpExceptionModalKeyController(final HttpExceptionModal keyControlledComponent) {
        super(keyControlledComponent);

        keyControlledComponent.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW)
            .put(KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0), "DirectExitFrameAction");

        keyControlledComponent.getActionMap()
            .put("DirectExitFrameAction", new DirectExitFrameAction());
    }

    private static final class DirectExitFrameAction extends AbstractAction {

        @Override
        public void actionPerformed(ActionEvent e) {
            if (FrameManager.getState() != FrameState.MODAL_OPENED)
                return;

            FrameManager.directExitFrame();
        }

    }

}