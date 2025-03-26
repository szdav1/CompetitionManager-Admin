package com._2p1team.cmadmin.general.constants;

import com._2p1team.cmadmin.general.io.LanguageReader;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;

import java.util.Map;

@AllArgsConstructor(access=AccessLevel.NONE)
public final class Language {

    private static boolean initialized = false;
    private static Map<String, String> languageMap;

    public static void initialize(final String language) {
        if (initialized)
            return;

        languageMap = new LanguageReader().read(language);
        initialized = true;
    }

    public static String get(final String key) {
        return languageMap.getOrDefault(key, "Lookup failed");
    }

}