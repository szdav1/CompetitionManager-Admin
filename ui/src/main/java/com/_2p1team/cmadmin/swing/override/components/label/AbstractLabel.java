package com._2p1team.cmadmin.swing.override.components.label;

import com._2p1team.cmadmin.swing.override.components.AppearanceComponent;
import com._2p1team.cmadmin.swing.override.graphics.Appearance;
import com._2p1team.cmadmin.swing.override.graphics.G2DPainter;
import lombok.EqualsAndHashCode;
import lombok.Getter;

import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;

@Getter
@EqualsAndHashCode(callSuper=false)
public abstract class AbstractLabel extends JLabel implements AppearanceComponent {

    private final Appearance appearance;

    public AbstractLabel() {
        this.appearance = new Appearance();
    }

    public AbstractLabel(Dimension preferredSize, String text, final Appearance appearance) {
        this.appearance = appearance;

        this.setIcon(this.appearance.getIconSet().getDefaultIcon());
        this.setForeground(appearance.getForegroundConfiguration().getDefaultColor());
        this.setText(text);
        this.setHorizontalAlignment(SwingConstants.CENTER);
        this.setVerticalAlignment(SwingConstants.CENTER);
        this.setFont(appearance.getFontSet().getDefaultFont());
        this.setPreferredSize(preferredSize);
        this.setBounds(new Rectangle(0, 0, preferredSize.width, preferredSize.height));
        this.addMouseListener(this);
    }

    public AbstractLabel(Dimension preferredSize, final Appearance appearance) {
        this(preferredSize, "", appearance);
    }

    public AbstractLabel(Rectangle bounds, String text, final Appearance appearance) {
        this.appearance = appearance;

        this.setIcon(this.appearance.getIconSet().getDefaultIcon());
        this.setForeground(appearance.getForegroundConfiguration().getDefaultColor());
        this.setText(text);
        this.setHorizontalAlignment(SwingConstants.CENTER);
        this.setVerticalAlignment(SwingConstants.CENTER);
        this.setFont(appearance.getFontSet().getDefaultFont());
        this.setBounds(bounds);
        this.setPreferredSize(new Dimension(bounds.width, bounds.height));
        this.addMouseListener(this);
    }

    public AbstractLabel(Rectangle bounds, final Appearance appearance) {
        this(bounds, "", appearance);
    }

    public AbstractLabel(Appearance appearance) {
        this(
            new Dimension(
                appearance.getIconSet()
                    .getDefaultIcon().getIconWidth(),
                appearance.getIconSet()
                    .getDefaultIcon().getIconHeight()
            ),
            appearance
        );
    }

    @Override
    public void paint(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        G2DPainter.paint(g2, this);
        super.paint(g);
        g2.dispose();
    }

}