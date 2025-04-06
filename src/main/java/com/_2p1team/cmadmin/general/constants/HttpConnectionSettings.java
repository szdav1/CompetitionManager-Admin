package com._2p1team.cmadmin.general.constants;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum HttpConnectionSettings {
    METHOD(HttpSettings.get("method")),
    DOMAIN(HttpSettings.get("domain")),
    PORT(HttpSettings.get("port")),
    SETUP(METHOD.value+"://"+DOMAIN.value+":"+PORT.value);

    private final String value;
}