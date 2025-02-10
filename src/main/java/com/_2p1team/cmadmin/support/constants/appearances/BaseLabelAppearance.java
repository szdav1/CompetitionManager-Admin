package com._2p1team.cmadmin.support.constants.appearances;

import com._2p1team.cmadmin.support.constants.AppearanceConstants;
import com._2p1team.cmadmin.swing.override.graphics.Appearance;
import com._2p1team.cmadmin.swing.override.graphics.configs.BackgroundConfiguration;
import com._2p1team.cmadmin.swing.override.graphics.configs.SimplePaintConfiguration;

import java.awt.Color;

public final class BaseLabelAppearance extends Appearance {

    public BaseLabelAppearance() {
        this.setBackgroundConfiguration(new BackgroundConfiguration(new SimplePaintConfiguration(Color.black)));
        this.setBorderConfiguration(AppearanceConstants.BASE_BORDER_CONFIGURATION);
    }

}