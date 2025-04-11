package com._2p1team.cmadmin.app.control.components.modal.login;

import com._2p1team.cmadmin.app.control.AbstractController;
import com._2p1team.cmadmin.app.dto.admins.Admins;
import com._2p1team.cmadmin.app.http.HttpCommunicator;
import com._2p1team.cmadmin.app.view.components.input.LabeledInput;
import com._2p1team.cmadmin.app.view.components.input.LabeledPasswordInput;
import com._2p1team.cmadmin.app.view.components.modals.LoginModal;
import com._2p1team.cmadmin.app.view.frame.FrameManager;
import com._2p1team.cmadmin.swing.override.components.button.Button;

import java.awt.event.ActionEvent;
import java.util.List;

public final class LoginModalController extends AbstractController {

    private final LoginModal modal;
    private final LabeledInput emailInput;
    private final LabeledPasswordInput passwordInput;
    private final Button loginButton;
    private final Button exitButton;

    public LoginModalController(final LoginModal component) {
        super(component);

        this.modal = component;
        this.emailInput = component.getEmailInput();
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
        String email = this.emailInput.getText();
        String password = this.passwordInput.getText();

        List<Admins> admins = HttpCommunicator.AdminsApi.getAllAdmins();

        List<Admins> result = admins.stream()
            .filter(admin -> admin.getEmail().equals(email) && admin.getPassword().equals(password))
            .toList();

        if (result.isEmpty())
            this.modal.getErrorLabel().setVisible(true);
        else
            FrameManager.hideOpenedModal();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(this.exitButton))
            FrameManager.directExitFrame();
        else if (e.getSource().equals(this.loginButton))
            this.tryLogin();
    }

}