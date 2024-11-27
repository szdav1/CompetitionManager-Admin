package com._2p1team.cmadmin.apperance;

public record BorderPaint(BackgroundPaint paint, int thickness, int arcWidth, int arcHeight) {
  public BorderPaint(BackgroundPaint backgroundPaint, int thickness) {
    this(backgroundPaint, thickness, 0, 0);
  }

  public BorderPaint() {
    this(new BackgroundPaint(), 0, 0, 0);
  }
}
