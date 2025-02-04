package com._2p1team.cmadmin.support.constants.appearances;

import com._2p1team.cmadmin.support.constants.CustomColors;
import com._2p1team.cmadmin.support.util.DirectIconSize;
import com._2p1team.cmadmin.support.util.Util;
import com._2p1team.cmadmin.swing.override.graphics.Appearance;
import com._2p1team.cmadmin.swing.override.graphics.configs.BackgroundConfiguration;
import com._2p1team.cmadmin.swing.override.graphics.configs.IconSet;
import com._2p1team.cmadmin.swing.override.graphics.configs.SimplePaintConfiguration;

public final class HttpExceptionLabelAppearance extends Appearance {

    public HttpExceptionLabelAppearance() {
        this.setBackgroundConfiguration(new BackgroundConfiguration(new SimplePaintConfiguration(CustomColors.OPAQUE)));
        this.setIconSet(new IconSet(Util.loadImageIcon("/assets/connectionErrorIcon.png", DirectIconSize.sizeByFrame(11, 14))));
    }

}