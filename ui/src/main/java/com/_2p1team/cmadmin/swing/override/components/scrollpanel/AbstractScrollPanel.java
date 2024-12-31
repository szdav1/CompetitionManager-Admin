package com._2p1team.cmadmin.swing.override.components.scrollpanel;

import com._2p1team.cmadmin.swing.override.components.AppearanceComponent;
import com._2p1team.cmadmin.swing.override.components.Container;
import com._2p1team.cmadmin.swing.override.components.panel.Panel;
import com._2p1team.cmadmin.swing.override.components.scrollpanel.scrollbar.CustomScrollBar;
import com._2p1team.cmadmin.swing.override.graphics.Appearance;
import lombok.EqualsAndHashCode;
import lombok.Getter;

import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import java.awt.Dimension;
import java.awt.LayoutManager;
import java.awt.Rectangle;

@Getter
@EqualsAndHashCode(callSuper = false)
public abstract class AbstractScrollPanel extends JScrollPane implements Container, AppearanceComponent {
    private final Appearance appearance;
    private final Panel viewPanel;

    public AbstractScrollPanel() {
        this.appearance = new Appearance();
        this.viewPanel = new Panel(new Dimension(0, 0), null, this.appearance);

        this.setFocusable(false);
        this.setBorder(null);
        this.setViewportView(this.viewPanel);
        this.setHorizontalScrollBar(new CustomScrollBar(JScrollBar.HORIZONTAL, appearance));
        this.setVerticalScrollBar(new CustomScrollBar(JScrollBar.VERTICAL, appearance));
        this.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        this.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
    }

    public AbstractScrollPanel(Dimension preferredSize, final LayoutManager layout, final Appearance appearance) {
        this.appearance = appearance;
        this.viewPanel = new Panel(new Dimension(0, 0), layout, appearance);

        this.setFocusable(false);
        this.setBorder(null);
        this.setViewportView(this.viewPanel);
        this.setHorizontalScrollBar(new CustomScrollBar(JScrollBar.HORIZONTAL, appearance));
        this.setVerticalScrollBar(new CustomScrollBar(JScrollBar.VERTICAL, appearance));
        this.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        this.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        this.setPreferredSize(preferredSize);
        this.setBounds(new Rectangle(0, 0, preferredSize.width, preferredSize.height));
    }

    public AbstractScrollPanel(Dimension preferredSize, final Appearance appearance) {
        this(preferredSize, null, appearance);
    }

    public AbstractScrollPanel(Rectangle bounds, final LayoutManager layout, final Appearance appearance) {
        this.appearance = appearance;
        this.viewPanel = new Panel(new Dimension(0, 0), layout, appearance);

        this.setFocusable(false);
        this.setBorder(null);
        this.setViewportView(this.viewPanel);
        this.setHorizontalScrollBar(new CustomScrollBar(JScrollBar.HORIZONTAL, appearance));
        this.setVerticalScrollBar(new CustomScrollBar(JScrollBar.VERTICAL, appearance));
        this.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        this.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        this.setBounds(bounds);
        this.setPreferredSize(new Dimension(bounds.width, bounds.height));
    }

    public AbstractScrollPanel(Rectangle bounds, final Appearance appearance) {
        this(bounds, null, appearance);
    }
}