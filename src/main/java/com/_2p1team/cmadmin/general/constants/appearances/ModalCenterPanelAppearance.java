package com._2p1team.cmadmin.general.constants.appearances;

import com._2p1team.cmadmin.general.constants.CustomColors;
import com._2p1team.cmadmin.swing.override.graphics.Appearance;
import com._2p1team.cmadmin.swing.override.graphics.configs.BackgroundConfiguration;
import com._2p1team.cmadmin.swing.override.graphics.configs.SimplePaintConfiguration;

public final class ModalCenterPanelAppearance extends Appearance {

    public ModalCenterPanelAppearance() {
        this.setBackgroundConfiguration(new BackgroundConfiguration(new SimplePaintConfiguration(CustomColors.OPAQUE)));
    }

}