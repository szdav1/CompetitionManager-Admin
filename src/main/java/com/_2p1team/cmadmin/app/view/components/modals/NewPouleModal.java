package com._2p1team.cmadmin.app.view.components.modals;

import com._2p1team.cmadmin.app.view.components.fencing.poule.Poule;
import com._2p1team.cmadmin.support.constants.AppearanceConstants;
import static com._2p1team.cmadmin.support.constants.AppearanceConstants.PADDING;
import com._2p1team.cmadmin.support.util.AppearanceRepository;
import com._2p1team.cmadmin.swing.override.components.panel.Panel;
import com._2p1team.cmadmin.swing.override.graphics.Appearance;

import javax.swing.JComponent;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.List;

// TODO: Finish this
public final class NewPouleModal extends AbstractModal {

    private final Panel leftPanel;
    private final Panel rightPanel;

    public NewPouleModal() {
        super();
        this.setTitle("New Poule");
//        this.getCenterPanel().setLayout(new GridLayout(1, 2, PADDING, PADDING));

        this.leftPanel = new Panel(new Dimension(this.getCenterPanel().getWidth()/2, this.getCenterPanel().getHeight()), new Appearance(AppearanceRepository.MODAL_APPEARANCE));
        this.rightPanel = new Panel(new Dimension(this.getCenterPanel().getWidth()/2, this.getCenterPanel().getHeight()), new Appearance(AppearanceRepository.MODAL_APPEARANCE));

//        this.setUpComponent();

        Poule p = new Poule(7);
        this.getCenterPanel().addComponent(p);
    }

    @Override
    public void setUpComponent() {
        this.getCenterPanel().addComponent(this.leftPanel);
        this.getCenterPanel().addComponent(this.rightPanel);
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