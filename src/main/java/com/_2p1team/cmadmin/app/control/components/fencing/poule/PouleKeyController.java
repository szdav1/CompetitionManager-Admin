package com._2p1team.cmadmin.app.control.components.fencing.poule;

import com._2p1team.cmadmin.app.control.AbstractKeyController;
import com._2p1team.cmadmin.app.view.components.fencing.poule.Box;
import com._2p1team.cmadmin.app.view.components.fencing.poule.Poule;
import lombok.Setter;

import javax.swing.AbstractAction;
import javax.swing.JComponent;
import javax.swing.KeyStroke;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

public final class PouleKeyController extends AbstractKeyController {

    private final Poule poule;
    @Setter
    private Box highlightedBox;
    @Setter
    private Box highlightedBoxSibling;

    public PouleKeyController(final Poule keyControlledComponent) {
        super(keyControlledComponent);

        this.poule = keyControlledComponent;

        this.poule.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW)
            .put(KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0), "FocusSiblingBox");

        this.poule.getActionMap()
            .put("FocusSiblingBox", new FocusSiblingBoxAction());

        this.poule.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW)
            .put(KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, KeyEvent.ALT_DOWN_MASK), "SubmitPouleDataAction");

        this.poule.getActionMap()
            .put("SubmitPouleDataAction", new SubmitPouleDataAction());
    }

    private final class FocusSiblingBoxAction extends AbstractAction {

        @Override
        public void actionPerformed(ActionEvent e) {
            if (PouleKeyController.this.highlightedBox.isFocusOwner())
                PouleKeyController.this.highlightedBoxSibling.requestFocus();
            else
                PouleKeyController.this.highlightedBox.requestFocus();
        }

    }

    private static final class SubmitPouleDataAction extends AbstractAction {

        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("Submitting poule data");
        }

    }

}