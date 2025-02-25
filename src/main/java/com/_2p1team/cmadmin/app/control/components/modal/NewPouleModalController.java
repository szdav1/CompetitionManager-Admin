package com._2p1team.cmadmin.app.control.components.modal;

import com._2p1team.cmadmin.app.control.AbstractController;
import com._2p1team.cmadmin.app.http.HttpCommunicator;
import com._2p1team.cmadmin.app.view.components.checkbox.Checkbox;
import com._2p1team.cmadmin.app.view.components.competitor.CompetitorDisplay;
import com._2p1team.cmadmin.app.view.components.fencing.poule.Poule;
import com._2p1team.cmadmin.app.view.components.input.LabeledInput;
import com._2p1team.cmadmin.app.view.components.modals.NewPouleModal;
import com._2p1team.cmadmin.app.view.frame.FrameManager;
import static com._2p1team.cmadmin.support.constants.SizeData.*;
import com._2p1team.cmadmin.swing.override.components.button.Button;
import com._2p1team.cmadmin.swing.override.components.scrollpanel.ScrollPanel;
import lombok.Getter;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.util.Comparator;
import java.util.List;

@Getter
public final class NewPouleModalController extends AbstractController {

    private final NewPouleModal newPouleModal;
    private final Checkbox headerCheckbox;
    private final Checkbox participatingCheckbox;

    private final LabeledInput idInput;
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

        this.idInput = this.newPouleModal.getIdInput();
        this.nameInput = this.newPouleModal.getNameInput();
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

        this.idInput.getInput().addKeyListener(this);
        this.nameInput.getInput().addKeyListener(this);
    }

    private void displaySearchResults() {
        this.scrollPanel.getViewPanel().removeAll();
        this.scrollPanel.addComponent(this.newPouleModal.getMainHeader());
        this.searchResults.forEach(this.scrollPanel::addComponent);
        this.scrollPanel.repaint();
    }

    public void searchForCompetitors() {
        String competitorId = this.idInput.getText();
        String competitorName = this.nameInput.getText();

        this.searchResults = this.newPouleModal.getCompetitorDisplays().stream()
            .filter(competitorDisplay -> competitorDisplay.getNameLabel().getText().contains(competitorName))
            .filter(competitorDisplay -> !competitorId.isBlank() ? competitorDisplay.getIdLabel().getText().equalsIgnoreCase(competitorId) : !competitorDisplay.getIdLabel().getText().isBlank())
            .toList();

        this.displaySearchResults();
    }

    private void resetCompetitorDisplay() {
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

        this.idInput.setText("");
        this.nameInput.setText("");
        this.resetCompetitorDisplay();
    }

    public void removeCompetitorFromParticipatingList() {
        this.searchResults = NewPouleModal.getParticipatingCompetitors().stream()
            .filter(competitorDisplay -> competitorDisplay.getCheckbox().isChecked())
            .toList();

        NewPouleModal.getParticipatingCompetitors().removeAll(searchResults);
        this.newPouleModal.getCompetitorDisplays().addAll(searchResults);

        this.newPouleModal.getParticipatingCompetitorsScrollPanel().repaint();
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

        else if (e.getSource().equals(this.createButton) && NewPouleModal.getParticipatingCompetitors().size() >= Poule.MIN_SIZE) {
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

            FrameManager.hideOpenedModal();
            FrameManager.displayPouleCompetitionPanel();
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        if (
            e.getKeyCode() != KeyEvent.VK_ENTER &&
                (e.getSource().equals(this.idInput.getInput()) || e.getSource().equals(this.nameInput.getInput())) &&
                (this.idInput.getText().isBlank() || this.nameInput.getText().isBlank())
        )
            this.resetCompetitorDisplay();
    }

}