package com._2p1team.cmadmin.swing.override.components;

import com._2p1team.cmadmin.swing.override.graphics.Appearance;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;

import javax.swing.JLayeredPane;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.LayoutManager;
import java.awt.Rectangle;

@Getter
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
public abstract class AbstractPanel extends JLayeredPane {
    private final Appearance appearance;

    public AbstractPanel() {
        this.appearance = new Appearance();
    }

    public AbstractPanel(Dimension preferredSize, LayoutManager layout, final Appearance appearance) {
        this.appearance = appearance;

        this.setOpaque(true);
        this.setLayout(layout);
        this.setPreferredSize(preferredSize);
        this.setBounds(new Rectangle(0, 0, preferredSize.width, preferredSize.height));
    }

    public AbstractPanel(Dimension preferredSize, final Appearance appearance) {
        this(preferredSize, new FlowLayout(), appearance);
    }

    public AbstractPanel(Rectangle bounds, LayoutManager layout, final Appearance appearance) {
        this.appearance = appearance;

        this.setOpaque(true);
        this.setLayout(layout);
        this.setBounds(bounds);
        this.setPreferredSize(new Dimension(bounds.width, bounds.height));
    }

    public AbstractPanel(Rectangle bounds, final Appearance appearance) {
        this(bounds, new FlowLayout(), appearance);
    }
}