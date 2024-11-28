package com._2p1team.cmadmin.swing.override.components;

import javax.swing.JComponent;

import com._2p1team.cmadmin.constants.Position;

public interface ComponentContainer {
  void addComponent(final JComponent component, Position position);
  void addComponent(final JComponent component);
  JComponent removeComponent(final JComponent component);
}