package com._2p1team.cmadmin.general.constants.appearances;

import com._2p1team.cmadmin.general.util.DirectIconSize;
import com._2p1team.cmadmin.general.util.Util;
import com._2p1team.cmadmin.swing.override.graphics.configs.IconSet;

public final class DeleteButtonAppearance extends BaseButtonAppearance {

    public DeleteButtonAppearance() {
        super();
        this.setIconSet(new IconSet(Util.loadImageIcon("/assets/deleteIcon2.png", DirectIconSize.sizeByFrame(2, 3)), Util.loadImageIcon("/assets/deleteIcon.png", DirectIconSize.sizeByFrame(2, 3))));
    }

}