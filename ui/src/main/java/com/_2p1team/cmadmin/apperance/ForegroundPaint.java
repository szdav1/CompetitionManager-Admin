package com._2p1team.cmadmin.apperance;

import java.awt.Color;

/**
 * The <b>ForegroundPaint</b> <i>record</i> stores the colors for the foreground
 * painting of a component. It stores a main and secondary color.
 *
 * @param mainColor      Type: <b>Color</b> - The main color for the foreground
 * @param secondaryColor Type: <b>Color</b> - The secondary color for the foreground
 */
public record ForegroundPaint(Color mainColor, Color secondaryColor) {
  public ForegroundPaint(Color color) {
    this(color, color);
  }

  /**
   * Initializes an empty <b>ForegroundPaint</b> object while avoiding the fields being null.
   */
  public ForegroundPaint() {
    this(Color.white, Color.black);
  }
}