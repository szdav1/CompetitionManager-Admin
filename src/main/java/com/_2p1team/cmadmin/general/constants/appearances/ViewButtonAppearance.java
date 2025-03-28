package com._2p1team.cmadmin.general.constants.appearances;

import com._2p1team.cmadmin.general.util.DirectIconSize;
import com._2p1team.cmadmin.general.util.Util;
import com._2p1team.cmadmin.swing.override.graphics.configs.IconSet;

public final class ViewButtonAppearance extends BaseButtonAppearance {

    public ViewButtonAppearance() {
        super();
        this.setIconSet(new IconSet(Util.loadImageIcon("/assets/viewIcon2.png", DirectIconSize.sizeByFrame(2, 2)), Util.loadImageIcon("/assets/viewIcon.png", DirectIconSize.sizeByFrame(2, 2))));
    }

}