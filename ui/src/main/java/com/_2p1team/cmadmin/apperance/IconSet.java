package com._2p1team.cmadmin.apperance;

import javax.swing.ImageIcon;

/**
 * The <b>IconSet</b> <i>record</i> stores icons for certain components.
 * It stores a main and a secondary icon.
 *
 * @param mainIcon      Type: <b>ImageIcon</b> - The main icon of a component
 * @param secondaryIcon Type: <b>ImageIcon</b> - The secondary icon of a component
 */
public record IconSet(ImageIcon mainIcon, ImageIcon secondaryIcon) {
  public IconSet(ImageIcon icon) {
    this(icon, icon);
  }

  /**
   * Initializes an empty <b>IconSet</b> object while avoiding the fields being null.
   */
  public IconSet() {
    this(new ImageIcon(), new ImageIcon());
  }
}