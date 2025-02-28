package com._2p1team.cmadmin.support;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum RemoteTestServerHttpData {
    IP("192.168.1.101"),
    PORT(":8080");

    private final String value;
}