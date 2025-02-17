package com._2p1team.cmadmin.app.view.components.modals;

import com._2p1team.cmadmin.app.view.components.competitor.CompetitorDisplay;
import com._2p1team.cmadmin.repository.CompetitorRepository;
import static com._2p1team.cmadmin.support.constants.SizeData.BUTTON_HEIGHT;
import com._2p1team.cmadmin.support.util.AppearanceRepository;
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
        this.setTitle("Competitors");

        this.header = new CompetitorDisplay.Header();

        this.scrollPanel = new ScrollPanel(new Dimension(this.getWidth()-2, this.getHeight()-(BUTTON_HEIGHT*2)), new FlowLayout(FlowLayout.CENTER, 0, 0), AppearanceRepository.BASE_SCROLL_PANEL_APPEARANCE);
        this.scrollPanel.setScrollSpeed(BUTTON_HEIGHT);

        this.competitorDisplays = new ArrayList<>();
        CompetitorRepository.competitors
            .forEach(competitor -> competitorDisplays.add(new CompetitorDisplay(competitor)));

        this.setUpComponent();
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