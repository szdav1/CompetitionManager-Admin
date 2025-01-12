package com._2p1team.cmadmin.support.constants.appearances;

import com._2p1team.cmadmin.support.constants.AppearanceConstants;
import com._2p1team.cmadmin.support.constants.CustomColors;
import com._2p1team.cmadmin.swing.override.graphics.Appearance;
import com._2p1team.cmadmin.swing.override.graphics.configs.BackgroundConfiguration;
import com._2p1team.cmadmin.swing.override.graphics.configs.BorderConfiguration;
import com._2p1team.cmadmin.swing.override.graphics.configs.LinearGradientPaintConfiguration;
import com._2p1team.cmadmin.swing.override.graphics.configs.SimplePaintConfiguration;

import java.awt.Color;

public final class DropdownAppearance extends Appearance {
    public DropdownAppearance() {
        this.setBackgroundConfiguration(new BackgroundConfiguration(new SimplePaintConfiguration(Color.black)));
        this.setBorderConfiguration(new BorderConfiguration(1, AppearanceConstants.BORDER_RADIUS, new LinearGradientPaintConfiguration(CustomColors.REDDISH, CustomColors.OPAQUE, CustomColors.OPAQUE, CustomColors.ORANGEISH, CustomColors.REDDISH)));
    }
}