package com._2p1team.cmadmin.swing.override.graphics.hints;

import java.awt.Font;

public final class FontSet {
    public static final Font SYSTEM_FONT = new Font(Font.MONOSPACED, Font.PLAIN, 10);

    private final Font defaultFont;
    private final Font hoveredFont;
    private final Font pressedFont;
    private final Font releasedFont;

    public FontSet() {
        this(SYSTEM_FONT, SYSTEM_FONT);
    }

    public FontSet(final Font defaultFont, final Font hoveredFont) {
        this.defaultFont = defaultFont;
        this.hoveredFont = hoveredFont;
        this.pressedFont = defaultFont;
        this.releasedFont = hoveredFont;
    }
}