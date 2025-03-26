package com._2p1team.cmadmin.app.view.components.modals;

import com._2p1team.cmadmin.app.control.components.modal.NewPouleModalController;
import com._2p1team.cmadmin.app.http.HttpCommunicator;
import com._2p1team.cmadmin.app.view.components.competitor.CompetitorDisplay;
import com._2p1team.cmadmin.app.view.components.input.LabeledInput;
import com._2p1team.cmadmin.app.view.frame.FrameManager;
import static com._2p1team.cmadmin.general.constants.AppearanceConstants.PADDING;
import com._2p1team.cmadmin.general.constants.CompetitionType;
import com._2p1team.cmadmin.general.constants.Language;
import static com._2p1team.cmadmin.general.constants.SizeData.*;
import com._2p1team.cmadmin.general.util.AppearanceRepository;
import com._2p1team.cmadmin.swing.override.components.button.Button;
import com._2p1team.cmadmin.swing.override.components.label.Label;
import com._2p1team.cmadmin.swing.override.components.panel.Panel;
import com._2p1team.cmadmin.swing.override.components.scrollpanel.ScrollPanel;
import com._2p1team.cmadmin.swing.override.graphics.Appearance;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;

import javax.swing.JComponent;
import javax.swing.SwingConstants;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.List;

@Data
@EqualsAndHashCode(callSuper=false)
public final class NewPouleModal extends AbstractModal {

    private final Panel leftPanel;
    private final Panel rightPanel;
    private final ScrollPanel scrollPanel;
    private final CompetitorDisplay.Header mainHeader;
    private final List<CompetitorDisplay> competitorDisplays;

    private final Label searchCompetitorLabel;
    private final Panel rightPanelContainer;
    private final LabeledInput nameInput;
    private final LabeledInput clubInput;
    private final Button searchButton;
    private final Button addButton;
    private final Button removeButton;

    @Getter
    private static final List<CompetitorDisplay> participatingCompetitors = new ArrayList<>();

    private final LabeledInput competitionNameInput;
    private final LabeledInput competitionLocationInput;

    private final Label participatingLabel;
    private final CompetitorDisplay.Header participatingHeader;
    private final ScrollPanel participatingCompetitorsScrollPanel;
    private final Button createButton;

    public NewPouleModal() {
        super();
        this.setTitle(Language.get("NewPouleTitle"));
        this.getCenterPanel().setLayout(new GridLayout(1, 2, PADDING, PADDING));

        this.leftPanel = new Panel(new Dimension(this.getCenterPanel().getWidth()/2-PADDING, this.getCenterPanel().getHeight()), new FlowLayout(FlowLayout.CENTER, 0, 0), new Appearance(AppearanceRepository.POULE_PANEL_APPEARANCE));
        this.rightPanel = new Panel(new Dimension(this.getCenterPanel().getWidth()/2-PADDING, this.getCenterPanel().getHeight()), new FlowLayout(FlowLayout.CENTER, PADDING, PADDING), new Appearance(AppearanceRepository.POULE_PANEL_APPEARANCE));
        this.scrollPanel = new ScrollPanel(new Dimension(this.leftPanel.getWidth(), this.leftPanel.getHeight()-(BUTTON_HEIGHT*2)), new FlowLayout(FlowLayout.CENTER, 0, 0), new Appearance(AppearanceRepository.BASE_SCROLL_PANEL_APPEARANCE));
        this.scrollPanel.setScrollSpeed(BUTTON_HEIGHT);
        this.mainHeader = new CompetitorDisplay.Header(BUTTON_SIZE, BUTTON_SIZE);
        this.competitorDisplays = new ArrayList<>();

        this.searchCompetitorLabel = new Label(new Dimension(this.rightPanel.getWidth(), BUTTON_HEIGHT), Language.get("Dashboard"), new Appearance(AppearanceRepository.LABELED_INPUT_APPEARANCE));
        this.searchCompetitorLabel.setHorizontalAlignment(SwingConstants.LEFT);

        this.rightPanelContainer = new Panel(new Dimension(this.rightPanel.getWidth(), (BUTTON_HEIGHT*3)+(PADDING*4)+1), new FlowLayout(FlowLayout.CENTER, PADDING, PADDING), new Appearance(AppearanceRepository.POULE_PANEL_APPEARANCE));

        this.nameInput = new LabeledInput(BUTTON_WIDTH, Language.get("Name"));
        this.clubInput = new LabeledInput(BUTTON_WIDTH, Language.get("Club"));

        this.searchButton = new Button(BUTTON_SIZE, Language.get("Search"), new Appearance(AppearanceRepository.BASE_BUTTON_APPEARANCE));
        this.addButton = new Button(BUTTON_SIZE, Language.get("Add"), new Appearance(AppearanceRepository.BASE_BUTTON_APPEARANCE));
        this.removeButton = new Button(BUTTON_SIZE, Language.get("Remove"), new Appearance(AppearanceRepository.BASE_BUTTON_APPEARANCE));

        this.competitionNameInput = new LabeledInput(BUTTON_WIDTH, Language.get("CompetitionName"));
        this.competitionLocationInput = new LabeledInput(BUTTON_WIDTH, Language.get("CompetitionLocation"));

        this.participatingLabel = new Label(this.searchCompetitorLabel.getPreferredSize(), Language.get("ParticipatingCompetitors"), new Appearance(AppearanceRepository.LABELED_INPUT_APPEARANCE));
        this.participatingLabel.setHorizontalAlignment(SwingConstants.LEFT);

        this.participatingHeader = new CompetitorDisplay.Header(BUTTON_SIZE, BUTTON_SIZE);

        this.participatingCompetitorsScrollPanel = new ScrollPanel(
            new Dimension(this.rightPanel.getWidth(), (this.rightPanel.getHeight()-this.rightPanelContainer.getHeight()-(BUTTON_HEIGHT*7)+PADDING+(PADDING/3))),
            new FlowLayout(FlowLayout.CENTER, 0, 0),
            new Appearance(AppearanceRepository.BASE_SCROLL_PANEL_APPEARANCE)
        );

        this.participatingCompetitorsScrollPanel.setScrollSpeed(BUTTON_HEIGHT);
        this.createButton = new Button(BUTTON_SIZE, Language.get("Create"), new Appearance(AppearanceRepository.BASE_BUTTON_APPEARANCE));

        this.setUpComponent();
        new NewPouleModalController(this);
    }

