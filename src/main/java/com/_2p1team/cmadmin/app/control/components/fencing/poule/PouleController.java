package com._2p1team.cmadmin.app.control.components.fencing.poule;

import com._2p1team.cmadmin.app.control.AbstractController;
import com._2p1team.cmadmin.app.view.components.fencing.poule.Box;
import com._2p1team.cmadmin.app.view.components.fencing.poule.Poule;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;

public final class PouleController extends AbstractController {

    private final Poule poule;
    private final Box[][] pouleBoxes;

    public PouleController(final Poule component) {
        super(component);

        this.poule = component;
        this.pouleBoxes = this.poule.getBoxes();

        for (Box[] pouleBoxRow : this.pouleBoxes) {
            for (Box box : pouleBoxRow) {
                box.addMouseListener(this);
            }
        }
    }

    private void focusEnteredBox(final Box box, final MouseEvent mouseEvent) {
        if (mouseEvent.getID() == MouseEvent.MOUSE_ENTERED)
            box.requestFocus();
    }

    private void highlightBoxes(final int x, final int y, final Box box, final MouseEvent mouseEvent) {
        box.setBackground(mouseEvent.getID() == MouseEvent.MOUSE_ENTERED ? Color.darkGray : Color.black);
        this.pouleBoxes[x-2][y+2].setBackground(mouseEvent.getID() == MouseEvent.MOUSE_ENTERED ? Color.darkGray : Color.black);
        this.pouleBoxes[y][0].setBackground(mouseEvent.getID() == MouseEvent.MOUSE_ENTERED ? Color.darkGray : Color.black);
        this.pouleBoxes[x-2][0].setBackground(mouseEvent.getID() == MouseEvent.MOUSE_ENTERED ? Color.darkGray : Color.black);
    }

    private void handleBoxHighlighting(final MouseEvent mouseEvent) {
        for (int y = 1; y < this.pouleBoxes.length; y++) {
            for (int x = 3; x < this.pouleBoxes[y].length-5; x++) {
                final Box box = this.pouleBoxes[y][x];

                if (mouseEvent.getSource().equals(box) && box.isEnabled()) {
                    this.focusEnteredBox(box, mouseEvent);
                    this.highlightBoxes(x, y, box, mouseEvent);
                    return;
                }
            }
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        this.handleBoxHighlighting(e);
    }

    @Override
    public void mouseExited(MouseEvent e) {
        this.handleBoxHighlighting(e);
    }

}