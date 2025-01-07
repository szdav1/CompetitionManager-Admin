package com._2p1team.cmadmin.support.util;

import static com._2p1team.cmadmin.support.constants.SizeData.SCREEN_HEIGHT;
import static com._2p1team.cmadmin.support.constants.SizeData.SCREEN_WIDTH;
import com._2p1team.cmadmin.swing.override.graphics.Appearance;
import com._2p1team.cmadmin.swing.override.graphics.build.AppearanceBuilder;
import com._2p1team.cmadmin.swing.override.graphics.configs.*;

import java.awt.Color;

public final class AppearanceRepository {
    public static final Appearance TITLE_BAR_APPEARANCE = new AppearanceBuilder()
        .setBackgroundConfiguration(new BackgroundConfiguration(new SimplePaintConfiguration(Color.black)))
        .build();

    public static final Appearance EXIT_BUTTON_APPEARANCE = new AppearanceBuilder()
        .enableInteractivity()
        .setBackgroundConfiguration(new BackgroundConfiguration(new SimplePaintConfiguration(CustomColors.OPAQUE)))
        .setForegroundConfiguration(new ForegroundConfiguration(Color.white, Color.red))
        .build();

    public static final Appearance ICONIFY_BUTTON_APPEARANCE = new AppearanceBuilder()
        .enableInteractivity()
        .setBackgroundConfiguration(new BackgroundConfiguration(new SimplePaintConfiguration(CustomColors.OPAQUE)))
        .setForegroundConfiguration(new ForegroundConfiguration(Color.white, Color.darkGray))
        .build();

    public static final Appearance TITLE_TEXT_APPEARANCE = new AppearanceBuilder()
        .setBackgroundConfiguration(new BackgroundConfiguration(new SimplePaintConfiguration(CustomColors.OPAQUE)))
        .setForegroundConfiguration(new ForegroundConfiguration(Color.darkGray))
        .build();

    public static final Appearance CENTER_PANEL_APPEARANCE = new AppearanceBuilder()
        .setBackgroundConfiguration(new BackgroundConfiguration(new SimplePaintConfiguration(Color.black)))
        .setIconSet(new IconSet(Util.loadImageIcon("/assets/background-temp.jpg", SCREEN_WIDTH, SCREEN_HEIGHT)))
        .build();

    public static final Appearance FILE_MENU_BUTTON_APPEARANCE = new AppearanceBuilder()
        .enableInteractivity()
        .setBackgroundConfiguration(new BackgroundConfiguration(new SimplePaintConfiguration(CustomColors.OPAQUE)))
        .setForegroundConfiguration(new ForegroundConfiguration(Color.white, Color.darkGray))
        .setIconSet(new IconSet(Util.loadImageIcon("/assets/fileIcon.png", 4)))
        .build();

    public static final Appearance DATABASE_MENU_BUTTON_APPEARANCE = new AppearanceBuilder()
        .enableInteractivity()
        .setBackgroundConfiguration(new BackgroundConfiguration(new SimplePaintConfiguration(CustomColors.OPAQUE)))
        .setForegroundConfiguration(new ForegroundConfiguration(Color.white, Color.darkGray))
        .setIconSet(new IconSet(Util.loadImageIcon("/assets/databaseIcon.png", 4)))
        .build();

    public static final Appearance SETTINGS_MENU_BUTTON_APPEARANCE = new AppearanceBuilder()
        .enableInteractivity()
        .setBackgroundConfiguration(new BackgroundConfiguration(new SimplePaintConfiguration(CustomColors.OPAQUE)))
        .setForegroundConfiguration(new ForegroundConfiguration(Color.white, Color.darkGray))
        .setIconSet(new IconSet(Util.loadImageIcon("/assets/settingsIcon.png", 4)))
        .build();

    public static final Appearance DROPDOWN_APPEARANCE = new AppearanceBuilder()
        .setBackgroundConfiguration(new BackgroundConfiguration(new SimplePaintConfiguration(Color.black)))
        .setBorderConfiguration(new BorderConfiguration(1, new LinearGradientPaintConfiguration(Color.red, Color.pink)))
        .build();
}