package com._2p1team.cmadmin.app.view.components.modals;

import com._2p1team.cmadmin.app.http.HttpCommunicator;
import com._2p1team.cmadmin.app.view.components.competitor.CompetitorDisplay;
import static com._2p1team.cmadmin.general.constants.SizeData.BUTTON_HEIGHT;
import static com._2p1team.cmadmin.general.constants.SizeData.X_BUTTON_SIZE;
import com._2p1team.cmadmin.general.util.AppearanceRepository;
import com._2p1team.cmadmin.swing.override.components.scrollpanel.ScrollPanel;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.swing.JComponent;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.util.ArrayList;
import java.util.List;

@Data
@EqualsAndHashCode(callSuper=false)
public final class ViewCompetitorsModal extends AbstractModal {

    private final CompetitorDisplay.Header header;
    private final ScrollPanel scrollPanel;
    private final List<CompetitorDisplay> competitorDisplays;

    public ViewCompetitorsModal() {
        super();
        this.setTitle("Competitors");

        this.header = new CompetitorDisplay.Header(X_BUTTON_SIZE, X_BUTTON_SIZE);
        this.header.removeComponent(this.header.getCheckbox());

        this.scrollPanel = new ScrollPanel(new Dimension(this.getWidth()-2, this.getHeight()-(BUTTON_HEIGHT*2)), new FlowLayout(FlowLayout.CENTER, 0, 0), AppearanceRepository.BASE_SCROLL_PANEL_APPEARANCE);
        this.scrollPanel.setScrollSpeed(BUTTON_HEIGHT);

        this.competitorDisplays = new ArrayList<>();
        HttpCommunicator.CompetitorApi.getAllCompetitors()
            .forEach(competitor -> this.competitorDisplays.add(new CompetitorDisplay(competitor)));

        this.competitorDisplays.forEach(competitorDisplay -> competitorDisplay.removeComponent(competitorDisplay.getCheckbox()));

        this.setUpComponent();
    }

    @Override
    public void appear() {
        super.appear();

        this.competitorDisplays.clear();
        this.scrollPanel.getViewPanel().removeAll();
        this.scrollPanel.getContents().clear();

        HttpCommunicator.CompetitorApi.getAllCompetitors()
            .forEach(competitor -> this.competitorDisplays.add(new CompetitorDisplay(X_BUTTON_SIZE, X_BUTTON_SIZE, competitor)));

        this.competitorDisplays.forEach(competitorDisplay -> competitorDisplay.removeComponent(competitorDisplay.getCheckbox()));
        this.scrollPanel.addComponent(this.header);
        this.competitorDisplays.forEach(this.scrollPanel::addComponent);
        this.scrollPanel.resizeViewPanel(this.scrollPanel.getViewPanel().getWidth());
    }

    @Override
    public void setUpComponent() {
        this.scrollPanel.addComponent(this.header);
        this.competitorDisplays.forEach(this.scrollPanel::addComponent);
        this.scrollPanel.resizeViewPanel(this.scrollPanel.getViewPanel().getWidth());

        this.getCenterPanel().addComponent(this.scrollPanel);
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