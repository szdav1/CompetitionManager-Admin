package com._2p1team.cmadmin.support.constants.appearances;

import static com._2p1team.cmadmin.support.constants.SizeData.SCREEN_HEIGHT;
import static com._2p1team.cmadmin.support.constants.SizeData.SCREEN_WIDTH;
import com._2p1team.cmadmin.support.util.Util;
import com._2p1team.cmadmin.swing.override.graphics.Appearance;
import com._2p1team.cmadmin.swing.override.graphics.configs.IconSet;

public final class BackgroundLabelAppearance extends Appearance {
    public BackgroundLabelAppearance() {
        this.setIconSet(new IconSet(Util.loadImageIcon("/assets/background2.png", SCREEN_WIDTH, SCREEN_HEIGHT)));
    }
}