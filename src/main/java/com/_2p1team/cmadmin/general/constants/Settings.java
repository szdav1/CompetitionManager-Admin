package com._2p1team.cmadmin.general.constants;

import com._2p1team.cmadmin.general.io.SettingsReader;

import java.util.Map;

public final class Settings {

    private static boolean initialized = false;
    private static Map<String, String> settingsMap;

    public static void initialize() {
        if (initialized)
            return;

        settingsMap = new SettingsReader().readSettings();
        initialized = true;
    }

    public static String get(final String key) {
        return settingsMap.getOrDefault(key, "");
    }

}