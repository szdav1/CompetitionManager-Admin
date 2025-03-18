package com._2p1team.cmadmin.app.view.components.checkbox;

import com._2p1team.cmadmin.general.constants.CustomColors;
import static com._2p1team.cmadmin.general.constants.SizeData.N_BUTTON_SIZE;
import com._2p1team.cmadmin.general.util.DirectIconSize;
import com._2p1team.cmadmin.general.util.Util;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.border.LineBorder;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

@Data
@EqualsAndHashCode(callSuper=false)
public final class Checkbox extends JButton implements ActionListener {

    private boolean checked;
    private final ImageIcon checkIcon;

    public Checkbox() {
        this.checked = false;
        this.checkIcon = Util.loadImageIcon("/assets/checkIcon.png", DirectIconSize.sizeByFrame(2, 3));

        this.setPreferredSize(N_BUTTON_SIZE);
        this.setFocusable(false);
        this.setContentAreaFilled(false);
        this.setBorder(new LineBorder(CustomColors.ORANGEISH, 1));
        this.addActionListener(this);
    }

    public void toggleChecked() {
        this.checked = !this.checked;

        if (this.checked)
            this.setIcon(this.checkIcon);
        else
            this.setIcon(null);
    }

    public void setChecked(boolean checked) {
        this.checked = checked;

        if (this.checked)
            this.setIcon(this.checkIcon);
        else
            this.setIcon(null);

        this.repaint();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(this))
            this.toggleChecked();
    }

}