package com._2p1team.cmadmin.app.view.components.fencing.table;

import com._2p1team.cmadmin.app.control.components.fencing.table.TableController;
import com._2p1team.cmadmin.app.dto.competitor.CompetitorTransferModel;
import com._2p1team.cmadmin.app.view.components.fencing.Box;
import com._2p1team.cmadmin.app.view.frame.FrameManager;
import com._2p1team.cmadmin.app.view.interfaces.ComplexComponent;
import com._2p1team.cmadmin.app.view.interfaces.ControlComponent;
import static com._2p1team.cmadmin.general.constants.AppearanceConstants.PADDING;
import com._2p1team.cmadmin.general.constants.CompetitionType;
import static com._2p1team.cmadmin.general.constants.SizeData.*;
import com._2p1team.cmadmin.general.util.AppearanceRepository;
import com._2p1team.cmadmin.swing.override.components.button.Button;
import com._2p1team.cmadmin.swing.override.components.panel.Panel;
import com._2p1team.cmadmin.swing.override.components.scrollpanel.ScrollPanel;
import com._2p1team.cmadmin.swing.override.graphics.Appearance;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.swing.JComponent;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.util.*;

@Data
@EqualsAndHashCode(callSuper=false)
public final class Table extends Panel implements ComplexComponent, ControlComponent {

    public static final String EMPTY_COMPETITOR = "---";

    private static final String tableau8 = "1;8;5;4;3;6;7;2";
    private static final String tableau16 = "1;16;9;8;5;12;13;4;3;14;11;6;7;10;15;2";
    private static final String tableau32 = "1;32;17;16;9;24;25;8;5;28;21;12;13;20;29;4;3;30;19;14;11;22;27;6;7;26;23;10;15;18;31;2";
    private static final String tableau64 = "1;64;33;32;17;48;49;16;9;56;41;24;25;40;57;8;5;60;37;28;21;44;53;12;13;52;45;20;29;36;61;4;3;62;35;30;19;46;51;14;11;54;43;22;27;38;59;6;7;58;39;26;23;42;55;10;15;50;47;18;31;34;63;2";
    private static final String tableau128 = "1;128;65;64;33;96;97;32;17;112;81;48;49;80;113;16;9;120;73;56;41;88;105;24;25;104;89;40;57;72;121;8;5;124;69;60;37;92;101;28;21;108;85;44;53;76;117;12;13;116;77;52;45;84;109;20;29;100;93;36;61;68;125;4;3;126;67;62;35;94;99;30;19;110;83;46;51;78;115;14;11;118;75;54;43;86;107;22;27;102;91;38;59;70;123;6;7;122;71;58;39;90;103;26;23;106;87;42;55;74;119;10;15;114;79;50;47;82;111;18;31;98;95;34;63;66;127;2";
    private static final Map<Integer, String> tableaus = new HashMap<>(Map.of(8, tableau8, 16, tableau16, 32, tableau32, 64, tableau64, 128, tableau128));

    public static final int MINIMUM_SIZE = 8;
    public static final int MAXIMUM_SIZE = 128;

    private final List<CompetitorTransferModel> competitorTransferModels;
    private List<CompetitorTransferModel> finishingCompetitors;
    private int desiredSize;
    private int tableSize;
    private String tableau;
    private final List<TableElement> elements;
    private TableElement finishingTableElement;
    private final ScrollPanel scrollPanel;

    public Table(final List<CompetitorTransferModel> competitorTransferModels) {
        super(new Dimension(FRAME_WIDTH, FRAME_HEIGHT-(BUTTON_HEIGHT*4)), new FlowLayout(FlowLayout.CENTER, 0, 0), new Appearance(AppearanceRepository.TABLE_PANEL_APPEARANCE));

        this.competitorTransferModels = competitorTransferModels;
        this.finishingCompetitors = new ArrayList<>();
        this.tableSize = this.determineTableSize();
        this.tableau = tableaus.get(this.tableSize);
        this.elements = new ArrayList<>(this.tableSize);

        this.scrollPanel = new ScrollPanel(new Dimension(this.getWidth(), this.getHeight()), null, AppearanceRepository.BASE_SCROLL_PANEL_APPEARANCE);
        this.scrollPanel.setScrollSpeed(BUTTON_HEIGHT*2);

        this.setUpComponent();

        new TableController(this);
    }

    public Table(final int tableSize) {
        super(new Dimension(FRAME_WIDTH, FRAME_HEIGHT-(BUTTON_HEIGHT*4)), new FlowLayout(FlowLayout.CENTER, 0, 0), new Appearance(AppearanceRepository.TABLE_PANEL_APPEARANCE));

        this.competitorTransferModels = new ArrayList<>(tableSize);
        this.finishingCompetitors = new ArrayList<>();
        this.desiredSize = tableSize;
        this.tableSize = this.determineTableSize();
        this.tableau = tableaus.get(this.tableSize);
        this.elements = new ArrayList<>(this.tableSize);

        this.scrollPanel = new ScrollPanel(new Dimension(this.getWidth(), this.getHeight()), null, AppearanceRepository.BASE_SCROLL_PANEL_APPEARANCE);
        this.scrollPanel.setScrollSpeed(BUTTON_HEIGHT*2);

        this.setUpComponent();

        new TableController(this);
    }

