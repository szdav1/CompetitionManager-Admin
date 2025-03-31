package com._2p1team.cmadmin.app.control.components.modal.exception;

import com._2p1team.cmadmin.app.control.AbstractController;
import com._2p1team.cmadmin.app.view.components.modals.HttpExceptionModal;
import com._2p1team.cmadmin.app.view.frame.FrameManager;
import com._2p1team.cmadmin.swing.override.components.button.Button;

import java.awt.event.ActionEvent;

public final class ExceptionModalController extends AbstractController {

    public ExceptionModalController(final HttpExceptionModal component) {
        super(component);

        new ExceptionModalKeyController(component);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Button exitButton = (Button) this.getComponent()
            .getControls()
            .getFirst();

        if (e.getSource().equals(exitButton))
            FrameManager.directExitFrame();
    }

}