package com._2p1team.cmadmin.app.view.components.fencing.poule;

import com._2p1team.cmadmin.support.util.AppearanceRepository;
import com._2p1team.cmadmin.swing.override.components.text.field.TextField;
import com._2p1team.cmadmin.swing.override.graphics.Appearance;

import java.awt.Rectangle;

public final class Box extends TextField {

    public Box(int x, int y, int width, int height, String text) {
        super(new Rectangle(x, y, width, height), text, new Appearance(AppearanceRepository.POULE_BOX_APPEARANCE));
    }

}