package com._2p1team.cmadmin.app.control.components.fencing.poule;

import com._2p1team.cmadmin.app.control.AbstractKeyController;
import com._2p1team.cmadmin.app.view.components.fencing.poule.PouleCompetitionPanel;
import com._2p1team.cmadmin.app.view.frame.FrameManager;
import com._2p1team.cmadmin.support.constants.states.FrameState;

import javax.swing.AbstractAction;
import javax.swing.JComponent;
import javax.swing.KeyStroke;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

public final class PouleCompetitionPanelKeyController extends AbstractKeyController {

    public PouleCompetitionPanelKeyController(final PouleCompetitionPanel keyControlledComponent) {
        super(keyControlledComponent);

        keyControlledComponent.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW)
            .put(KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), "HidePouleCompetitionPanelAction");

        keyControlledComponent.getActionMap()
            .put("HidePouleCompetitionPanelAction", new HidePouleCompetitionPanelAction());
    }

    private static final class HidePouleCompetitionPanelAction extends AbstractAction {

        @Override
        public void actionPerformed(ActionEvent e) {
            if (FrameManager.getState() == FrameState.POULE_COMPETITION_PANEL_OPENED)
                FrameManager.hidePouleCompetitionPanel();
        }

    }

}