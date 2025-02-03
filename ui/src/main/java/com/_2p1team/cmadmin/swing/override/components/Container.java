package com._2p1team.cmadmin.swing.override.components;

import com._2p1team.cmadmin.swing.override.constants.Position;

import javax.swing.JComponent;

public interface Container {

    void addComponent(final JComponent component, final Position position);

    void addComponent(final JComponent component);

    JComponent removeComponent(final JComponent component);

}