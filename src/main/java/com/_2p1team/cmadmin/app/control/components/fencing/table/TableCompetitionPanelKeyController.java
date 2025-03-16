package com._2p1team.cmadmin.app.control.components.fencing.table;

import com._2p1team.cmadmin.app.control.AbstractKeyController;
import com._2p1team.cmadmin.app.view.components.fencing.table.TableCompetitionPanel;
import com._2p1team.cmadmin.app.view.frame.FrameManager;
import com._2p1team.cmadmin.general.constants.states.FrameState;

import javax.swing.AbstractAction;
import javax.swing.JComponent;
import javax.swing.KeyStroke;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

public final class TableCompetitionPanelKeyController extends AbstractKeyController {

    private final TableCompetitionPanel panel;

    public TableCompetitionPanelKeyController(final TableCompetitionPanel keyControlledComponent) {
        super(keyControlledComponent);

        this.panel = keyControlledComponent;

        this.panel.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW)
            .put(KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), "HideTableCompetitionPanelAction");

        this.panel.getActionMap()
            .put("HideTableCompetitionPanelAction", new HideTableCompetitionPanelAction());
    }

    private static final class HideTableCompetitionPanelAction extends AbstractAction {

        @Override
        public void actionPerformed(ActionEvent e) {
            if (FrameManager.getState() == FrameState.TABLE_COMPETITION_PANEL_OPENED)
                FrameManager.hideTableCompetitionPanel();
        }

    }

}