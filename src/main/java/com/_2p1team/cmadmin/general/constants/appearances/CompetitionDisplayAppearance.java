package com._2p1team.cmadmin.general.constants.appearances;

import com._2p1team.cmadmin.general.constants.AppearanceConstants;
import com._2p1team.cmadmin.general.constants.CustomColors;
import com._2p1team.cmadmin.swing.override.graphics.Appearance;
import com._2p1team.cmadmin.swing.override.graphics.configs.BackgroundConfiguration;
import com._2p1team.cmadmin.swing.override.graphics.configs.SimplePaintConfiguration;

public final class CompetitionDisplayAppearance extends Appearance {

    public CompetitionDisplayAppearance() {
        this.setBackgroundConfiguration(new BackgroundConfiguration(new SimplePaintConfiguration(CustomColors.OPAQUE)));
        this.setBorderConfiguration(AppearanceConstants.BASE_BORDER_CONFIGURATION);
    }

}