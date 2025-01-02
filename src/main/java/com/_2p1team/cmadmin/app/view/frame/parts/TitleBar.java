package com._2p1team.cmadmin.app.view.frame.parts;

import com._2p1team.cmadmin.app.control.frame.parts.TitleBarController;
import com._2p1team.cmadmin.app.view.interfaces.ComplexComponent;
import com._2p1team.cmadmin.app.view.interfaces.ControlComponent;
import com._2p1team.cmadmin.support.appdata.SizeData;
import static com._2p1team.cmadmin.support.appdata.SizeData.*;
import com._2p1team.cmadmin.support.util.AppearanceRepository;
import com._2p1team.cmadmin.swing.override.components.button.Button;
import com._2p1team.cmadmin.swing.override.components.label.Label;
import com._2p1team.cmadmin.swing.override.components.panel.Panel;
import lombok.Getter;

import javax.swing.JComponent;
import javax.swing.SwingConstants;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.util.List;

@Getter
public final class TitleBar extends Panel implements ComplexComponent, ControlComponent {
    private final Button exitButton;
    private final Button iconifyButton;
    private final TitleBarController controller;

    private final Panel leftPanel;
    private final Panel centerPanel;
    private final Panel rightPanel;

    private final Label dashboardLabel;
    private final Label titleLabel;

    public TitleBar() {
        super(SizeData.TITLE_SIZE, new GridLayout(1, 3), AppearanceRepository.TITLE_BAR_APPEARANCE);

        this.exitButton = new Button(N_BUTTON_SIZE, "x", AppearanceRepository.EXIT_BUTTON_APPEARANCE);
        this.iconifyButton = new Button(N_BUTTON_SIZE, "_", AppearanceRepository.ICONIFY_BUTTON_APPEARANCE);
        this.controller = new TitleBarController(this);

        this.leftPanel = new Panel(new Dimension(), new FlowLayout(FlowLayout.LEFT, 0, 0), this.getAppearance());
        this.centerPanel = new Panel(new Dimension(), new FlowLayout(FlowLayout.CENTER, 0, 0), this.getAppearance());
        this.rightPanel = new Panel(new Dimension(), new FlowLayout(FlowLayout.RIGHT, 0, 0), this.getAppearance());

        this.dashboardLabel = new Label(TITLE_TEXT_SIZE, "Dashboard", AppearanceRepository.DASHBOARD_LABEL_APPEARANCE);
        this.dashboardLabel.setHorizontalAlignment(SwingConstants.LEFT);

        this.titleLabel = new Label(TITLE_TEXT_SIZE, "CompetitionManager - Admin", AppearanceRepository.TITLE_TEXT_APPEARANCE);

        this.setUpComponent();
    }

    @Override
    public void setUpComponent() {
        this.leftPanel.addComponent(this.dashboardLabel);

        this.centerPanel.addComponent(this.titleLabel);

        this.rightPanel.addComponent(this.iconifyButton);
        this.rightPanel.addComponent(this.exitButton);

        this.addComponent(this.leftPanel);
        this.addComponent(this.centerPanel);
        this.addComponent(this.rightPanel);
    }

    @Override
    public List<JComponent> getControls() {
        return List.of(this.exitButton, this.iconifyButton);
    }
}