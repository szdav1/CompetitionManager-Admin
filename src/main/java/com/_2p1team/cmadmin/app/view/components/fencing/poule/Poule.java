package com._2p1team.cmadmin.app.view.components.fencing.poule;

import com._2p1team.cmadmin.app.control.components.fencing.poule.PouleController;
import com._2p1team.cmadmin.app.dto.competitor.Competitor;
import com._2p1team.cmadmin.app.dto.competitor.CompetitorSortModel;
import com._2p1team.cmadmin.app.dto.competitor.CompetitorTransferModel;
import com._2p1team.cmadmin.app.view.components.fencing.Box;
import com._2p1team.cmadmin.app.view.components.input.LabeledInput;
import com._2p1team.cmadmin.app.view.interfaces.ComplexComponent;
import com._2p1team.cmadmin.app.view.interfaces.ControlComponent;
import com._2p1team.cmadmin.app.view.interfaces.KeyControlledComponent;
import com._2p1team.cmadmin.general.constants.AppearanceConstants;
import static com._2p1team.cmadmin.general.constants.AppearanceConstants.PADDING;
import com._2p1team.cmadmin.general.constants.Language;
import static com._2p1team.cmadmin.general.constants.SizeData.*;
import com._2p1team.cmadmin.general.util.AppearanceRepository;
import com._2p1team.cmadmin.swing.override.components.Container;
import com._2p1team.cmadmin.swing.override.components.button.Button;
import com._2p1team.cmadmin.swing.override.components.label.Label;
import com._2p1team.cmadmin.swing.override.components.panel.Panel;
import com._2p1team.cmadmin.swing.override.components.text.field.TextField;
import com._2p1team.cmadmin.swing.override.constants.Position;
import com._2p1team.cmadmin.swing.override.graphics.Appearance;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.SneakyThrows;

import javax.imageio.ImageIO;
import javax.swing.JComponent;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.File;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@Data
@EqualsAndHashCode(callSuper=false)
public class Poule extends Panel implements ComplexComponent, Container, ControlComponent, KeyControlledComponent {

    public static final int MIN_SIZE = 4;
    public static final int MAX_SIZE = 8;
    public static final int PREFERRED_SIZE = 7;

    private final Panel verticalDivider;
    private final Panel horizontalDivider;

    private int numberOfCompetitors;
    private final List<Competitor> startingCompetitors;
    private final List<CompetitorTransferModel> finishingCompetitors;
    private int rowLength;
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
    private final TextField refereeLabel;

    private final PouleController controller;

