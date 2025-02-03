package com._2p1team.cmadmin.support.constants.appearances;

import com._2p1team.cmadmin.support.constants.CustomColors;
import com._2p1team.cmadmin.swing.override.graphics.Appearance;
import com._2p1team.cmadmin.swing.override.graphics.configs.BackgroundConfiguration;
import com._2p1team.cmadmin.swing.override.graphics.configs.ForegroundConfiguration;
import com._2p1team.cmadmin.swing.override.graphics.configs.SimplePaintConfiguration;

import java.awt.Color;

public final class ExitConfirmLabelAppearance extends Appearance {

    public ExitConfirmLabelAppearance() {
        this.setBackgroundConfiguration(new BackgroundConfiguration(new SimplePaintConfiguration(CustomColors.OPAQUE)));
        this.setForegroundConfiguration(new ForegroundConfiguration(Color.white));
    }

}