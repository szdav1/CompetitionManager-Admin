package com._2p1team.cmadmin.app.control;

import com._2p1team.cmadmin.app.view.interfaces.ControlComponent;
import lombok.Getter;

import javax.swing.JButton;
import javax.swing.JComponent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.List;

@Getter
public abstract class AbstractController implements ActionListener, MouseListener {

    private final ControlComponent component;
    private final List<JComponent> controls;

    public AbstractController(final ControlComponent component) {
        this.component = component;
        this.controls = component.getControls();

        this.controls.forEach(control -> {
            if (control instanceof JButton button)
                button.addActionListener(this);
        });
    }

    @Override
    public void mouseClicked(MouseEvent e) {
    }

    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }

}