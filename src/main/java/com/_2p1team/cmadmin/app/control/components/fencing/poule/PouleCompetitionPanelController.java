package com._2p1team.cmadmin.app.control.components.fencing.poule;

import com._2p1team.cmadmin.app.control.AbstractController;
import com._2p1team.cmadmin.app.dto.competition.CompetitionTransfer;
import com._2p1team.cmadmin.app.dto.competitor.CompetitorTransferModel;
import com._2p1team.cmadmin.app.dto.leaderboard.Leaderboard;
import com._2p1team.cmadmin.app.http.HttpCommunicator;
import com._2p1team.cmadmin.app.http.ResponseInterpreter;
import com._2p1team.cmadmin.app.view.components.fencing.poule.PouleCompetitionPanel;
import com._2p1team.cmadmin.app.view.frame.FrameManager;
import com._2p1team.cmadmin.general.util.JsonConverter;
import com._2p1team.cmadmin.swing.override.components.button.Button;

import java.awt.event.ActionEvent;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;

public final class PouleCompetitionPanelController extends AbstractController {

    private final PouleCompetitionPanel panel;
    private final Button closeButton;
    private final Button finishButton;
    private final Button resultsButton;
    private final Button bottomCloseButton;
    private final Button continueButton;

    public PouleCompetitionPanelController(final PouleCompetitionPanel component) {
        super(component);

        this.panel = component;
        this.closeButton = this.panel.getCloseButton();
        this.finishButton = this.panel.getFinishButton();
        this.resultsButton = this.panel.getResultsButton();
        this.bottomCloseButton = this.panel.getBottomCloseButton();
        this.continueButton = this.panel.getContinueButton();

        this.addListeners();
        new PouleCompetitionPanelKeyController(this.panel);
    }

    private void addListeners() {
        this.closeButton.addActionListener(this);
        this.finishButton.addActionListener(this);
        this.resultsButton.addActionListener(this);
        this.bottomCloseButton.addActionListener(this);
        this.continueButton.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(this.closeButton) || e.getSource().equals(this.bottomCloseButton)) {
            FrameManager.hidePouleCompetitionPanel();

            if (!this.panel.checkIfFinished())
                return;

            HttpResponse<String> response = HttpCommunicator.CompetitionApi.uploadCompetition(FrameManager.getCurrentCompetition());

            if (response.statusCode() != ResponseInterpreter.RESPONSE_CODE_CREATED) {
                FrameManager.setLastApiResponse(response);
                FrameManager.displayApiResponseModal();
                return;
            }

            CompetitionTransfer competitionTransfer = JsonConverter.jsonToCompetition(response.body());

            List<CompetitorTransferModel> finishingCompetitors = new ArrayList<>();

            PouleCompetitionPanel.getCompetitorTransferModels().forEach(competitor -> {
                Long id = competitor.id();
                String name = competitor.name();
                String club = competitor.club();
                String birthDate = competitor.birthDate();
                int index = competitor.index();
                int placement = competitor.placement();

                finishingCompetitors.add(new CompetitorTransferModel(id, name, club, birthDate, index, placement));
            });

            for (CompetitorTransferModel finishingCompetitor : finishingCompetitors) {
                HttpResponse<String> response2 = HttpCommunicator.LeaderboardApi.uploadResult(
                    new Leaderboard(competitionTransfer.getId(), finishingCompetitor.id(), finishingCompetitor.placement())
                );

                if (response2.statusCode() != ResponseInterpreter.RESPONSE_CODE_CREATED) {
                    FrameManager.setLastApiResponse(response2);
                    FrameManager.displayApiResponseModal();
                    return;
                }
            }
        }

        else if (e.getSource().equals(this.finishButton))
            this.panel.finishPoules();

        else if (e.getSource().equals(this.resultsButton))
            this.panel.showResults();

        else if (e.getSource().equals(this.continueButton)) {
            FrameManager.hidePouleCompetitionPanel();
            FrameManager.displayTableCompetitionPanel();
        }
    }

}