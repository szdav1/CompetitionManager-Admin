package com._2p1team.cmadmin.app.control.components.modal.exception.resources;

import com._2p1team.cmadmin.app.control.AbstractController;
import com._2p1team.cmadmin.app.view.components.modals.ResourcesNotFoundExceptionModal;
import com._2p1team.cmadmin.app.view.frame.FrameManager;
import com._2p1team.cmadmin.swing.override.components.button.Button;

import java.awt.event.ActionEvent;

public final class ResourcesNotFoundExceptionModalController extends AbstractController {

    private final ResourcesNotFoundExceptionModal modal;
    private final Button closeButton;

    public ResourcesNotFoundExceptionModalController(final ResourcesNotFoundExceptionModal component) {
        super(component);

        this.modal = component;
        this.closeButton = this.modal.getBottomCloseButton();

        this.addListeners();
        new ResourcesNotFoundExceptionModalKeyController(this.modal);
    }

    private void addListeners() {
        this.closeButton.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(this.closeButton))
            FrameManager.directExitFrame();
    }

}