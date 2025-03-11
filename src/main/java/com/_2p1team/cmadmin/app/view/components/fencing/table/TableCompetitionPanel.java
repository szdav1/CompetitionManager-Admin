package com._2p1team.cmadmin.app.view.components.fencing.table;

import com._2p1team.cmadmin.app.control.components.fencing.table.TableCompetitionPanelController;
import com._2p1team.cmadmin.app.dto.competitor.CompetitorTransferClass;
import com._2p1team.cmadmin.app.view.components.competitor.CompetitorTransferDisplay;
import com._2p1team.cmadmin.app.view.components.fencing.poule.PouleCompetitionPanel;
import com._2p1team.cmadmin.app.view.components.modals.NewTableModal;
import com._2p1team.cmadmin.app.view.frame.FrameManager;
import com._2p1team.cmadmin.app.view.interfaces.ComplexComponent;
import com._2p1team.cmadmin.app.view.interfaces.ControlComponent;
import com._2p1team.cmadmin.app.view.interfaces.KeyControlledComponent;
import static com._2p1team.cmadmin.support.constants.AppearanceConstants.PADDING;
import com._2p1team.cmadmin.support.constants.CompetitionType;
import static com._2p1team.cmadmin.support.constants.SizeData.*;
import com._2p1team.cmadmin.support.util.AppearanceRepository;
import com._2p1team.cmadmin.swing.override.components.button.Button;
import com._2p1team.cmadmin.swing.override.components.panel.Panel;
import com._2p1team.cmadmin.swing.override.components.scrollpanel.ScrollPanel;
import com._2p1team.cmadmin.swing.override.constants.Position;
import com._2p1team.cmadmin.swing.override.graphics.Appearance;
import lombok.Getter;

import javax.swing.JComponent;
import java.awt.*;
import java.util.List;

@Getter
public final class TableCompetitionPanel extends Panel implements ControlComponent, KeyControlledComponent, ComplexComponent {

    private final Panel topPanel;
    private final Panel centerPanel;
    private final Panel bottomPanel;
    private final Button closeButton;
    private final Button finishButton;
    private final Button bottomCloseButton;

    private Table table;

    private final ScrollPanel scrollPanel;

    public TableCompetitionPanel() {
        super(new Rectangle(0, 0, FRAME_WIDTH, FRAME_HEIGHT-(BUTTON_HEIGHT*2)), new BorderLayout(), AppearanceRepository.COMPETITION_PANEL_APPEARANCE);

        this.topPanel = new Panel(new Dimension(this.getWidth(), BUTTON_HEIGHT), new FlowLayout(FlowLayout.RIGHT, 0, 0), new Appearance(AppearanceRepository.MODAL_TITLE_BAR_APPEARANCE));
        this.centerPanel = new Panel(new Dimension(this.getWidth(), this.getHeight()-(BUTTON_HEIGHT*2)), new FlowLayout(FlowLayout.CENTER, 0, 0), new Appearance(AppearanceRepository.MODAL_CENTER_PANEL_APPEARANCE));
        this.bottomPanel = new Panel(new Dimension(this.getWidth(), BUTTON_HEIGHT), new FlowLayout(FlowLayout.CENTER, 0, 0), new Appearance(AppearanceRepository.MODAL_TITLE_BAR_APPEARANCE));
        this.closeButton = new Button(N_BUTTON_SIZE, "x", new Appearance(AppearanceRepository.EXIT_BUTTON_APPEARANCE));
        this.finishButton = new Button(BUTTON_SIZE, "Finish", new Appearance(AppearanceRepository.BASE_BUTTON_APPEARANCE));
        this.bottomCloseButton = new Button(BUTTON_SIZE, "Close", new Appearance(AppearanceRepository.BASE_BUTTON_APPEARANCE));

        this.scrollPanel = new ScrollPanel(new Dimension(this.centerPanel.getWidth()-2, this.centerPanel.getHeight()), new FlowLayout(FlowLayout.CENTER, PADDING, PADDING), new Appearance(AppearanceRepository.BASE_SCROLL_PANEL_APPEARANCE));

        this.setUpComponent();
        new TableCompetitionPanelController(this);
    }

    public void appear() {
        if (FrameManager.getCompetitionType() == CompetitionType.TABLE_ONLY) {
            this.table = new Table(NewTableModal.getDesiredSize());

            for (int i = 0; i < this.table.getTableSize()/2; i++) {
                this.table.getElements().get(i).getTopCompetitorBox().setFocusable(true);
                this.table.getElements().get(i).getTopCompetitorBox().setCursor(new Cursor(Cursor.TEXT_CURSOR));

                this.table.getElements().get(i).getBottomCompetitorBox().setFocusable(true);
                this.table.getElements().get(i).getBottomCompetitorBox().setCursor(new Cursor(Cursor.TEXT_CURSOR));
            }
        }
        else if (FrameManager.getCompetitionType() == CompetitionType.COMPETITION)
            this.table = new Table(PouleCompetitionPanel.getCompetitorTransferModels());

        this.centerPanel.addComponent(this.table);
        this.setVisible(true);
    }

    public void disappear() {
        this.centerPanel.removeAll();
        this.scrollPanel.getViewPanel().removeAll();
        this.scrollPanel.getContents().clear();
        this.bottomPanel.removeAll();
        this.bottomPanel.addComponent(this.finishButton);
        this.setVisible(false);
    }

    public void finish() {
        this.table.finish();
        this.centerPanel.removeAll();

        this.scrollPanel.addComponent(new CompetitorTransferDisplay.Header());
        this.table.getFinishingCompetitors().forEach(competitor -> {
            final CompetitorTransferClass competitorTransferClass = new CompetitorTransferClass(competitor);
            competitorTransferClass.setPlacement(this.table.getFinishingCompetitors().indexOf(competitor)+1);

            this.scrollPanel.addComponent(new CompetitorTransferDisplay(competitorTransferClass));
        });

        this.scrollPanel.resizeViewPanel(0);
        this.scrollPanel.getViewPanel().setPreferredSize(new Dimension(this.scrollPanel.getViewPanel().getWidth(), this.scrollPanel.getHeight()+PADDING));
        this.centerPanel.addComponent(this.scrollPanel);
        this.bottomPanel.removeAll();
        this.bottomPanel.addComponent(this.bottomCloseButton);
    }

    @Override
    public void setUpComponent() {
        this.topPanel.addComponent(this.closeButton);
        this.bottomPanel.addComponent(this.finishButton);

        this.addComponent(this.topPanel, Position.TOP);
        this.addComponent(this.centerPanel);
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