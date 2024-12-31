package com._2p1team.cmadmin.swing.override.components.text.field;

import com._2p1team.cmadmin.swing.override.components.AppearanceComponent;
import com._2p1team.cmadmin.swing.override.graphics.Appearance;
import com._2p1team.cmadmin.swing.override.graphics.G2DPainter;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;

import javax.swing.JTextField;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;

@Getter
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
public abstract class AbstractTextField extends JTextField implements AppearanceComponent {
    private final Appearance appearance;

    public AbstractTextField() {
        this.appearance = new Appearance();
    }

    public AbstractTextField(Dimension preferredSize, String text, final Appearance appearance) {
        this.appearance = appearance;

        this.setForeground(appearance.getForegroundConfiguration().getDefaultColor());
        this.setCaretColor(this.getForeground());
        this.setText(text);
        this.setHorizontalAlignment(JTextField.CENTER);
        this.setBorder(null);
        this.setOpaque(false);
        this.setFont(appearance.getFontSet().getDefaultFont());
        this.setPreferredSize(preferredSize);
        this.setBounds(new Rectangle(0, 0, preferredSize.width, preferredSize.height));
        this.addMouseListener(this);
    }

    public AbstractTextField(Dimension preferredSize, final Appearance appearance) {
        this(preferredSize, "", appearance);
    }

    public AbstractTextField(Rectangle bounds, String text, final Appearance appearance) {
        this.appearance = appearance;

        this.setForeground(appearance.getForegroundConfiguration().getDefaultColor());
        this.setCaretColor(this.getForeground());
        this.setText(text);
        this.setHorizontalAlignment(JTextField.CENTER);
        this.setBorder(null);
        this.setOpaque(false);
        this.setFont(appearance.getFontSet().getDefaultFont());
        this.setBounds(bounds);
        this.setPreferredSize(new Dimension(bounds.width, bounds.height));
        this.addMouseListener(this);
    }

    public AbstractTextField(Rectangle bounds, final Appearance appearance) {
        this(bounds, "", appearance);
    }

    @Override
    public void paint(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        G2DPainter.paint(g2, this);
        super.paint(g);
        g2.dispose();
    }
}