package com._2p1team.cmadmin.support.constants.appearances;

import com._2p1team.cmadmin.support.constants.CustomColors;
import com._2p1team.cmadmin.swing.override.graphics.Appearance;
import com._2p1team.cmadmin.swing.override.graphics.configs.BackgroundConfiguration;
import com._2p1team.cmadmin.swing.override.graphics.configs.SimplePaintConfiguration;

public final class MainPanelAppearance extends Appearance {
    public MainPanelAppearance() {
        this.setBackgroundConfiguration(new BackgroundConfiguration(new SimplePaintConfiguration(CustomColors.OPAQUE)));
    }
}