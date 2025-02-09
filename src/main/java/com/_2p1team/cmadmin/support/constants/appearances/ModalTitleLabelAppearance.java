package com._2p1team.cmadmin.support.constants.appearances;

import com._2p1team.cmadmin.support.constants.AppearanceConstants;
import com._2p1team.cmadmin.support.constants.CustomColors;
import com._2p1team.cmadmin.swing.override.graphics.Appearance;
import com._2p1team.cmadmin.swing.override.graphics.build.BorderConfigurationBuilder;
import com._2p1team.cmadmin.swing.override.graphics.configs.BackgroundConfiguration;
import com._2p1team.cmadmin.swing.override.graphics.configs.ForegroundConfiguration;
import com._2p1team.cmadmin.swing.override.graphics.configs.SimplePaintConfiguration;

public final class ModalTitleLabelAppearance extends Appearance {

    public ModalTitleLabelAppearance() {
        this.setBackgroundConfiguration(new BackgroundConfiguration(new SimplePaintConfiguration(CustomColors.OPAQUE)));
        this.setForegroundConfiguration(new ForegroundConfiguration(CustomColors.ORANGEISH));
        this.setBorderConfiguration(
            new BorderConfigurationBuilder()
                .setRadius(AppearanceConstants.BORDER_RADIUS)
                .build()
        );
    }

}