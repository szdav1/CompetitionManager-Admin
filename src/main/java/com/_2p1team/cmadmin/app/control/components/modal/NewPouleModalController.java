package com._2p1team.cmadmin.app.control.components.modal;

import com._2p1team.cmadmin.app.control.AbstractController;
import com._2p1team.cmadmin.app.dto.competition.Competition;
import com._2p1team.cmadmin.app.http.HttpCommunicator;
import com._2p1team.cmadmin.app.view.components.checkbox.Checkbox;
import com._2p1team.cmadmin.app.view.components.competitor.CompetitorDisplay;
import com._2p1team.cmadmin.app.view.components.fencing.poule.Poule;
import com._2p1team.cmadmin.app.view.components.input.LabeledInput;
import com._2p1team.cmadmin.app.view.components.modals.NewPouleModal;
import com._2p1team.cmadmin.app.view.frame.FrameManager;
import com._2p1team.cmadmin.general.constants.CustomColors;
import static com._2p1team.cmadmin.general.constants.SizeData.*;
import com._2p1team.cmadmin.swing.override.components.button.Button;
import com._2p1team.cmadmin.swing.override.components.scrollpanel.ScrollPanel;
import lombok.Getter;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.util.Comparator;
import java.util.List;

@Getter
public final class NewPouleModalController extends AbstractController {

    private final NewPouleModal newPouleModal;
    private final Checkbox headerCheckbox;
    private final Checkbox participatingCheckbox;

    private final LabeledInput clubInput;
    private final LabeledInput nameInput;
    private final ScrollPanel scrollPanel;
    private final ScrollPanel participatingScrollPanel;

    private final Button searchButton;
    private final Button addButton;
    private final Button removeButton;
    private final Button createButton;

    private List<CompetitorDisplay> searchResults;

    public NewPouleModalController(final NewPouleModal component) {
        super(component);

        this.newPouleModal = component;
        this.headerCheckbox = this.newPouleModal.getMainHeader().getCheckbox();
        this.participatingCheckbox = this.newPouleModal.getParticipatingHeader().getCheckbox();

        this.nameInput = this.newPouleModal.getNameInput();
        this.clubInput = this.newPouleModal.getClubInput();
        this.scrollPanel = this.newPouleModal.getScrollPanel();
        this.participatingScrollPanel = this.newPouleModal.getParticipatingCompetitorsScrollPanel();

        this.searchButton = this.newPouleModal.getSearchButton();
        this.addButton = this.newPouleModal.getAddButton();
        this.removeButton = this.newPouleModal.getRemoveButton();
        this.createButton = this.newPouleModal.getCreateButton();

        this.searchResults = this.newPouleModal.getCompetitorDisplays();

        this.addListeners();
        new NewPouleModalKeyController(this.newPouleModal, this);
    }

    private void addListeners() {
        this.headerCheckbox.addActionListener(this);
        this.participatingCheckbox.addActionListener(this);

        this.searchButton.addActionListener(this);
        this.addButton.addActionListener(this);
        this.removeButton.addActionListener(this);
        this.createButton.addActionListener(this);

        this.clubInput.getInput().addKeyListener(this);
        this.nameInput.getInput().addKeyListener(this);

        this.newPouleModal.getCompetitionNameInput()
            .getInput()
            .addKeyListener(this);

        this.newPouleModal.getCompetitionLocationInput()
            .getInput()
            .addKeyListener(this);
    }

    private void displaySearchResults() {
        this.scrollPanel.getContents().clear();
        this.scrollPanel.getViewPanel().removeAll();
        this.scrollPanel.addComponent(this.newPouleModal.getMainHeader());
        this.searchResults.forEach(this.scrollPanel::addComponent);
        this.scrollPanel.resizeViewPanel(this.newPouleModal.getMainHeader().getWidth());
        this.scrollPanel.repaint();
    }

    public void searchForCompetitors() {
        String competitorName = this.nameInput.getText();
        String competitorClub = this.clubInput.getText();

        this.searchResults = this.newPouleModal.getCompetitorDisplays().stream()
            .filter(competitorDisplay -> competitorDisplay.getNameLabel().getText().contains(competitorName))
            .filter(competitorDisplay -> !competitorClub.isBlank() ? competitorDisplay.getClubLabel().getText().contains(competitorClub) : !competitorDisplay.getClubLabel().getText().isBlank())
            .toList();

        this.displaySearchResults();
    }

    private void resetCompetitorDisplay() {
        this.scrollPanel.getContents().clear();
        this.scrollPanel.getViewPanel().removeAll();
        this.scrollPanel.addComponent(this.newPouleModal.getMainHeader());

        this.newPouleModal.getCompetitorDisplays()
            .sort(Comparator.comparingInt(cd -> Integer.parseInt(cd.getIdLabel().getText())));

        this.newPouleModal.getCompetitorDisplays().forEach(competitorDisplay -> {
            competitorDisplay.getCheckbox().setChecked(false);
            this.scrollPanel.addComponent(competitorDisplay);
        });

        this.newPouleModal.getMainHeader()
            .getCheckbox()
            .setChecked(false);

        this.searchResults = this.newPouleModal.getCompetitorDisplays();
        this.scrollPanel.resizeViewPanel(this.newPouleModal.getMainHeader().getWidth());
        this.scrollPanel.repaint();
    }

