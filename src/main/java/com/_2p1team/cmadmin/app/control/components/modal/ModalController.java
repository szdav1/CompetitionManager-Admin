package com._2p1team.cmadmin.app.control.components.modal;

import com._2p1team.cmadmin.app.control.AbstractController;
import com._2p1team.cmadmin.app.view.components.modals.AbstractModal;
import com._2p1team.cmadmin.app.view.frame.FrameManager;

import java.awt.event.ActionEvent;

public final class ModalController extends AbstractController {
    public ModalController(final AbstractModal modal) {
        super(modal);

        new ModalKeyController(modal);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        AbstractModal modal = (AbstractModal) this.getComponent();

        if (e.getSource().equals(modal.getCloseButton()))
            FrameManager.hideOpenedModal();
    }
}