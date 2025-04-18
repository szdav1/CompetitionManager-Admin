package com._2p1team.cmadmin.general.constants.appearances;

import com._2p1team.cmadmin.general.constants.AppearanceConstants;
import com._2p1team.cmadmin.general.constants.CustomColors;
import com._2p1team.cmadmin.swing.override.graphics.Appearance;
import com._2p1team.cmadmin.swing.override.graphics.build.BackgroundConfigurationBuilder;
import com._2p1team.cmadmin.swing.override.graphics.build.BorderConfigurationBuilder;
import com._2p1team.cmadmin.swing.override.graphics.configs.ForegroundConfiguration;
import com._2p1team.cmadmin.swing.override.graphics.configs.LinearGradientPaintConfiguration;
import com._2p1team.cmadmin.swing.override.graphics.configs.SimplePaintConfiguration;

public final class BaseScrollPanelAppearance extends Appearance {

    public BaseScrollPanelAppearance() {
        this.disableInteractivity();
        this.setBackgroundConfiguration(
            new BackgroundConfigurationBuilder()
                .setDefaultConfiguration(new SimplePaintConfiguration(CustomColors.OPAQUE))
                .setHoveredConfiguration(new LinearGradientPaintConfiguration(CustomColors.MAIN_COLOR_2))
                .build()
        );
        this.setForegroundConfiguration(new ForegroundConfiguration(CustomColors.OPAQUE));
        this.setBorderConfiguration(
            new BorderConfigurationBuilder()
                .setRadius(AppearanceConstants.SCROLL_BAR_RADIUS)
                .build()
        );
    }

}