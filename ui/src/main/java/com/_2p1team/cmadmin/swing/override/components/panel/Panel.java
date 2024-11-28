package com._2p1team.cmadmin.swing.override.components.panel;

import java.awt.*;

import javax.swing.JComponent;

import com._2p1team.cmadmin.apperance.Appearance;
import com._2p1team.cmadmin.constants.Position;

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
  public Appearance getAppearance() {
    return this.appearance;
  }

  @Override
  public void paintBackground(final Graphics2D g2, int x, int y, int width, int height) {
    g2.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
    g2.setPaint(this.appearance.backgroundPaint().createPaint(x, y, width, height));
    g2.fillRoundRect(x, y, width, height, this.appearance.borderPaint().getArcWidth(), this.appearance.borderPaint().getArcHeight());
  }

  @Override
  public void paintBorder(Graphics2D g2, int x, int y, int width, int height) {
    if (this.appearance.borderPaint().getThickness() <= 0)
      return;

    g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
    g2.setPaint(this.appearance.borderPaint().getPaint().createPaint(x, y, width, height));
    g2.setStroke(new BasicStroke(this.appearance.borderPaint().getThickness()));
    g2.drawRoundRect(x, y, width, height, this.appearance.borderPaint().getArcWidth(), this.appearance.borderPaint().getArcHeight());
  }

  @Override
  public void paint(Graphics g) {
    Graphics2D g2 = (Graphics2D) g;
    Rectangle paintSurface = g2.getClipBounds();
    int x = paintSurface.x;
    int y = paintSurface.y;
    int width = paintSurface.width;
    int height = paintSurface.height;

    this.paintBackground(g2, x, y, width, height);
    this.paintBorder(g2, x, y, width, height);
    g2.dispose();
  }
}