package com._2p1team.cmadmin.app.control.components.modal;

import com._2p1team.cmadmin.app.control.AbstractController;
import com._2p1team.cmadmin.app.view.components.modals.LanguageSelectorModal;

import java.awt.event.ActionEvent;

public final class LanguageSelectorModalController extends AbstractController {

    private final LanguageSelectorModal modal;

    public LanguageSelectorModalController(final LanguageSelectorModal component) {
        super(component);

        this.modal = component;

        new LanguageSelectorModalKeyController(modal);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }

}