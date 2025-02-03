package com._2p1team.cmadmin.app.control;

import com._2p1team.cmadmin.app.view.interfaces.KeyControlledComponent;
import com._2p1team.cmadmin.swing.override.components.button.Button;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public abstract class AbstractKeyController {

    private final KeyControlledComponent keyControlledComponent;
    private final List<Button> controllerComponents;

    public AbstractKeyController(List<Button> controllerComponents) {
        this.keyControlledComponent = null;
        this.controllerComponents = controllerComponents;
    }

    public AbstractKeyController(final KeyControlledComponent keyControlledComponent) {
        this.keyControlledComponent = keyControlledComponent;
        this.controllerComponents = new ArrayList<>();
    }

}