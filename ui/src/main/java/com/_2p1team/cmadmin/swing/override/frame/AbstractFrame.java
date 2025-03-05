package com._2p1team.cmadmin.swing.override.frame;

import com._2p1team.cmadmin.swing.override.components.Container;
import com._2p1team.cmadmin.swing.override.components.panel.Panel;
import lombok.Getter;
import lombok.ToString;

import javax.swing.JFrame;
import java.awt.BorderLayout;
import java.awt.Frame;
import java.awt.Image;

/**
 * The AbstractFrame class is the custom representation of Swing's
 * JFrame and awt's Frame class.
 *
 * @see Frame
 * @see JFrame
 * @see Container
 */
@Getter
@ToString
public abstract class AbstractFrame extends JFrame implements Container {

    private final Panel contentPanel;

    /**
     * Constructs a custom frame with the specified icon and title.
     * Basic frame configurations are done inside the constructor, but
     * its visibility will be false after finishing.
     *
     * @param iconImage The icon of the frame
     * @param title     The title of the frame
     */
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