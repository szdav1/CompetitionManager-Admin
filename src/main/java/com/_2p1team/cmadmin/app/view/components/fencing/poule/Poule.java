package com._2p1team.cmadmin.app.view.components.fencing.poule;

import com._2p1team.cmadmin.app.control.components.fencing.poule.PouleController;
import com._2p1team.cmadmin.app.databasemodels.competitor.Competitor;
import com._2p1team.cmadmin.app.view.components.input.LabeledInput;
import com._2p1team.cmadmin.app.view.interfaces.ComplexComponent;
import com._2p1team.cmadmin.app.view.interfaces.ControlComponent;
import com._2p1team.cmadmin.app.view.interfaces.KeyControlledComponent;
import static com._2p1team.cmadmin.support.constants.AppearanceConstants.PADDING;
import com._2p1team.cmadmin.support.constants.CustomColors;
import static com._2p1team.cmadmin.support.constants.SizeData.*;
import com._2p1team.cmadmin.support.util.AppearanceRepository;
import com._2p1team.cmadmin.swing.override.components.Container;
import com._2p1team.cmadmin.swing.override.components.button.Button;
import com._2p1team.cmadmin.swing.override.components.label.Label;
import com._2p1team.cmadmin.swing.override.components.panel.Panel;
import com._2p1team.cmadmin.swing.override.constants.Position;
import com._2p1team.cmadmin.swing.override.graphics.Appearance;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.swing.JComponent;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Rectangle;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Data
@EqualsAndHashCode(callSuper=false)
public class Poule extends Panel implements ComplexComponent, Container, ControlComponent, KeyControlledComponent {

    private int numberOfCompetitors;
    private final List<Competitor> competitors;
    private Box[][] boxes;

    private final Label dataPanelLabel;
    private final Panel dataPanel;
    private final Panel dataPanelLeftContainer;
    private final Panel dataPanelRightContainer;
    private final LabeledInput competitor1IndexInput;
    private final LabeledInput competitor2IndexInput;
    private final LabeledInput competitor1PointInput;
    private final LabeledInput competitor2PointInput;
    private final Button insertDataButton;
    private final Label dateLabel;
    private final Label pouleNumberLabel;
    private final Label refereeLabel;
    private final Button finishButton;

    public Poule(final int numberOfCompetitors) {
        super(new Dimension(POULE_PANEL_WIDTH, BUTTON_HEIGHT*(numberOfCompetitors+6)+PADDING), null, new Appearance(AppearanceRepository.POULE_PANEL_APPEARANCE));

        this.numberOfCompetitors = numberOfCompetitors;
        this.competitors = new ArrayList<>();
        this.boxes = new Box[this.numberOfCompetitors+1][this.numberOfCompetitors+8];

        this.dataPanelLabel = new Label(
            new Rectangle(PADDING, BUTTON_HEIGHT*(this.numberOfCompetitors+1), BUTTON_WIDTH, BUTTON_HEIGHT),
            "Data Sheet",
            new Appearance(AppearanceRepository.LABELED_INPUT_APPEARANCE)
        );

        this.dataPanel = new Panel(
            new Rectangle(
                PADDING,
                BUTTON_HEIGHT*(this.numberOfCompetitors+2),
                this.getWidth()-(PADDING*2),
                BUTTON_HEIGHT*4
            ),
            new FlowLayout(FlowLayout.CENTER, PADDING/2, PADDING/2),
            new Appearance(AppearanceRepository.POULE_PANEL_APPEARANCE)
        );

        this.dataPanelLeftContainer = new Panel(
            new Dimension((this.dataPanel.getWidth()/2)-PADDING, this.dataPanel.getHeight()-PADDING),
            new FlowLayout(FlowLayout.CENTER, PADDING/2, PADDING/2),
            new Appearance(AppearanceRepository.LABELED_INPUT_APPEARANCE)
        );

        this.dataPanelRightContainer = new Panel(
            new Dimension((this.dataPanel.getWidth()/2)-PADDING, this.dataPanel.getHeight()-PADDING),
            new FlowLayout(FlowLayout.CENTER, PADDING/2, PADDING/2),
            new Appearance(AppearanceRepository.LABELED_INPUT_APPEARANCE)
        );

        this.competitor1IndexInput = new LabeledInput("Competitor 1");
        this.competitor2IndexInput = new LabeledInput("Competitor 2");
        this.competitor1PointInput = new LabeledInput("Point 1");
        this.competitor2PointInput = new LabeledInput("Point 2");
        this.insertDataButton = new Button(BUTTON_SIZE, "Insert", new Appearance(AppearanceRepository.BASE_BUTTON_APPEARANCE));
        this.dateLabel = new Label(BUTTON_SIZE, String.valueOf(LocalDate.now()), new Appearance(AppearanceRepository.POULE_PANEL_APPEARANCE));
        this.pouleNumberLabel = new Label(BUTTON_SIZE, "Poule No.: ", new Appearance(AppearanceRepository.POULE_PANEL_APPEARANCE));
        this.refereeLabel = new Label(new Dimension(BUTTON_WIDTH*2, BUTTON_HEIGHT), "Referee: ", new Appearance(AppearanceRepository.POULE_PANEL_APPEARANCE));
        this.finishButton = new Button(BUTTON_SIZE, "Finish", new Appearance(AppearanceRepository.BASE_BUTTON_APPEARANCE));

        this.setUpComponent();
        new PouleController(this);
    }

