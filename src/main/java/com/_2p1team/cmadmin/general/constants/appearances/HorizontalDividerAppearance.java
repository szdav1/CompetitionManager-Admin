package com._2p1team.cmadmin.general.constants.appearances;

import com._2p1team.cmadmin.general.constants.CustomColors;
import com._2p1team.cmadmin.swing.override.graphics.Appearance;
import com._2p1team.cmadmin.swing.override.graphics.configs.BackgroundConfiguration;
import com._2p1team.cmadmin.swing.override.graphics.configs.LinearGradientPaintConfiguration;

public final class HorizontalDividerAppearance extends Appearance {

    public HorizontalDividerAppearance() {
        this.setBackgroundConfiguration(new BackgroundConfiguration(new LinearGradientPaintConfiguration(CustomColors.MAIN_COLOR_1, CustomColors.MAIN_COLOR_2)));
    }

}