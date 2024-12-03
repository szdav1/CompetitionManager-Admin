package com._2p1team.cmadmin.swing.override.graphics.hints;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public final class BackgroundHint {
    private final LinearGradientPaintHint defaultHint;
    private final LinearGradientPaintHint hoveredHint;
    private final LinearGradientPaintHint pressedHint;
    private final LinearGradientPaintHint releasedHint;

    public BackgroundHint() {
        this(new LinearGradientPaintHint(), new LinearGradientPaintHint());
    }

    public BackgroundHint(final LinearGradientPaintHint defaultHint, final LinearGradientPaintHint hoveredHint) {
        this.defaultHint = defaultHint;
        this.hoveredHint = hoveredHint;
        this.pressedHint = defaultHint;
        this.releasedHint = hoveredHint;
    }
}
