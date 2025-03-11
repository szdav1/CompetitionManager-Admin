package com._2p1team.cmadmin.app.control.components.fencing.table;

import com._2p1team.cmadmin.app.control.AbstractController;
import com._2p1team.cmadmin.app.view.components.fencing.table.TableCompetitionPanel;
import com._2p1team.cmadmin.app.view.frame.FrameManager;

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
        this.panel.getBottomCloseButton().addActionListener(this);
    }

    // TODO: Put data into the database
    private void finishTable() {
        if (this.panel.getTable().checkIfFinished())
            this.panel.finish();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(this.panel.getCloseButton()) || e.getSource().equals(this.panel.getBottomCloseButton()))
            FrameManager.hideTableCompetitionPanel();
        else if (e.getSource().equals(this.panel.getFinishButton()))
            this.finishTable();
    }

}