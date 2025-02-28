package com._2p1team.cmadmin.support.constants.appearances;

import com._2p1team.cmadmin.swing.override.graphics.Appearance;
import com._2p1team.cmadmin.swing.override.graphics.configs.BackgroundConfiguration;
import com._2p1team.cmadmin.swing.override.graphics.configs.SimplePaintConfiguration;

import java.awt.Color;

public final class TableElementAppearance extends Appearance {

    public TableElementAppearance() {
        this.setBackgroundConfiguration(new BackgroundConfiguration(new SimplePaintConfiguration(Color.black)));
    }

}