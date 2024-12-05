package com._2p1team.cmadmin.swing.override.graphics.configs;

import javax.swing.ImageIcon;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public final class IconSet {
    private final ImageIcon defaultIcon;
    private final ImageIcon hoveredIcon;
    private final ImageIcon pressedIcon;
    private final ImageIcon releasedIcon;

    public IconSet() {
        this(new ImageIcon(), new ImageIcon());
    }

    public IconSet(final ImageIcon defaultIcon, final ImageIcon hoveredIcon) {
        this.defaultIcon = defaultIcon;
        this.hoveredIcon = hoveredIcon;
        this.pressedIcon = defaultIcon;
        this.releasedIcon = hoveredIcon;
    }

    public IconSet(final ImageIcon icon) {
        this(icon, icon);
    }
}