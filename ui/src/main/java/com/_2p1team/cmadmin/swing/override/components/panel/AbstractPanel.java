package com._2p1team.cmadmin.swing.override.components.panel;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.LayoutManager;
import java.awt.Rectangle;

import javax.swing.JLayeredPane;

import com._2p1team.cmadmin.apperance.Appearance;
import com._2p1team.cmadmin.swing.override.components.ComponentContainer;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@ToString
@Getter
@EqualsAndHashCode(callSuper = false)
public abstract class AbstractPanel extends JLayeredPane implements ComponentContainer {
  private final Appearance appearance;

  public AbstractPanel(Dimension preferredSize, LayoutManager layout, Appearance appearance) {
    this.appearance = appearance;

    this.setPreferredSize(preferredSize);
    this.setBounds(new Rectangle(0, 0, preferredSize.width, preferredSize.height));
    this.setLayout(layout);
    this.setOpaque(true);
  }

  public AbstractPanel(Dimension preferredSize, Appearance appearance) {
    this(preferredSize, new FlowLayout(), appearance);
  }

  public AbstractPanel(Rectangle bounds, LayoutManager layout, Appearance appearance) {
    this.appearance = appearance;

    this.setBounds(new Rectangle(bounds.x, bounds.y, bounds.width, bounds.height));
    this.setPreferredSize(new Dimension(bounds.width, bounds.height));
    this.setLayout(layout);
    this.setOpaque(true);
  }

  public AbstractPanel(Rectangle bounds, Appearance appearance) {
    this(bounds, new FlowLayout(), appearance);
  }

  public AbstractPanel(Appearance appearance) {
    this(new Dimension(250, 250), appearance);
  }
}