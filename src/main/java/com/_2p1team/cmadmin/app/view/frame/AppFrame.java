package com._2p1team.cmadmin.app.view.frame;

import com._2p1team.cmadmin.app.view.frame.parts.Sidebar;
import com._2p1team.cmadmin.app.view.frame.parts.TitleBar;
import static com._2p1team.cmadmin.support.appdata.SizeData.SCREEN_HEIGHT;
import static com._2p1team.cmadmin.support.appdata.SizeData.SCREEN_WIDTH;
import com._2p1team.cmadmin.support.util.Util;
import com._2p1team.cmadmin.swing.override.constants.Position;
import com._2p1team.cmadmin.swing.override.frame.AbstractFrame;

import javax.swing.JComponent;
import java.awt.BorderLayout;
import java.awt.Image;

public final class AppFrame extends AbstractFrame {
    private final TitleBar titleBar;
    private final Sidebar sidebar;

    public AppFrame(Image iconImage, String title) {
        super(iconImage, title);
        FrameManager.initManager(this);

        this.titleBar = new TitleBar();
        this.sidebar = new Sidebar();

        this.createFrameUI();
    }

    private void createFrameUI() {
        this.getBackgroundLabel().setIcon(Util.loadImageIcon("/assets/background.png", SCREEN_WIDTH, SCREEN_HEIGHT));
        this.addComponent(this.titleBar, Position.TOP);
        this.addComponent(this.sidebar, Position.LEFT);
        this.addComponent(this.getBackgroundLabel(), Position.CENTER);
    }

    @Override
    public void addComponent(final JComponent component, final Position position) {
        this.add(component, this.getLayout() instanceof BorderLayout ? position.getLayoutValue() : position.getPositionValue());
        this.repaint();
        this.revalidate();
    }

    @Override
    public void addComponent(final JComponent component) {
        this.addComponent(component, this.getLayout() instanceof BorderLayout ? Position.CENTER : Position.MID);
    }

    @Override
    public JComponent removeComponent(final JComponent component) {
        this.remove(component);
        this.repaint();
        this.revalidate();
        return component;
    }
}