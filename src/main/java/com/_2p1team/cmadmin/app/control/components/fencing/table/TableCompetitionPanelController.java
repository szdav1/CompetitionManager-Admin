package com._2p1team.cmadmin.app.control.components.fencing.table;

import com._2p1team.cmadmin.app.control.AbstractController;
import com._2p1team.cmadmin.app.dto.competitor.CompetitorTransferModel;
import com._2p1team.cmadmin.app.view.components.fencing.Box;
import com._2p1team.cmadmin.app.view.components.fencing.table.Table;
import com._2p1team.cmadmin.app.view.components.fencing.table.TableCompetitionPanel;
import com._2p1team.cmadmin.app.view.frame.FrameManager;
import com._2p1team.cmadmin.swing.override.components.button.Button;

import java.awt.event.ActionEvent;

public final class TableCompetitionPanelController extends AbstractController {

    private final TableCompetitionPanel panel;

    public TableCompetitionPanelController(final TableCompetitionPanel component) {
        super(component);

        this.panel = component;

        this.addListeners();
        new TableCompetitionPanelKeyController(panel);
    }

    private void addListeners() {
        this.panel.getCloseButton().addActionListener(this);
        this.panel.getFinishButton().addActionListener(this);
    }

    private void finishTable() {
        /*
         * Fill list
         * Sort without first 8
         * Sort without first 3 (4, because of the two 3rd places)
         * Merge
         * */

        final Table table = this.panel.getTable();
        table.buildFinalResultsList();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(this.panel.getCloseButton()))
            FrameManager.hideTableCompetitionPanel();
        else if (e.getSource().equals(this.panel.getFinishButton()))
            this.finishTable();
    }

}