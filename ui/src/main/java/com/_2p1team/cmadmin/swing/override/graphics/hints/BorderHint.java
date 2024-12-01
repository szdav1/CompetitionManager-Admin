package com._2p1team.cmadmin.swing.override.graphics.hints;

import java.awt.Color;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public final class BorderHint {
    private final LinearGradientPaintHint defaultHint;
    private final LinearGradientPaintHint hoveredHint;
    private final LinearGradientPaintHint pressedHint;
    private final LinearGradientPaintHint releasedHint;

    public BorderHint() {
        this(new LinearGradientPaintHint(Color.black), new LinearGradientPaintHint(Color.darkGray));
    }

    public BorderHint(final LinearGradientPaintHint defaultHint, final LinearGradientPaintHint hoveredHint) {
        this.defaultHint = defaultHint;
        this.hoveredHint = hoveredHint;
        this.pressedHint = defaultHint;
        this.releasedHint = hoveredHint;
    }
}
