package com._2p1team.cmadmin.general.constants.appearances;

import com._2p1team.cmadmin.general.util.DirectIconSize;
import com._2p1team.cmadmin.general.util.Util;
import com._2p1team.cmadmin.swing.override.graphics.configs.IconSet;

public final class CompetitionButtonAppearance extends BaseButtonAppearance{

    public CompetitionButtonAppearance() {
        super();
        this.setIconSet(new IconSet(Util.loadImageIcon("/assets/competitionIcon2.png", DirectIconSize.sizeByFrame(2, 3)), Util.loadImageIcon("/assets/competitionIcon.png", DirectIconSize.sizeByFrame(2, 3))));
    }

}