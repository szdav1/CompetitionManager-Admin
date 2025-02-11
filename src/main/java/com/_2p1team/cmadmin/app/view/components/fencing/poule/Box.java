package com._2p1team.cmadmin.app.view.components.fencing.poule;

import com._2p1team.cmadmin.support.constants.CustomColors;
import com._2p1team.cmadmin.swing.override.graphics.configs.FontSet;

import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import java.awt.Color;

public class Box extends JTextField {

    public Box(int x, int y, int width, int height, String text) {
        this.setBounds(x, y, width, height);
        this.setText(text);
        this.setOpaque(true);
        this.setForeground(Color.white);
        this.setBackground(Color.black);
        this.setFont(FontSet.SYSTEM_FONT);
        this.setCaretColor(this.getForeground());
        this.setHorizontalAlignment(JTextField.CENTER);
        this.setBorder(new LineBorder(CustomColors.ORANGEISH, 1));
    }

}