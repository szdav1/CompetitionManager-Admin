package com._2p1team.cmadmin.app.view.components.modals;

import com._2p1team.cmadmin.app.control.components.modal.login.LoginModalController;
import com._2p1team.cmadmin.app.view.components.input.LabeledInput;
import com._2p1team.cmadmin.app.view.components.input.LabeledPasswordInput;
import static com._2p1team.cmadmin.general.constants.AppearanceConstants.PADDING;
import com._2p1team.cmadmin.general.constants.Language;
import static com._2p1team.cmadmin.general.constants.SizeData.*;
import com._2p1team.cmadmin.general.util.AppearanceRepository;
import com._2p1team.cmadmin.swing.override.components.button.Button;
import com._2p1team.cmadmin.swing.override.components.label.Label;
import com._2p1team.cmadmin.swing.override.components.panel.Panel;
import com._2p1team.cmadmin.swing.override.constants.Position;
import com._2p1team.cmadmin.swing.override.graphics.Appearance;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.swing.JComponent;
import java.awt.*;
import java.util.List;

@Data
@EqualsAndHashCode(callSuper=false)
public final class LoginModal extends AbstractModal {

    private final LabeledInput emailInput;
    private final LabeledPasswordInput passwordInput;
    private final Button loginButton;
    private final Label lockLabel;
    private final Label errorLabel;
    private final Button exitButton;
    private final Label messageLabel;

    public LoginModal() {
        super();
        this.setTitle(Language.get("Login"));
        this.getCenterPanel().setLayout(new GridLayout(1, 2));
        this.getTopPanel().removeComponent(this.getCloseButton());

        this.emailInput = new LabeledInput(W_BUTTON_WIDTH, Language.get("Email"));
        this.passwordInput = new LabeledPasswordInput(W_BUTTON_WIDTH, Language.get("Password"));
        this.loginButton = new Button(BUTTON_SIZE, Language.get("Login"), new Appearance(AppearanceRepository.BASE_BUTTON_APPEARANCE));
        this.lockLabel = new Label(AppearanceRepository.LOCK_LABEL_APPEARANCE);
        this.errorLabel = new Label(new Dimension(X_BUTTON_WIDTH*2, BUTTON_HEIGHT), Language.get("InvalidUsernameOrPassword"), AppearanceRepository.HTTP_EXCEPTION_MESSAGE_APPEARANCE);
        this.exitButton = new Button(BUTTON_SIZE, Language.get("Close"), new Appearance(AppearanceRepository.BASE_BUTTON_APPEARANCE));
        this.messageLabel = new Label(new Dimension(X_BUTTON_WIDTH*3, BUTTON_HEIGHT), Language.get("HowToLogin"), AppearanceRepository.LABELED_INPUT_APPEARANCE);

        this.getActionMap().clear();

        this.setUpComponent();
        new LoginModalController(this);
    }

    @Override
    public void setUpComponent() {

        Panel leftPanel = new Panel(new Dimension(this.getWidth()/2, this.getHeight()-(BUTTON_HEIGHT*2)), null, AppearanceRepository.LABELED_INPUT_APPEARANCE);
        Panel rightPanel = new Panel(leftPanel.getPreferredSize(), new BorderLayout(), leftPanel.getAppearance());

        Panel innerPanel = new Panel(
            new Rectangle((leftPanel.getWidth()/2)-W_BUTTON_WIDTH, (leftPanel.getHeight()/2)-(((BUTTON_HEIGHT*3)+(BUTTON_HEIGHT*6))/2), W_BUTTON_WIDTH*2+BUTTON_WIDTH, (BUTTON_HEIGHT*4)+(BUTTON_HEIGHT*8)),
            new FlowLayout(FlowLayout.CENTER, PADDING, BUTTON_HEIGHT),
            AppearanceRepository.LABELED_INPUT_APPEARANCE
        );

        innerPanel.addComponent(this.emailInput);
        innerPanel.addComponent(this.passwordInput);
        innerPanel.addComponent(this.errorLabel);
        innerPanel.addComponent(this.loginButton);
        innerPanel.addComponent(this.messageLabel);

        this.errorLabel.setVisible(false);

        leftPanel.addComponent(innerPanel);
        rightPanel.addComponent(this.lockLabel, Position.CENTER);

        this.getCenterPanel().addComponent(leftPanel);
        this.getCenterPanel().addComponent(rightPanel);
        this.getBottomPanel().addComponent(this.exitButton);
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