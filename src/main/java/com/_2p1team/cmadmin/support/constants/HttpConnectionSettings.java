package com._2p1team.cmadmin.support.constants;

import com._2p1team.cmadmin.support.RemoteTestServerHttpData;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum HttpConnectionSettings {
    METHOD("http://"),
    DOMAIN(RemoteTestServerHttpData.IP.getValue()),
    PORT(RemoteTestServerHttpData.PORT.getValue()),
    SETUP(METHOD.value+DOMAIN.value+PORT.value);

    private final String value;
}