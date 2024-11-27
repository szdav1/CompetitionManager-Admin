package com._2p1team.cmadmin.apperance;

/**
 * The <b>Appearance</b> <i>record</i> stores behavioural and display
 * data for components. These data are processed inside the <b>swing.override</b>
 * package's components inside their <b>paint()</b> method. This way making custom
 * looking components is much easier and faster.
 *
 * @param backgroundPaint Type: <b>BackgroundPaint</b> - Defines the color(s) of the background
 * @param foregroundPaint Type <b>ForegroundPaint</b> - Defines the color(s) of the foreground
 * @param iconSet         Type: <b>IconSet</b> - Defines the icon(s) displayed by certain components
 * @param borderPaint     Type: <b>BorderPaint</b> - Defines the color(s), thickness and edge roundness of the border
 */
public record Appearance(BackgroundPaint backgroundPaint, ForegroundPaint foregroundPaint, IconSet iconSet, BorderPaint borderPaint) {
  /**
   * Constructs an <b>Appearance</b> with the given <b>BackgroundPaint</b> and <b>BorderPaint</b> while
   * initializing the <b>ForegroundPaint</b> and the <b>IconSet</b> with empty constructor calls.
   *
   * @param backgroundPaint Type: <b>BackgroundPaint</b> - Defines the color(s) of the background
   * @param borderPaint     Type: <b>BorderPaint</b> - Defines the color(s), thickness and edge roundness of the border
   */
  public Appearance(BackgroundPaint backgroundPaint, BorderPaint borderPaint) {
    this(backgroundPaint, new ForegroundPaint(), new IconSet(), borderPaint);
  }

  /**
   * Initializes an empty <b>Appearance</b> object while avoiding the fields being null.
   */
  public Appearance() {
    this(new BackgroundPaint(), new ForegroundPaint(), new IconSet(), new BorderPaint());
  }
}