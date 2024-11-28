package com._2p1team.cmadmin.swing.override.components.panel;

import java.awt.*;

import javax.swing.JComponent;

import com._2p1team.cmadmin.apperance.Appearance;
import com._2p1team.cmadmin.constants.Position;
import com._2p1team.cmadmin.swing.override.ComponentGraphicsHandler;

public class Panel extends AbstractPanel {
  public Panel(Dimension preferredSize, LayoutManager layout, Appearance appearance) {
    super(preferredSize, layout, appearance);
  }

  public Panel(Dimension preferredSize, Appearance appearance) {
    super(preferredSize, appearance);
  }

  public Panel(Rectangle bounds, LayoutManager layout, Appearance appearance) {
    super(bounds, layout, appearance);
  }

  public Panel(Rectangle bounds, Appearance appearance) {
    super(bounds, appearance);
  }

  public Panel(Appearance appearance) {
    super(appearance);
  }

  @Override
  public void addComponent(final JComponent component, final Position position) {
    this.add(component, this.getLayout() instanceof BorderLayout ? position.getLayoutPosition() : position.getValue());
    this.revalidate();
  }

  @Override
  public void addComponent(final JComponent component) {
    this.addComponent(component, this.getLayout() instanceof BorderLayout ? Position.CENTER : Position.MIDDLE);
  }

  @Override
  public JComponent removeComponent(final JComponent component) {
    this.revalidate();
    this.remove(component);

    return component;
  }

  @Override
  public void paint(Graphics g) {
    Graphics2D g2 = (Graphics2D) g;
    Rectangle paintSurface = g2.getClipBounds();
    int x = paintSurface.x;
    int y = paintSurface.y;
    int width = paintSurface.width;
    int height = paintSurface.height;

    ComponentGraphicsHandler.paintBackground(g2, x, y, width, height, this.getAppearance());
    ComponentGraphicsHandler.paintBorder(g2, x, y, width, height, this.getAppearance());
    g2.dispose();
  }
}