package com._2p1team.cmadmin.general.constants.appearances;

import com._2p1team.cmadmin.general.constants.AppearanceConstants;
import com._2p1team.cmadmin.general.constants.CustomColors;
import com._2p1team.cmadmin.swing.override.graphics.Appearance;
import com._2p1team.cmadmin.swing.override.graphics.configs.*;

import java.awt.Color;
import java.awt.Font;

public final class IconifyButtonAppearance extends Appearance {

    public IconifyButtonAppearance() {
        this.enableInteractivity();
        this.setBackgroundConfiguration(new BackgroundConfiguration(
            new SimplePaintConfiguration(CustomColors.OPAQUE),
            new LinearGradientPaintConfiguration(CustomColors.OPAQUE, CustomColors.OPAQUE, CustomColors.OPAQUE, Color.gray)
        ));

        this.setForegroundConfiguration(new ForegroundConfiguration(Color.white, Color.darkGray));
        this.setBorderConfiguration(new BorderConfiguration(0, AppearanceConstants.BORDER_RADIUS, new SimplePaintConfiguration()));
        this.setFontSet(new FontSet(new Font(FontSet.SYSTEM_FONT.getFamily(), Font.BOLD, FontSet.SYSTEM_FONT.getSize())));
    }

}