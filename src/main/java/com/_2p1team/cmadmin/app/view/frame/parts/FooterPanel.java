package com._2p1team.cmadmin.app.view.frame.parts;

import com._2p1team.cmadmin.app.view.frame.AppFrame;
import com._2p1team.cmadmin.app.view.interfaces.ComplexComponent;
import static com._2p1team.cmadmin.general.constants.SizeData.TITLE_SIZE;
import static com._2p1team.cmadmin.general.constants.SizeData.TITLE_TEXT_SIZE;
import com._2p1team.cmadmin.general.util.AppearanceRepository;
import com._2p1team.cmadmin.swing.override.components.label.Label;
import com._2p1team.cmadmin.swing.override.components.panel.Panel;

import java.awt.Dimension;
import java.awt.FlowLayout;

public final class FooterPanel extends Panel implements ComplexComponent {

    private final Label versionLabel;

    public FooterPanel() {
        this(TITLE_SIZE);
    }

    public FooterPanel(final Dimension preferredSize) {
        super(preferredSize, new FlowLayout(FlowLayout.CENTER), AppearanceRepository.TITLE_BAR_APPEARANCE);

        this.versionLabel = new Label(TITLE_TEXT_SIZE, AppFrame.VERSION, AppearanceRepository.TITLE_TEXT_APPEARANCE);

        this.setUpComponent();
    }

    @Override
    public void setUpComponent() {
        this.addComponent(this.versionLabel);
    }

}