    public Poule(final int numberOfCompetitors) {
        super(new Dimension(POULE_PANEL_WIDTH, BUTTON_HEIGHT*(numberOfCompetitors+6)+PADDING), null, new Appearance(AppearanceRepository.POULE_PANEL_APPEARANCE));

        this.verticalDivider = new Panel(
            new Rectangle(
                BUTTON_WIDTH+W_BUTTON_WIDTH+(N_BUTTON_WIDTH*(numberOfCompetitors+1))-2,
                0,
                4,
                BUTTON_HEIGHT*(numberOfCompetitors+1)
            ),
            AppearanceRepository.VERTICAL_DIVIDER_APPEARANCE
        );

        this.horizontalDivider = new Panel(
            new Rectangle(
                0,
                BUTTON_HEIGHT-2,
                BUTTON_WIDTH+W_BUTTON_WIDTH+(N_BUTTON_WIDTH*(numberOfCompetitors+6)),
                4
            ),
            AppearanceRepository.HORIZONTAL_DIVIDER_APPEARANCE
        );

        this.numberOfCompetitors = numberOfCompetitors;
        this.startingCompetitors = new ArrayList<>();
        this.finishingCompetitors = new ArrayList<>();
        this.rowLength = this.numberOfCompetitors+8;
        this.boxes = new Box[this.numberOfCompetitors+1][this.rowLength];

        this.dataPanelLabel = new Label(
            new Rectangle(PADDING, BUTTON_HEIGHT*(this.numberOfCompetitors+1), BUTTON_WIDTH, BUTTON_HEIGHT),
            Language.get("DataSheet"),
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

        this.competitor1IndexInput = new LabeledInput(Language.get("Competitor1"));
        this.competitor2IndexInput = new LabeledInput(Language.get("Competitor2"));
        this.competitor1PointInput = new LabeledInput(Language.get("Point1"));
        this.competitor2PointInput = new LabeledInput(Language.get("Point2"));
        this.insertDataButton = new Button(BUTTON_SIZE, Language.get("Insert"), new Appearance(AppearanceRepository.BASE_BUTTON_APPEARANCE));

        this.dateLabel = new Label(BUTTON_SIZE, String.valueOf(LocalDate.now()), new Appearance(AppearanceRepository.POULE_PANEL_APPEARANCE));
        this.pouleNumberLabel = new Label(BUTTON_SIZE, "Poule No.: ", new Appearance(AppearanceRepository.POULE_PANEL_APPEARANCE));
        this.refereeLabel = new TextField(new Dimension(BUTTON_WIDTH*2, BUTTON_HEIGHT), Language.get("Referee"), new Appearance(AppearanceRepository.POULE_PANEL_APPEARANCE));

        this.setUpComponent();
        this.controller = new PouleController(this);
    }

    public void setPouleNumberLabel(final int number) {
        this.pouleNumberLabel.setText(this.pouleNumberLabel.getText().concat(String.valueOf(number)));
    }

    @SneakyThrows
    public void saveAsImage(final String fileName) {
        final BufferedImage image = new BufferedImage(this.getWidth(), this.getHeight(), BufferedImage.TYPE_INT_ARGB);
        this.paint(image.getGraphics());
        ImageIO.write(image, "PNG", new File(fileName+".png"));
    }

    private boolean checkCompetitorData() {
        boolean hasError = false;
        for (int y = 1; y < this.boxes.length; y++) {
            for (int x = 3; x < this.boxes[y].length-5; x++) {
                if (this.boxes[y][x].getText().isBlank() && this.boxes[y][x].isEnabled()) {
                    this.boxes[y][x].setBackground(AppearanceConstants.ERROR_COLOR);
                    hasError = true;
                }
            }
        }

        return hasError;
    }

    private void calculateWinsAnsTs() {
        for (int y = 1; y < this.boxes.length; y++) {
            int wins = 0;
            int ts = 0;

            for (int x = 3; x < this.boxes[y].length-5; x++) {
                Box box = this.boxes[y][x];

                if (!box.isEnabled())
                    continue;

                if (box.getText().equalsIgnoreCase("v")) {
                    wins++;
                    ts += 5;
                }
                else {
                    ts += Integer.parseInt(box.getText());
                }
            }

            this.boxes[y][this.rowLength-5].setText(String.valueOf(wins));
            this.boxes[y][this.rowLength-4].setText(String.valueOf(ts));
        }
    }

    private void calculateTrAndIndex() {
        for (int x = 3; x < this.rowLength-5; x++) {
            int tr = 0;

            for (int y = 1; y < this.numberOfCompetitors+1; y++) {
                Box box = this.boxes[y][x];

                if (!box.isEnabled())
                    continue;

                tr += box.getText().equalsIgnoreCase("v") ? 5 : Integer.parseInt(box.getText());
            }

            this.boxes[x-2][this.rowLength-3].setText(String.valueOf(tr));
        }

        for (int y = 1; y < this.boxes.length; y++) {
            this.boxes[y][this.rowLength-2].setText(String.valueOf(Integer.parseInt(this.boxes[y][this.rowLength-4].getText())-Integer.parseInt(this.boxes[y][this.rowLength-3].getText())));
        }
    }

    private void sortCompetitorsByIndex() {
        List<CompetitorSortModel> competitorsToSort = new ArrayList<>();

        for (int y = 1; y < this.numberOfCompetitors+1; y++) {
            competitorsToSort.add(new CompetitorSortModel(
                this.boxes[y][1].getText(),
                Integer.parseInt(this.boxes[y][this.rowLength-5].getText()),
                Integer.parseInt(this.boxes[y][this.rowLength-2].getText())
            ));
        }

        competitorsToSort.sort(Comparator.comparing(CompetitorSortModel::index).reversed());

        for (int y = 1; y < this.numberOfCompetitors+1; y++) {
            for (CompetitorSortModel competitorSortModel : competitorsToSort) {
                if (competitorSortModel.name().equalsIgnoreCase(this.boxes[y][1].getText()))
                    this.boxes[y][this.rowLength-1].setText(String.valueOf(competitorsToSort.indexOf(competitorSortModel)+1));
            }
        }
    }

    private Competitor findStartingCompetitorByName(final String name) {
        return this.startingCompetitors.stream()
            .filter(startingCompetitor -> startingCompetitor.getName().equalsIgnoreCase(name))
            .toList()
            .getFirst();
    }

    private void finish() {
        for (int y = 1; y < this.numberOfCompetitors+1; y++) {
            final Competitor startingCompetitorObject = this.findStartingCompetitorByName(this.boxes[y][1].getText());
            this.finishingCompetitors.add(new CompetitorTransferModel(
                startingCompetitorObject.getId(),
                startingCompetitorObject.getName(),
                startingCompetitorObject.getClub(),
                startingCompetitorObject.getBirthDateAsString(),
                Integer.parseInt(this.boxes[y][this.rowLength-2].getText()),
                Integer.parseInt(this.boxes[y][this.rowLength-1].getText())
            ));
        }
    }

    public boolean calculateCompetitorData() {
        if (this.checkCompetitorData())
            return true;

        this.calculateWinsAnsTs();
        this.calculateTrAndIndex();
        this.sortCompetitorsByIndex();
        this.finish();

        return false;
    }

    private void doFirstRowModifications(int x, int y, final Box box) {
        if (y != 0)
            return;

        box.setEnabled(false);
        box.setDisabledTextColor(box.getForeground());

        switch (x) {
            case 0 -> box.setText("Club");
            case 1 -> box.setText("Name");
            case 2 -> box.setText("#");
        }

        if (x > 2 && x < this.rowLength-5)
            box.setText(String.valueOf(x-2));
        else if (x == this.rowLength-5)
            box.setText("V");
        else if (x == this.rowLength-4)
            box.setText("TS");
        else if (x == this.rowLength-3)
            box.setText("TR");
        else if (x == this.rowLength-2)
            box.setText("Ind");
        else if (x == this.rowLength-1)
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

        if (y > 0 && x < 2)
            box.setEnabled(false);

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
            for (int x = 0; x < this.rowLength; x++) {
                Box box = new Box(this.calculateBoxBounds(x, y), "", Color.white);

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
        this.dataPanelLeftContainer.addComponent(this.competitor1IndexInput);
        this.dataPanelLeftContainer.addComponent(this.competitor2IndexInput);
        this.dataPanelLeftContainer.addComponent(this.competitor1PointInput);
        this.dataPanelLeftContainer.addComponent(this.competitor2PointInput);
        this.dataPanelLeftContainer.addComponent(this.insertDataButton);

        this.dataPanelRightContainer.addComponent(this.pouleNumberLabel);
        this.dataPanelRightContainer.addComponent(this.dateLabel);
        this.dataPanelRightContainer.addComponent(this.refereeLabel);

        this.dataPanel.addComponent(this.dataPanelLeftContainer);
        this.dataPanel.addComponent(this.dataPanelRightContainer);

        this.createLayout();
        this.addComponent(this.verticalDivider, Position.HIGH);
        this.addComponent(this.horizontalDivider, Position.HIGH);
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