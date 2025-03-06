package com._2p1team.cmadmin.swing.override.graphics.configs;

import com._2p1team.cmadmin.swing.override.graphics.Appearance;
import lombok.AllArgsConstructor;
import lombok.Data;

import javax.swing.ImageIcon;

/**
 * The IconSet specifies icons for an Appearance object. It defines
 * icons for different states of a component:
 * <p>default, hovered, pressed, released and error.</p>
 *
 * @see ImageIcon
 * @see Appearance
 */
@Data
@AllArgsConstructor
public final class IconSet {

    private final ImageIcon defaultIcon;
    private final ImageIcon hoveredIcon;
    private final ImageIcon pressedIcon;
    private final ImageIcon releasedIcon;

    /**
     * Constructs a IconSet object with every ImageIcon being empty.
     */
    public IconSet() {
        this(new ImageIcon(), new ImageIcon());
    }

    /**
     * Constructs a IconSet object with the icon
     * being distributed among the component states.
     *
     * @param icon The font object that should be used
     */
    public IconSet(final ImageIcon icon) {
        this(icon, icon);
    }

    /**
     * Constructs a IconSet object with the icons
     * being distributed among the component states.
     *
     * @param defaultIcon The default and the pressed font
     * @param hoveredIcon The hovered and the released font
     */
    public IconSet(final ImageIcon defaultIcon, final ImageIcon hoveredIcon) {
        this.defaultIcon = defaultIcon;
        this.hoveredIcon = hoveredIcon;
        this.pressedIcon = defaultIcon;
        this.releasedIcon = hoveredIcon;
    }

}