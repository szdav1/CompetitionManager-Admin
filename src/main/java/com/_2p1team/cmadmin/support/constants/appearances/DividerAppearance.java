package com._2p1team.cmadmin.support.constants.appearances;

import static com._2p1team.cmadmin.support.constants.CustomColors.ORANGEISH;
import com._2p1team.cmadmin.swing.override.graphics.Appearance;
import com._2p1team.cmadmin.swing.override.graphics.configs.BackgroundConfiguration;
import com._2p1team.cmadmin.swing.override.graphics.configs.SimplePaintConfiguration;

public final class DividerAppearance extends Appearance {

    public DividerAppearance() {
        this.setBackgroundConfiguration(new BackgroundConfiguration(new SimplePaintConfiguration(ORANGEISH)));
    }

}