package com._2p1team.cmadmin.apperance;

import lombok.Data;

import java.awt.Color;

@Data
public final class BorderPaint {
  private final int thickness;
  private final int arcWidth;
  private final int arcHeight;
  private final BackgroundPaint paint;

  public BorderPaint(int thickness, int arcWidth, int arcHeight, Color... colors) {
    this.thickness = thickness;
    this.arcWidth = arcWidth;
    this.arcHeight = arcHeight;
    this.paint = new BackgroundPaint(colors);
  }

  public BorderPaint(int thickness, int arc, Color... colors) {
    this(thickness, arc, arc, colors);
  }

  public BorderPaint(int thickness, Color... colors) {
    this(thickness, 0, 0, colors);
  }

  public BorderPaint() {
    this(0, 0, 0, Color.black, Color.black);
  }
}