package com._2p1team.cmadmin.support.constants.appearances;

import com._2p1team.cmadmin.support.constants.CustomColors;
import com._2p1team.cmadmin.swing.override.graphics.Appearance;
import com._2p1team.cmadmin.swing.override.graphics.configs.BackgroundConfiguration;
import com._2p1team.cmadmin.swing.override.graphics.configs.FontSet;
import com._2p1team.cmadmin.swing.override.graphics.configs.ForegroundConfiguration;
import com._2p1team.cmadmin.swing.override.graphics.configs.SimplePaintConfiguration;

import java.awt.Color;
import java.awt.Font;

public final class IconifyButtonAppearance extends Appearance {

    public IconifyButtonAppearance() {
        this.enableInteractivity();
        this.setBackgroundConfiguration(new BackgroundConfiguration(new SimplePaintConfiguration(CustomColors.OPAQUE)));
        this.setForegroundConfiguration(new ForegroundConfiguration(Color.white, Color.darkGray));
        this.setFontSet(new FontSet(new Font(FontSet.SYSTEM_FONT.getFamily(), Font.BOLD, FontSet.SYSTEM_FONT.getSize())));
    }

}