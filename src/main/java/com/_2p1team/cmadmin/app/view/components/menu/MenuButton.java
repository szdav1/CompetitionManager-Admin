package com._2p1team.cmadmin.app.view.components.menu;

import com._2p1team.cmadmin.app.view.frame.FrameManager;
import static com._2p1team.cmadmin.support.constants.SizeData.*;
import com._2p1team.cmadmin.support.util.AppearanceRepository;
import com._2p1team.cmadmin.swing.override.components.button.Button;
import com._2p1team.cmadmin.swing.override.components.panel.Panel;
import com._2p1team.cmadmin.swing.override.constants.Position;
import com._2p1team.cmadmin.swing.override.graphics.Appearance;
import lombok.Getter;
import lombok.Setter;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Point;
import java.awt.Rectangle;

@Getter
public final class MenuButton extends Button {
    @Setter
    private boolean toggled;
    private final Panel dropdownPanel;

    public MenuButton(final String text, final Appearance appearance) {
        super(BUTTON_SIZE, text, appearance);

        this.toggled = false;
        this.dropdownPanel = new Panel(new Rectangle(0, 0, BUTTON_WIDTH, BUTTON_HEIGHT*5), new FlowLayout(FlowLayout.CENTER, 0, 0), AppearanceRepository.DROPDOWN_APPEARANCE);
    }

    public void setDropdownPanelPosition(int x, int y) {
        this.dropdownPanel.setLocation(new Point(x, y));
    }

    public void addButtonToDropdownPanel(final String buttonText, final Appearance appearance) {
        Button button = new Button(new Dimension(BUTTON_WIDTH, BUTTON_HEIGHT), buttonText, appearance);

        this.dropdownPanel.addComponent(button);
    }
}