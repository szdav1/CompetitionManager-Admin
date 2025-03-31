package com._2p1team.cmadmin.app.view.components.modals;

import com._2p1team.cmadmin.app.control.components.modal.languageselector.LanguageSelectorModalController;

import javax.swing.JComponent;
import java.util.List;

public final class LanguageSelectorModal extends AbstractModal {

    public LanguageSelectorModal() {
        super();
        this.setTitle("Select Language");

        new LanguageSelectorModalController(this);
    }

    @Override
    public void setUpComponent() {

    }

    @Override
    public List<JComponent> getControls() {
        return List.of();
    }

    @Override
    public List<JComponent> getKeyControls() {
        return List.of();
    }

}