package com._2p1team.cmadmin.support.constants.appearances;

import com._2p1team.cmadmin.support.constants.CustomColors;
import com._2p1team.cmadmin.swing.override.graphics.Appearance;
import com._2p1team.cmadmin.swing.override.graphics.configs.BackgroundConfiguration;
import com._2p1team.cmadmin.swing.override.graphics.configs.BorderConfiguration;
import com._2p1team.cmadmin.swing.override.graphics.configs.LinearGradientPaintConfiguration;
import com._2p1team.cmadmin.swing.override.graphics.configs.SimplePaintConfiguration;

import java.awt.Color;

public final class BaseLabelAppearance extends Appearance {

    public BaseLabelAppearance() {
        this.setBackgroundConfiguration(new BackgroundConfiguration(new SimplePaintConfiguration(Color.black)));
        this.setBorderConfiguration(new BorderConfiguration(
                1,
                new LinearGradientPaintConfiguration(
                    CustomColors.REDDISH,
                    CustomColors.OPAQUE,
                    CustomColors.OPAQUE,
                    CustomColors.ORANGEISH,
                    CustomColors.REDDISH
                )
            )
        );
    }

}