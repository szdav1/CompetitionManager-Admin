package com._2p1team.cmadmin.app.control;

import com._2p1team.cmadmin.app.view.interfaces.KeyControlledComponent;
import lombok.Getter;

@Getter
public abstract class AbstractKeyController {
    private final KeyControlledComponent keyControlledComponent;

    public AbstractKeyController(final KeyControlledComponent keyControlledComponent) {
        this.keyControlledComponent = keyControlledComponent;
    }
}