package com._2p1team.cmadmin.app.view.components.modals;

import com._2p1team.cmadmin.app.control.components.modal.exception.http.HttpExceptionModalController;
import com._2p1team.cmadmin.app.view.components.input.LabeledInput;
import com._2p1team.cmadmin.general.constants.HttpConnectionSettings;
import com._2p1team.cmadmin.general.constants.Language;
import static com._2p1team.cmadmin.general.constants.SizeData.*;
import com._2p1team.cmadmin.general.util.AppearanceRepository;
import com._2p1team.cmadmin.swing.override.components.button.Button;
import com._2p1team.cmadmin.swing.override.components.label.Label;
import com._2p1team.cmadmin.swing.override.components.panel.Panel;
import com._2p1team.cmadmin.swing.override.graphics.Appearance;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.swing.JComponent;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.util.List;

@Data
@EqualsAndHashCode(callSuper=true)
public final class HttpExceptionModal extends AbstractModal {

    private Exception exception;
    private final LabeledInput serverCommunicationMethodInput;
    private final LabeledInput domainInput;
    private final LabeledInput portInput;
    private final Label messageLabel;
    private final Panel innerPanel;
    private final Label iconLabel;
    private final Label exceptionMessageLabel;
    private final Button exitButton;

    public HttpExceptionModal() {
        super();

        this.serverCommunicationMethodInput = new LabeledInput(X_BUTTON_WIDTH, Language.get("Method"));
        this.domainInput = new LabeledInput(X_BUTTON_WIDTH, "Domain");
        this.portInput = new LabeledInput(X_BUTTON_WIDTH, "Port");
        this.messageLabel = new Label(new Dimension(this.getWidth(), BUTTON_HEIGHT), Language.get("HttpSettingHint"), AppearanceRepository.LABELED_INPUT_APPEARANCE);
        this.innerPanel = new Panel(new Dimension(this.getWidth(), this.getHeight()-BUTTON_HEIGHT), new FlowLayout(FlowLayout.CENTER, 0, BUTTON_HEIGHT*2), AppearanceRepository.MODAL_CENTER_PANEL_APPEARANCE);
        this.iconLabel = new Label(AppearanceRepository.HTTP_EXCEPTION_LABEL_APPEARANCE);
        this.iconLabel.setLocation((this.getWidth()/2)-(this.iconLabel.getWidth()/2), (this.innerPanel.getHeight()/2)-(this.iconLabel.getHeight()/2)-BUTTON_HEIGHT);
        this.exceptionMessageLabel = new Label(XL_BUTTON_SIZE, Language.get("ConnectionError"), AppearanceRepository.HTTP_EXCEPTION_MESSAGE_APPEARANCE);
        this.exitButton = new Button(W_BUTTON_SIZE, Language.get("Exit")+" [Enter]", new Appearance(AppearanceRepository.BASE_BUTTON_APPEARANCE));

        this.serverCommunicationMethodInput.setText(HttpConnectionSettings.METHOD.getValue());
        this.domainInput.setText(HttpConnectionSettings.DOMAIN.getValue());
        this.portInput.setText(HttpConnectionSettings.PORT.getValue());

        this.getActionMap().clear();

        new HttpExceptionModalController(this);
        this.setUpComponent();
    }

    @Override
    public void setUpComponent() {
        this.getTopPanel().removeComponent(this.getCloseButton());

        this.innerPanel.addComponent(this.serverCommunicationMethodInput);
        this.innerPanel.addComponent(this.domainInput);
        this.innerPanel.addComponent(this.portInput);
        this.innerPanel.addComponent(this.messageLabel);
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