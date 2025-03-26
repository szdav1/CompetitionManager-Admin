package com._2p1team.cmadmin.general.constants;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum IOData {
    SETTINGS_PATH("/settings/Settings.json"),
    LANGUAGE_PATH("/settings/");

    private final String data;
}