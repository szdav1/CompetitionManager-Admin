package com._2p1team.cmadmin.general.constants.appearances;

import com._2p1team.cmadmin.general.constants.AppearanceConstants;
import com._2p1team.cmadmin.general.constants.CustomColors;
import com._2p1team.cmadmin.swing.override.graphics.Appearance;
import com._2p1team.cmadmin.swing.override.graphics.build.BorderConfigurationBuilder;
import com._2p1team.cmadmin.swing.override.graphics.configs.BackgroundConfiguration;
import com._2p1team.cmadmin.swing.override.graphics.configs.SimplePaintConfiguration;

public final class ModalTitleBarAppearance extends Appearance {

    public ModalTitleBarAppearance() {
        this.setBackgroundConfiguration(new BackgroundConfiguration(new SimplePaintConfiguration(CustomColors.OPAQUE)));

        this.setBorderConfiguration(
            new BorderConfigurationBuilder()
                .setRadius(AppearanceConstants.BORDER_RADIUS)
                .build()
        );
    }

}