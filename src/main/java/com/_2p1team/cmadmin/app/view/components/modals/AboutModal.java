package com._2p1team.cmadmin.app.view.components.modals;

import com._2p1team.cmadmin.app.control.components.modal.about.AboutModalKeyController;
import com._2p1team.cmadmin.app.view.frame.AppFrame;
import com._2p1team.cmadmin.app.view.frame.FrameManager;
import com._2p1team.cmadmin.general.constants.Language;
import static com._2p1team.cmadmin.general.constants.SizeData.BUTTON_HEIGHT;
import com._2p1team.cmadmin.general.util.AppearanceRepository;
import com._2p1team.cmadmin.swing.override.components.label.Label;
import com._2p1team.cmadmin.swing.override.components.panel.Panel;
import com._2p1team.cmadmin.swing.override.graphics.Appearance;
import lombok.Getter;

import javax.swing.JComponent;
import java.awt.Dimension;
import java.util.List;

public final class AboutModal extends AbstractModal {

    @Getter
    private final Label logoLabel;
    private final Label titleLabel;
    private final Panel divider;
    private final Label buildNumberLabel;
    private final Label versionNumberLabel;
    private final Label licenseLabel;
    private final Label poweredByLabel;
    private final Label developedByLabel;

    public AboutModal() {
        super();
        this.setTitle(Language.get("About"));

        this.logoLabel = new Label(new Appearance(AppearanceRepository.LOGO_LABEL_APPEARANCE));
        this.titleLabel = new Label(new Dimension(this.getWidth(), BUTTON_HEIGHT), Language.get("ApplicationTitle"), AppearanceRepository.LABELED_INPUT_APPEARANCE);
        this.divider = new Panel(new Dimension(this.getWidth()/2, 1), AppearanceRepository.HOLLOW_HORIZONTAL_DIVIDER_APPEARANCE);
        this.buildNumberLabel = new Label(new Dimension(this.getWidth(), BUTTON_HEIGHT), "", AppearanceRepository.BUILD_LABEL_APPEARANCE);
        this.versionNumberLabel = new Label(new Dimension(this.getWidth(), BUTTON_HEIGHT), AppFrame.VERSION, AppearanceRepository.LABELED_INPUT_APPEARANCE);
        this.licenseLabel = new Label(new Dimension(this.getWidth(), BUTTON_HEIGHT), Language.get("License"), AppearanceRepository.LABELED_INPUT_APPEARANCE);
        this.poweredByLabel = new Label(new Dimension(this.getWidth(), BUTTON_HEIGHT), Language.get("PoweredBy")+" Java, Swing", AppearanceRepository.POWERED_BY_LABEL_APPEARANCE);
        this.developedByLabel = new Label(new Dimension(this.getWidth(), BUTTON_HEIGHT), Language.get("DevelopedBy")+" 2+1 team", AppearanceRepository.DEVELOPED_BY_LABEL_APPEARANCE);

        this.setUpComponent();
        new AboutModalKeyController(this);
    }

    public void setUpBuildDisplay() {
        this.buildNumberLabel.setText(String.format("LTS Build: %s, %s %s", FrameManager.getBuild(), Language.get("Built"), FrameManager.getBuildDate()));
    }

    @Override
    public void setUpComponent() {
        this.getCenterPanel().addComponent(this.logoLabel);
        this.getCenterPanel().addComponent(this.titleLabel);
        this.getCenterPanel().addComponent(this.divider);
        this.getCenterPanel().addComponent(this.buildNumberLabel);
        this.getCenterPanel().addComponent(this.licenseLabel);
        this.getCenterPanel().addComponent(this.poweredByLabel);
        this.getCenterPanel().addComponent(this.developedByLabel);
        this.getCenterPanel().addComponent(this.versionNumberLabel);
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