package com._2p1team.cmadmin.swing.override.components.button;

import com._2p1team.cmadmin.swing.override.components.AppearanceComponent;
import com._2p1team.cmadmin.swing.override.graphics.Appearance;
import com._2p1team.cmadmin.swing.override.graphics.Painter;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;

import javax.swing.JButton;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.MouseListener;

@Getter
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
public abstract class AbstractButton extends JButton implements AppearanceComponent {
    private final Appearance appearance;

    public AbstractButton() {
        this.appearance = new Appearance();
    }

    public AbstractButton(Dimension preferredSize, String text, final Appearance appearance) {
        this.appearance = appearance;

        this.setBorderPainted(false);
        this.setBorder(null);
        this.setContentAreaFilled(false);
        this.setFocusPainted(false);
        this.setFocusable(false);
        this.setIcon(appearance.getIconSet().getDefaultIcon());
        this.setText(text);
        this.setHorizontalAlignment(JButton.CENTER);
        this.setVerticalAlignment(JButton.CENTER);
        this.setFont(appearance.getFontSet().getDefaultFont());
        this.setPreferredSize(preferredSize);
        this.setBounds(new Rectangle(0, 0, preferredSize.width, preferredSize.height));
        this.addMouseListener(this);
    }

    public AbstractButton(Dimension preferredSize, final Appearance appearance) {
        this(preferredSize, "", appearance);
    }

    public AbstractButton(Rectangle bounds, String text, final Appearance appearance) {
        this.appearance = appearance;

        this.setBorderPainted(false);
        this.setBorder(null);
        this.setContentAreaFilled(false);
        this.setFocusPainted(false);
        this.setFocusable(false);
        this.setIcon(appearance.getIconSet().getDefaultIcon());
        this.setText(text);
        this.setHorizontalAlignment(JButton.CENTER);
        this.setVerticalAlignment(JButton.CENTER);
        this.setFont(appearance.getFontSet().getDefaultFont());
        this.setBounds(bounds);
        this.setPreferredSize(new Dimension(bounds.width, bounds.height));
        this.addMouseListener(this);
    }

    public AbstractButton(Rectangle bounds, final Appearance appearance) {
        this(bounds, "", appearance);
    }

    @Override
    public void paint(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        Painter.paint(g2, this);
        super.paint(g);
        g2.dispose();
    }
}