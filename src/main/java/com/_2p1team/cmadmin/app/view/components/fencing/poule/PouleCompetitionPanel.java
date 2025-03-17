package com._2p1team.cmadmin.app.view.components.fencing.poule;

import com._2p1team.cmadmin.app.control.components.fencing.poule.PouleCompetitionPanelController;
import com._2p1team.cmadmin.app.dto.competitor.Competitor;
import com._2p1team.cmadmin.app.dto.competitor.CompetitorTransferModel;
import com._2p1team.cmadmin.app.view.components.competition.CompetitionDisplay;
import com._2p1team.cmadmin.app.view.components.competitor.CompetitorDisplay;
import com._2p1team.cmadmin.app.view.components.competitor.CompetitorTransferDisplay;
import com._2p1team.cmadmin.app.view.components.modals.NewPouleModal;
import com._2p1team.cmadmin.app.view.frame.FrameManager;
import com._2p1team.cmadmin.app.view.interfaces.ComplexComponent;
import com._2p1team.cmadmin.app.view.interfaces.ControlComponent;
import com._2p1team.cmadmin.app.view.interfaces.KeyControlledComponent;
import static com._2p1team.cmadmin.general.constants.AppearanceConstants.PADDING;
import com._2p1team.cmadmin.general.constants.CompetitionType;
import static com._2p1team.cmadmin.general.constants.SizeData.*;
import com._2p1team.cmadmin.general.util.AppearanceRepository;
import com._2p1team.cmadmin.swing.override.components.button.Button;
import com._2p1team.cmadmin.swing.override.components.panel.Panel;
import com._2p1team.cmadmin.swing.override.components.scrollpanel.ScrollPanel;
import com._2p1team.cmadmin.swing.override.constants.Position;
import com._2p1team.cmadmin.swing.override.graphics.Appearance;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;

import javax.swing.JComponent;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@Data
@EqualsAndHashCode(callSuper=false)
public final class PouleCompetitionPanel extends Panel implements ComplexComponent, ControlComponent, KeyControlledComponent {

    private final Panel topPanel;
    private final Panel topInnerPanel;
    private final Panel centerPanel;
    private final Panel bottomPanel;
    private ScrollPanel scrollPanel;

    private CompetitionDisplay competitionDisplay;
    private final Button closeButton;
    private final Button finishButton;
    private final Button resultsButton;
    private final Button bottomCloseButton;
    private final Button continueButton;

    private List<CompetitorDisplay> competitors;
    private final List<Poule> poules;

    @Getter
    private static final List<CompetitorTransferModel> competitorTransferModels = new ArrayList<>();

