package com._2p1team.cmadmin.app.control;

import com._2p1team.cmadmin.app.view.interfaces.KeyControlComponent;
import lombok.Getter;

@Getter
public abstract class AbstractKeyController {
    private final KeyControlComponent keyControlComponent;

    public AbstractKeyController(final KeyControlComponent keyControlComponent) {
        this.keyControlComponent = keyControlComponent;
    }
}