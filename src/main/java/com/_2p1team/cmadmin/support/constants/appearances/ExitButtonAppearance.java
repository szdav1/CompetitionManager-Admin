package com._2p1team.cmadmin.support.constants.appearances;

import com._2p1team.cmadmin.support.constants.AppearanceConstants;
import com._2p1team.cmadmin.support.constants.CustomColors;
import com._2p1team.cmadmin.swing.override.graphics.Appearance;
import com._2p1team.cmadmin.swing.override.graphics.configs.*;

import java.awt.Color;
import java.awt.Font;

public final class ExitButtonAppearance extends Appearance {

    public ExitButtonAppearance() {
        this.enableInteractivity();
        this.setBackgroundConfiguration(new BackgroundConfiguration(
            new SimplePaintConfiguration(CustomColors.OPAQUE),
            new LinearGradientPaintConfiguration(CustomColors.OPAQUE, CustomColors.OPAQUE, CustomColors.OPAQUE, CustomColors.REDDISH)
        ));

        this.setForegroundConfiguration(new ForegroundConfiguration(Color.white, CustomColors.REDDISH));
        this.setBorderConfiguration(new BorderConfiguration(0, AppearanceConstants.BORDER_RADIUS, new SimplePaintConfiguration()));
        this.setFontSet(new FontSet(new Font(FontSet.SYSTEM_FONT.getFamily(), Font.BOLD, FontSet.SYSTEM_FONT.getSize())));
    }

}