package com._2p1team.cmadmin.general.constants;

import com._2p1team.cmadmin.swing.override.graphics.configs.BorderConfiguration;
import com._2p1team.cmadmin.swing.override.graphics.configs.LinearGradientPaintConfiguration;

import java.awt.Color;

public final class AppearanceConstants {

    public static final int BORDER_RADIUS = SizeData.FRAME_WIDTH*2/100;
    public static final int SCROLL_BAR_RADIUS = SizeData.FRAME_WIDTH/100;
    public static final int PADDING = SizeData.FRAME_WIDTH/125;

    public static final Color ERROR_COLOR = new Color(220, 53, 69);

    public static final BorderConfiguration BASE_BORDER_CONFIGURATION = new BorderConfiguration(
        1,
        BORDER_RADIUS,
        new LinearGradientPaintConfiguration(
            CustomColors.MAIN_COLOR_1,
            CustomColors.OPAQUE,
            CustomColors.OPAQUE,
            CustomColors.MAIN_COLOR_2,
            CustomColors.MAIN_COLOR_1
        )
    );

    public static final BorderConfiguration BASE_BORDER_NO_ROUND_CONFIGURATION = new BorderConfiguration(
        1,
        0,
        new LinearGradientPaintConfiguration(
            CustomColors.MAIN_COLOR_2
//            CustomColors.MAIN_COLOR_2,
//            CustomColors.MAIN_COLOR_1
        )
    );

    public static final BorderConfiguration BASE_FULL_BORDER_CONFIGURATION = new BorderConfiguration(
        1,
        BORDER_RADIUS,
        new LinearGradientPaintConfiguration(
            CustomColors.MAIN_COLOR_1,
            CustomColors.MAIN_COLOR_2,
            CustomColors.MAIN_COLOR_1
        )
    );

}