    private int determineColumnNumberConstant() {
        return switch (this.tableSize) {
            case 16 -> 5;
            case 32 -> 9;
            case 64 -> 17;
            case 128 -> 33;
            default -> 4;
        };
    }

    private int determinePositionHandler() {
        return switch (this.tableSize) {
            case 32 -> 8;
            case 64 -> 16;
            case 128 -> 32;
            default -> 4;
        };
    }

    private int determineTableSize() {
        final int numberOfCompetitors = this.competitorTransferModels.isEmpty() ? this.desiredSize : this.competitorTransferModels.size();
        int nPowerOf2 = 3;

        if (numberOfCompetitors > MINIMUM_SIZE) {
            while (Math.pow(2, nPowerOf2) < numberOfCompetitors)
                nPowerOf2++;

            return (int) Math.pow(2, nPowerOf2);
        }
        else
            return MINIMUM_SIZE;
    }

    private void createFirstColumn() {
        int numberIndex = 0;
        String[] numbers = tableau.split(";");

        for (int i = 0; i < this.tableSize/2; i++) {
            final TableElement tableElement = new TableElement(numbers[numberIndex], numbers[numberIndex+1], N_BUTTON_WIDTH, N_BUTTON_WIDTH+(TABLE_ELEMENT_BOUNDS.height*i)+(BUTTON_HEIGHT*i));
            numberIndex += 2;

            this.elements.add(tableElement);
            this.scrollPanel.addComponent(tableElement);
        }
    }

    private void createSecondColumn() {
        int iterationCounter = 0;

        for (int i = 0; i < this.tableSize/4; i++) {
            final TableElement tableElement = new TableElement(this.elements.get(i+iterationCounter), this.elements.get(i+1+iterationCounter), 2);
            iterationCounter++;

            this.elements.add(tableElement);
            this.scrollPanel.addComponent(tableElement);
        }
    }

    private void createThirdColumn() {
        if (this.tableSize == 8) {
            final TableElement finishingTableElement = new TableElement(this.elements.get(this.elements.size()-2), this.elements.getLast(), 3);
            this.elements.add(finishingTableElement);
            this.scrollPanel.addComponent(finishingTableElement);
            return;
        }

        int positionHandler = this.determinePositionHandler();
        final List<TableElement> temporaryElements = new ArrayList<>();

        for (int i = 0; i < this.tableSize/8; i++) {
            final TableElement tableElement = new TableElement(this.elements.get(this.elements.size()-positionHandler), this.elements.get(this.elements.size()-(positionHandler-1)), 3);
            positionHandler -= 2;

            temporaryElements.add(tableElement);
            this.scrollPanel.addComponent(tableElement);
        }

        this.elements.addAll(temporaryElements);
    }

    private void createFourthColumn() {
        if (this.tableSize < 32)
            return;

        int positionHandler = this.determinePositionHandler()/2;
        final List<TableElement> temporaryElements = new ArrayList<>();

        for (int i = 0; i < this.tableSize/16; i++) {
            final TableElement tableElement = new TableElement(this.elements.get(this.elements.size()-positionHandler), this.elements.get(this.elements.size()-(positionHandler-1)), 5);
            positionHandler -= 2;

            temporaryElements.add(tableElement);
            this.scrollPanel.addComponent(tableElement);
        }

        this.elements.addAll(temporaryElements);
    }

    private void createFifthColumn() {
        if (this.tableSize < 64)
            return;

        int positionHandler = this.determinePositionHandler()/4;
        final List<TableElement> temporaryElements = new ArrayList<>();

        for (int i = 0; i < this.tableSize/32; i++) {
            final TableElement tableElement = new TableElement(this.elements.get(this.elements.size()-positionHandler), this.elements.get(this.elements.size()-(positionHandler-1)), 9);
            positionHandler -= 2;

            temporaryElements.add(tableElement);
            this.scrollPanel.addComponent(tableElement);
        }

        this.elements.addAll(temporaryElements);
    }

    private void createLastColumn() {
        if (this.tableSize < 128)
            return;

        int positionHandler = this.determinePositionHandler()/8;
        final List<TableElement> temporaryElements = new ArrayList<>();

        for (int i = 0; i < this.tableSize/64; i++) {
            final TableElement tableElement = new TableElement(this.elements.get(this.elements.size()-positionHandler), this.elements.get(this.elements.size()-(positionHandler-1)), 17);
            positionHandler -= 2;

            temporaryElements.add(tableElement);
            this.scrollPanel.addComponent(tableElement);
        }

        this.elements.addAll(temporaryElements);
    }

