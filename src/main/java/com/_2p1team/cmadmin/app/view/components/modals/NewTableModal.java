package com._2p1team.cmadmin.app.view.components.modals;

import com._2p1team.cmadmin.app.control.components.modal.NewTableModalController;
import com._2p1team.cmadmin.app.view.components.fencing.Box;
import com._2p1team.cmadmin.app.view.components.input.LabeledInput;
import static com._2p1team.cmadmin.general.constants.AppearanceConstants.PADDING;
import com._2p1team.cmadmin.general.constants.CustomColors;
import com._2p1team.cmadmin.general.constants.Language;
import static com._2p1team.cmadmin.general.constants.SizeData.*;
import com._2p1team.cmadmin.general.util.AppearanceRepository;
import com._2p1team.cmadmin.swing.override.components.button.Button;
import com._2p1team.cmadmin.swing.override.components.label.Label;
import com._2p1team.cmadmin.swing.override.components.panel.Panel;
import com._2p1team.cmadmin.swing.override.graphics.Appearance;
import lombok.Getter;

import javax.swing.JComponent;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Rectangle;
import java.util.List;

@Getter
public final class NewTableModal extends AbstractModal {

    @Getter
    private static int desiredSize = 0;

    private final Label textLabel;
    private final Box numberInput;
    private final LabeledInput competitionNameInput;
    private final LabeledInput competitionLocationInput;
    private final Panel innerPanel;
    private final Label decorationLabel;
    private final Button createButton;

    public NewTableModal() {
        super();
        this.setTitle(Language.get("NewTableTitle"));
        this.getCenterPanel().setLayout(new FlowLayout(FlowLayout.CENTER, PADDING, PADDING));

        this.textLabel = new Label(X_BUTTON_SIZE, Language.get("NumberOfCompetitors"), AppearanceRepository.LABELED_INPUT_APPEARANCE);
        this.numberInput = new Box(new Rectangle(0, 0, N_BUTTON_WIDTH, BUTTON_HEIGHT), "", CustomColors.MAIN_COLOR_1);
        this.competitionNameInput = new LabeledInput(BUTTON_WIDTH/2, Language.get("CompetitionName"));
        this.competitionLocationInput = new LabeledInput(BUTTON_WIDTH/2, Language.get("CompetitionLocation"));
        this.innerPanel = new Panel(new Dimension(this.getWidth()-(PADDING*2), this.getHeight()-(BUTTON_HEIGHT*4)), null, AppearanceRepository.LABELED_INPUT_APPEARANCE);

        this.decorationLabel = new Label(AppearanceRepository.NEW_TABLE_MODAL_DECORATION_APPEARANCE);
        this.decorationLabel.setLocation(0, this.innerPanel.getHeight()-this.decorationLabel.getHeight());

        this.createButton = new Button(BUTTON_SIZE, Language.get("Create"), new Appearance(AppearanceRepository.BASE_BUTTON_APPEARANCE));

        this.setUpComponent();

        new NewTableModalController(this);
    }

    public boolean validateInputData() {
        try {
            int numberOfCompetitors = Integer.parseInt(this.numberInput.getText());

            if (numberOfCompetitors < 4 || numberOfCompetitors > 128) {
                this.numberInput.setBackground(CustomColors.MAIN_COLOR_2);
                return false;
            }

            desiredSize = numberOfCompetitors;
            return true;
        }
        catch (Exception exception) {
            this.numberInput.setBackground(CustomColors.MAIN_COLOR_2);

            return false;
        }
    }

    @Override
    public void disappear() {
        super.disappear();
        this.numberInput.setBackground(Color.black);
        this.competitionNameInput.getInput().setBackground(Color.black);
        this.competitionLocationInput.getInput().setBackground(Color.black);
    }

    @Override
    public void setUpComponent() {
        this.innerPanel.addComponent(this.decorationLabel);

        this.getCenterPanel().addComponent(this.textLabel);
        this.getCenterPanel().addComponent(this.numberInput);
        this.getCenterPanel().addComponent(this.competitionNameInput);
        this.getCenterPanel().addComponent(this.competitionLocationInput);
        this.getCenterPanel().addComponent(this.innerPanel);
        this.getBottomPanel().addComponent(this.createButton);
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