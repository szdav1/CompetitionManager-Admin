package com._2p1team.cmadmin.app.view.components.fencing.poule;

import com._2p1team.cmadmin.app.view.interfaces.ComplexComponent;
import com._2p1team.cmadmin.support.constants.SizeData;
import static com._2p1team.cmadmin.support.constants.SizeData.BUTTON_HEIGHT;
import static com._2p1team.cmadmin.support.constants.SizeData.N_BUTTON_WIDTH;
import com._2p1team.cmadmin.support.util.AppearanceRepository;
import com._2p1team.cmadmin.swing.override.components.Container;
import com._2p1team.cmadmin.swing.override.components.label.Label;
import com._2p1team.cmadmin.swing.override.components.panel.Panel;

import java.awt.Dimension;
import java.util.ArrayList;
import java.util.List;

public class Poule extends Panel implements ComplexComponent, Container {

    private int numberOfCompetitors;
    private List<List<Box>> boxes;

    public Poule(int numberOfCompetitors) {
        super(new Dimension(numberOfCompetitors*N_BUTTON_WIDTH, numberOfCompetitors*BUTTON_HEIGHT), null, AppearanceRepository.MODAL_APPEARANCE);

        this.numberOfCompetitors = numberOfCompetitors;
        this.boxes = new ArrayList<>();

        this.setUpComponent();
    }

    private void createLayout() {
        for (int y = 0; y < this.numberOfCompetitors; y++) {
            for (int x = 0; x < this.numberOfCompetitors+8; x++) {
                List<Label> boxRow = new ArrayList<>();
                Box box = new Box(N_BUTTON_WIDTH*x, BUTTON_HEIGHT*y, String.valueOf(x));
                boxRow.add(box);
                this.addComponent(box);
            }
        }
    }

    @Override
    public void setUpComponent() {
        this.createLayout();
    }

}