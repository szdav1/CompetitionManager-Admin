package com._2p1team.cmadmin.app.view.components.modals;

import com._2p1team.cmadmin.app.view.components.fencing.poule.Poule;

import javax.swing.JComponent;
import java.util.List;

public final class NewPouleModal extends AbstractModal {

    public NewPouleModal() {
        this.setTitle("New Poule");

         Poule p = new Poule(7);
         this.getCenterPanel().addComponent(p);
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