package com._2p1team.cmadmin.app.control.components.modal;

import com._2p1team.cmadmin.app.control.AbstractController;
import com._2p1team.cmadmin.app.dto.competitor.Competitor;
import com._2p1team.cmadmin.app.dto.competitor.CompetitorUploadModel;
import com._2p1team.cmadmin.app.http.HttpCommunicator;
import com._2p1team.cmadmin.app.http.ResponseInterpreter;
import com._2p1team.cmadmin.app.view.components.competitor.CompetitorDisplay;
import com._2p1team.cmadmin.app.view.components.modals.UpdateCompetitorModal;
import com._2p1team.cmadmin.app.view.frame.FrameManager;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.net.http.HttpResponse;
import java.util.List;
import java.util.Optional;

public final class UpdateCompetitorModalController extends AbstractController {

    private final UpdateCompetitorModal updateCompetitorModal;

    public UpdateCompetitorModalController(final UpdateCompetitorModal component) {
        super(component);

        this.updateCompetitorModal = component;

        this.addListeners();
        new UpdateCompetitorModalKeyController(this.updateCompetitorModal, this);
    }

    public void addListenersToDisplays() {
        this.updateCompetitorModal.getCompetitorDisplays()
            .forEach(competitorDisplay -> competitorDisplay.getCheckbox().addActionListener(this));
    }

    private void addListeners() {
        this.updateCompetitorModal.getUpdateButton().addActionListener(this);
        this.updateCompetitorModal.getSearchButton().addActionListener(this);

        this.updateCompetitorModal.getIdInput().getInput().addKeyListener(this);
        this.updateCompetitorModal.getNameInput().getInput().addKeyListener(this);
        this.updateCompetitorModal.getClubInput().getInput().addKeyListener(this);
        this.updateCompetitorModal.getBirthDateInput().getInput().addKeyListener(this);

        this.updateCompetitorModal.getNameSearchInput().getInput().addKeyListener(this);
        this.updateCompetitorModal.getClubSearchInput().getInput().addKeyListener(this);
    }

    private void setInputDataToSelectedCompetitor(final CompetitorDisplay competitorDisplay) {
        String id = competitorDisplay.getIdLabel().getText().equals("0") ? "" : competitorDisplay.getIdLabel().getText();
        String name = competitorDisplay.getNameLabel().getText();
        String club = competitorDisplay.getClubLabel().getText();
        String birthDate = competitorDisplay.getBirthDateLabel().getText();

        this.updateCompetitorModal.getIdInput().setText(id);
        this.updateCompetitorModal.getNameInput().setText(name);
        this.updateCompetitorModal.getClubInput().setText(club);
        this.updateCompetitorModal.getBirthDateInput().setText(birthDate);

        this.updateCompetitorModal.getIdInput().getInput().setBackground(Color.black);
        this.updateCompetitorModal.getNameInput().getInput().setBackground(Color.black);
        this.updateCompetitorModal.getClubInput().getInput().setBackground(Color.black);
        this.updateCompetitorModal.getBirthDateInput().getInput().setBackground(Color.black);
    }

    private Optional<CompetitorDisplay> findSelectedDisplay(final ActionEvent actionEvent) {
        return Optional.ofNullable(this.updateCompetitorModal.getCompetitorDisplays()
            .stream()
            .filter(competitorDisplay -> actionEvent.getSource().equals(competitorDisplay.getCheckbox()))
            .toList()
            .getFirst());
    }

    void updateCompetitor() {
        if (this.updateCompetitorModal.checkInputData())
            return;

        long id = Long.parseLong(this.updateCompetitorModal.getIdInput().getText());
        String name = this.updateCompetitorModal.getNameInput().getText();
        String club = this.updateCompetitorModal.getClubInput().getText();
        String birthDate = this.updateCompetitorModal.getBirthDateInput().getText();

        HttpResponse<String> response = HttpCommunicator.CompetitorApi.updateCompetitor(id, new CompetitorUploadModel(name, club, birthDate));

        if (response.statusCode() != ResponseInterpreter.RESPONSE_CODE_OK) {
            FrameManager.setLastApiResponse(response);
            FrameManager.displayApiResponseModal();
            return;
        }

        this.updateCompetitorModal.getCompetitorDisplays().clear();
        this.updateCompetitorModal.getScrollPanel().getContents().clear();
        this.updateCompetitorModal.getScrollPanel().getViewPanel().removeAll();
        this.updateCompetitorModal.fillCompetitors();

        this.updateCompetitorModal.getIdInput().setText("");
        this.updateCompetitorModal.getNameInput().setText("");
        this.updateCompetitorModal.getClubInput().setText("");
        this.updateCompetitorModal.getBirthDateInput().setText("");
    }

