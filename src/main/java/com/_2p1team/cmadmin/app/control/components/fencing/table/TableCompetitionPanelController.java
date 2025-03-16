package com._2p1team.cmadmin.app.control.components.fencing.table;

import com._2p1team.cmadmin.app.control.AbstractController;
import com._2p1team.cmadmin.app.dto.competition.CompetitionTransfer;
import com._2p1team.cmadmin.app.dto.leaderboard.Leaderboard;
import com._2p1team.cmadmin.app.http.HttpCommunicator;
import com._2p1team.cmadmin.app.view.components.fencing.table.TableCompetitionPanel;
import com._2p1team.cmadmin.app.view.frame.FrameManager;
import com._2p1team.cmadmin.support.constants.CompetitionType;
import com._2p1team.cmadmin.support.util.JsonConverter;

import java.awt.event.ActionEvent;
import java.net.http.HttpResponse;

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

    private void finishTable() {
        if (!this.panel.getTable().checkIfFinished())
            return;

        this.panel.finish();

        if (FrameManager.getCompetitionType() != CompetitionType.COMPETITION)
            return;

        HttpResponse<String> response = HttpCommunicator.CompetitionApi.uploadCompetition(FrameManager.getCurrentCompetition());

        if (response.body().isBlank())
            return;

        CompetitionTransfer competitionTransfer = JsonConverter.jsonToCompetition(response.body());

        this.panel.getTable().getFinishingCompetitors().forEach(competitor ->
            HttpCommunicator.LeaderboardApi.uploadResult(
                new Leaderboard(competitionTransfer.getId(), competitor.id(), this.panel.getTable().getFinishingCompetitors().indexOf(competitor)+1))
        );

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(this.panel.getCloseButton()) || e.getSource().equals(this.panel.getBottomCloseButton()))
            FrameManager.hideTableCompetitionPanel();
        else if (e.getSource().equals(this.panel.getFinishButton()))
            this.finishTable();
    }

}