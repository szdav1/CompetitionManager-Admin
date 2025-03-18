package com._2p1team.cmadmin.app.control.components.modal;

import com._2p1team.cmadmin.app.control.AbstractController;
import com._2p1team.cmadmin.app.http.HttpCommunicator;
import com._2p1team.cmadmin.app.http.ResponseInterpreter;
import com._2p1team.cmadmin.app.view.components.competitor.CompetitorDisplay;
import com._2p1team.cmadmin.app.view.components.modals.RemoveCompetitorModal;
import com._2p1team.cmadmin.app.view.frame.FrameManager;
import lombok.Getter;

import java.awt.event.ActionEvent;
import java.net.http.HttpResponse;
import java.util.List;

@Getter
public final class RemoveCompetitorModalController extends AbstractController {

    private final RemoveCompetitorModal removeCompetitorModal;

    public RemoveCompetitorModalController(final RemoveCompetitorModal component) {
        super(component);

        this.removeCompetitorModal = component;

        this.addListeners();
        new RemoveCompetitorModalKeyController(this.removeCompetitorModal, this);
    }

    private void addListeners() {
        this.removeCompetitorModal.getDeleteButton().addActionListener(this);
        this.removeCompetitorModal.getHeader().getCheckbox().addActionListener(this);
    }

    void deleteSelectedCompetitors() {
        List<CompetitorDisplay> selectedCompetitors = this.removeCompetitorModal.getSelectedCompetitors();

        if (selectedCompetitors.isEmpty())
            return;

        for (CompetitorDisplay selectedCompetitor : selectedCompetitors) {
            long id = Long.parseLong(selectedCompetitor.getIdLabel().getText());

            HttpResponse<String> response = HttpCommunicator.CompetitorApi.deleteCompetitor(id);

            if (response.statusCode() == ResponseInterpreter.RESPONSE_CODE_OK) {
                FrameManager.setLastApiResponse(response);
                FrameManager.displayApiResponseModal();
                return;
            }
        }

        this.removeCompetitorModal.getCompetitorDisplays().clear();
        this.removeCompetitorModal.getScrollPanel().getContents().clear();
        this.removeCompetitorModal.getScrollPanel().getViewPanel().removeAll();
        this.removeCompetitorModal.fillCompetitors();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(this.removeCompetitorModal.getHeader().getCheckbox()))
            this.removeCompetitorModal.getCompetitorDisplays().forEach(competitorDisplay -> competitorDisplay.getCheckbox().toggleChecked());

        else if (e.getSource().equals(this.removeCompetitorModal.getDeleteButton()))
            this.deleteSelectedCompetitors();
    }

}