package com._2p1team.cmadmin.app.view.components.fencing.poule;

import com._2p1team.cmadmin.support.constants.SizeData;
import com._2p1team.cmadmin.support.util.AppearanceRepository;
import com._2p1team.cmadmin.swing.override.components.label.Label;

import java.awt.Rectangle;

public final class Box extends Label {

    public Box(int x, int y, String text) {
        super(new Rectangle(x, y, SizeData.N_BUTTON_WIDTH, SizeData.BUTTON_HEIGHT), text, AppearanceRepository.BASE_BUTTON_APPEARANCE);
    }

}