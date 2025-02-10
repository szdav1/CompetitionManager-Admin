package com._2p1team.cmadmin.app.view.components.modals;

import com._2p1team.cmadmin.app.view.components.fencing.poule.Poule;
import com._2p1team.cmadmin.swing.override.constants.Position;

import javax.swing.JComponent;
import java.util.List;

public final class NewPouleModal extends AbstractModal {

    public NewPouleModal() {
        this.setTitle("New Poule");

        Poule p = new Poule(8);
        this.addComponent(p, Position.CENTER);
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