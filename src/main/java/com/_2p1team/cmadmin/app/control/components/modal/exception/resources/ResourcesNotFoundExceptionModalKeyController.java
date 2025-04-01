package com._2p1team.cmadmin.app.control.components.modal.exception.resources;

import com._2p1team.cmadmin.app.control.AbstractKeyController;
import com._2p1team.cmadmin.app.view.components.modals.ResourcesNotFoundExceptionModal;
import com._2p1team.cmadmin.app.view.frame.FrameManager;

import javax.swing.AbstractAction;
import javax.swing.JComponent;
import javax.swing.KeyStroke;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

public final class ResourcesNotFoundExceptionModalKeyController extends AbstractKeyController {


    public ResourcesNotFoundExceptionModalKeyController(final ResourcesNotFoundExceptionModal keyControlledComponent) {
        super(keyControlledComponent);

        keyControlledComponent.getInformationLabel()
            .getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW)
            .put(KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0), "CloseResourcesNotFoundExceptionModalAction");

        keyControlledComponent.getInformationLabel()
            .getActionMap()
            .put("CloseResourcesNotFoundExceptionModalAction", new CloseResourcesNotFoundExceptionModalAction());
    }

    private static final class CloseResourcesNotFoundExceptionModalAction extends AbstractAction {

        @Override
        public void actionPerformed(ActionEvent e) {
            FrameManager.directExitFrame();
        }

    }

}