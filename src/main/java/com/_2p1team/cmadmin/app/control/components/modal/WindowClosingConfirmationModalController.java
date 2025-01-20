package com._2p1team.cmadmin.app.control.components.modal;

import com._2p1team.cmadmin.app.control.AbstractController;
import com._2p1team.cmadmin.app.view.components.modals.WindowClosingConfirmationModal;
import com._2p1team.cmadmin.app.view.frame.FrameManager;
import com._2p1team.cmadmin.swing.override.components.button.Button;

import java.awt.event.ActionEvent;

public final class WindowClosingConfirmationModalController extends AbstractController {
    public WindowClosingConfirmationModalController(final WindowClosingConfirmationModal component) {
        super(component);

        new WindowClosingConfirmationModalKeyController(component);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Button confirmButton = (Button) this.getComponent()
            .getControls()
            .getFirst();

        Button cancelButton = (Button) this.getComponent()
            .getControls()
            .get(1);

        if (e.getSource().equals(confirmButton))
            FrameManager.directExitFrame();
        else if (e.getSource().equals(cancelButton))
            FrameManager.hideOpenedModal();
    }
}