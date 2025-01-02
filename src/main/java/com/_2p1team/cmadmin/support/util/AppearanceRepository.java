package com._2p1team.cmadmin.support.util;

import com._2p1team.cmadmin.swing.override.graphics.Appearance;
import com._2p1team.cmadmin.swing.override.graphics.build.AppearanceBuilder;
import com._2p1team.cmadmin.swing.override.graphics.configs.BackgroundConfiguration;
import com._2p1team.cmadmin.swing.override.graphics.configs.ForegroundConfiguration;
import com._2p1team.cmadmin.swing.override.graphics.configs.IconSet;
import com._2p1team.cmadmin.swing.override.graphics.configs.SimplePaintConfiguration;

import java.awt.Color;

public final class AppearanceRepository {
    public static final Appearance TITLE_BAR_APPEARANCE = new AppearanceBuilder()
        .setBackgroundConfiguration(new BackgroundConfiguration(new SimplePaintConfiguration(CustomColors.TITLE_BAR_BACKGROUND)))
        .build();

    public static final Appearance EXIT_BUTTON_APPEARANCE = new AppearanceBuilder()
        .enableInteractivity()
        .setBackgroundConfiguration(new BackgroundConfiguration(new SimplePaintConfiguration(CustomColors.OPAQUE)))
        .setForegroundConfiguration(new ForegroundConfiguration(Color.gray, Color.red))
        .build();

    public static final Appearance ICONIFY_BUTTON_APPEARANCE = new AppearanceBuilder()
        .enableInteractivity()
        .setBackgroundConfiguration(new BackgroundConfiguration(new SimplePaintConfiguration(CustomColors.OPAQUE)))
        .setForegroundConfiguration(new ForegroundConfiguration(Color.gray, Color.darkGray))
        .build();

    public static final Appearance TITLE_TEXT_APPEARANCE = new AppearanceBuilder()
        .setBackgroundConfiguration(new BackgroundConfiguration(new SimplePaintConfiguration(CustomColors.OPAQUE)))
        .setForegroundConfiguration(new ForegroundConfiguration(Color.gray))
        .build();

    public static final Appearance DASHBOARD_LABEL_APPEARANCE = new AppearanceBuilder()
        .setBackgroundConfiguration(new BackgroundConfiguration(new SimplePaintConfiguration(CustomColors.OPAQUE)))
        .setForegroundConfiguration(new ForegroundConfiguration(Color.gray))
        .setIconSet(new IconSet(Util.loadImageIcon("/assets/dashboardIcon.png", 5)))
        .build();

    public static final Appearance SIDEBAR_APPEARANCE = new AppearanceBuilder()
        .setBackgroundConfiguration(new BackgroundConfiguration(new SimplePaintConfiguration(CustomColors.BACKGROUND_BLUE)))
        .build();
}