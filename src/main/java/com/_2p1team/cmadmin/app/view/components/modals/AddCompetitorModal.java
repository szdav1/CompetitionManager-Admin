package com._2p1team.cmadmin.app.view.components.modals;

import com._2p1team.cmadmin.app.control.components.modal.addcompetitor.AddCompetitorModalController;
import com._2p1team.cmadmin.app.http.HttpCommunicator;
import com._2p1team.cmadmin.app.view.components.competitor.CompetitorDisplay;
import com._2p1team.cmadmin.app.view.components.input.LabeledInput;
import static com._2p1team.cmadmin.general.constants.AppearanceConstants.PADDING;
import com._2p1team.cmadmin.general.constants.CustomColors;
import com._2p1team.cmadmin.general.constants.Language;
import static com._2p1team.cmadmin.general.constants.SizeData.*;
import com._2p1team.cmadmin.general.util.AppearanceRepository;
import com._2p1team.cmadmin.swing.override.components.button.Button;
import com._2p1team.cmadmin.swing.override.components.label.Label;
import com._2p1team.cmadmin.swing.override.components.panel.Panel;
import com._2p1team.cmadmin.swing.override.components.scrollpanel.ScrollPanel;
import com._2p1team.cmadmin.swing.override.graphics.Appearance;
import lombok.Getter;

import javax.swing.JComponent;
import javax.swing.SwingConstants;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@Getter
public final class AddCompetitorModal extends AbstractModal {

    private final Panel leftPanel;
    private final Panel rightPanel;
    private final ScrollPanel scrollPanel;
    private final CompetitorDisplay.Header mainHeader;
    private final List<CompetitorDisplay> competitorDisplays;

    private final Label dashboardLabel;
    private final LabeledInput nameInput;
    private final LabeledInput clubInput;
    private final LabeledInput birthDateInput;

    private final Button addButton;

    public AddCompetitorModal() {
        super();
        this.setTitle(Language.get("AddCompetitorTitle"));
        this.getCenterPanel().setLayout(new GridLayout(1, 2, PADDING, PADDING));

        this.leftPanel = new Panel(new Dimension(this.getCenterPanel().getWidth()/2-PADDING, this.getCenterPanel().getHeight()), new FlowLayout(FlowLayout.CENTER, 0, 0), new Appearance(AppearanceRepository.POULE_PANEL_APPEARANCE));
        this.rightPanel = new Panel(new Dimension(this.getCenterPanel().getWidth()/2-PADDING, this.getCenterPanel().getHeight()), new FlowLayout(FlowLayout.CENTER, PADDING, PADDING), new Appearance(AppearanceRepository.POULE_PANEL_APPEARANCE));
        this.scrollPanel = new ScrollPanel(new Dimension(this.leftPanel.getWidth(), this.leftPanel.getHeight()-(BUTTON_HEIGHT*2)), new FlowLayout(FlowLayout.CENTER, 0, 0), new Appearance(AppearanceRepository.BASE_SCROLL_PANEL_APPEARANCE));
        this.scrollPanel.setScrollSpeed(BUTTON_HEIGHT);

        this.mainHeader = new CompetitorDisplay.Header(BUTTON_SIZE, BUTTON_SIZE);
        this.mainHeader.removeComponent(mainHeader.getCheckbox());

        this.competitorDisplays = new ArrayList<>();

        this.dashboardLabel = new Label(new Dimension(this.rightPanel.getWidth(), BUTTON_HEIGHT), Language.get("Dashboard"), AppearanceRepository.LABELED_INPUT_APPEARANCE);
        this.dashboardLabel.setHorizontalAlignment(SwingConstants.LEFT);

        this.nameInput = new LabeledInput(X_BUTTON_WIDTH, Language.get("Name"));
        this.clubInput = new LabeledInput(X_BUTTON_WIDTH, Language.get("Club"));
        this.birthDateInput = new LabeledInput(X_BUTTON_WIDTH, Language.get("BirthDate"));

        this.addButton = new Button(BUTTON_SIZE, Language.get("Add"), new Appearance(AppearanceRepository.BASE_BUTTON_APPEARANCE));

        this.setUpComponent();
        new AddCompetitorModalController(this);
    }

    public void fillCompetitors() {
        HttpCommunicator.CompetitorApi.getAllCompetitors().forEach(competitor ->
            this.competitorDisplays.add(new CompetitorDisplay(BUTTON_SIZE, BUTTON_SIZE, competitor)));

        this.competitorDisplays.forEach(competitorDisplay -> competitorDisplay.removeComponent(competitorDisplay.getCheckbox()));

        this.scrollPanel.addComponent(this.mainHeader);
        this.competitorDisplays.forEach(this.scrollPanel::addComponent);
        this.scrollPanel.resizeViewPanel(this.mainHeader.getWidth());
    }

    public boolean checkInputData() {
        if (this.nameInput.getText().isBlank())
            this.nameInput.getInput().setBackground(CustomColors.MAIN_COLOR_2);

        if (this.clubInput.getText().isBlank())
            this.clubInput.getInput().setBackground(CustomColors.MAIN_COLOR_2);

        if (this.birthDateInput.getText().isBlank())
            this.birthDateInput.getInput().setBackground(CustomColors.MAIN_COLOR_2);

        try {
            LocalDate.parse(this.birthDateInput.getText(), DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        }
        catch (Exception exception) {
            this.birthDateInput.getInput().setBackground(CustomColors.MAIN_COLOR_2);
            return true;
        }

        return this.nameInput.getInput().getText().isBlank() &&
            this.clubInput.getInput().getText().isBlank() &&
            this.birthDateInput.getInput().getText().isBlank();
    }

    @Override
    public void appear() {
        super.appear();
        this.fillCompetitors();
    }

    @Override
    public void disappear() {
        super.disappear();

        this.competitorDisplays.clear();
        this.scrollPanel.getViewPanel().removeAll();
        this.nameInput.getInput().setBackground(Color.black);
        this.clubInput.getInput().setBackground(Color.black);
        this.birthDateInput.getInput().setBackground(Color.black);
    }

    @Override
    public void setUpComponent() {
        this.leftPanel.addComponent(this.scrollPanel);

        this.rightPanel.addComponent(this.dashboardLabel);
        this.rightPanel.addComponent(this.nameInput);
        this.rightPanel.addComponent(this.clubInput);
        this.rightPanel.addComponent(this.birthDateInput);

        this.getCenterPanel().addComponent(this.leftPanel);
        this.getCenterPanel().addComponent(this.rightPanel);

        this.getBottomPanel().addComponent(this.addButton);
    }

    @Override
    public List<JComponent> getControls() {
        return List.of();
    }

    @Override
    public List<JComponent> getKeyControls() {
        return List.of();
    }

}