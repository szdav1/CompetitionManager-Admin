package com._2p1team.cmadmin.support.settings;

public final class WindowSettings {
    public static final WindowSettingsLoader loader = new WindowSettingsLoader("/settings/Settings.json");

    public static int getWindowWidth() {
        if (loader.getWindowSettings().has("width"))
            return loader.getWindowSettings()
                .getInt("width");
        else
            return 1920;
    }

    public static int getWindowHeight() {
        if (loader.getWindowSettings().has("height"))
            return loader.getWindowSettings()
                .getInt("height");
        else
            return 1080;
    }

    public static String getWindowSize() {
        if (loader.getWindowSettings().has("size"))
            return loader.getWindowSettings()
                .getString("size");
        else
            return "";
    }
}