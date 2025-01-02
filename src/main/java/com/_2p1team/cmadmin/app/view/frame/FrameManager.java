package com._2p1team.cmadmin.app.view.frame;

import javax.swing.JFrame;

public final class FrameManager {
    private static boolean hasInstance = false;
    private static AppFrame frame;

    public static void initManager(final AppFrame frame) {
        if (hasInstance)
            return;

        hasInstance = true;
        FrameManager.frame = frame;
    }

    public static void exitFrame() {
        frame.dispose();
        System.exit(0);
    }

    public static void iconifyFrame() {
        frame.setState(JFrame.ICONIFIED);
    }
}