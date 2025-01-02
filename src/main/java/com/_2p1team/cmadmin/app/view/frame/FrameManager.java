package com._2p1team.cmadmin.app.view.frame;

import com._2p1team.cmadmin.swing.override.constants.Position;

import javax.swing.JComponent;
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

    public static void repaintFrame() {
        frame.repaint();
        frame.revalidate();
    }

    public static void exitFrame() {
        frame.dispose();
        System.exit(0);
    }

    public static void iconifyFrame() {
        frame.setState(JFrame.ICONIFIED);
    }

    public static void addToFrame(final JComponent component, final Position position) {
        frame.getCenterPanel()
            .addComponent(component, position);
    }

    public static void addToFrame(final JComponent component) {
        frame.getCenterPanel()
            .addComponent(component);
    }

    public static void removeFromFrame(final JComponent component) {
        frame.getCenterPanel()
            .removeComponent(component);
    }
}