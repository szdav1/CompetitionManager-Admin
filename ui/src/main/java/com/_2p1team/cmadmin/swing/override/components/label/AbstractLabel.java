package com._2p1team.cmadmin.swing.override.components.label;

import java.awt.Dimension;
import java.awt.Rectangle;

import javax.swing.JLabel;
import javax.swing.SwingConstants;

import com._2p1team.cmadmin.apperance.Appearance;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@ToString
@Getter
@EqualsAndHashCode(callSuper = false)
public abstract class AbstractLabel extends JLabel {
  private final Appearance appearance;

  public AbstractLabel(Dimension preferredSize, String text, Appearance appearance) {
    this.appearance = appearance;

    this.setForeground(this.getAppearance().foregroundPaint().mainColor());
    this.setIcon(this.appearance.iconSet().getMainIcon());
    this.setText(text);
    this.setHorizontalAlignment(SwingConstants.CENTER);
    this.setVerticalAlignment(SwingConstants.CENTER);
    this.setBounds(new Rectangle(0, 0, preferredSize.width, preferredSize.height));
    this.setPreferredSize(preferredSize);
  }

  public AbstractLabel(Dimension preferredSize, Appearance appearance) {
    this(preferredSize, "", appearance);
  }

  public AbstractLabel(Rectangle bounds, String text, Appearance appearance) {
    this.appearance = appearance;

    this.setForeground(this.getAppearance().foregroundPaint().mainColor());
    this.setIcon(this.appearance.iconSet().getMainIcon());
    this.setText(text);
    this.setHorizontalAlignment(SwingConstants.CENTER);
    this.setVerticalAlignment(SwingConstants.CENTER);
    this.setPreferredSize(new Dimension(bounds.width, bounds.height));
    this.setBounds(new Rectangle(bounds.x, bounds.y, bounds.width, bounds.height));
  }

  public AbstractLabel(Rectangle bounds, Appearance appearance) {
    this(bounds, "", appearance);
  }
}
