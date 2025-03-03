package com._2p1team.cmadmin.swing.override.frame;

import com._2p1team.cmadmin.swing.override.components.Container;
import com._2p1team.cmadmin.swing.override.components.panel.Panel;
import lombok.Getter;
import lombok.ToString;

import javax.swing.JFrame;
import java.awt.BorderLayout;
import java.awt.Image;

@Getter
@ToString
public abstract class AbstractFrame extends JFrame implements Container {

    private final Panel contentPanel;

    public AbstractFrame(final Image iconImage, final String title) {
        this.contentPanel = new Panel();

        this.setUpFrame(iconImage, title);
    }

    private void setUpFrame(final Image iconImage, final String title) {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setIconImage(iconImage);
        this.setTitle(title);
        this.setContentPane(this.contentPanel);
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        this.setLocationRelativeTo(null);
        this.setUndecorated(true);
        this.setLayout(new BorderLayout());
    }

}