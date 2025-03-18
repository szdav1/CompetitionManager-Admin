package com._2p1team.cmadmin.app.view.components.modals;

import com._2p1team.cmadmin.app.control.components.modal.RemoveCompetitorModalController;
import com._2p1team.cmadmin.app.http.HttpCommunicator;
import com._2p1team.cmadmin.app.view.components.competitor.CompetitorDisplay;
import static com._2p1team.cmadmin.general.constants.SizeData.*;
import com._2p1team.cmadmin.general.util.AppearanceRepository;
import com._2p1team.cmadmin.swing.override.components.button.Button;
import com._2p1team.cmadmin.swing.override.components.scrollpanel.ScrollPanel;
import com._2p1team.cmadmin.swing.override.graphics.Appearance;
import lombok.Getter;

import javax.swing.JComponent;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.util.ArrayList;
import java.util.List;

@Getter
public final class RemoveCompetitorModal extends AbstractModal {

    private final CompetitorDisplay.Header header;
    private final ScrollPanel scrollPanel;
    private final Button deleteButton;
    private final List<CompetitorDisplay> competitorDisplays;

    public RemoveCompetitorModal() {
        super();
        this.setTitle("Remove Competitor");

        this.header = new CompetitorDisplay.Header();
        this.scrollPanel = new ScrollPanel(new Dimension(this.getWidth()-2, this.getHeight()-(BUTTON_HEIGHT*2)), new FlowLayout(FlowLayout.CENTER, 0, 0), AppearanceRepository.BASE_SCROLL_PANEL_APPEARANCE);
        this.scrollPanel.setScrollSpeed(BUTTON_HEIGHT);
        this.deleteButton = new Button(BUTTON_SIZE, "Delete", new Appearance(AppearanceRepository.BASE_BUTTON_APPEARANCE));
        this.competitorDisplays = new ArrayList<>();

        HttpCommunicator.CompetitorApi.getAllCompetitors()
            .forEach(competitor -> this.competitorDisplays.add(new CompetitorDisplay(competitor)));

        this.setUpComponent();
        new RemoveCompetitorModalController(this);
    }

    public void fillCompetitors() {
        this.competitorDisplays.clear();

        HttpCommunicator.CompetitorApi.getAllCompetitors().forEach(competitor ->
            this.competitorDisplays.add(new CompetitorDisplay(BUTTON_SIZE, W_BUTTON_SIZE, competitor)));

        this.scrollPanel.addComponent(this.header);
        this.competitorDisplays.forEach(this.scrollPanel::addComponent);
        this.scrollPanel.resizeViewPanel(this.header.getWidth());
    }

    public List<CompetitorDisplay> getSelectedCompetitors() {
        return this.competitorDisplays.stream()
            .filter(competitorDisplay -> competitorDisplay.getCheckbox().isChecked())
            .toList();
    }

    @Override
    public void setUpComponent() {
        this.scrollPanel.addComponent(this.header);
        this.competitorDisplays.forEach(this.scrollPanel::addComponent);
        this.scrollPanel.resizeViewPanel(this.scrollPanel.getViewPanel().getWidth());

        this.getCenterPanel().addComponent(this.scrollPanel);
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