    @Override
    public void appear() {
        super.appear();
        this.setTitle(FrameManager.getCompetitionType() == CompetitionType.POULE_ONLY ? Language.get("NewPouleTitle") : Language.get("NewCompetitionTitle"));

        this.competitorDisplays.clear();

        HttpCommunicator.CompetitorApi.getAllCompetitors()
            .forEach(competitor -> this.competitorDisplays.add(new CompetitorDisplay(BUTTON_SIZE, BUTTON_SIZE, competitor)));

        this.scrollPanel.getContents().clear();
        this.scrollPanel.getViewPanel().removeAll();
        this.scrollPanel.addComponent(this.mainHeader);
        this.competitorDisplays.forEach(this.scrollPanel::addComponent);
        this.scrollPanel.resizeViewPanel(this.mainHeader.getWidth());
    }

    @Override
    public void disappear() {
        super.disappear();

        this.participatingCompetitorsScrollPanel.getViewPanel().removeAll();
        this.participatingCompetitorsScrollPanel.getContents().clear();
        this.participatingCompetitorsScrollPanel.addComponent(this.participatingHeader);
        this.participatingCompetitorsScrollPanel.resizeViewPanel(0);
    }

    @Override
    public void setUpComponent() {
        Panel horizontalDivider = new Panel(new Dimension(this.rightPanel.getWidth(), 1), AppearanceRepository.HOLLOW_HORIZONTAL_DIVIDER_APPEARANCE);

        this.scrollPanel.addComponent(mainHeader);
        this.competitorDisplays.forEach(this.scrollPanel::addComponent);

        this.leftPanel.addComponent(this.scrollPanel);
        this.scrollPanel.resizeViewPanel(N_BUTTON_WIDTH+(BUTTON_WIDTH*4));

        this.rightPanelContainer.addComponent(this.competitionNameInput);
        this.rightPanelContainer.addComponent(this.competitionLocationInput);
        this.rightPanelContainer.addComponent(horizontalDivider);
        this.rightPanelContainer.addComponent(this.nameInput);
        this.rightPanelContainer.addComponent(this.clubInput);
        this.rightPanelContainer.addComponent(this.searchButton);
        this.rightPanelContainer.addComponent(this.addButton);
        this.rightPanelContainer.addComponent(this.removeButton);

        this.participatingCompetitorsScrollPanel.addComponent(this.participatingHeader);

        this.rightPanel.addComponent(this.searchCompetitorLabel);
        this.rightPanel.addComponent(this.rightPanelContainer);
        this.rightPanel.addComponent(this.participatingLabel);
        this.rightPanel.addComponent(this.participatingCompetitorsScrollPanel);

        this.getCenterPanel().addComponent(this.leftPanel);
        this.getCenterPanel().addComponent(this.rightPanel);
        this.getBottomPanel().addComponent(this.createButton);
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