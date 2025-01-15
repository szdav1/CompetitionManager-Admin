package com._2p1team.cmadmin.app.view.frame;

import com._2p1team.cmadmin.swing.override.components.panel.Panel;
import com._2p1team.cmadmin.swing.override.constants.Position;
import lombok.Getter;

import javax.swing.JComponent;
import javax.swing.JFrame;

public final class FrameManager {
    private static boolean hasInstance = false;
    @Getter // TODO: For testing purposes only
    private static AppFrame frame;

    public static void initManager(final AppFrame frame) {
        if (hasInstance)
            return;

        hasInstance = true;
        FrameManager.frame = frame;
    }

    public static Panel getCenterPanel() {
        return frame.getCenterPanel();
    }

    public static void repaintCenterPanel() {
        frame.getCenterPanel().repaint();
        frame.getCenterPanel().revalidate();
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

        repaintFrame();
    }

    public static void addToFrame(final JComponent component) {
        frame.getCenterPanel()
            .addComponent(component);

        repaintFrame();
    }

    public static JComponent removeFromFrame(final JComponent component) {
        return frame.getCenterPanel()
            .removeComponent(component);
    }

    public static void addToFrameRoot(final JComponent component, final Position position) {
        frame.getRootPanel()
            .addComponent(component, position);

        repaintFrame();
    }

    public static void addToFrameRoot(final JComponent component) {
        frame.getRootPanel()
            .addComponent(component);

        repaintFrame();
    }

    public static JComponent removeFromFrameRoot(final JComponent component) {
        return frame.getRootPanel()
            .removeComponent(component);
    }

    public static void repaintRootPanel() {
        frame.getRootPanel()
            .repaint();
    }

    public static void revalidateRootPanel() {
        frame.getRootPanel()
            .revalidate();
    }

    public static void displayDatabaseConnectModal() {
        frame.getDatabaseConnectModal()
                .appear();
    }

    public static void hideDatabaseConnectModal() {
        frame.getDatabaseConnectModal()
            .disappear();
    }
}