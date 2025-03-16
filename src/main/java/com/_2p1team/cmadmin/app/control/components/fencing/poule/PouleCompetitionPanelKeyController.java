package com._2p1team.cmadmin.app.control.components.fencing.poule;

import com._2p1team.cmadmin.app.control.AbstractKeyController;
import com._2p1team.cmadmin.app.view.components.fencing.poule.PouleCompetitionPanel;
import com._2p1team.cmadmin.app.view.frame.FrameManager;
import com._2p1team.cmadmin.general.constants.states.FrameState;

import javax.swing.AbstractAction;
import javax.swing.JComponent;
import javax.swing.KeyStroke;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.util.Random;

public final class PouleCompetitionPanelKeyController extends AbstractKeyController {

    private final PouleCompetitionPanel panel;

    public PouleCompetitionPanelKeyController(final PouleCompetitionPanel keyControlledComponent) {
        super(keyControlledComponent);

        this.panel = keyControlledComponent;

        keyControlledComponent.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW)
            .put(KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), "HidePouleCompetitionPanelAction");

        keyControlledComponent.getActionMap()
            .put("HidePouleCompetitionPanelAction", new HidePouleCompetitionPanelAction());

        keyControlledComponent.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW)
            .put(KeyStroke.getKeyStroke(KeyEvent.VK_F12, 0), "FillPoulesAction");

        keyControlledComponent.getActionMap()
            .put("FillPoulesAction", new FillPoulesAction());
    }

    private static final class HidePouleCompetitionPanelAction extends AbstractAction {

        @Override
        public void actionPerformed(ActionEvent e) {
            if (FrameManager.getState() == FrameState.POULE_COMPETITION_PANEL_OPENED)
                FrameManager.hidePouleCompetitionPanel();
        }

    }

    private final class FillPoulesAction extends AbstractAction {

        private static final Random random = new Random();

        @Override
        public void actionPerformed(ActionEvent e) {
            PouleCompetitionPanelKeyController.this.panel.getPoules().forEach(poule -> {
                for (int y = 1; y < poule.getBoxes().length; y++) {
                    for (int x = 3; x < poule.getBoxes()[y].length-5; x++) {
                        if (!poule.getBoxes()[y][x].isEnabled())
                            continue;

                        boolean winner = random.nextBoolean();
                        int num1 = 0;
                        int num2 = 0;

                        if (winner) {
                            num1 = 5;
                            num2 = random.nextInt(0, 5);
                        }
                        else {
                            num1 = random.nextInt(0, 5);
                            num2 = 5;
                        }

                        poule.getBoxes()[y][x].setText(num1 == 5 ? "v" : String.valueOf(num1));
                        poule.getBoxes()[x-2][y+2].setText(num2 == 5 ? "v" : String.valueOf(num2));
                    }
                }
            });
        }

    }

}