package com._2p1team.cmadmin.general.constants.appearances;

import com._2p1team.cmadmin.general.constants.CustomColors;
import com._2p1team.cmadmin.general.util.DirectIconSize;
import com._2p1team.cmadmin.general.util.Util;
import com._2p1team.cmadmin.swing.override.graphics.Appearance;
import com._2p1team.cmadmin.swing.override.graphics.configs.BackgroundConfiguration;
import com._2p1team.cmadmin.swing.override.graphics.configs.IconSet;
import com._2p1team.cmadmin.swing.override.graphics.configs.SimplePaintConfiguration;

public final class ErrorLabelAppearance extends Appearance {

    public ErrorLabelAppearance() {
        this.setBackgroundConfiguration(new BackgroundConfiguration(new SimplePaintConfiguration(CustomColors.OPAQUE)));
        this.setIconSet(new IconSet(Util.loadImageIcon("/assets/errorIcon.png", DirectIconSize.sizeByFrame(6, 9))));
    }

}