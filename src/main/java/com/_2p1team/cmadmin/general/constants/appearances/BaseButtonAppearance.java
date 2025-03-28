package com._2p1team.cmadmin.general.constants.appearances;

import com._2p1team.cmadmin.general.constants.AppearanceConstants;
import com._2p1team.cmadmin.general.constants.CustomColors;
import com._2p1team.cmadmin.swing.override.graphics.Appearance;
import com._2p1team.cmadmin.swing.override.graphics.build.BorderConfigurationBuilder;
import com._2p1team.cmadmin.swing.override.graphics.configs.BackgroundConfiguration;
import com._2p1team.cmadmin.swing.override.graphics.configs.ForegroundConfiguration;
import com._2p1team.cmadmin.swing.override.graphics.configs.LinearGradientPaintConfiguration;
import com._2p1team.cmadmin.swing.override.graphics.configs.SimplePaintConfiguration;

import java.awt.Color;

public class BaseButtonAppearance extends Appearance {

    public BaseButtonAppearance() {
        this.enableInteractivity();

        this.setBackgroundConfiguration(
            new BackgroundConfiguration(
                new SimplePaintConfiguration(CustomColors.OPAQUE),
                new LinearGradientPaintConfiguration(CustomColors.OPAQUE, CustomColors.OPAQUE, CustomColors.OPAQUE, CustomColors.MAIN_COLOR_2, CustomColors.MAIN_COLOR_1)
            )
        );

        this.setForegroundConfiguration(new ForegroundConfiguration(Color.white));

        this.setBorderConfiguration(
            new BorderConfigurationBuilder()
                .setRadius(AppearanceConstants.BORDER_RADIUS)
                .build()
        );
    }

}