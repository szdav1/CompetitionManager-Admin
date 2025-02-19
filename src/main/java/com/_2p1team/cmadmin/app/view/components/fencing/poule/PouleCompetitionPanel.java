package com._2p1team.cmadmin.app.view.components.fencing.poule;

import com._2p1team.cmadmin.app.control.components.fencing.poule.PouleCompetitionPanelController;
import com._2p1team.cmadmin.app.view.components.competitor.CompetitorDisplay;
import com._2p1team.cmadmin.app.view.components.modals.NewPouleModal;
import com._2p1team.cmadmin.app.view.interfaces.ComplexComponent;
import com._2p1team.cmadmin.app.view.interfaces.ControlComponent;
import com._2p1team.cmadmin.app.view.interfaces.KeyControlledComponent;
import static com._2p1team.cmadmin.support.constants.AppearanceConstants.PADDING;
import static com._2p1team.cmadmin.support.constants.SizeData.*;
import com._2p1team.cmadmin.support.util.AppearanceRepository;
import com._2p1team.cmadmin.swing.override.components.button.Button;
import com._2p1team.cmadmin.swing.override.components.panel.Panel;
import com._2p1team.cmadmin.swing.override.components.scrollpanel.ScrollPanel;
import com._2p1team.cmadmin.swing.override.constants.Position;
import com._2p1team.cmadmin.swing.override.graphics.Appearance;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.swing.JComponent;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.List;
// TODO: Design the final form of this panel
@Data
@EqualsAndHashCode(callSuper=false)
public final class PouleCompetitionPanel extends Panel implements ComplexComponent, ControlComponent, KeyControlledComponent {

    private final Panel topPanel;
    private final Panel centerPanel;
    private final Panel bottomPanel;
    private ScrollPanel scrollPanel;

    private final Button closeButton;

    private List<CompetitorDisplay> competitors;
    private final List<Poule> poules;

    public PouleCompetitionPanel() {
        super(new Rectangle(0, 0, FRAME_WIDTH, FRAME_HEIGHT-(BUTTON_HEIGHT*2)), new BorderLayout(), new Appearance(AppearanceRepository.POULE_COMPETITION_PANEL_APPEARANCE));

        this.topPanel = new Panel(new Dimension(this.getWidth(), BUTTON_HEIGHT), new FlowLayout(FlowLayout.RIGHT, 0, 0), new Appearance(AppearanceRepository.MODAL_TITLE_BAR_APPEARANCE));
        this.centerPanel = new Panel(new Dimension(this.getWidth(), this.getHeight()-(BUTTON_HEIGHT*2)), new FlowLayout(FlowLayout.CENTER, PADDING, PADDING), new Appearance(AppearanceRepository.MODAL_CENTER_PANEL_APPEARANCE));
        this.bottomPanel = new Panel(new Dimension(this.getWidth(), BUTTON_HEIGHT), new FlowLayout(FlowLayout.RIGHT, 0, 0), new Appearance(AppearanceRepository.MODAL_TITLE_BAR_APPEARANCE));

        this.scrollPanel = new ScrollPanel(this.centerPanel.getPreferredSize(), new FlowLayout(FlowLayout.CENTER, PADDING, PADDING), new Appearance(AppearanceRepository.BASE_SCROLL_PANEL_APPEARANCE));
        this.scrollPanel.setScrollSpeed(POULE_PANEL_HEIGHT/4);

        this.closeButton = new Button(N_BUTTON_SIZE, "x", new Appearance(AppearanceRepository.EXIT_BUTTON_APPEARANCE));

        this.competitors = new ArrayList<>();
        this.poules = new ArrayList<>();

        this.setUpComponent();
        new PouleCompetitionPanelController(this);
    }

    private void drawPoules() {
        this.poules.forEach(this.scrollPanel::addComponent);
        this.scrollPanel.resizeViewPanel(this.scrollPanel.getViewPanel().getWidth());
    }

    private void createPoules() {
        this.competitors = NewPouleModal.getParticipatingCompetitors();
        int numberOfCompetitors = this.competitors.size();
        int numberOfPoules = (int) Math.ceil((double) numberOfCompetitors/Poule.DESIRED_SIZE);
        int competitorsPerPoule = numberOfCompetitors/numberOfPoules;
        int remainderCompetitors = numberOfCompetitors%competitorsPerPoule;

        if (numberOfCompetitors < Poule.DESIRED_SIZE)
            this.poules.add(new Poule(numberOfCompetitors));

        else if (numberOfCompetitors == Poule.DESIRED_SIZE)
            this.poules.add(new Poule(Poule.DESIRED_SIZE));

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
                Poule poule = this.poules.get(index);

                if (poule.getNumberOfCompetitors() >= Poule.MAX_SIZE)
                    continue;

                poule.recreateLayout(poule.getNumberOfCompetitors()+1);
                remainderCompetitors--;
                index++;

                if (index >= this.poules.size())
                    index = 0;
            }
        }

        this.drawPoules();
    }

    public void disappear() {
        this.setVisible(false);

        this.scrollPanel.getViewPanel().removeAll();
        this.scrollPanel.getContents().clear();
        this.scrollPanel.resizeViewPanel(this.scrollPanel.getWidth());
        this.poules.clear();
        this.competitors.clear();
    }

    public void appear() {
        this.createPoules();
        this.setVisible(true);
    }

    @Override
    public void setUpComponent() {
        this.topPanel.addComponent(this.closeButton);
        this.centerPanel.addComponent(this.scrollPanel);

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