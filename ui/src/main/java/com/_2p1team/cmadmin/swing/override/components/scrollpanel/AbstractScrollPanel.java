package com._2p1team.cmadmin.swing.override.components.scrollpanel;

import com._2p1team.cmadmin.swing.override.components.AppearanceComponent;
import com._2p1team.cmadmin.swing.override.components.Container;
import com._2p1team.cmadmin.swing.override.components.panel.Panel;
import com._2p1team.cmadmin.swing.override.components.scrollpanel.scrollbar.CustomScrollBar;
import com._2p1team.cmadmin.swing.override.graphics.Appearance;
import com._2p1team.cmadmin.swing.override.graphics.G2DPainter;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.swing.JComponent;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import java.awt.*;
import java.awt.event.AdjustmentListener;
import java.util.ArrayList;
import java.util.List;

@Getter
@EqualsAndHashCode(callSuper=false)
public abstract class AbstractScrollPanel extends JScrollPane implements Container, AppearanceComponent, AdjustmentListener {

    private final Appearance appearance;
    private final Panel viewPanel;
    private final List<JComponent> contents;
    @Setter
    private int scrollCounter;

    public AbstractScrollPanel() {
        this.appearance = new Appearance();
        this.viewPanel = new Panel(new Dimension(0, 0), null, this.appearance);
        this.viewPanel.setOpaque(false);
        this.contents = new ArrayList<>();
        this.scrollCounter = 0;

        this.setFocusable(false);
        this.setBorder(null);
        this.setViewportBorder(null);
        this.setViewportView(this.viewPanel);
        this.setOpaque(false);
        this.getViewport().setOpaque(false);
        this.setHorizontalScrollBar(new CustomScrollBar(JScrollBar.HORIZONTAL, appearance));
        this.setVerticalScrollBar(new CustomScrollBar(JScrollBar.VERTICAL, appearance));
        this.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        this.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        this.getVerticalScrollBar().addAdjustmentListener(this);
        this.getVerticalScrollBar().addAdjustmentListener(this);
    }

    public AbstractScrollPanel(Dimension preferredSize, final LayoutManager layout, final Appearance appearance) {
        this.appearance = appearance;
        this.viewPanel = new Panel(new Dimension(0, 0), layout, appearance);
        this.viewPanel.setOpaque(false);
        this.contents = new ArrayList<>();
        this.scrollCounter = 0;

        this.setFocusable(false);
        this.setBorder(null);
        this.setViewportBorder(null);
        this.setViewportView(this.viewPanel);
        this.setOpaque(false);
        this.getViewport().setOpaque(false);
        this.setHorizontalScrollBar(new CustomScrollBar(JScrollBar.HORIZONTAL, appearance));
        this.setVerticalScrollBar(new CustomScrollBar(JScrollBar.VERTICAL, appearance));
        this.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        this.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        this.setPreferredSize(preferredSize);
        this.setBounds(new Rectangle(0, 0, preferredSize.width, preferredSize.height));
        this.getVerticalScrollBar().addAdjustmentListener(this);
        this.getVerticalScrollBar().addAdjustmentListener(this);
    }

    public AbstractScrollPanel(Dimension preferredSize, final Appearance appearance) {
        this(preferredSize, null, appearance);
    }

    public AbstractScrollPanel(Rectangle bounds, final LayoutManager layout, final Appearance appearance) {
        this.appearance = appearance;
        this.viewPanel = new Panel(new Dimension(0, 0), layout, appearance);
        this.viewPanel.setOpaque(false);
        this.contents = new ArrayList<>();
        this.scrollCounter = 0;

        this.setFocusable(false);
        this.setBorder(null);
        this.setViewportBorder(null);
        this.setViewportView(this.viewPanel);
        this.setOpaque(false);
        this.getViewport().setOpaque(false);
        this.setHorizontalScrollBar(new CustomScrollBar(JScrollBar.HORIZONTAL, appearance));
        this.setVerticalScrollBar(new CustomScrollBar(JScrollBar.VERTICAL, appearance));
        this.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        this.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        this.setBounds(bounds);
        this.setPreferredSize(new Dimension(bounds.width, bounds.height));
        this.getVerticalScrollBar().addAdjustmentListener(this);
        this.getVerticalScrollBar().addAdjustmentListener(this);
    }

    public AbstractScrollPanel(Rectangle bounds, final Appearance appearance) {
        this(bounds, null, appearance);
    }

    public void setScrollSpeed(int speed) {
        this.getHorizontalScrollBar().setUnitIncrement(speed);
        this.getVerticalScrollBar().setUnitIncrement(speed);
    }

    public int getScrollPosition() {
        return this.scrollCounter*this.getHorizontalScrollBar().getUnitIncrement();
    }


    @Override
    public void paint(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        G2DPainter.paint(g2, this);
        super.paint(g);
        g2.dispose();
    }

}