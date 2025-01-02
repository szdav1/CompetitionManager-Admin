package com._2p1team.cmadmin.app.view.frame;

import com._2p1team.cmadmin.app.view.frame.parts.CenterPanel;
import com._2p1team.cmadmin.app.view.frame.parts.FooterPanel;
import com._2p1team.cmadmin.app.view.frame.parts.TitleBar;
import com._2p1team.cmadmin.swing.override.constants.Position;
import com._2p1team.cmadmin.swing.override.frame.AbstractFrame;
import lombok.AccessLevel;
import lombok.Getter;

import javax.swing.JComponent;
import java.awt.BorderLayout;
import java.awt.Image;

public final class AppFrame extends AbstractFrame {
    private final TitleBar titleBar;
    @Getter(AccessLevel.PACKAGE)
    private final CenterPanel centerPanel;
    private final FooterPanel footerPanel;

    public AppFrame(Image iconImage, String title) {
        super(iconImage, title);

        this.titleBar = new TitleBar();
        this.centerPanel = new CenterPanel();
        this.footerPanel = new FooterPanel();

        FrameManager.initManager(this);
        this.createFrameUI();
    }

    private void createFrameUI() {
        this.addComponent(this.titleBar, Position.TOP);
        this.addComponent(this.centerPanel, Position.CENTER);
        this.addComponent(this.footerPanel, Position.BOTTOM);
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