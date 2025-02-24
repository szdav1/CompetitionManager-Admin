package com._2p1team.cmadmin.app.view.components.modals;

import com._2p1team.cmadmin.app.control.components.modal.NewPouleModalController;
import com._2p1team.cmadmin.app.http.HttpCommunicator;
import com._2p1team.cmadmin.app.view.components.competitor.CompetitorDisplay;
import com._2p1team.cmadmin.app.view.components.input.LabeledInput;
import static com._2p1team.cmadmin.support.constants.AppearanceConstants.PADDING;
import static com._2p1team.cmadmin.support.constants.SizeData.*;
import com._2p1team.cmadmin.support.util.AppearanceRepository;
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
    private final LabeledInput idInput;
    private final LabeledInput nameInput;
    private final Button searchButton;
    private final Button addButton;
    private final Button removeButton;

    @Getter
    private static final List<CompetitorDisplay> participatingCompetitors = new ArrayList<>();

    private final Label participatingLabel;
    private final CompetitorDisplay.Header participatingHeader;
    private final ScrollPanel participatingCompetitorsScrollPanel;
    private final Button createButton;

    public NewPouleModal() {
        super();
        this.setTitle("New Poule");
        this.getCenterPanel().setLayout(new GridLayout(1, 2, PADDING, PADDING));

        this.leftPanel = new Panel(new Dimension(this.getCenterPanel().getWidth()/2-PADDING, this.getCenterPanel().getHeight()), new FlowLayout(FlowLayout.CENTER, 0, 0), new Appearance(AppearanceRepository.POULE_PANEL_APPEARANCE));
        this.rightPanel = new Panel(new Dimension(this.getCenterPanel().getWidth()/2-PADDING, this.getCenterPanel().getHeight()), new FlowLayout(FlowLayout.CENTER, PADDING, PADDING), new Appearance(AppearanceRepository.POULE_PANEL_APPEARANCE));
        this.scrollPanel = new ScrollPanel(new Dimension(this.leftPanel.getWidth(), this.leftPanel.getHeight()-(BUTTON_HEIGHT*2)), new FlowLayout(FlowLayout.CENTER, 0, 0), new Appearance(AppearanceRepository.BASE_SCROLL_PANEL_APPEARANCE));
        this.scrollPanel.setScrollSpeed(BUTTON_HEIGHT);
        this.mainHeader = new CompetitorDisplay.Header(BUTTON_SIZE, BUTTON_SIZE);
        this.competitorDisplays = new ArrayList<>();

        HttpCommunicator.CompetitorApi.getAllCompetitors()
            .forEach(competitor -> this.competitorDisplays.add(new CompetitorDisplay(BUTTON_SIZE, BUTTON_SIZE, competitor)));

        this.searchCompetitorLabel = new Label(new Dimension(this.rightPanel.getWidth(), BUTTON_HEIGHT), "Search competitor", new Appearance(AppearanceRepository.LABELED_INPUT_APPEARANCE));
        this.searchCompetitorLabel.setHorizontalAlignment(SwingConstants.LEFT);

        this.rightPanelContainer = new Panel(new Dimension(this.rightPanel.getWidth(), (BUTTON_HEIGHT*2)+(PADDING*3)), new FlowLayout(FlowLayout.CENTER, PADDING, PADDING), new Appearance(AppearanceRepository.POULE_PANEL_APPEARANCE));
        this.idInput = new LabeledInput("Id");

        this.nameInput = new LabeledInput("Name");
        this.nameInput.getInput().setPreferredSize(W_BUTTON_SIZE);
        this.nameInput.setPreferredSize(new Dimension(this.nameInput.getWidth()+W_BUTTON_WIDTH, this.nameInput.getHeight()));

        this.searchButton = new Button(BUTTON_SIZE, "Search", new Appearance(AppearanceRepository.BASE_BUTTON_APPEARANCE));
        this.addButton = new Button(BUTTON_SIZE, "Add", new Appearance(AppearanceRepository.BASE_BUTTON_APPEARANCE));
        this.removeButton = new Button(BUTTON_SIZE, "Remove", new Appearance(AppearanceRepository.BASE_BUTTON_APPEARANCE));

        this.participatingLabel = new Label(this.searchCompetitorLabel.getPreferredSize(), "Participating Competitors", new Appearance(AppearanceRepository.LABELED_INPUT_APPEARANCE));
        this.participatingLabel.setHorizontalAlignment(SwingConstants.LEFT);

        this.participatingHeader = new CompetitorDisplay.Header(BUTTON_SIZE, BUTTON_SIZE);

        this.participatingCompetitorsScrollPanel = new ScrollPanel(new Dimension(this.rightPanel.getWidth(), this.rightPanel.getHeight()-this.rightPanelContainer.getHeight()-(BUTTON_HEIGHT*5)-PADDING), new FlowLayout(FlowLayout.CENTER, 0, 0), new Appearance(AppearanceRepository.BASE_SCROLL_PANEL_APPEARANCE));
        this.participatingCompetitorsScrollPanel.setScrollSpeed(BUTTON_HEIGHT);
        this.createButton = new Button(BUTTON_SIZE, "Create", new Appearance(AppearanceRepository.BASE_BUTTON_APPEARANCE));

        this.setUpComponent();
        new NewPouleModalController(this);
    }

    @Override
    public void setUpComponent() {
        this.scrollPanel.addComponent(mainHeader);
        this.competitorDisplays.forEach(this.scrollPanel::addComponent);

        this.leftPanel.addComponent(this.scrollPanel);
        this.scrollPanel.resizeViewPanel(N_BUTTON_WIDTH+(BUTTON_WIDTH*4));

        this.rightPanelContainer.addComponent(this.idInput);
        this.rightPanelContainer.addComponent(this.nameInput);
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