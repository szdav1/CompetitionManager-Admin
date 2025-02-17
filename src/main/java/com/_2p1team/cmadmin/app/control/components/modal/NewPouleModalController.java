package com._2p1team.cmadmin.app.control.components.modal;

import com._2p1team.cmadmin.app.control.AbstractController;
import com._2p1team.cmadmin.app.view.components.checkbox.Checkbox;
import com._2p1team.cmadmin.app.view.components.modals.NewPouleModal;

import java.awt.event.ActionEvent;

public final class NewPouleModalController extends AbstractController {

    private final NewPouleModal newPouleModal;
    private final Checkbox headerCheckbox;

    public NewPouleModalController(final NewPouleModal component) {
        super(component);

        this.newPouleModal = component;
        this.headerCheckbox = this.newPouleModal.getHeader().getCheckbox();

        this.addListeners();
    }

    private void addListeners() {
        this.headerCheckbox.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(this.headerCheckbox))
            this.newPouleModal.getCompetitorDisplays()
                .forEach(competitorDisplay -> competitorDisplay.getCheckbox().toggleChecked());
    }

}