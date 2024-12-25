package com._2p1team.cmadmin.swing.override.components.panel.scroll;

import com._2p1team.cmadmin.swing.override.components.AppearanceComponent;
import com._2p1team.cmadmin.swing.override.components.Container;
import com._2p1team.cmadmin.swing.override.components.panel.Panel;
import com._2p1team.cmadmin.swing.override.components.panel.scroll.bar.CustomScrollBar;
import com._2p1team.cmadmin.swing.override.graphics.Appearance;
import com._2p1team.cmadmin.swing.override.graphics.ScrollBarAppearance;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;

import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import java.awt.Dimension;
import java.awt.LayoutManager;
import java.awt.Rectangle;

@Getter
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
public abstract class AbstractScrollPanel extends JScrollPane implements Container, AppearanceComponent {
    private final Appearance panelAppearance;
    private final ScrollBarAppearance scrollBarAppearance;
    private final Panel viewPort;

    public AbstractScrollPanel() {
        this.panelAppearance = new Appearance();
        this.scrollBarAppearance = new ScrollBarAppearance();
        this.viewPort = new Panel(new Dimension(0, 0), new Appearance());

        this.setFocusable(false);
        this.setBorder(null);
        this.setViewportView(this.viewport);
        this.setHorizontalScrollBar(new CustomScrollBar(JScrollBar.HORIZONTAL, scrollBarAppearance));
        this.setVerticalScrollBar(new CustomScrollBar(JScrollBar.VERTICAL, scrollBarAppearance));
        this.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        this.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
    }

    public AbstractScrollPanel(Dimension preferredSize, LayoutManager layout, final Appearance panelAppearance, final ScrollBarAppearance scrollBarAppearance) {
        this.panelAppearance = panelAppearance;
        this.scrollBarAppearance = scrollBarAppearance;
        this.viewPort = new Panel(new Dimension(0, 0), layout, panelAppearance);

        this.setFocusable(false);
        this.setBorder(null);
        this.setViewportView(this.viewport);
        this.setHorizontalScrollBar(new CustomScrollBar(JScrollBar.HORIZONTAL, scrollBarAppearance));
        this.setVerticalScrollBar(new CustomScrollBar(JScrollBar.VERTICAL, scrollBarAppearance));
        this.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        this.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        this.setPreferredSize(preferredSize);
        this.setBounds(new Rectangle(0, 0, preferredSize.width, preferredSize.height));
    }

    public AbstractScrollPanel(Dimension preferredSize, final Appearance panelAppearance, final ScrollBarAppearance scrollBarAppearance) {
        this(preferredSize, null, panelAppearance, scrollBarAppearance);
    }
}