package com._2p1team.cmadmin.general.constants.appearances;

import com._2p1team.cmadmin.general.constants.CustomColors;
import com._2p1team.cmadmin.swing.override.graphics.Appearance;
import com._2p1team.cmadmin.swing.override.graphics.configs.BackgroundConfiguration;
import com._2p1team.cmadmin.swing.override.graphics.configs.LinearGradientPaintConfiguration;

public final class VerticalDividerAppearance extends Appearance {

    public VerticalDividerAppearance() {
        this.setBackgroundConfiguration(new BackgroundConfiguration(new LinearGradientPaintConfiguration(CustomColors.MAIN_COLOR_2, CustomColors.MAIN_COLOR_1)));
    }

}