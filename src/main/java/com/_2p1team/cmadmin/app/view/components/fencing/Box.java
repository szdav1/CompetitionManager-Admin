package com._2p1team.cmadmin.app.view.components.fencing;

import com._2p1team.cmadmin.support.constants.CustomColors;
import com._2p1team.cmadmin.swing.override.graphics.configs.FontSet;

import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import java.awt.Color;
import java.awt.Rectangle;

public class Box extends JTextField {
    
    public static final Color DEFAULT_BACKGROUND = Color.black;
    public static final Color HIGHLIGHTED_BACKGROUND = Color.gray;

    public Box(Rectangle bounds, String text) {
        this.setBounds(bounds);
        this.setText(text);
        this.setOpaque(true);
        this.setForeground(Color.white);
        this.setBackground(Color.black);
        this.setFont(FontSet.SYSTEM_FONT);
        this.setCaretColor(this.getForeground());
        this.setHorizontalAlignment(JTextField.CENTER);
        this.setBorder(new LineBorder(CustomColors.ORANGEISH, 1));
        this.setRequestFocusEnabled(false);
    }

    public boolean compareContentsWith(final Box box) {
        return this.getText().equalsIgnoreCase(box.getText());
    }

    public boolean compareContentsTo(final String string) {
        return this.getText().equalsIgnoreCase(string);
    }

}