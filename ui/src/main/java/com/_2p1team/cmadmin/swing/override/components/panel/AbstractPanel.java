package com._2p1team.cmadmin.swing.override.components.panel;

import com._2p1team.cmadmin.swing.override.components.AppearanceComponent;
import com._2p1team.cmadmin.swing.override.components.Container;
import com._2p1team.cmadmin.swing.override.graphics.Appearance;
import com._2p1team.cmadmin.swing.override.graphics.Painter;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;

import javax.swing.JLayeredPane;
import java.awt.*;

@Getter
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
public abstract class AbstractPanel extends JLayeredPane implements AppearanceComponent, Container {
    private final Appearance appearance;

    public AbstractPanel() {
        this.appearance = new Appearance();
    }

    public AbstractPanel(Dimension preferredSize, LayoutManager layout, final Appearance appearance) {
        this.appearance = appearance;

        this.setLayout(layout);
        this.setPreferredSize(preferredSize);
        this.setBounds(new Rectangle(0, 0, preferredSize.width, preferredSize.height));
        this.addMouseListener(this);
    }

    public AbstractPanel(Dimension preferredSize, final Appearance appearance) {
        this(preferredSize, new FlowLayout(), appearance);
    }

    public AbstractPanel(Rectangle bounds, LayoutManager layout, final Appearance appearance) {
        this.appearance = appearance;

        this.setLayout(layout);
        this.setBounds(bounds);
        this.setPreferredSize(new Dimension(bounds.width, bounds.height));
        this.addMouseListener(this);
    }

    public AbstractPanel(Rectangle bounds, final Appearance appearance) {
        this(bounds, new FlowLayout(), appearance);
    }

    @Override
    public void paint(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        Painter.paint(g2, this);
        super.paint(g);
        g2.dispose();
    }
}