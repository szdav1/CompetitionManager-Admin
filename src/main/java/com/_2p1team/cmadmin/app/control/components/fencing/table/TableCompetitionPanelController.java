package com._2p1team.cmadmin.app.control.components.fencing.table;

import com._2p1team.cmadmin.app.control.AbstractController;
import com._2p1team.cmadmin.app.dto.competition.CompetitionTransfer;
import com._2p1team.cmadmin.app.dto.competitor.CompetitorTransferModel;
import com._2p1team.cmadmin.app.dto.leaderboard.Leaderboard;
import com._2p1team.cmadmin.app.http.HttpCommunicator;
import com._2p1team.cmadmin.app.http.ResponseInterpreter;
import com._2p1team.cmadmin.app.view.components.fencing.table.TableCompetitionPanel;
import com._2p1team.cmadmin.app.view.frame.FrameManager;
import com._2p1team.cmadmin.general.constants.CompetitionType;
import com._2p1team.cmadmin.general.util.JsonConverter;

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

        if (FrameManager.getCurrentCompetition() != CompetitionType.COMPETITION)
            return;

        HttpResponse<String> response = HttpCommunicator.CompetitionApi.uploadCompetition(FrameManager.getCurrentCompetition());

        if (response.statusCode() != ResponseInterpreter.RESPONSE_CODE_CREATED) {
            FrameManager.setLastApiResponse(response);
            FrameManager.displayApiResponseModal();
            return;
        }

        CompetitionTransfer competitionTransfer = JsonConverter.jsonToCompetition(response.body());

        for (CompetitorTransferModel finishingCompetitor : this.panel.getTable().getFinishingCompetitors()) {
            HttpResponse<String> response2 = HttpCommunicator.LeaderboardApi.uploadResult(
                new Leaderboard(competitionTransfer.getId(), finishingCompetitor.id(), this.panel.getTable().getFinishingCompetitors().indexOf(finishingCompetitor)+1)
            );

            if (response2.statusCode() != ResponseInterpreter.RESPONSE_CODE_CREATED) {
                FrameManager.setLastApiResponse(response2);
                FrameManager.displayApiResponseModal();
                return;
            }
        }

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(this.panel.getCloseButton()) || e.getSource().equals(this.panel.getBottomCloseButton()))
            FrameManager.hideTableCompetitionPanel();
        else if (e.getSource().equals(this.panel.getFinishButton()))
            this.finishTable();
    }

}