package com._2p1team.cmadmin.app.view.components.fencing;

import com._2p1team.cmadmin.general.constants.CustomColors;
import com._2p1team.cmadmin.swing.override.graphics.configs.FontSet;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Rectangle;

@Data
@EqualsAndHashCode(callSuper=true)
public class Box extends JTextField {

    public static final Color DEFAULT_BACKGROUND = Color.black;
    public static final Color HIGHLIGHTED_BACKGROUND = Color.gray;

    public Box(Rectangle bounds, String text) {
        this(bounds, text, CustomColors.ORANGEISH);
    }

    public Box(Rectangle bounds, String text, Color borderColor) {
        this.setBounds(bounds);
        this.setPreferredSize(new Dimension(bounds.width, bounds.height));
        this.setText(text);
        this.setOpaque(true);
        this.setForeground(Color.white);
        this.setBackground(Color.black);
        this.setFont(FontSet.SYSTEM_FONT);
        this.setCaretColor(this.getForeground());
        this.setHorizontalAlignment(JTextField.CENTER);
        this.setBorder(new LineBorder(borderColor, 1));
        this.setEnabled(true);
    }

    public boolean compareContentsWith(final Box box) {
        return this.getText().equalsIgnoreCase(box.getText());
    }

    public boolean compareContentsTo(final String string) {
        return this.getText().equalsIgnoreCase(string);
    }

}