    void searchCompetitor() {
        String name = this.updateCompetitorModal.getNameSearchInput().getText();
        String club = this.updateCompetitorModal.getClubSearchInput().getText();

        List<CompetitorDisplay> matchingCompetitors = this.updateCompetitorModal.getCompetitorDisplays()
            .stream()
            .filter(competitorDisplay -> competitorDisplay.getNameLabel().getText().contains(name))
            .filter(competitorDisplay -> !club.isBlank() ? competitorDisplay.getClubLabel().getText().contains(club) : !competitorDisplay.getClubLabel().getText().isBlank())
            .toList();

        this.updateCompetitorModal.getScrollPanel().getContents().clear();
        this.updateCompetitorModal.getScrollPanel().getViewPanel().removeAll();
        this.updateCompetitorModal.getScrollPanel().addComponent(this.updateCompetitorModal.getHeader());
        matchingCompetitors.forEach(this.updateCompetitorModal.getScrollPanel()::addComponent);
        this.updateCompetitorModal.getScrollPanel().resizeViewPanel(this.updateCompetitorModal.getHeader().getWidth());
        this.updateCompetitorModal.getScrollPanel().repaint();
    }

    @Override
    public void keyReleased(KeyEvent e) {
        if (e.getSource().equals(this.updateCompetitorModal.getIdInput().getInput()))
            this.updateCompetitorModal.getIdInput().getInput().setBackground(Color.black);

        else if (e.getSource().equals(this.updateCompetitorModal.getNameInput().getInput()))
            this.updateCompetitorModal.getNameInput().getInput().setBackground(Color.black);

        else if (e.getSource().equals(this.updateCompetitorModal.getClubInput().getInput()))
            this.updateCompetitorModal.getClubInput().getInput().setBackground(Color.black);

        else if (e.getSource().equals(this.updateCompetitorModal.getBirthDateInput().getInput()))
            this.updateCompetitorModal.getBirthDateInput().getInput().setBackground(Color.black);

        else if (
            e.getSource().equals(this.updateCompetitorModal.getNameSearchInput().getInput()) ||
                e.getSource().equals(this.updateCompetitorModal.getClubSearchInput().getInput())
        ) {
            if (e.getKeyCode() == KeyEvent.VK_BACK_SPACE || e.getKeyCode() == KeyEvent.VK_DELETE) {
                this.updateCompetitorModal.getScrollPanel().getContents().clear();
                this.updateCompetitorModal.getScrollPanel().getViewPanel().removeAll();
                this.updateCompetitorModal.fillCompetitors();
            }
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(this.updateCompetitorModal.getSearchButton()))
            this.searchCompetitor();

        else if (e.getSource().equals(this.updateCompetitorModal.getUpdateButton()))
            this.updateCompetitor();

        else {
            this.updateCompetitorModal.getCompetitorDisplays().forEach(competitorDisplay -> {
                if (!e.getSource().equals(competitorDisplay.getCheckbox()))
                    competitorDisplay.getCheckbox().setChecked(false);
            });

            Optional<CompetitorDisplay> optionalCompetitorDisplay = this.findSelectedDisplay(e);
            
            optionalCompetitorDisplay.ifPresent((competitorDisplay) ->
                this.setInputDataToSelectedCompetitor(!competitorDisplay.getCheckbox().isChecked() ?
                    competitorDisplay :
                    new CompetitorDisplay(new Competitor(0L, "", "", "")))
            );
        }
    }

}