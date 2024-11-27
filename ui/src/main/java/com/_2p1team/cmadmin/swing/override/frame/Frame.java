package com._2p1team.cmadmin.swing.override.frame;

import javax.swing.ImageIcon;

/**
 * The <b>Frame</b> <i>class</i> extends the <b>AbstractFrame</b> making the
 * implemented boilerplate code usable.
 */
public final class Frame extends AbstractFrame {
  /**
   * Constructs a <code>Frame</code> with the given icon and title.
   *
   * @param icon  Type: <b>ImageIcon</b> - The icon of the frame
   * @param title Type: <b>String</b> - The title of the frame
   */
  public Frame(ImageIcon icon, String title) {
    super(icon, title);
  }

  /**
   * Constructs a <code>Frame</code> without icon and a hardcoded title "Java Swing Frame".
   */
  public Frame() {
  }
}