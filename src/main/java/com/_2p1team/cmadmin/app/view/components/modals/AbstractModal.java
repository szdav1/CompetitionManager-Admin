package com._2p1team.cmadmin.app.view.components.modals;

import com._2p1team.cmadmin.app.control.components.modal.ModalController;
import com._2p1team.cmadmin.app.view.frame.FrameManager;
import com._2p1team.cmadmin.app.view.interfaces.ComplexComponent;
import com._2p1team.cmadmin.app.view.interfaces.ControlComponent;
import com._2p1team.cmadmin.app.view.interfaces.KeyControlledComponent;
import static com._2p1team.cmadmin.support.constants.SizeData.*;
import com._2p1team.cmadmin.support.util.AppearanceRepository;
import com._2p1team.cmadmin.swing.override.components.button.Button;
import com._2p1team.cmadmin.swing.override.components.panel.Panel;
import com._2p1team.cmadmin.swing.override.constants.Position;
import com._2p1team.cmadmin.swing.override.graphics.Appearance;
import lombok.Getter;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Rectangle;

@Getter
public abstract class AbstractModal extends Panel implements ComplexComponent, ControlComponent, KeyControlledComponent {
    private final Panel backgroundPanel;
    private final Panel topPanel;
    private final Button closeButton;
    private final ModalController controller;

    public AbstractModal() {
        super(new Rectangle(FRAME_WIDTH/4, FRAME_HEIGHT/4, FRAME_WIDTH/2, FRAME_HEIGHT/2), new BorderLayout(), new Appearance(AppearanceRepository.MODAL_APPEARANCE));

        this.backgroundPanel = new Panel(new Rectangle(0, 0, SCREEN_WIDTH, SCREEN_HEIGHT), null, new Appearance(AppearanceRepository.MODAL_BACKGROUND_APPEARANCE));
        this.topPanel = new Panel(new Dimension(this.getWidth(), BUTTON_HEIGHT), new FlowLayout(FlowLayout.RIGHT, 0, 0), new Appearance(AppearanceRepository.TITLE_BAR_APPEARANCE));
        this.closeButton = new Button(N_BUTTON_SIZE, "x", new Appearance(AppearanceRepository.EXIT_BUTTON_APPEARANCE));
        this.controller = new ModalController(this);

        this.setUpComponent();
    }

    public void appear() {
        this.backgroundPanel.setVisible(true);
        FrameManager.revalidateRootPanel();
    }

    public void disappear() {
        this.backgroundPanel.setVisible(false);
        FrameManager.revalidateRootPanel();
    }

    @Override
    public void setUpComponent() {
        this.topPanel.addComponent(this.closeButton);

        this.addComponent(this.topPanel, Position.TOP);

        this.backgroundPanel.addComponent(this, Position.HIGH);
    }
}