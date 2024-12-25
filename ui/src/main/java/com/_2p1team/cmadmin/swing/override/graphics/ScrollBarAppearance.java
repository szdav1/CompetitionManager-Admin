package com._2p1team.cmadmin.swing.override.graphics;

import com._2p1team.cmadmin.swing.override.graphics.configs.BackgroundConfiguration;
import com._2p1team.cmadmin.swing.override.graphics.configs.ForegroundConfiguration;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public final class ScrollBarAppearance {
    private final int radius;
    private final BackgroundConfiguration backgroundConfiguration;
    private final ForegroundConfiguration thumbConfiguration;

    public ScrollBarAppearance() {
        this.radius = 0;
        this.backgroundConfiguration = new BackgroundConfiguration();
        this.thumbConfiguration = new ForegroundConfiguration();
    }
}