    public void setPouleNumber(int pouleNumber) {
        this.pouleNumberLabel.setText(String.format("Poule No.: %d", pouleNumber));
    }

    public void setReferee(String referee) {
        this.refereeLabel.setText(String.format("Referee: %s", referee));
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
            box.setBackground(CustomColors.ORANGEISH);
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

        if (y >= 0 && x >= rowLength-5 && x < rowLength)
            box.setEnabled(false);
    }

    private void performBoxModifications(int x, int y, final Box box) {
        this.doFirstRowModifications(x, y, box);
        this.doCrossModifications(x, y, box);
        this.doHorizontalNumbering(x, y, box);
        this.disableStatsSection(x, y, box);
    }

    private Rectangle calculateBoxBounds(final int x, final int y) {
        int width;

        if (x == 0)
            width = BUTTON_WIDTH;
        else if (x == 1)
            width = W_BUTTON_WIDTH;
        else
            width = N_BUTTON_WIDTH;

        return new Rectangle(
            x > 1 ? ((x-2)*N_BUTTON_WIDTH)+W_BUTTON_WIDTH+BUTTON_WIDTH : x == 0 ? 0 : BUTTON_WIDTH,
            BUTTON_HEIGHT*y,
            width,
            BUTTON_HEIGHT
        );
    }

    private void createLayout() {
        for (int y = 0; y < this.numberOfCompetitors+1; y++) {
            for (int x = 0; x < this.numberOfCompetitors+8; x++) {
                Box box = new Box(this.calculateBoxBounds(x, y), "");

                this.performBoxModifications(x, y, box);
                this.boxes[y][x] = box;
            }
        }

        for (Box[] boxRow : this.boxes) {
            for (Box box : boxRow) {
                this.addComponent(box);
            }
        }
    }

    @Override
    public void setUpComponent() {
        final Panel verticalDivider = new Panel(
            new Rectangle(
                BUTTON_WIDTH+W_BUTTON_WIDTH+(N_BUTTON_WIDTH*(this.numberOfCompetitors+1))-2,
                0,
                4,
                BUTTON_HEIGHT*(this.numberOfCompetitors+1)
            ),
            AppearanceRepository.VERTICAL_DIVIDER_APPEARANCE
        );

        final Panel horizontalDivider = new Panel(
            new Rectangle(
                0,
                BUTTON_HEIGHT-2,
                BUTTON_WIDTH+W_BUTTON_WIDTH+(N_BUTTON_WIDTH*(this.numberOfCompetitors+6)),
                4
            ),
            AppearanceRepository.HORIZONTAL_DIVIDER_APPEARANCE
        );

        this.dataPanelLeftContainer.addComponent(this.competitor1IndexInput);
        this.dataPanelLeftContainer.addComponent(this.competitor2IndexInput);
        this.dataPanelLeftContainer.addComponent(this.competitor1PointInput);
        this.dataPanelLeftContainer.addComponent(this.competitor2PointInput);
        this.dataPanelLeftContainer.addComponent(this.insertDataButton);

        this.dataPanelRightContainer.addComponent(this.pouleNumberLabel);
        this.dataPanelRightContainer.addComponent(this.dateLabel);
        this.dataPanelRightContainer.addComponent(this.refereeLabel);
        this.dataPanelRightContainer.addComponent(this.finishButton);

        this.dataPanel.addComponent(this.dataPanelLeftContainer);
        this.dataPanel.addComponent(this.dataPanelRightContainer);

        this.createLayout();
        this.addComponent(verticalDivider, Position.HIGH);
        this.addComponent(horizontalDivider, Position.HIGH);
        this.addComponent(this.dataPanelLabel);
        this.addComponent(this.dataPanel);
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