package com._2p1team.cmadmin.swing.override.frame;

import java.awt.BorderLayout;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLayeredPane;

import lombok.EqualsAndHashCode;

/**
 * The <b>AbstractFrame</b> <i>class</i> is an extension of Swing's <b>JFrame</b> class.
 * It implements all necessary boilerplate code and changes the default content pane to a
 * layered one.
 */
@EqualsAndHashCode(callSuper = false)
public abstract class AbstractFrame extends JFrame {
  private final JLayeredPane contentPane;

  /**
   * Constructs a <code>Frame</code> with the given icon and title.
   *
   * @param icon  Type: <b>ImageIcon</b> - The icon of the frame
   * @param title Type: <b>String</b> - The title of the frame
   */
  public AbstractFrame(final ImageIcon icon, final String title) {
    this.contentPane = new JLayeredPane();

    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.setIconImage(icon == null ? null : icon.getImage());
    this.setExtendedState(JFrame.MAXIMIZED_BOTH);
    this.setContentPane(this.contentPane);
    this.setLayout(new BorderLayout());
    this.setLocationRelativeTo(null);
    this.setUndecorated(true);
    this.setTitle(title);
  }

  /**
   * Constructs a <code>Frame</code> without icon and a hardcoded title "Java Swing Frame".
   */
  public AbstractFrame() {
    this(null, "Java Swing Frame");
  }
}