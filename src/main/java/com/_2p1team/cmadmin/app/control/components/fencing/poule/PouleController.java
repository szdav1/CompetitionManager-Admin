package com._2p1team.cmadmin.app.control.components.fencing.poule;

import com._2p1team.cmadmin.app.control.AbstractController;
import com._2p1team.cmadmin.app.view.components.fencing.poule.Poule;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
// TODO: Create MouseController class, finish writing the mouse actions of the Poule component
public final class PouleController extends AbstractController implements MouseListener {

    public PouleController(final Poule component) {
        super(component);

        component.getBoxes()
            .forEach(boxes -> boxes.forEach(box -> box.addMouseListener(this)));
    }

    @Override
    public void actionPerformed(ActionEvent e) {

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
        Poule poule = (Poule) this.getComponent();

        poule.getBoxes()
            .forEach(boxes -> boxes.forEach(box -> {
                if (e.getSource().equals(box) && box.isEnabled()) {
                    int sourceBoxIndex = boxes.indexOf(box);

                    box.setOpaque(true);
                    box.setBackground(Color.gray);
                }
            }));
    }

    @Override
    public void mouseExited(MouseEvent e) {
        Poule poule = (Poule) this.getComponent();

        poule.getBoxes()
            .forEach(boxes -> boxes.forEach(box -> {
                if (e.getSource().equals(box) && box.isEnabled()) {
                    box.setOpaque(false);
                    box.setBackground(Color.black);
                }
            }));
    }

}