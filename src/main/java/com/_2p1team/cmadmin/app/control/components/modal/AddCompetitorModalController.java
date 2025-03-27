package com._2p1team.cmadmin.app.control.components.modal;

import com._2p1team.cmadmin.app.control.AbstractController;
import com._2p1team.cmadmin.app.dto.competitor.CompetitorUploadModel;
import com._2p1team.cmadmin.app.http.HttpCommunicator;
import com._2p1team.cmadmin.app.http.ResponseInterpreter;
import com._2p1team.cmadmin.app.view.components.modals.AddCompetitorModal;
import com._2p1team.cmadmin.app.view.frame.FrameManager;
import com._2p1team.cmadmin.general.constants.CustomColors;
import com._2p1team.cmadmin.general.constants.DatabaseLimitations;
import com._2p1team.cmadmin.general.constants.Language;
import com._2p1team.cmadmin.swing.override.components.button.Button;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.net.http.HttpResponse;

public final class AddCompetitorModalController extends AbstractController {

    private final AddCompetitorModal addCompetitorModal;
    private final Button addCompetitorButton;

    public AddCompetitorModalController(final AddCompetitorModal component) {
        super(component);

        this.addCompetitorModal = component;
        this.addCompetitorButton = this.addCompetitorModal.getAddButton();

        this.addListeners();
        new AddCompetitorModalKeyController(this.addCompetitorModal, this);
    }

    private void addListeners() {
        this.addCompetitorButton.addActionListener(this);
        this.addCompetitorModal.getNameInput().getInput().addKeyListener(this);
        this.addCompetitorModal.getClubInput().getInput().addKeyListener(this);
        this.addCompetitorModal.getBirthDateInput().getInput().addKeyListener(this);
    }

    private void resetCompetitorDisplays() {
        this.addCompetitorModal.getCompetitorDisplays().clear();
        this.addCompetitorModal.getScrollPanel().getViewPanel().removeAll();
        this.addCompetitorModal.getScrollPanel().getContents().clear();
        this.addCompetitorModal.getScrollPanel().resizeViewPanel(0);
        this.addCompetitorModal.fillCompetitors();
    }

    void addCompetitor() {
        if (this.addCompetitorModal.checkInputData())
            return;

        String name = this.addCompetitorModal.getNameInput().getText();
        String club = this.addCompetitorModal.getClubInput().getText();
        String birthDate = this.addCompetitorModal.getBirthDateInput().getText();
        CompetitorUploadModel competitor = new CompetitorUploadModel(name, club, birthDate);

        if (HttpCommunicator.CompetitorApi.getAllCompetitors().size() >= DatabaseLimitations.MAX_SIZE) {
            FrameManager.displayApiResponseModal(Language.get("DatabaseSizeExceeded"));
            return;
        }

        HttpResponse<String> response = HttpCommunicator.CompetitorApi.uploadCompetitor(competitor);

        if (response.statusCode() != ResponseInterpreter.RESPONSE_CODE_CREATED) {
            FrameManager.setLastApiResponse(response);
            FrameManager.displayApiResponseModal();
            return;
        }

        this.resetCompetitorDisplays();
        this.addCompetitorModal.getNameInput().setText("");
        this.addCompetitorModal.getClubInput().setText("");
        this.addCompetitorModal.getBirthDateInput().setText("");
        this.addCompetitorModal.getCompetitorDisplays()
            .getLast()
            .setForegrounds(CustomColors.MAIN_COLOR_2);
    }

    @Override
    public void keyTyped(KeyEvent e) {
        if (e.getSource().equals(this.addCompetitorModal.getNameInput().getInput()))
            this.addCompetitorModal.getNameInput().getInput().setBackground(Color.black);

        else if (e.getSource().equals(this.addCompetitorModal.getClubInput().getInput()))
            this.addCompetitorModal.getClubInput().getInput().setBackground(Color.black);

        else if (e.getSource().equals(this.addCompetitorModal.getBirthDateInput().getInput()))
            this.addCompetitorModal.getBirthDateInput().getInput().setBackground(Color.black);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(this.addCompetitorButton))
            this.addCompetitor();
    }

}