package com._2p1team.cmadmin.app.control.frame.parts;

import com._2p1team.cmadmin.app.control.AbstractController;
import com._2p1team.cmadmin.app.view.frame.FrameManager;
import com._2p1team.cmadmin.app.view.frame.parts.TitleBar;

import java.awt.event.ActionEvent;

public final class TitleBarController extends AbstractController {
    public TitleBarController(final TitleBar titleBar) {
        super(titleBar);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        this.getControls().forEach(control -> {
            if (e.getSource().equals(control)) {
                int controlIndex = this.getControls().indexOf(control);

                switch (controlIndex) {
                    case 0 -> FrameManager.exitFrame();
                    case 1 -> FrameManager.iconifyFrame();
                }
            }
        });
    }
}