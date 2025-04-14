package com._2p1team.cmadmin.app.control.components.modal.login;

import com._2p1team.cmadmin.app.control.AbstractController;
import com._2p1team.cmadmin.app.http.HttpCommunicator;
import com._2p1team.cmadmin.app.view.components.input.LabeledInput;
import com._2p1team.cmadmin.app.view.components.input.LabeledPasswordInput;
import com._2p1team.cmadmin.app.view.components.modals.LoginModal;
import com._2p1team.cmadmin.app.view.frame.FrameManager;
import com._2p1team.cmadmin.general.constants.states.CurrentStateUser;
import com._2p1team.cmadmin.swing.override.components.button.Button;

import java.awt.event.ActionEvent;
import java.net.http.HttpResponse;

public final class LoginModalController extends AbstractController {

    private final LoginModal modal;
    private final LabeledInput usernameInput;
    private final LabeledPasswordInput passwordInput;
    private final Button loginButton;
    private final Button exitButton;

    public LoginModalController(final LoginModal component) {
        super(component);

        this.modal = component;
        this.usernameInput = component.getUsernameInput();
        this.passwordInput = component.getPasswordInput();
        this.loginButton = component.getLoginButton();
        this.exitButton = component.getExitButton();

        this.addListeners();
        new LoginModalKeyController(this.modal, this);
    }

    private void addListeners() {
        this.exitButton.addActionListener(this);
        this.loginButton.addActionListener(this);
    }

    void tryLogin() {
        String username = usernameInput.getText();
        String password = passwordInput.getText();

        HttpResponse<String> response = HttpCommunicator.LoginApi.login(username, password);

        if (response.statusCode() == 200) {
            CurrentStateUser.setUsername(username);
            CurrentStateUser.setPassword(password);
            FrameManager.hideOpenedModal();
        }
        else
            this.modal.getErrorLabel().setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(this.exitButton))
            FrameManager.directExitFrame();
        else if (e.getSource().equals(this.loginButton))
            this.tryLogin();
    }

}