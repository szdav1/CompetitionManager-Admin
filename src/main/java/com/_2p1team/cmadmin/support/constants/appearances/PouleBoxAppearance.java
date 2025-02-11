package com._2p1team.cmadmin.support.constants.appearances;

import com._2p1team.cmadmin.support.constants.CustomColors;
import com._2p1team.cmadmin.swing.override.graphics.Appearance;
import com._2p1team.cmadmin.swing.override.graphics.configs.BackgroundConfiguration;
import com._2p1team.cmadmin.swing.override.graphics.configs.BorderConfiguration;
import com._2p1team.cmadmin.swing.override.graphics.configs.ForegroundConfiguration;
import com._2p1team.cmadmin.swing.override.graphics.configs.SimplePaintConfiguration;

import java.awt.Color;

public final class PouleBoxAppearance extends Appearance {

    public PouleBoxAppearance() {
        this.enableInteractivity();
        this.setBackgroundConfiguration(new BackgroundConfiguration(new SimplePaintConfiguration(Color.black), new SimplePaintConfiguration(Color.gray)));
        this.setForegroundConfiguration(new ForegroundConfiguration(Color.white));
        this.setBorderConfiguration(new BorderConfiguration(1, new SimplePaintConfiguration(CustomColors.ORANGEISH)));
    }

}