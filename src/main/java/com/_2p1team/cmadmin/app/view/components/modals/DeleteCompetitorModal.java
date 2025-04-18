package com._2p1team.cmadmin.app.view.components.modals;

import com._2p1team.cmadmin.app.control.components.modal.deletecompetitor.DeleteCompetitorModalController;
import com._2p1team.cmadmin.app.http.HttpCommunicator;
import com._2p1team.cmadmin.app.view.components.competitor.CompetitorDisplay;
import com._2p1team.cmadmin.app.view.components.input.LabeledInput;
import static com._2p1team.cmadmin.general.constants.AppearanceConstants.PADDING;
import com._2p1team.cmadmin.general.constants.Language;
import static com._2p1team.cmadmin.general.constants.SizeData.*;
import com._2p1team.cmadmin.general.util.AppearanceRepository;
import com._2p1team.cmadmin.swing.override.components.button.Button;
import com._2p1team.cmadmin.swing.override.components.label.Label;
import com._2p1team.cmadmin.swing.override.components.panel.Panel;
import com._2p1team.cmadmin.swing.override.components.scrollpanel.ScrollPanel;
import com._2p1team.cmadmin.swing.override.graphics.Appearance;
import lombok.Getter;

import javax.swing.JComponent;
import javax.swing.SwingConstants;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.List;

@Getter
public final class DeleteCompetitorModal extends AbstractModal {

    private final Panel leftPanel;
    private final Panel rightPanel;
    private final ScrollPanel scrollPanel;
    private final CompetitorDisplay.Header header;
    private final List<CompetitorDisplay> competitorDisplays;

    private final Label dashboardLabel;

    private final Label searchCompetitorLabel;
    private final Panel rightPanelContainer;
    private final LabeledInput nameSearchInput;
    private final LabeledInput clubSearchInput;

    private final Button searchButton;
    private final Button deleteButton;

    private final DeleteCompetitorModalController controller;

    public DeleteCompetitorModal() {
        super();
        this.setTitle(Language.get("DeleteCompetitorTitle"));
        this.getCenterPanel().setLayout(new GridLayout(1, 2, PADDING, PADDING));

        this.leftPanel = new Panel(new Dimension(this.getCenterPanel().getWidth()/2-PADDING, this.getCenterPanel().getHeight()), new FlowLayout(FlowLayout.CENTER, 0, 0), new Appearance(AppearanceRepository.POULE_PANEL_APPEARANCE));
        this.rightPanel = new Panel(new Dimension(this.getCenterPanel().getWidth()/2-PADDING, this.getCenterPanel().getHeight()), new FlowLayout(FlowLayout.CENTER, PADDING, PADDING), new Appearance(AppearanceRepository.POULE_PANEL_APPEARANCE));
        this.scrollPanel = new ScrollPanel(new Dimension(this.leftPanel.getWidth(), this.leftPanel.getHeight()-(BUTTON_HEIGHT*2)), new FlowLayout(FlowLayout.CENTER, 0, 0), new Appearance(AppearanceRepository.BASE_SCROLL_PANEL_APPEARANCE));
        this.scrollPanel.setScrollSpeed(BUTTON_HEIGHT);

        this.header = new CompetitorDisplay.Header(BUTTON_SIZE, BUTTON_SIZE);
        this.competitorDisplays = new ArrayList<>();

        this.dashboardLabel = new Label(new Dimension(this.rightPanel.getWidth(), BUTTON_HEIGHT), Language.get("Dashboard"), AppearanceRepository.LABELED_INPUT_APPEARANCE);
        this.dashboardLabel.setHorizontalAlignment(SwingConstants.LEFT);

        this.searchCompetitorLabel = new Label(new Dimension(this.rightPanel.getWidth(), BUTTON_HEIGHT), Language.get("Dashboard"), new Appearance(AppearanceRepository.LABELED_INPUT_APPEARANCE));
        this.searchCompetitorLabel.setHorizontalAlignment(SwingConstants.LEFT);

        this.rightPanelContainer = new Panel(new Dimension(this.rightPanel.getWidth(), (BUTTON_HEIGHT*4)+(PADDING*5)+1), new FlowLayout(FlowLayout.CENTER, PADDING, PADDING), new Appearance(AppearanceRepository.POULE_PANEL_APPEARANCE));

        this.nameSearchInput = new LabeledInput(W_BUTTON_WIDTH, Language.get("Name"));
        this.clubSearchInput = new LabeledInput(W_BUTTON_WIDTH, Language.get("Club"));

        this.searchButton = new Button(BUTTON_SIZE, Language.get("Search"), new Appearance(AppearanceRepository.BASE_BUTTON_APPEARANCE));
        this.deleteButton = new Button(BUTTON_SIZE, Language.get("Delete"), new Appearance(AppearanceRepository.BASE_BUTTON_APPEARANCE));

        this.setUpComponent();

        this.controller = new DeleteCompetitorModalController(this);
    }

    public List<JComponent> getSelectedCompetitors() {
        return this.scrollPanel.getContents()
            .stream()
            .filter(competitorDisplay -> ((CompetitorDisplay) competitorDisplay).getCheckbox().isChecked() && !this.header.equals(competitorDisplay))
            .toList();
    }

    public void fillCompetitors() {
        this.competitorDisplays.clear();

        HttpCommunicator.CompetitorApi.getAllCompetitors().forEach(competitor ->
            this.competitorDisplays.add(new CompetitorDisplay(BUTTON_SIZE, BUTTON_SIZE, competitor)));

        this.controller.addListenersToDisplays();
        this.scrollPanel.addComponent(this.header);
        this.competitorDisplays.forEach(this.scrollPanel::addComponent);
        this.scrollPanel.resizeViewPanel(this.header.getWidth());
    }

    @Override
    public void appear() {
        super.appear();
        this.fillCompetitors();
    }

    @Override
    public void disappear() {
        super.disappear();

        this.competitorDisplays.clear();
        this.scrollPanel.getViewPanel().removeAll();
    }

    @Override
    public void setUpComponent() {
        Panel rightPanelContainerInnerPanel = new Panel(new Dimension(this.rightPanelContainer.getWidth(), BUTTON_HEIGHT), new FlowLayout(FlowLayout.CENTER, 0, 0), AppearanceRepository.LABELED_INPUT_APPEARANCE);

        this.leftPanel.addComponent(this.scrollPanel);

        rightPanelContainerInnerPanel.addComponent(this.searchButton);

        this.rightPanel.addComponent(this.dashboardLabel);

        this.rightPanelContainer.addComponent(this.nameSearchInput);
        this.rightPanelContainer.addComponent(this.clubSearchInput);
        this.rightPanelContainer.addComponent(rightPanelContainerInnerPanel);

        this.rightPanel.addComponent(this.rightPanelContainer);

        this.getCenterPanel().addComponent(this.leftPanel);
        this.getCenterPanel().addComponent(this.rightPanel);

        this.getBottomPanel().addComponent(this.deleteButton);
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