    private void finishStructure() {
        this.finishingTableElement = new TableElement(this.elements.get(this.elements.size()-2), this.elements.getLast(), this.determineColumnNumberConstant());
        this.elements.add(this.finishingTableElement);
        this.scrollPanel.addComponent(this.finishingTableElement);
    }

    private void createColumnStructure() {
        this.createFirstColumn();
        this.createSecondColumn();
        this.createThirdColumn();
        this.createFourthColumn();
        this.createFifthColumn();
        this.createLastColumn();
        this.finishStructure();
    }

    private void createStructure() {
        this.createColumnStructure();
        this.addCompetitors();

        this.scrollPanel.getViewPanel()
            .setPreferredSize(new Dimension(0, ((BUTTON_HEIGHT*3))*this.tableSize+(PADDING*this.tableSize)));
        this.addComponent(this.scrollPanel);
    }

    private String findCompetitorNameByPlacement(int placement) {
        for (CompetitorTransferModel competitorTransferModel : this.competitorTransferModels) {
            if (this.competitorTransferModels.indexOf(competitorTransferModel)+1 == placement)
                return competitorTransferModel.name();
        }

        return FrameManager.getCompetitionType() == CompetitionType.COMPETITION ? Table.EMPTY_COMPETITOR : "";
    }

    public Optional<CompetitorTransferModel> findCompetitorByName(final String name) {
        if (name.isBlank() || name.equals(Table.EMPTY_COMPETITOR))
            return Optional.empty();

        return Optional.ofNullable(this.competitorTransferModels.stream()
            .filter(competitor -> competitor.name().equalsIgnoreCase(name))
            .toList()
            .getFirst());
    }

    private void addCompetitors() {
        for (int i = 0; i < this.tableSize/2; i++) {
            final TableElement element = this.elements.get(i);

            element.getTopCompetitorBox().setText(this.findCompetitorNameByPlacement(element.getTopNumbering()));
            element.getBottomCompetitorBox().setText(this.findCompetitorNameByPlacement(element.getBottomNumbering()));
        }
    }

    public boolean checkIfFinished() {
        boolean finished = false;

        for (int i = 0; i < this.elements.size()-1; i++) {
            final TableElement element = this.elements.get(i);
            finished = !element.getWinnerCompetitorBox().getText().isBlank();
        }

        return finished;
    }

    private List<CompetitorTransferModel> removeLastNCompetitors(int amount) {
        List<CompetitorTransferModel> returnList = new ArrayList<>();
        this.finishingCompetitors = this.finishingCompetitors.reversed();

        for (int i = 0; i < amount; i++)
            returnList.add(this.finishingCompetitors.removeFirst());

        return returnList;
    }

    private void sortCompetitors() {
        List<CompetitorTransferModel> temp = this.removeLastNCompetitors(this.finishingCompetitors.size() <= MINIMUM_SIZE ? 3 : 8);
        List<CompetitorTransferModel> tempOfLast8 = new ArrayList<>();

        if (this.finishingCompetitors.size() > MINIMUM_SIZE) {
            for (int i = 0; i < 4; i++)
                tempOfLast8.add(temp.removeLast());

            tempOfLast8.sort(Comparator.comparing(CompetitorTransferModel::placement));
        }

        this.finishingCompetitors.sort(Comparator.comparing(CompetitorTransferModel::placement));
        temp.addAll(tempOfLast8);
        temp.addAll(this.finishingCompetitors);

        this.finishingCompetitors = temp;
    }

    private void buildFinalResultsList() {
        String lastWinner = "";

        if (this.competitorTransferModels.isEmpty()) {
            this.elements.forEach(element -> {
                this.competitorTransferModels.add(new CompetitorTransferModel(0L, element.getTopCompetitorBox().getText(), "-", "-", 0, element.getTopNumbering()));
                this.competitorTransferModels.add(new CompetitorTransferModel(0L, element.getBottomCompetitorBox().getText(), "-", "-", 0, element.getBottomNumbering()));
            });
        }

        for (TableElement element : this.elements) {
            final Box winner = element.getWinnerCompetitorBox();
            final Button topCompetitor = element.getDropdownButtons().getFirst();
            final Button bottomCompetitor = element.getDropdownButtons().getLast();
            final String loserName = winner.getText().equalsIgnoreCase(topCompetitor.getText()) ? bottomCompetitor.getText() : topCompetitor.getText();
            this.findCompetitorByName(loserName).ifPresent(this.finishingCompetitors::add);

            if (!winner.getText().isBlank())
                lastWinner = winner.getText();
        }

        this.findCompetitorByName(lastWinner).ifPresent(this.finishingCompetitors::add);
    }

    public void finish() {
        if (!this.checkIfFinished())
            return;

        this.buildFinalResultsList();
        this.sortCompetitors();
    }

    @Override
    public void setUpComponent() {
        this.createStructure();

        this.elements.forEach(element -> {
            element.setUpDropdownPanel(this.scrollPanel);
            element.stepFencers();
        });
    }

    @Override
    public List<JComponent> getControls() {
        return List.of();
    }

}