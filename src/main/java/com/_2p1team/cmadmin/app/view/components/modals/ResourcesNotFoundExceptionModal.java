package com._2p1team.cmadmin.app.view.components.modals;

import com._2p1team.cmadmin.app.control.components.modal.exception.resources.ResourcesNotFoundExceptionModalController;
import static com._2p1team.cmadmin.general.constants.SizeData.BUTTON_SIZE;
import com._2p1team.cmadmin.general.util.AppearanceRepository;
import com._2p1team.cmadmin.swing.override.components.button.Button;
import com._2p1team.cmadmin.swing.override.components.label.Label;
import com._2p1team.cmadmin.swing.override.graphics.Appearance;
import lombok.Getter;

import javax.swing.JComponent;
import java.awt.GridLayout;
import java.util.List;

@Getter
public final class ResourcesNotFoundExceptionModal extends AbstractModal {

    private final Button bottomCloseButton;
    private final Label informationLabel;

    public ResourcesNotFoundExceptionModal() {
        super();
        this.getTopPanel().removeComponent(this.getCloseButton());
        this.getCenterPanel().setLayout(new GridLayout(1, 1));
        this.setTitle("Resources Not Found");

        this.bottomCloseButton = new Button(BUTTON_SIZE, "Exit [Enter]", new Appearance(AppearanceRepository.BASE_BUTTON_APPEARANCE));
        this.informationLabel = new Label(BUTTON_SIZE, "Failed to load essential resources, please reset or reinstall the application", AppearanceRepository.BUILD_LABEL_APPEARANCE);

        this.setUpComponent();
        new ResourcesNotFoundExceptionModalController(this);
    }

    @Override
    public void setUpComponent() {
        this.getCenterPanel().addComponent(this.informationLabel);
        this.getBottomPanel().addComponent(this.bottomCloseButton);
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