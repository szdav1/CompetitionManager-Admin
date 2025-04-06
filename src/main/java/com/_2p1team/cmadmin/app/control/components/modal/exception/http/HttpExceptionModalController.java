package com._2p1team.cmadmin.app.control.components.modal.exception.http;

import com._2p1team.cmadmin.app.control.AbstractController;
import com._2p1team.cmadmin.app.view.components.input.LabeledInput;
import com._2p1team.cmadmin.app.view.components.modals.HttpExceptionModal;
import com._2p1team.cmadmin.app.view.frame.FrameManager;
import com._2p1team.cmadmin.general.constants.IOData;
import com._2p1team.cmadmin.general.constants.Language;
import com._2p1team.cmadmin.general.io.HttpWrite;
import com._2p1team.cmadmin.general.util.ResourceManager;
import com._2p1team.cmadmin.swing.override.components.button.Button;
import com.google.gson.Gson;

import java.awt.event.ActionEvent;
import java.io.FileWriter;

public final class HttpExceptionModalController extends AbstractController {

    private final LabeledInput serverCommunicationMethodInput;
    private final LabeledInput domainInput;
    private final LabeledInput portInput;
    private final Gson converter;

    public HttpExceptionModalController(final HttpExceptionModal component) {
        super(component);

        this.serverCommunicationMethodInput = component.getServerCommunicationMethodInput();
        this.domainInput = component.getDomainInput();
        this.portInput = component.getPortInput();
        this.converter = new Gson();

        new HttpExceptionModalKeyController(component, this);
    }

    void saveAndExit() {
        String serverCommunicationMethod = serverCommunicationMethodInput.getText();
        String domain = domainInput.getText();
        String port = portInput.getText();

        if (serverCommunicationMethod.isBlank() || domain.isBlank() || port.isBlank()) {
            FrameManager.directExitFrame();
            return;
        }

        try (FileWriter writer = new FileWriter(ResourceManager.get(IOData.HTTP_SETTINGS_PATH.getData()))) {
            this.converter.toJson(new HttpWrite(serverCommunicationMethod, domain, port), writer);
        }
        catch (Exception exception) {
            FrameManager.displayAppResponseModal(Language.get("Error"), Language.get("HttpSettingsError"));
        }

        FrameManager.directExitFrame();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Button exitButton = (Button) this.getComponent()
            .getControls()
            .getFirst();

        if (e.getSource().equals(exitButton))
            this.saveAndExit();
    }

}