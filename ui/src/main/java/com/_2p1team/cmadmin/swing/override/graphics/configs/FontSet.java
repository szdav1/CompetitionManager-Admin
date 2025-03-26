package com._2p1team.cmadmin.swing.override.graphics.configs;

import com._2p1team.cmadmin.swing.override.graphics.Appearance;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.awt.Font;
import java.awt.Toolkit;

/**
 * The FontSet specifies fonts for an Appearance object. It defines
 * fonts for different states of a component:
 * <p>default, hovered, pressed, released and error.</p>
 *
 * @see Font
 * @see Appearance
 */
@Data
@AllArgsConstructor
public final class FontSet {

    /**
     * Specifies a default font based on the running environment, with proportional
     * size and default (PLAIN) style.
     */
    public static final Font SYSTEM_FONT = new Font(Font.SANS_SERIF, Font.PLAIN, calculateFontSize());

    private final Font defaultFont;
    private final Font hoveredFont;
    private final Font pressedFont;
    private final Font releasedFont;

    /**
     * Constructs a FontSet object with every font
     * being the SYSTEM_FONT.
     */
    public FontSet() {
        this(SYSTEM_FONT);
    }

    /**
     * Constructs a FontSet object with the font
     * being distributed among the component states.
     *
     * @param font The font object that should be used
     */
    public FontSet(final Font font) {
        this(font, font);
    }

    /**
     * Constructs a FontSet object with the fonts
     * being distributed among the component states.
     *
     * @param defaultFont The default and the pressed font
     * @param hoveredFont The hovered and the released font
     */
    public FontSet(final Font defaultFont, final Font hoveredFont) {
        this.defaultFont = defaultFont;
        this.hoveredFont = hoveredFont;
        this.pressedFont = defaultFont;
        this.releasedFont = hoveredFont;
    }

    private static int calculateFontSize() {
        return Toolkit.getDefaultToolkit()
            .getScreenSize()
            .width/100;
    }

}