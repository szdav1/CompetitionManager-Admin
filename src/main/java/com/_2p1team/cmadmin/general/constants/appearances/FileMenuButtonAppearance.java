package com._2p1team.cmadmin.general.constants.appearances;

import com._2p1team.cmadmin.general.constants.AppearanceConstants;
import com._2p1team.cmadmin.general.constants.CustomColors;
import com._2p1team.cmadmin.general.util.DirectIconSize;
import com._2p1team.cmadmin.general.util.Util;
import com._2p1team.cmadmin.swing.override.graphics.Appearance;
import com._2p1team.cmadmin.swing.override.graphics.build.BorderConfigurationBuilder;
import com._2p1team.cmadmin.swing.override.graphics.configs.*;

import java.awt.Color;

public final class FileMenuButtonAppearance extends Appearance {

    public FileMenuButtonAppearance() {
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

        this.setIconSet(new IconSet(Util.loadImageIcon("/assets/fileIcon.png", DirectIconSize.sizeByFrame(1, 2)), Util.loadImageIcon("/assets/fileIcon2.png", DirectIconSize.sizeByFrame(1, 2))));
    }

}