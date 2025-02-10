package com._2p1team.cmadmin.app.view.components.fencing.poule;

import com._2p1team.cmadmin.app.control.components.fencing.poule.PouleController;
import com._2p1team.cmadmin.app.model.competitor.Competitor;
import com._2p1team.cmadmin.app.view.interfaces.ComplexComponent;
import com._2p1team.cmadmin.app.view.interfaces.ControlComponent;
import com._2p1team.cmadmin.app.view.interfaces.KeyControlledComponent;
import static com._2p1team.cmadmin.support.constants.SizeData.*;
import com._2p1team.cmadmin.support.util.AppearanceRepository;
import com._2p1team.cmadmin.swing.override.components.Container;
import com._2p1team.cmadmin.swing.override.components.panel.Panel;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.swing.JComponent;
import java.awt.Color;
import java.util.ArrayList;
import java.util.List;
// TODO: Create the UI design plan for the Poule component and implement it
@Data
@EqualsAndHashCode(callSuper=false)
public class Poule extends Panel implements ComplexComponent, Container, ControlComponent, KeyControlledComponent {

    private int numberOfCompetitors;
    private final List<Competitor> competitors;
    private List<List<Box>> boxes;

    public Poule(int numberOfCompetitors) {
        super(POULE_PANEL_SIZE, null, AppearanceRepository.MODAL_APPEARANCE);

        this.numberOfCompetitors = numberOfCompetitors;
        this.competitors = new ArrayList<>();
        this.boxes = new ArrayList<>();

        this.setUpComponent();
        new PouleController(this);
    }

    private void doFirstRowModifications(int x, int y, final Box box) {
        if (y != 0)
            return;

        box.setEnabled(false);
        box.setDisabledTextColor(box.getForeground());

        int rowLength = this.numberOfCompetitors+8;

        switch (x) {
            case 0 -> box.setText("Club");
            case 1 -> box.setText("Name");
            case 2 -> box.setText("#");
        }

        if (x > 2 && x < rowLength-5)
            box.setText(String.valueOf(x-2));
        else if (x == rowLength-5)
            box.setText("V");
        else if (x == rowLength-4)
            box.setText("TS");
        else if (x == rowLength-3)
            box.setText("TR");
        else if (x == rowLength-2)
            box.setText("Ind");
        else if (x == rowLength-1)
            box.setText("Pl");
    }

    private void doCrossModifications(int x, int y, final Box box) {
        box.setDisabledTextColor(box.getForeground());

        if (x-2 == y && y > 0) {
            box.setOpaque(true);
            box.setEnabled(false);
            box.setBackground(Color.white);
        }
    }

    private void doHorizontalNumbering(int x, int y, final Box box) {
        box.setDisabledTextColor(box.getForeground());

        if (x == 2 && y > 0) {
            box.setEnabled(false);
            box.setText(String.valueOf(y));
        }
    }

    private void disableStatsSection(int x, int y, final Box box) {
        int rowLength = this.numberOfCompetitors+8;

        if (y > 0 && x >= rowLength-5 && x < rowLength)
            box.setEnabled(false);
    }

    private void performBoxModifications(int x, int y, final Box box) {
        this.doFirstRowModifications(x, y, box);
        this.doCrossModifications(x, y, box);
        this.doHorizontalNumbering(x, y, box);
        this.disableStatsSection(x, y, box);
    }

    private void createLayout() {
        for (int y = 0; y < this.numberOfCompetitors+1; y++) {
            final List<Box> boxRow = new ArrayList<>();

            for (int x = 0; x < this.numberOfCompetitors+8; x++) {
                Box box = new Box(
                    x > 1 ? ((x-2)*N_BUTTON_WIDTH)+(W_BUTTON_WIDTH*2) : x == 0 ? 0 : W_BUTTON_WIDTH,
                    BUTTON_HEIGHT*y,
                    x == 0 || x == 1 ? W_BUTTON_WIDTH : N_BUTTON_WIDTH,
                    BUTTON_HEIGHT,
                    ""
                );

                this.performBoxModifications(x, y, box);
                boxRow.add(box);
            }
            this.boxes.add(boxRow);
        }

        this.boxes.forEach(boxes -> boxes.forEach(this::addComponent));
    }

    @Override
    public void setUpComponent() {
        this.createLayout();
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