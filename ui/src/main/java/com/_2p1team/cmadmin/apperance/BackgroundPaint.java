// TODO: Create separate paint for buttons
package com._2p1team.cmadmin.apperance;

import java.awt.Color;
import java.awt.LinearGradientPaint;
import java.util.Arrays;

import lombok.Data;

/**
 * The <b>BackgroundPaint</b> <i>class</i> stores behavioural and display information for
 * the background. This manifests in a <b>LinearGradientPaint</b> which is constructed
 * automatically in a way that the passed in colors are going to fill the surface in
 * equal fractions. For easier use, it also decides the paint mode of the background.
 * If only 1 color is passed into the constructor, the paint mode is going to be
 * "<b>SINGLE</b>", which tells the implementing component not to use a gradient paint
 * during rendering, otherwise the paint mode is "<b>MULTI</b>", which does to opposite.
 * If a no args constructor call was made, the paint mode will be "<b>UNDEFINED</b>".
 */
@Data
public final class BackgroundPaint {
  private final float[] fractions;
  private final Color[] colors;
  private LinearGradientPaint paint;

  /**
   * Constructs a <b>BackgroundPaint</b> object with the given parameters.
   *
   * @param colors Type: <b>Color[]</b> - The desired colors for the linear paint
   */
  public BackgroundPaint(Color... colors) {
    this.fractions = new float[colors.length];
    this.colors = colors;
    float unit = 1.0f/colors.length;

    for (int i = 0; i < colors.length; i++) {
      fractions[i] = unit*i;
    }
    if (colors.length >= 2)
      fractions[fractions.length-1] = (float) Math.ceil(fractions[fractions.length-1]);
  }

  /**
   * Initializes an empty <b>BackgroundPaint</b> object with the paint being plain black.
   */
  public BackgroundPaint() {
    this.fractions = new float[]{0.0f, 1.0f};
    this.colors = new Color[]{Color.black, Color.black};
    this.paint = new LinearGradientPaint(0, 0, 100, 100, this.fractions, this.colors);
  }

  public LinearGradientPaint createPaint(int startX, int startY, int endX, int endY) {
    if (colors.length >= 2)
      this.paint = new LinearGradientPaint(startX, startY, endX, endY, this.fractions, this.colors);

    return this.paint;
  }
}