package com._2p1team.cmadmin.app.control.components.modal.exception.http;

import com._2p1team.cmadmin.app.control.AbstractKeyController;
import com._2p1team.cmadmin.app.view.components.modals.HttpExceptionModal;

import javax.swing.AbstractAction;
import javax.swing.JComponent;
import javax.swing.KeyStroke;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

public final class HttpExceptionModalKeyController extends AbstractKeyController {

    private final HttpExceptionModalController controller;

    public HttpExceptionModalKeyController(final HttpExceptionModal keyControlledComponent, final HttpExceptionModalController controller) {
        super(keyControlledComponent);

        this.controller = controller;

        keyControlledComponent.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW)
            .put(KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0), "DirectExitFrameAction");

        keyControlledComponent.getActionMap()
            .put("DirectExitFrameAction", new DirectExitFrameAction());
    }

    private final class DirectExitFrameAction extends AbstractAction {

        @Override
        public void actionPerformed(ActionEvent e) {
            HttpExceptionModalKeyController.this.controller.saveAndExit();
        }

    }

}