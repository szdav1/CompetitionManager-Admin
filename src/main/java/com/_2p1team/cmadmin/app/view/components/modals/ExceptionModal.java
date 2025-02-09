package com._2p1team.cmadmin.app.view.components.modals;

import com._2p1team.cmadmin.app.control.components.modal.ExceptionModalController;
import static com._2p1team.cmadmin.support.constants.SizeData.*;
import com._2p1team.cmadmin.support.util.AppearanceRepository;
import com._2p1team.cmadmin.swing.override.components.button.Button;
import com._2p1team.cmadmin.swing.override.components.label.Label;
import com._2p1team.cmadmin.swing.override.components.panel.Panel;
import com._2p1team.cmadmin.swing.override.graphics.Appearance;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.swing.JComponent;
import java.awt.Dimension;
import java.util.List;

@Data
@EqualsAndHashCode(callSuper=true)
public final class ExceptionModal extends AbstractModal {

    private Exception exception;
    private final Panel innerPanel;
    private final Label iconLabel;
    private final Label exceptionMessageLabel;
    private final Button exitButton;

    public ExceptionModal() {
        this.innerPanel = new Panel(new Dimension(this.getWidth(), this.getHeight()-BUTTON_HEIGHT), null, AppearanceRepository.MODAL_CENTER_PANEL_APPEARANCE);
        this.iconLabel = new Label(AppearanceRepository.HTTP_EXCEPTION_LABEL_APPEARANCE);
        this.iconLabel.setLocation((this.getWidth()/2)-(this.iconLabel.getWidth()/2), (this.innerPanel.getHeight()/2)-(this.iconLabel.getHeight()/2)-BUTTON_HEIGHT);
        this.exceptionMessageLabel = new Label(XL_BUTTON_SIZE, "Connection with server couldn't be established", AppearanceRepository.EXIT_CONFIRM_LABEL_APPEARANCE);
        this.exitButton = new Button(W_BUTTON_SIZE, "Exit [Enter]", new Appearance(AppearanceRepository.BASE_BUTTON_APPEARANCE));

        new ExceptionModalController(this);
        this.setUpComponent();
    }

    @Override
    public void setUpComponent() {
        this.innerPanel.addComponent(this.iconLabel);

        this.getCenterPanel().addComponent(this.exceptionMessageLabel);
        this.getCenterPanel().addComponent(this.innerPanel);
        this.getBottomPanel().addComponent(this.exitButton);
    }

    @Override
    public List<JComponent> getControls() {
        return List.of(this.exitButton);
    }

    @Override
    public List<JComponent> getKeyControls() {
        return List.of();
    }

}