package com._2p1team.cmadmin.general.constants;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum HttpConnectionSettings {
    METHOD("http://"),
    DOMAIN("localhost"),
    PORT(":8080"),
    SETUP(METHOD.value+DOMAIN.value+PORT.value);

    private final String value;
}