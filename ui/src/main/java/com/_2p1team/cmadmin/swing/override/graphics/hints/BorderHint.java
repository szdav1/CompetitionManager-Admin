package com._2p1team.cmadmin.swing.override.graphics.hints;

import java.awt.Color;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public final class BorderHint {
    private final int thickness;
    private final int radius;
    private final LinearGradientPaintHint defaultHint;
    private final LinearGradientPaintHint hoveredHint;
    private final LinearGradientPaintHint pressedHint;
    private final LinearGradientPaintHint releasedHint;

    public BorderHint() {
        this(0, 0, new LinearGradientPaintHint(Color.black), new LinearGradientPaintHint(Color.darkGray));
    }

    public BorderHint(int thickness, final LinearGradientPaintHint defaultHint, final LinearGradientPaintHint hoveredHint, final LinearGradientPaintHint pressedHint, final LinearGradientPaintHint releasedHint) {
        this.thickness = thickness;
        this.radius = 0;
        this.defaultHint = defaultHint;
        this.hoveredHint = hoveredHint;
        this.pressedHint = pressedHint;
        this.releasedHint = releasedHint;
    }

    public BorderHint(int thickness, int radius, final LinearGradientPaintHint defaultHint, final LinearGradientPaintHint hoveredHint) {
        this.thickness = thickness;
        this.radius = radius;
        this.defaultHint = defaultHint;
        this.hoveredHint = hoveredHint;
        this.pressedHint = defaultHint;
        this.releasedHint = hoveredHint;
    }

    public BorderHint(int thickness, final LinearGradientPaintHint defaultHint, final LinearGradientPaintHint hoveredHint) {
        this.thickness = thickness;
        this.radius = 0;
        this.defaultHint = defaultHint;
        this.hoveredHint = hoveredHint;
        this.pressedHint = defaultHint;
        this.releasedHint = hoveredHint;
    }
}