package com._2p1team.cmadmin.general.constants.appearances;

import com._2p1team.cmadmin.general.constants.AppearanceConstants;
import com._2p1team.cmadmin.swing.override.graphics.Appearance;
import com._2p1team.cmadmin.swing.override.graphics.configs.BackgroundConfiguration;
import com._2p1team.cmadmin.swing.override.graphics.configs.SimplePaintConfiguration;

import java.awt.Color;

public final class CompetitionPanelAppearance extends Appearance {

    public CompetitionPanelAppearance() {
        this.setBackgroundConfiguration(new BackgroundConfiguration(new SimplePaintConfiguration(Color.black)));
        this.setBorderConfiguration(AppearanceConstants.BASE_FULL_BORDER_CONFIGURATION);
    }

}