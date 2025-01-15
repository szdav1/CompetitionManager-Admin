package com._2p1team.cmadmin.app.control.frame.parts;

import com._2p1team.cmadmin.app.control.AbstractKeyController;
import com._2p1team.cmadmin.app.view.frame.FrameManager;
import com._2p1team.cmadmin.app.view.interfaces.KeyControlComponent;

import javax.swing.AbstractAction;
import javax.swing.JComponent;
import javax.swing.KeyStroke;
import java.awt.event.ActionEvent;

public final class TitleBarKeyController extends AbstractKeyController {
    public TitleBarKeyController(KeyControlComponent keyControlComponent) {
        super(keyControlComponent);

        this.getKeyControlComponent()
            .getKeyControls()
            .getFirst()
            .getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW)
            .put(KeyStroke.getKeyStroke("ESCAPE"), "ExitAction");

        this.getKeyControlComponent()
            .getKeyControls()
            .getFirst()
            .getActionMap()
            .put("ExitAction", new ExitAction());
    }

    private static class ExitAction extends AbstractAction {
        @Override
        public void actionPerformed(ActionEvent e) {
            FrameManager.exitFrame();
        }
    }
}