package com._2p1team.cmadmin.support.constants.appearances;

import com._2p1team.cmadmin.support.constants.AppearanceConstants;
import com._2p1team.cmadmin.support.constants.CustomColors;
import com._2p1team.cmadmin.swing.override.graphics.Appearance;
import com._2p1team.cmadmin.swing.override.graphics.configs.BackgroundConfiguration;
import com._2p1team.cmadmin.swing.override.graphics.configs.BorderConfiguration;
import com._2p1team.cmadmin.swing.override.graphics.configs.SimplePaintConfiguration;

public final class TablePanelAppearance extends Appearance {

    public TablePanelAppearance() {
        this.setBackgroundConfiguration(new BackgroundConfiguration(new SimplePaintConfiguration(CustomColors.OPAQUE)));
        this.setBorderConfiguration(new BorderConfiguration(0, AppearanceConstants.BORDER_RADIUS, new SimplePaintConfiguration()));
    }

}