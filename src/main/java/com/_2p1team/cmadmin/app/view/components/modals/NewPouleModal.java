package com._2p1team.cmadmin.app.view.components.modals;

import com._2p1team.cmadmin.app.control.components.modal.NewPouleModalController;
import com._2p1team.cmadmin.app.http.HttpCommunicator;
import com._2p1team.cmadmin.app.view.components.competitor.CompetitorDisplay;
import static com._2p1team.cmadmin.support.constants.AppearanceConstants.PADDING;
import static com._2p1team.cmadmin.support.constants.SizeData.*;
import com._2p1team.cmadmin.support.util.AppearanceRepository;
import com._2p1team.cmadmin.swing.override.components.panel.Panel;
import com._2p1team.cmadmin.swing.override.components.scrollpanel.ScrollPanel;
import com._2p1team.cmadmin.swing.override.graphics.Appearance;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.swing.JComponent;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.List;

// TODO: Finish this
@Data
@EqualsAndHashCode(callSuper=false)
public final class NewPouleModal extends AbstractModal {

    private final Panel leftPanel;
    private final Panel rightPanel;
    private final ScrollPanel scrollPanel;
    private final CompetitorDisplay.Header header;
    private final List<CompetitorDisplay> competitorDisplays;

    public NewPouleModal() {
        super();
        this.setTitle("New Poule");
        this.getCenterPanel().setLayout(new GridLayout(1, 2, PADDING, PADDING));

        this.leftPanel = new Panel(new Dimension(this.getCenterPanel().getWidth()/2-PADDING, this.getCenterPanel().getHeight()), new FlowLayout(FlowLayout.CENTER, 0, 0), new Appearance(AppearanceRepository.POULE_PANEL_APPEARANCE));
        this.rightPanel = new Panel(new Dimension(this.getCenterPanel().getWidth()/2-PADDING, this.getCenterPanel().getHeight()), new Appearance(AppearanceRepository.POULE_PANEL_APPEARANCE));
        this.scrollPanel = new ScrollPanel(new Dimension(this.leftPanel.getWidth(), this.leftPanel.getHeight()-(BUTTON_HEIGHT*2)), new FlowLayout(FlowLayout.CENTER, 0, 0), new Appearance(AppearanceRepository.BASE_SCROLL_PANEL_APPEARANCE));
        this.scrollPanel.setScrollSpeed(BUTTON_HEIGHT);
        header = new CompetitorDisplay.Header();
        this.competitorDisplays = new ArrayList<>();

        HttpCommunicator.CompetitorApi.getAllCompetitors()
            .forEach(competitor -> this.competitorDisplays.add(new CompetitorDisplay(BUTTON_SIZE, BUTTON_SIZE, competitor)));

        this.setUpComponent();
        new NewPouleModalController(this);
    }

    @Override
    public void setUpComponent() {
        this.scrollPanel.addComponent(header);
        this.competitorDisplays.forEach(this.scrollPanel::addComponent);

        this.leftPanel.addComponent(this.scrollPanel);
        this.scrollPanel.resizeViewPanel(N_BUTTON_WIDTH+(BUTTON_WIDTH*4)+4);

        this.getCenterPanel().addComponent(this.leftPanel);
        this.getCenterPanel().addComponent(this.rightPanel);
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