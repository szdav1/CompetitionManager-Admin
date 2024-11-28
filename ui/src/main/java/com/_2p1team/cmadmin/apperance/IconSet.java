package com._2p1team.cmadmin.apperance;

import com._2p1team.cmadmin.util.ResourceHandler;

import javax.swing.ImageIcon;
import java.awt.Image;

/**
 * The <b>IconSet</b> <i>class</i> stores icons for certain components.
 * It stores a main and a secondary icon.
 */
public final class IconSet {
  private final ImageIcon mainIcon;
  private final ImageIcon secondaryIcon;

  /**
   * @param mainHints      Type: <b>IconHints</b> - The path of the main icon
   * @param secondaryHints Type: <b>IconHints</b> - The path of the secondary icon
   */
  public IconSet(final IconHints mainHints, final IconHints secondaryHints) {
    this.mainIcon = loadIcon(mainHints);
    this.secondaryIcon = loadIcon(secondaryHints);
  }

  /**
   * Initializes an empty <b>IconSet</b> object while avoiding the fields being null.
   */
  public IconSet() {
    this.mainIcon = new ImageIcon();
    this.secondaryIcon = new ImageIcon();
  }

  public static ImageIcon loadIcon(final IconHints hints) {
    return hints.width() == -1 && hints.height() == -1 ?
      new ImageIcon(ResourceHandler.getPath(hints.path())) :
      new ImageIcon(new ImageIcon(ResourceHandler.getPath(hints.path()))
        .getImage()
        .getScaledInstance(hints.width(), hints.height(), Image.SCALE_FAST)
      );
  }
}