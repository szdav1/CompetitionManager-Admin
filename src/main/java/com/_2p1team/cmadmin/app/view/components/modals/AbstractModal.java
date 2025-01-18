package com._2p1team.cmadmin.app.view.components.modals;

import com._2p1team.cmadmin.app.view.frame.FrameManager;
import com._2p1team.cmadmin.app.view.interfaces.ComplexComponent;
import com._2p1team.cmadmin.app.view.interfaces.ControlComponent;
import com._2p1team.cmadmin.app.view.interfaces.KeyControlledComponent;
import static com._2p1team.cmadmin.support.constants.SizeData.*;
import com._2p1team.cmadmin.support.constants.states.FrameState;
import com._2p1team.cmadmin.support.util.AppearanceRepository;
import com._2p1team.cmadmin.swing.override.components.button.Button;
import com._2p1team.cmadmin.swing.override.components.panel.Panel;
import com._2p1team.cmadmin.swing.override.constants.Position;
import com._2p1team.cmadmin.swing.override.graphics.Appearance;
import lombok.Getter;

import javax.swing.AbstractAction;
import javax.swing.JComponent;
import javax.swing.KeyStroke;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

@Getter
public abstract class AbstractModal extends Panel implements ComplexComponent, ControlComponent, KeyControlledComponent, ActionListener {
    private final Panel backgroundPanel;
    private final Panel topPanel;
    private final Panel centerPanel;
    private final Panel bottomPanel;
    private final Button closeButton;

    public AbstractModal() {
        super(new Rectangle(FRAME_WIDTH/4, FRAME_HEIGHT/4, FRAME_WIDTH/2, FRAME_HEIGHT/2), new BorderLayout(), AppearanceRepository.MODAL_APPEARANCE);

        this.backgroundPanel = new Panel(new Rectangle(0, 0, SCREEN_WIDTH, SCREEN_HEIGHT), null, AppearanceRepository.MODAL_BACKGROUND_APPEARANCE);
        this.topPanel = new Panel(new Dimension(this.getWidth(), BUTTON_HEIGHT), new FlowLayout(FlowLayout.RIGHT, 0, 0), AppearanceRepository.MODAL_TITLE_BAR_APPEARANCE);
        this.centerPanel = new Panel(new Dimension(this.getWidth(), this.getHeight()), new FlowLayout(FlowLayout.CENTER, 0, 0), AppearanceRepository.MODAL_CENTER_PANEL_APPEARANCE);
        this.bottomPanel = new Panel(this.topPanel.getPreferredSize(), new FlowLayout(FlowLayout.CENTER, 0, 0), AppearanceRepository.MODAL_TITLE_BAR_APPEARANCE);

        this.closeButton = new Button(N_BUTTON_SIZE, "x", new Appearance(AppearanceRepository.EXIT_BUTTON_APPEARANCE));
        this.closeButton.addActionListener(this);
        this.closeButton.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW)
            .put(KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), "CloseModal");
        this.closeButton.getActionMap()
            .put("CloseModal", new CloseModalAction());

        this.topPanel.addComponent(this.closeButton);

        this.addComponent(this.topPanel, Position.TOP);
        this.addComponent(this.centerPanel, Position.CENTER);
        this.addComponent(this.bottomPanel, Position.BOTTOM);

        this.backgroundPanel.addComponent(this, Position.HIGH);
    }

    private static class CloseModalAction extends AbstractAction {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (FrameManager.getState() == FrameState.MODAL_OPENED)
                FrameManager.hideOpenedModal();
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(this.closeButton))
            FrameManager.hideOpenedModal();
    }

    public void appear() {
        this.backgroundPanel.setVisible(true);
        FrameManager.revalidateRootPanel();
    }

    public void disappear() {
        this.backgroundPanel.setVisible(false);
        FrameManager.revalidateRootPanel();
    }
}