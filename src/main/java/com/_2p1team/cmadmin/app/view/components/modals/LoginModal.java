package com._2p1team.cmadmin.app.view.components.modals;

import com._2p1team.cmadmin.app.view.components.input.LabeledInput;
import static com._2p1team.cmadmin.general.constants.AppearanceConstants.PADDING;
import com._2p1team.cmadmin.general.constants.Language;
import static com._2p1team.cmadmin.general.constants.SizeData.*;
import com._2p1team.cmadmin.general.util.AppearanceRepository;
import com._2p1team.cmadmin.swing.override.components.button.Button;
import com._2p1team.cmadmin.swing.override.components.label.Label;
import com._2p1team.cmadmin.swing.override.components.panel.Panel;
import com._2p1team.cmadmin.swing.override.constants.Position;
import com._2p1team.cmadmin.swing.override.graphics.Appearance;

import javax.swing.JComponent;
import java.awt.*;
import java.util.List;

public final class LoginModal extends AbstractModal {

    private final LabeledInput usernameInput;
    private final LabeledInput passwordInput;
    private final Button loginButton;
    private final Label lockLabel;

    public LoginModal() {
        super();
        this.setTitle(Language.get("Login"));
        this.getCenterPanel().setLayout(new GridLayout(1, 2));

        this.usernameInput = new LabeledInput(W_BUTTON_WIDTH, Language.get("Email"));
        this.passwordInput = new LabeledInput(W_BUTTON_WIDTH, Language.get("Password"));
        this.loginButton = new Button(BUTTON_SIZE, Language.get("Login"), new Appearance(AppearanceRepository.BASE_BUTTON_APPEARANCE));
        this.lockLabel = new Label(AppearanceRepository.LOCK_LABEL_APPEARANCE);

        this.setUpComponent();
    }

    @Override
    public void setUpComponent() {

        Panel leftPanel = new Panel(new Dimension(this.getWidth()/2, this.getHeight()-(BUTTON_HEIGHT*2)), null, AppearanceRepository.LABELED_INPUT_APPEARANCE);
        Panel rightPanel = new Panel(leftPanel.getPreferredSize(), new BorderLayout(), leftPanel.getAppearance());

        Panel innerPanel = new Panel(
            new Rectangle((leftPanel.getWidth()/2)-W_BUTTON_WIDTH, (leftPanel.getHeight()/2)-(((BUTTON_HEIGHT*3)+(BUTTON_HEIGHT*6))/2), W_BUTTON_WIDTH*2, (BUTTON_HEIGHT*3)+(BUTTON_HEIGHT*6)),
            new FlowLayout(FlowLayout.CENTER, PADDING, BUTTON_HEIGHT),
            AppearanceRepository.LABELED_INPUT_APPEARANCE
        );

        innerPanel.addComponent(this.usernameInput);
        innerPanel.addComponent(this.passwordInput);
        innerPanel.addComponent(this.loginButton);

        leftPanel.addComponent(innerPanel);
        rightPanel.addComponent(this.lockLabel, Position.CENTER);

        this.getCenterPanel().addComponent(leftPanel);
        this.getCenterPanel().addComponent(rightPanel);
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