    public PouleCompetitionPanel() {
        super(new Rectangle(0, 0, FRAME_WIDTH, FRAME_HEIGHT-(BUTTON_HEIGHT*2)), new BorderLayout(), new Appearance(AppearanceRepository.COMPETITION_PANEL_APPEARANCE));

        this.topPanel = new Panel(new Dimension(this.getWidth(), BUTTON_HEIGHT), new FlowLayout(FlowLayout.RIGHT, 0, 0), new Appearance(AppearanceRepository.MODAL_TITLE_BAR_APPEARANCE));
        this.topInnerPanel = new Panel(new Dimension(this.topPanel.getWidth()-N_BUTTON_WIDTH, BUTTON_HEIGHT), new FlowLayout(FlowLayout.LEFT, 0, 0), AppearanceRepository.LABELED_INPUT_APPEARANCE);
        this.centerPanel = new Panel(new Dimension(this.getWidth(), this.getHeight()-(BUTTON_HEIGHT*2)), new FlowLayout(FlowLayout.CENTER, PADDING, PADDING), new Appearance(AppearanceRepository.MODAL_CENTER_PANEL_APPEARANCE));
        this.bottomPanel = new Panel(new Dimension(this.getWidth(), BUTTON_HEIGHT), new FlowLayout(FlowLayout.CENTER, 0, 0), new Appearance(AppearanceRepository.MODAL_TITLE_BAR_APPEARANCE));

        this.scrollPanel = new ScrollPanel(new Dimension(this.centerPanel.getWidth()-2, this.centerPanel.getHeight()-BUTTON_HEIGHT), new FlowLayout(FlowLayout.CENTER, 0, 0), new Appearance(AppearanceRepository.BASE_SCROLL_PANEL_APPEARANCE));
        this.scrollPanel.setScrollSpeed(POULE_PANEL_HEIGHT/6);

        this.closeButton = new Button(N_BUTTON_SIZE, "x", new Appearance(AppearanceRepository.EXIT_BUTTON_APPEARANCE));
        this.finishButton = new Button(BUTTON_SIZE, "Finish All", new Appearance(AppearanceRepository.BASE_BUTTON_APPEARANCE));
        this.resultsButton = new Button(BUTTON_SIZE, "Results", new Appearance(AppearanceRepository.BASE_BUTTON_APPEARANCE));
        this.bottomCloseButton = new Button(BUTTON_SIZE, "Close", new Appearance(AppearanceRepository.BASE_BUTTON_APPEARANCE));
        this.continueButton = new Button(BUTTON_SIZE, "Continue", new Appearance(AppearanceRepository.BASE_BUTTON_APPEARANCE));

        this.competitors = new ArrayList<>();
        this.poules = new ArrayList<>();

        this.setUpComponent();
        new PouleCompetitionPanelController(this);
    }

    private void drawPoules() {
        this.poules.forEach(poule -> {
            poule.setPouleNumberLabel(this.poules.indexOf(poule)+1);
            this.scrollPanel.addComponent(poule);
        });

        this.scrollPanel.resizeViewPanel(this.scrollPanel.getViewPanel().getWidth());
    }

    private void fillPoules() {
        List<CompetitorDisplay> sortedCompetitors = this.competitors.stream()
            .sorted(Comparator.comparing(competitorDisplay -> competitorDisplay.getClubLabel().getText()))
            .toList();

        int pouleBoxIndex = 1;
        int pouleIndex = 0;

        for (CompetitorDisplay sortedCompetitor : sortedCompetitors) {
            if (pouleIndex >= this.poules.size())
                pouleIndex = 0;

            final Poule poule = this.poules.get(pouleIndex);

            if (pouleBoxIndex >= poule.getBoxes().length)
                pouleBoxIndex = 1;

            if (!poule.getBoxes()[pouleBoxIndex][0].getText().isBlank())
                continue;

            poule.getBoxes()[pouleBoxIndex][0].setText(sortedCompetitor.getClubLabel().getText());
            poule.getBoxes()[pouleBoxIndex][1].setText(sortedCompetitor.getNameLabel().getText());
            poule.getStartingCompetitors().add(new Competitor(sortedCompetitor));

            pouleBoxIndex++;
            pouleIndex++;
        }
    }

    private void createPoules() {
        this.competitors = NewPouleModal.getParticipatingCompetitors();
        int numberOfCompetitors = this.competitors.size();
        int numberOfPoules = (int) Math.ceil((double) numberOfCompetitors/Poule.PREFERRED_SIZE);
        int competitorsPerPoule = numberOfCompetitors/numberOfPoules;
        int remainderCompetitors = numberOfCompetitors%competitorsPerPoule;

        if (numberOfCompetitors < Poule.PREFERRED_SIZE)
            this.poules.add(new Poule(numberOfCompetitors));

        else if (numberOfCompetitors == Poule.PREFERRED_SIZE)
            this.poules.add(new Poule(Poule.PREFERRED_SIZE));

        else if (numberOfCompetitors == Poule.MAX_SIZE)
            this.poules.add(new Poule(numberOfCompetitors));

        else if (remainderCompetitors == 0) {
            for (int i = 0; i < numberOfPoules; i++) {
                this.poules.add(new Poule(competitorsPerPoule));
            }
        }
        else {
            for (int i = 0; i < numberOfPoules; i++) {
                this.poules.add(new Poule(competitorsPerPoule));
            }

            int index = 0;

            while (remainderCompetitors > 0) {
                int numberOfCompetitorsInCurrentPoule = this.poules.get(index).getNumberOfCompetitors();
                this.poules.remove(this.poules.get(index));
                this.poules.add(new Poule(numberOfCompetitorsInCurrentPoule+1));
                remainderCompetitors--;
                index++;

                if (index >= this.poules.size())
                    index = 0;
            }
        }

        this.poules.sort(Comparator.comparing(Poule::getNumberOfCompetitors).reversed());
        this.fillPoules();
        this.drawPoules();
    }

