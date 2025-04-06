package com._2p1team.cmadmin.general.constants;

import com._2p1team.cmadmin.general.io.HttpSettingsReader;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;

import java.util.Map;

@AllArgsConstructor(access=AccessLevel.NONE)

public final class HttpSettings {

    private static boolean initialized = false;
    private static Map<String, String> httpSettingsMap;

    public static void initialize() {
        if (initialized)
            return;

        httpSettingsMap = new HttpSettingsReader().readHttpSettings();
        initialized = true;
    }

    public static String get(final String key) {
        return httpSettingsMap.getOrDefault(key, "");
    }

}