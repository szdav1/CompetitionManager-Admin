package com._2p1team.cmadmin.app.control.frame.parts;

import com._2p1team.cmadmin.app.control.AbstractController;
import com._2p1team.cmadmin.app.view.components.menu.MenuButton;
import com._2p1team.cmadmin.app.view.frame.FrameManager;
import com._2p1team.cmadmin.app.view.frame.parts.TitleBar;
import com._2p1team.cmadmin.general.constants.CompetitionType;
import com._2p1team.cmadmin.swing.override.components.button.Button;

import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

public final class TitleBarController extends AbstractController {

    private final List<MenuButton> menuButtons;
    private final List<Button> dropdownPanelButtons;

    public TitleBarController(final TitleBar titleBar) {
        super(titleBar);
        this.getControls().forEach(control -> control.addMouseListener(this));
        this.menuButtons = new ArrayList<>();
        this.menuButtons.add((MenuButton) this.getControls().get(2));
        this.menuButtons.add((MenuButton) this.getControls().get(3));
        this.menuButtons.add((MenuButton) this.getControls().get(4));

        this.dropdownPanelButtons = new ArrayList<>();
        this.menuButtons.forEach(menuButton -> dropdownPanelButtons.addAll(menuButton.getButtons()));
        this.dropdownPanelButtons.forEach(dropdownPanelButton -> dropdownPanelButton.addActionListener(this));

        new TitleBarKeyController(titleBar);
    }

    public void controlFrameState(final ActionEvent event) {
        this.getControls().forEach(control -> {
            if (event.getSource().equals(control)) {
                int controlIndex = this.getControls().indexOf(control);

                switch (controlIndex) {
                    case 0 -> FrameManager.attemptExitFrame();
                    case 1 -> FrameManager.iconifyFrame();
                }
            }
        });
    }

    private void clearDropdownPanels(final MenuButton source) {
        this.menuButtons.forEach(menuButton -> {
            if (!menuButton.equals(source)) {
                menuButton.setToggled(false);

                menuButton.getDropdownPanel()
                    .setVisible(false);

                FrameManager.getCenterPanel()
                    .revalidate();
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

    public void controlDropdownPanelButtons(final ActionEvent event) {
        this.dropdownPanelButtons.forEach(dropdownPanelButton -> {
            if (event.getSource().equals(dropdownPanelButton)) {
                int index = this.dropdownPanelButtons.indexOf(dropdownPanelButton);
                this.clearDropdownPanels(null);

                switch (index) {
                    // File menu
                    case 0 -> FrameManager.displayNewPouleModal(CompetitionType.COMPETITION);
                    case 1 -> FrameManager.displayNewPouleModal(CompetitionType.POULE_ONLY);
                    case 2 -> FrameManager.displayNewTableModal();

                    // Database menu
                    case 3 -> FrameManager.displayViewCompetitorsModal();
                    case 4 -> FrameManager.displayAddCompetitorModal();
                    case 5 -> {
                    }

                    // Settings menu
                    case 6 -> {
                    }
                    case 7 -> {
                    }
                    case 8 -> {
                    }
                }
            }
        });
    }

    private void handleMenuButtons(final MouseEvent mouseEvent) {
        this.menuButtons.forEach(menuButton -> {
            if (mouseEvent.getSource().equals(menuButton) && menuButton.isEnabled()) {
                if (!menuButton.isToggled()) {
                    menuButton.getDropdownPanel()
                        .setVisible(mouseEvent.getID() == MouseEvent.MOUSE_ENTERED);

                    FrameManager.getCenterPanel()
                        .revalidate();
                }

                if (mouseEvent.getID() == MouseEvent.MOUSE_ENTERED)
                    this.clearDropdownPanels(menuButton);
            }
        });
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        this.controlFrameState(e);
        this.controlDropdownPanels(e);
        this.controlDropdownPanelButtons(e);
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        this.handleMenuButtons(e);
    }

    @Override
    public void mouseExited(MouseEvent e) {
        this.handleMenuButtons(e);
    }

}