package com._2p1team.cmadmin.app.control.components.modal.login;

import com._2p1team.cmadmin.app.control.AbstractKeyController;
import com._2p1team.cmadmin.app.view.components.modals.LoginModal;

import javax.swing.AbstractAction;
import javax.swing.JComponent;
import javax.swing.KeyStroke;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

public final class LoginModalKeyController extends AbstractKeyController {

    private final LoginModalController controller;

    public LoginModalKeyController(final LoginModal keyControlledComponent, final LoginModalController controller) {
        super(keyControlledComponent);

        this.controller = controller;

        keyControlledComponent.getLockLabel()
            .getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW)
            .put(KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0), "TryLoginAction");

        keyControlledComponent.getLockLabel()
            .getActionMap()
            .put("TryLoginAction", new TryLoginAction());
    }

    private final class TryLoginAction extends AbstractAction {

        @Override
        public void actionPerformed(ActionEvent e) {
            LoginModalKeyController.this.controller.tryLogin();
        }

    }

}