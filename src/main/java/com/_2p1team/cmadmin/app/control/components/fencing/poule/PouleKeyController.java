package com._2p1team.cmadmin.app.control.components.fencing.poule;

import com._2p1team.cmadmin.app.control.AbstractKeyController;
import com._2p1team.cmadmin.app.view.components.fencing.poule.Box;
import com._2p1team.cmadmin.app.view.components.fencing.poule.Poule;
import com._2p1team.cmadmin.app.view.components.input.LabeledInput;
import lombok.Setter;

import javax.swing.AbstractAction;
import javax.swing.JComponent;
import javax.swing.KeyStroke;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

public final class PouleKeyController extends AbstractKeyController {

    private final Poule poule;
    private final Box[][] pouleBoxes;

    private final LabeledInput competitor1;
    private final LabeledInput competitor2;
    private final LabeledInput point1;
    private final LabeledInput point2;

    @Setter
    private Box highlightedBox;
    @Setter
    private Box highlightedBoxSibling;


    public PouleKeyController(final Poule keyControlledComponent) {
        super(keyControlledComponent);

        this.poule = keyControlledComponent;
        this.pouleBoxes = this.poule.getBoxes();

        this.competitor1 = this.poule.getCompetitor1IndexInput();
        this.competitor2 = this.poule.getCompetitor2IndexInput();
        this.point1 = this.poule.getCompetitor1PointInput();
        this.point2 = this.poule.getCompetitor2PointInput();

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

    private final class SubmitPouleDataAction extends AbstractAction {

        @Override
        public void actionPerformed(ActionEvent e) {
            String competitor1String = PouleKeyController.this.competitor1.getText();
            String competitor2String = PouleKeyController.this.competitor2.getText();
            String point1String = PouleKeyController.this.point1.getText();
            String point2String = PouleKeyController.this.point2.getText();

            try {
                int competitor1 = Integer.parseInt(competitor1String);
                int competitor2 = Integer.parseInt(competitor2String);

                PouleKeyController.this.pouleBoxes[competitor1][competitor2+2].setText(point1String);
                PouleKeyController.this.pouleBoxes[competitor2][competitor1+2].setText(point2String);

                PouleKeyController.this.competitor1.setText("");
                PouleKeyController.this.competitor2.setText("");
                PouleKeyController.this.point1.setText("");
                PouleKeyController.this.point2.setText("");
            }
            catch (Exception exception) {
            }
        }

    }

}