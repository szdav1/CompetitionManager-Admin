package com._2p1team.cmadmin.app.control.frame.parts;

import com._2p1team.cmadmin.app.control.AbstractController;
import com._2p1team.cmadmin.app.view.components.menu.MenuButton;
import com._2p1team.cmadmin.app.view.frame.FrameManager;
import com._2p1team.cmadmin.app.view.frame.parts.TitleBar;
import com._2p1team.cmadmin.swing.override.constants.Position;

import javax.swing.JComponent;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.List;

public final class TitleBarController extends AbstractController implements MouseListener {
    private final List<MenuButton> menuButtons;

    public TitleBarController(final TitleBar titleBar) {
        super(titleBar);
        this.getControls().forEach(control -> control.addMouseListener(this));
        this.menuButtons = new ArrayList<>();
        this.menuButtons.add((MenuButton) this.getControls().get(2));
        this.menuButtons.add((MenuButton) this.getControls().get(3));
        this.menuButtons.add((MenuButton) this.getControls().get(4));
    }

    public void controlFrameState(final ActionEvent event) {
        this.getControls().forEach(control -> {
            if (event.getSource().equals(control)) {
                int controlIndex = this.getControls().indexOf(control);
                JComponent source = this.getControls().get(controlIndex);

                switch (controlIndex) {
                    case 0 -> FrameManager.exitFrame();
                    case 1 -> FrameManager.iconifyFrame();
                }
            }
        });
    }

    private void clearDropdownPanels(final MenuButton source) {
        this.menuButtons.forEach(mb -> {
            if (!mb.equals(source)) {
                mb.setToggled(false);
                FrameManager.removeFromFrame(mb.getDropdownPanel());
            }
        });
    }

    public void controlDropdownPanels(final ActionEvent event) {
        this.menuButtons.forEach(menuButton -> {
            if (event.getSource().equals(menuButton)) {
                menuButton.setToggled(!menuButton.isToggled());
                this.clearDropdownPanels(menuButton);
            }
        });
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        this.controlFrameState(e);
        this.controlDropdownPanels(e);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
    }

    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        this.menuButtons.forEach(menuButton -> {
            if (e.getSource().equals(menuButton)) {
                if (!menuButton.isToggled())
                    FrameManager.addToFrame(menuButton.getDropdownPanel(), Position.HIGH);

                this.clearDropdownPanels(menuButton);
            }
        });
    }

    @Override
    public void mouseExited(MouseEvent e) {
        this.menuButtons.forEach(menuButton -> {
            if (e.getSource().equals(menuButton)) {
                if (!menuButton.isToggled())
                    FrameManager.removeFromFrame(menuButton.getDropdownPanel());
            }
        });
    }
}