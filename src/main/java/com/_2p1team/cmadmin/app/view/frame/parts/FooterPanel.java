package com._2p1team.cmadmin.app.view.frame.parts;

import com._2p1team.cmadmin.app.view.frame.AppFrame;
import com._2p1team.cmadmin.app.view.frame.FrameManager;
import com._2p1team.cmadmin.app.view.interfaces.ComplexComponent;
import com._2p1team.cmadmin.general.constants.Language;
import static com._2p1team.cmadmin.general.constants.SizeData.*;
import com._2p1team.cmadmin.general.util.AppearanceRepository;
import com._2p1team.cmadmin.swing.override.components.label.Label;
import com._2p1team.cmadmin.swing.override.components.panel.Panel;

import java.awt.Dimension;
import java.awt.FlowLayout;

public final class FooterPanel extends Panel implements ComplexComponent {

    private final Label versionLabel;
    private final Label buildLabel;
    private final Label buildDateLabel;
    private final Label poweredByLabel;

    public FooterPanel() {
        this(TITLE_SIZE);
    }

    public FooterPanel(final Dimension preferredSize) {
        super(preferredSize, new FlowLayout(FlowLayout.CENTER), AppearanceRepository.TITLE_BAR_APPEARANCE);

        this.versionLabel = new Label(X_BUTTON_SIZE, AppFrame.VERSION, AppearanceRepository.TITLE_TEXT_APPEARANCE);
        this.buildLabel = new Label(X_BUTTON_SIZE, "", AppearanceRepository.BUILD_LABEL_APPEARANCE);
        this.buildDateLabel = new Label(X_BUTTON_SIZE, "", AppearanceRepository.LABELED_INPUT_APPEARANCE);
        this.poweredByLabel = new Label(X_BUTTON_SIZE, Language.get("PoweredBy")+" Swing", AppearanceRepository.POWERED_BY_LABEL_APPEARANCE);

        this.setUpComponent();
    }

    public void setData() {
        this.buildLabel.setText("Build: "+FrameManager.getBuild());
        this.buildDateLabel.setText("LTS "+Language.get("Built")+" "+FrameManager.getBuildDate());
    }

    @Override
    public void setUpComponent() {
        this.addComponent(this.versionLabel);
        this.addComponent(this.buildLabel);
        this.addComponent(this.buildDateLabel);
        this.addComponent(this.poweredByLabel);
    }

}