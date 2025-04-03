package com._2p1team.cmadmin.app.control.components.modal.appresponse;

import com._2p1team.cmadmin.app.control.AbstractKeyController;
import com._2p1team.cmadmin.app.view.components.modals.AppResponseModal;
import com._2p1team.cmadmin.app.view.frame.FrameManager;

import javax.swing.AbstractAction;
import javax.swing.JComponent;
import javax.swing.KeyStroke;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

public final class AppResponseModalKeyController extends AbstractKeyController {

    public AppResponseModalKeyController(final AppResponseModal keyControlledComponent) {
        super(keyControlledComponent);

        keyControlledComponent.getMessageLabel()
            .getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW)
            .put(KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), "CloseAppResponseModalAction");

        keyControlledComponent.getMessageLabel()
            .getActionMap()
            .put("CloseAppResponseModalAction", new CloseAppResponseModalAction());
    }

    public static final class CloseAppResponseModalAction extends AbstractAction {

        @Override
        public void actionPerformed(ActionEvent e) {
            FrameManager.hideOpenedModal();
        }

    }

}