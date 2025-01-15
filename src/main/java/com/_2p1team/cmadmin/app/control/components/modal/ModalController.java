package com._2p1team.cmadmin.app.control.components.modal;

import com._2p1team.cmadmin.app.control.AbstractController;
import com._2p1team.cmadmin.app.view.components.modals.AbstractModal;
import com._2p1team.cmadmin.app.view.frame.FrameManager;
import com._2p1team.cmadmin.app.view.interfaces.ControlComponent;

import java.awt.event.ActionEvent;

public final class ModalController extends AbstractController {
    public ModalController(ControlComponent component) {
        super(component);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        AbstractModal modal = (AbstractModal) this.getComponent();

        if (e.getSource().equals(modal.getCloseButton()))
            FrameManager.hideDatabaseConnectModal();
    }
}