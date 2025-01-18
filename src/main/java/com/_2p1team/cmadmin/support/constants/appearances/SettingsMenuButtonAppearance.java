package com._2p1team.cmadmin.support.constants.appearances;

import com._2p1team.cmadmin.support.constants.AppearanceConstants;
import com._2p1team.cmadmin.support.constants.CustomColors;
import com._2p1team.cmadmin.support.util.DirectSize;
import com._2p1team.cmadmin.support.util.Util;
import com._2p1team.cmadmin.swing.override.graphics.Appearance;
import com._2p1team.cmadmin.swing.override.graphics.build.BorderConfigurationBuilder;
import com._2p1team.cmadmin.swing.override.graphics.configs.*;

import java.awt.Color;

public final class SettingsMenuButtonAppearance extends Appearance {
    public SettingsMenuButtonAppearance() {
        this.enableInteractivity();

        this.setBackgroundConfiguration(
            new BackgroundConfiguration(
                new SimplePaintConfiguration(CustomColors.OPAQUE),
                new LinearGradientPaintConfiguration(CustomColors.OPAQUE, CustomColors.OPAQUE, CustomColors.OPAQUE, CustomColors.ORANGEISH, CustomColors.REDDISH)
            )
        );

        this.setForegroundConfiguration(new ForegroundConfiguration(Color.white));

        this.setBorderConfiguration(
            new BorderConfigurationBuilder()
                .setRadius(AppearanceConstants.BORDER_RADIUS)
                .build()
        );

        this.setIconSet(new IconSet(Util.loadImageIcon("/assets/settingsIcon.png", DirectSize.sizeByFrame(1, 2))));
    }
}