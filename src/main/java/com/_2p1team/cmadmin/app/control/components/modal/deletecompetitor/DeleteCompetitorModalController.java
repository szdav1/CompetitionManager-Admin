package com._2p1team.cmadmin.app.control.components.modal.deletecompetitor;

import com._2p1team.cmadmin.app.control.AbstractController;
import com._2p1team.cmadmin.app.http.HttpCommunicator;
import com._2p1team.cmadmin.app.http.ResponseInterpreter;
import com._2p1team.cmadmin.app.view.components.competitor.CompetitorDisplay;
import com._2p1team.cmadmin.app.view.components.modals.DeleteCompetitorModal;
import com._2p1team.cmadmin.app.view.frame.FrameManager;
import lombok.Getter;

import javax.swing.JComponent;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.net.http.HttpResponse;
import java.util.List;

@Getter
public final class DeleteCompetitorModalController extends AbstractController {

    private final DeleteCompetitorModal deleteCompetitorModal;

    public DeleteCompetitorModalController(final DeleteCompetitorModal component) {
        super(component);

        this.deleteCompetitorModal = component;

        this.addListeners();
        new DeleteCompetitorModalKeyController(this.deleteCompetitorModal, this);
    }

    public void addListenersToDisplays() {
        this.deleteCompetitorModal.getCompetitorDisplays()
            .forEach(competitorDisplay -> competitorDisplay.getCheckbox().addActionListener(this));
    }

    private void addListeners() {
        this.deleteCompetitorModal.getDeleteButton().addActionListener(this);
        this.deleteCompetitorModal.getSearchButton().addActionListener(this);
        this.deleteCompetitorModal.getHeader().getCheckbox().addActionListener(this);

        this.deleteCompetitorModal.getNameSearchInput().getInput().addKeyListener(this);
        this.deleteCompetitorModal.getClubSearchInput().getInput().addKeyListener(this);
    }

    void deleteCompetitors() {
        List<JComponent> selectedCompetitorDisplays = this.deleteCompetitorModal.getSelectedCompetitors();

        for (JComponent component : selectedCompetitorDisplays) {
            if (component instanceof CompetitorDisplay competitorDisplay) {
                long id = Long.parseLong(competitorDisplay.getIdLabel().getText());
                HttpResponse<String> response = HttpCommunicator.CompetitorApi.deleteCompetitor(id);

                if (response.statusCode() != ResponseInterpreter.RESPONSE_CODE_NO_CONTENT) {
                    FrameManager.setLastApiResponse(response);
                    FrameManager.displayApiResponseModal();
                    return;
                }
            }
        }

        this.deleteCompetitorModal.getHeader().getCheckbox().setChecked(false);
        this.deleteCompetitorModal.getCompetitorDisplays().clear();
        this.deleteCompetitorModal.getScrollPanel().getContents().clear();
        this.deleteCompetitorModal.getScrollPanel().getViewPanel().removeAll();
        this.deleteCompetitorModal.fillCompetitors();
    }

    void searchCompetitor() {
        String name = this.deleteCompetitorModal.getNameSearchInput().getText();
        String club = this.deleteCompetitorModal.getClubSearchInput().getText();

        List<CompetitorDisplay> matchingCompetitors = this.deleteCompetitorModal.getCompetitorDisplays()
            .stream()
            .filter(competitorDisplay -> competitorDisplay.getNameLabel().getText().contains(name))
            .filter(competitorDisplay -> !club.isBlank() ? competitorDisplay.getClubLabel().getText().contains(club) : !competitorDisplay.getClubLabel().getText().isBlank())
            .toList();

        this.deleteCompetitorModal.getScrollPanel().getContents().clear();
        this.deleteCompetitorModal.getScrollPanel().getViewPanel().removeAll();
        this.deleteCompetitorModal.getScrollPanel().addComponent(this.deleteCompetitorModal.getHeader());
        matchingCompetitors.forEach(this.deleteCompetitorModal.getScrollPanel()::addComponent);
        this.deleteCompetitorModal.getScrollPanel().resizeViewPanel(this.deleteCompetitorModal.getHeader().getWidth());
        this.deleteCompetitorModal.getScrollPanel().repaint();
    }

    void selectAllCompetitors() {
        this.deleteCompetitorModal.getCompetitorDisplays()
            .forEach(competitorDisplay -> competitorDisplay.getCheckbox().toggleChecked());
    }

    @Override
    public void keyReleased(KeyEvent e) {
        if (
            e.getSource().equals(this.deleteCompetitorModal.getNameSearchInput().getInput()) ||
                e.getSource().equals(this.deleteCompetitorModal.getClubSearchInput().getInput())
        ) {
            if (e.getKeyCode() == KeyEvent.VK_BACK_SPACE || e.getKeyCode() == KeyEvent.VK_DELETE) {
                this.deleteCompetitorModal.getScrollPanel().getContents().clear();
                this.deleteCompetitorModal.getScrollPanel().getViewPanel().removeAll();
                this.deleteCompetitorModal.fillCompetitors();
            }
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(this.deleteCompetitorModal.getSearchButton()))
            this.searchCompetitor();

        else if (e.getSource().equals(this.deleteCompetitorModal.getHeader().getCheckbox()))
            this.selectAllCompetitors();

        else if (e.getSource().equals(this.deleteCompetitorModal.getDeleteButton()))
            this.deleteCompetitors();
    }

}