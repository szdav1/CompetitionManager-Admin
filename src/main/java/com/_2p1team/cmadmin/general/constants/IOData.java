package com._2p1team.cmadmin.general.constants;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum IOData {
    SETTINGS_PATH("/settings/LanguageSettings.json"),
    LANGUAGE_PATH("/languages/");

    private final String data;
}