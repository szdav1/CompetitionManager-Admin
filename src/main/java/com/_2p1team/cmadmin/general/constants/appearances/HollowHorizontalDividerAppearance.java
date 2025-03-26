package com._2p1team.cmadmin.general.constants.appearances;

import static com._2p1team.cmadmin.general.constants.CustomColors.*;
import com._2p1team.cmadmin.swing.override.graphics.Appearance;
import com._2p1team.cmadmin.swing.override.graphics.configs.BackgroundConfiguration;
import com._2p1team.cmadmin.swing.override.graphics.configs.LinearGradientPaintConfiguration;

public final class HollowHorizontalDividerAppearance extends Appearance {

    public HollowHorizontalDividerAppearance() {
        this.setBackgroundConfiguration(new BackgroundConfiguration(
            new LinearGradientPaintConfiguration(OPAQUE, MAIN_COLOR_1, MAIN_COLOR_2, OPAQUE))
        );

    }

}