    public void addCompetitorToParticipatingList() {
        List<CompetitorDisplay> selectedCompetitors = this.newPouleModal.getCompetitorDisplays().stream()
            .filter(competitorDisplay -> competitorDisplay.getCheckbox().isChecked())
            .toList();

        selectedCompetitors.forEach(selectedCompetitor -> {
            this.participatingScrollPanel.addComponent(selectedCompetitor);
            selectedCompetitor.getCheckbox().setChecked(false);
        });

        NewPouleModal.getParticipatingCompetitors().addAll(selectedCompetitors);
        this.newPouleModal.getCompetitorDisplays().removeAll(selectedCompetitors);
        this.participatingScrollPanel.resizeViewPanel(N_BUTTON_WIDTH+(BUTTON_WIDTH*4));

        this.clubInput.setText("");
        this.nameInput.setText("");
        this.resetCompetitorDisplay();
    }

    public void removeCompetitorFromParticipatingList() {
        this.searchResults = NewPouleModal.getParticipatingCompetitors().stream()
            .filter(competitorDisplay -> competitorDisplay.getCheckbox().isChecked())
            .toList();

        NewPouleModal.getParticipatingCompetitors().removeAll(searchResults);
        this.newPouleModal.getCompetitorDisplays().addAll(searchResults);

        this.participatingScrollPanel.getContents().clear();
        this.participatingScrollPanel.resizeViewPanel(this.participatingScrollPanel.getViewPanel().getWidth());
        this.participatingScrollPanel.repaint();
        this.participatingCheckbox.setChecked(false);
        this.resetCompetitorDisplay();
    }

    public void highlightAllCompetitors() {
        this.searchResults.forEach(competitorDisplay -> competitorDisplay.getCheckbox().toggleChecked());
    }

    public void highlightParticipatingCompetitors() {
        NewPouleModal.getParticipatingCompetitors().forEach(competitorDisplay -> competitorDisplay.getCheckbox().toggleChecked());
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String competitionName = this.newPouleModal.getCompetitionNameInput().getText();
        String competitionLocation = this.newPouleModal.getCompetitionLocationInput().getText();

        if (e.getSource().equals(this.headerCheckbox))
            this.highlightAllCompetitors();

        else if (e.getSource().equals(this.participatingCheckbox))
            this.highlightParticipatingCompetitors();

        else if (e.getSource().equals(this.searchButton))
            this.searchForCompetitors();

        else if (e.getSource().equals(this.addButton))
            this.addCompetitorToParticipatingList();

        else if (e.getSource().equals(this.removeButton))
            this.removeCompetitorFromParticipatingList();

        else if (e.getSource().equals(this.createButton)) {
            boolean error = false;

            if (competitionName.isBlank()) {
                this.newPouleModal.getCompetitionNameInput()
                    .getInput()
                    .setBackground(CustomColors.MAIN_COLOR_2);
                
                error = true;
            }

            if (competitionLocation.isBlank()) {
                this.newPouleModal.getCompetitionLocationInput()
                    .getInput()
                    .setBackground(CustomColors.MAIN_COLOR_2);

                error = true;
            }

            if (NewPouleModal.getParticipatingCompetitors().size() < Poule.MIN_SIZE)
                error = true;

            if (error)
                return;

            FrameManager.setCurrentCompetition(new Competition(competitionName, competitionLocation));

            this.newPouleModal.getCompetitorDisplays().clear();
            this.scrollPanel.getViewPanel().removeAll();
            this.scrollPanel.getContents().clear();
            this.scrollPanel.resizeViewPanel(N_BUTTON_WIDTH+(BUTTON_WIDTH*4));

            HttpCommunicator.CompetitorApi.getAllCompetitors()
                .forEach(competitor -> this.newPouleModal.getCompetitorDisplays().add(new CompetitorDisplay(BUTTON_SIZE, BUTTON_SIZE, competitor)));

            this.scrollPanel.addComponent(this.newPouleModal.getMainHeader());
            this.newPouleModal.getCompetitorDisplays().forEach(this.scrollPanel::addComponent);
            this.scrollPanel.resizeViewPanel(N_BUTTON_WIDTH+(BUTTON_WIDTH*4));

            this.participatingScrollPanel.getViewPanel().removeAll();
            this.participatingScrollPanel.getContents().clear();
            this.participatingScrollPanel.addComponent(this.newPouleModal.getParticipatingHeader());
            this.participatingScrollPanel.resizeViewPanel(N_BUTTON_WIDTH+(BUTTON_WIDTH*4));

            this.newPouleModal.getCompetitionNameInput().setText("");
            this.newPouleModal.getCompetitionLocationInput().setText("");

            FrameManager.hideOpenedModal();
            FrameManager.displayPouleCompetitionPanel();
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        if (
            e.getKeyCode() != KeyEvent.VK_ENTER &&
                (e.getSource().equals(this.clubInput.getInput()) || e.getSource().equals(this.nameInput.getInput())) &&
                (this.clubInput.getText().isBlank() || this.nameInput.getText().isBlank())
        )
            this.resetCompetitorDisplay();

        if (e.getSource().equals(this.newPouleModal.getCompetitionNameInput().getInput()))
            this.newPouleModal.getCompetitionNameInput()
                .getInput()
                .setBackground(Color.black);

        else if (e.getSource().equals(this.newPouleModal.getCompetitionLocationInput().getInput()))
            this.newPouleModal.getCompetitionLocationInput()
                .getInput()
                .setBackground(Color.black);
    }

}