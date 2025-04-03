package com._2p1team.cmadmin.app.view.components.modals;

import com._2p1team.cmadmin.app.control.components.modal.appresponse.AppResponseModalKeyController;
import static com._2p1team.cmadmin.general.constants.SizeData.BUTTON_HEIGHT;
import com._2p1team.cmadmin.general.util.AppearanceRepository;
import com._2p1team.cmadmin.swing.override.components.label.Label;
import lombok.Getter;

import javax.swing.JComponent;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.List;

@Getter
public final class AppResponseModal extends AbstractModal {

    private final Label messageLabel;

    public AppResponseModal() {
        super();
        this.getCenterPanel().setLayout(new GridLayout(2, 1));

        this.messageLabel = new Label(new Dimension(this.getWidth(), BUTTON_HEIGHT), "", AppearanceRepository.BUILD_LABEL_APPEARANCE);

        new AppResponseModalKeyController(this);
    }

    public void showMessage(final String title, final String message) {
        Label iconLabel = new Label(
            new Dimension(this.getWidth(), BUTTON_HEIGHT),
            "",
            title.contains("Error") ? AppearanceRepository.ERROR_LABEL_APPEARANCE : AppearanceRepository.SUCCESS_LABEL_APPEARANCE
        );

        this.messageLabel.setText(message);
        this.getCenterPanel().addComponent(iconLabel);
        this.getCenterPanel().addComponent(this.messageLabel);
        this.setTitle(title);
        this.appear();
    }

    @Override
    public void setUpComponent() {
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