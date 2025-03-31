package com._2p1team.cmadmin.app.control.components.modal.about;

import com._2p1team.cmadmin.app.control.AbstractKeyController;
import com._2p1team.cmadmin.app.view.components.modals.AboutModal;
import com._2p1team.cmadmin.app.view.frame.FrameManager;

import javax.swing.AbstractAction;
import javax.swing.JComponent;
import javax.swing.KeyStroke;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

public final class AboutModalKeyController extends AbstractKeyController {

    public AboutModalKeyController(final AboutModal keyControlledComponent) {
        super(keyControlledComponent);

        keyControlledComponent.getBackgroundPanel()
            .getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW)
            .put(KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), "CloseAboutModalAction");

        keyControlledComponent.getBackgroundPanel()
            .getActionMap()
            .put("CloseAboutModalAction", new CloseAboutModalAction());
    }

    private static final class CloseAboutModalAction extends AbstractAction {

        @Override
        public void actionPerformed(ActionEvent e) {
            FrameManager.hideOpenedModal();
        }

    }

}