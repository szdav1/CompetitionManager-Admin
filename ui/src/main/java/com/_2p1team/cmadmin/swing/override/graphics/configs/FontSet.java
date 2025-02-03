package com._2p1team.cmadmin.swing.override.graphics.configs;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.awt.Font;
import java.awt.Toolkit;

@Data
@AllArgsConstructor
public final class FontSet {

    public static final Font SYSTEM_FONT = new Font(Font.DIALOG, Font.PLAIN, calculateFontSize());


    private final Font defaultFont;
    private final Font hoveredFont;
    private final Font pressedFont;
    private final Font releasedFont;

    public FontSet() {
        this(SYSTEM_FONT);
    }

    public FontSet(final Font font) {
        this(font, font);
    }

    public FontSet(final Font defaultFont, final Font hoveredFont) {
        this.defaultFont = defaultFont;
        this.hoveredFont = hoveredFont;
        this.pressedFont = defaultFont;
        this.releasedFont = hoveredFont;
    }

    private static int calculateFontSize() {
        return (int) (Toolkit.getDefaultToolkit()
            .getScreenSize()
            .width/100);
    }

}