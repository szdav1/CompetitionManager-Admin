package com._2p1team.cmadmin.app.view.components.modals;

import com._2p1team.cmadmin.app.control.components.modal.WindowClosingConfirmationModalController;
import static com._2p1team.cmadmin.support.constants.SizeData.*;
import com._2p1team.cmadmin.support.util.AppearanceRepository;
import com._2p1team.cmadmin.swing.override.components.button.Button;
import com._2p1team.cmadmin.swing.override.components.label.Label;
import com._2p1team.cmadmin.swing.override.components.panel.Panel;
import com._2p1team.cmadmin.swing.override.graphics.Appearance;

import javax.swing.JComponent;
import java.awt.Dimension;
import java.awt.Rectangle;
import java.util.List;

public final class WindowClosingConfirmationModal extends AbstractModal {

    private final Label confirmLabel;
    private final Panel innerPanel;
    private final Label exitLabel;
    private final Button confirmButton;
    private final Button cancelButton;

    public WindowClosingConfirmationModal() {
        this.confirmLabel = new Label(new Rectangle((this.getWidth()/2)-(W_LABEL_WIDTH/2), 0, W_LABEL_WIDTH, BUTTON_HEIGHT), "Are you sure you want to exit?", AppearanceRepository.EXIT_CONFIRM_LABEL_APPEARANCE);
        this.innerPanel = new Panel(new Dimension(this.getWidth(), this.getHeight()-BUTTON_HEIGHT), null, AppearanceRepository.MODAL_TITLE_BAR_APPEARANCE);
        this.exitLabel = new Label(AppearanceRepository.EXIT_LABEL_APPEARANCE);
        this.exitLabel.setLocation((this.getWidth()/2)-(this.exitLabel.getWidth()/2), (this.getHeight()/2)-(this.exitLabel.getHeight()/2)-(BUTTON_HEIGHT*2));
        this.confirmButton = new Button(BUTTON_SIZE, "Confirm [Enter]", new Appearance(AppearanceRepository.BASE_BUTTON_APPEARANCE));
        this.cancelButton = new Button(BUTTON_SIZE, "Cancel [Esc]", new Appearance(AppearanceRepository.BASE_BUTTON_APPEARANCE));

        new WindowClosingConfirmationModalController(this);
        this.setUpComponent();
    }

    @Override
    public void setUpComponent() {
        this.innerPanel.addComponent(this.exitLabel);
        this.getCenterPanel().addComponent(this.confirmLabel);
        this.getCenterPanel().addComponent(this.innerPanel);
        this.getBottomPanel().addComponent(this.confirmButton);
        this.getBottomPanel().addComponent(this.cancelButton);
    }

    @Override
    public List<JComponent> getControls() {
        return List.of(this.confirmButton, this.cancelButton);
    }

    @Override
    public List<JComponent> getKeyControls() {
        return List.of(this.confirmButton, this.cancelButton);
    }

}