    private void resetPanel() {
        this.scrollPanel.getViewPanel().removeAll();
        this.scrollPanel.getContents().clear();
        this.scrollPanel.resizeViewPanel(0);
        this.competitors.clear();
    }

    public void disappear() {
        this.setVisible(false);
        this.resetPanel();
        this.poules.clear();
        this.topInnerPanel.removeComponent(this.competitionDisplay);
        this.bottomPanel.removeComponent(this.finishButton);
        this.bottomPanel.removeComponent(this.resultsButton);
        this.bottomPanel.removeComponent(this.bottomCloseButton);
        this.bottomPanel.removeComponent(this.continueButton);
        this.bottomPanel.addComponent(this.finishButton);
    }

    public void appear() {
        this.competitionDisplay = new CompetitionDisplay(FrameManager.getCurrentCompetition());

        this.topInnerPanel.addComponent(this.competitionDisplay);

        competitorTransferModels.clear();
        this.createPoules();
        this.setVisible(true);
    }

    public void finishPoules() {
        for (Poule poule : this.poules) {
            if (poule.calculateCompetitorData())
                return;
        }

        this.poules.forEach(poule -> poule.getFinishingCompetitors().forEach(competitor -> competitorTransferModels.add(new CompetitorTransferModel(
            competitor.id(),
            competitor.name(),
            competitor.club(),
            competitor.birthDate(),
            competitor.index(),
            competitor.placement()
        ))));

        competitorTransferModels.sort((ctm1, ctm2) -> ctm1.index() != ctm2.index() ? ctm2.index()-ctm1.index() : ctm2.placement()-ctm1.placement());
        this.bottomPanel.removeComponent(this.finishButton);
        this.bottomPanel.addComponent(this.resultsButton);
    }

    public void showResults() {
        this.resetPanel();

        this.scrollPanel.addComponent(new CompetitorTransferDisplay.Header());

        competitorTransferModels.forEach(competitorTransferModel -> {
            final CompetitorTransferDisplay competitorTransferDisplay = new CompetitorTransferDisplay(competitorTransferModel);
            competitorTransferDisplay.getPlacementLabel().setText(String.valueOf(competitorTransferModels.indexOf(competitorTransferModel)+1));
            this.scrollPanel.addComponent(competitorTransferDisplay);
        });

        this.scrollPanel.resizeViewPanel(X_BUTTON_WIDTH*4);
        this.bottomPanel.removeComponent(this.resultsButton);

        if (FrameManager.getCompetitionType() == CompetitionType.POULE_ONLY)
            this.bottomPanel.addComponent(this.bottomCloseButton);
        else if (FrameManager.getCompetitionType() == CompetitionType.COMPETITION)
            this.bottomPanel.addComponent(this.continueButton);
    }

    @Override
    public void setUpComponent() {
        this.topPanel.addComponent(this.topInnerPanel);
        this.topPanel.addComponent(this.closeButton);
        this.centerPanel.addComponent(this.scrollPanel);
        this.bottomPanel.addComponent(this.finishButton);

        this.addComponent(this.topPanel, Position.TOP);
        this.addComponent(this.centerPanel, Position.CENTER);
        this.addComponent(this.bottomPanel, Position.BOTTOM);
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