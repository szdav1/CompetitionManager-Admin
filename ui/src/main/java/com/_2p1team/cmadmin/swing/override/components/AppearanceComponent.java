package com._2p1team.cmadmin.swing.override.components;

import com._2p1team.cmadmin.swing.override.graphics.Appearance;

import java.awt.event.MouseListener;

public interface AppearanceComponent extends MouseListener {

    Appearance getComponentAppearance();

}