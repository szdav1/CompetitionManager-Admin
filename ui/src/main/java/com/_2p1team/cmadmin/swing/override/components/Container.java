package com._2p1team.cmadmin.swing.override.components;

import javax.swing.JComponent;

import com._2p1team.cmadmin.swing.override.constants.Position;

public interface Container {
    void addComponent(final JComponent component, final Position position);
    void addComponent(final JComponent component);
    JComponent removeComponent(final JComponent component);
}