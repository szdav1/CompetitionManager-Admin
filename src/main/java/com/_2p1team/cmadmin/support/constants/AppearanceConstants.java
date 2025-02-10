package com._2p1team.cmadmin.support.constants;

import com._2p1team.cmadmin.swing.override.graphics.configs.BorderConfiguration;
import com._2p1team.cmadmin.swing.override.graphics.configs.LinearGradientPaintConfiguration;

public final class AppearanceConstants {

    public static final int BORDER_RADIUS = SizeData.FRAME_WIDTH*2/100;
    public static final int SCROLL_BAR_RADIUS = SizeData.FRAME_WIDTH/100;
    public static final int PADDING = SizeData.FRAME_WIDTH/125;

    public static final BorderConfiguration BASE_BORDER_CONFIGURATION = new BorderConfiguration(
        1,
        new LinearGradientPaintConfiguration(
            CustomColors.REDDISH,
            CustomColors.OPAQUE,
            CustomColors.OPAQUE,
            CustomColors.ORANGEISH,
            CustomColors.REDDISH
        )
    );

    public static final BorderConfiguration BASE_FULL_BORDER_CONFIGURATION = new BorderConfiguration(
        1,
        new LinearGradientPaintConfiguration(
            CustomColors.REDDISH,
            CustomColors.ORANGEISH,
            CustomColors.REDDISH
        )
    );

}