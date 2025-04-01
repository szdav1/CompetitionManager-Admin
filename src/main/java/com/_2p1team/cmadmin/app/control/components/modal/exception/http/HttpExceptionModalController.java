package com._2p1team.cmadmin.app.control.components.modal.exception.http;

import com._2p1team.cmadmin.app.control.AbstractController;
import com._2p1team.cmadmin.app.view.components.modals.HttpExceptionModal;
import com._2p1team.cmadmin.app.view.frame.FrameManager;
import com._2p1team.cmadmin.swing.override.components.button.Button;

import java.awt.event.ActionEvent;

public final class HttpExceptionModalController extends AbstractController {

    public HttpExceptionModalController(final HttpExceptionModal component) {
        super(component);

        new HttpExceptionModalKeyController(component);
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