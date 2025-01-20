package com._2p1team.cmadmin.app.control.frame;

import com._2p1team.cmadmin.app.view.frame.FrameManager;
import com._2p1team.cmadmin.support.constants.states.FrameState;
import com._2p1team.cmadmin.swing.override.frame.AbstractFrame;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public final class FrameController extends WindowAdapter {
    public FrameController(final AbstractFrame frame) {
        frame.addWindowListener(this);
    }

    @Override
    public void windowClosing(WindowEvent e) {
        if (FrameManager.getState() != FrameState.MODAL_OPENED)
            FrameManager.attemptExitFrame();
    }
}