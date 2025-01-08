package com._2p1team.cmadmin.app.view.frame;

import com._2p1team.cmadmin.app.view.frame.parts.CenterPanel;
import com._2p1team.cmadmin.app.view.frame.parts.FooterPanel;
import com._2p1team.cmadmin.app.view.frame.parts.RootPanel;
import com._2p1team.cmadmin.app.view.frame.parts.TitleBar;
import static com._2p1team.cmadmin.support.constants.SizeData.SCREEN_HEIGHT;
import static com._2p1team.cmadmin.support.constants.SizeData.SCREEN_WIDTH;
import com._2p1team.cmadmin.support.util.AppearanceRepository;
import com._2p1team.cmadmin.swing.override.components.panel.Panel;
import com._2p1team.cmadmin.swing.override.constants.Position;
import com._2p1team.cmadmin.swing.override.frame.AbstractFrame;
import lombok.AccessLevel;
import lombok.Getter;

import javax.swing.JComponent;
import java.awt.BorderLayout;
import java.awt.Image;
import java.awt.Rectangle;

public final class AppFrame extends AbstractFrame {
    private final RootPanel rootPanel;
    @Getter(AccessLevel.PACKAGE)
    private final Panel mainPanel;
    private final TitleBar titleBar;
    @Getter(AccessLevel.PACKAGE)
    private final CenterPanel centerPanel;
    private final FooterPanel footerPanel;

    public AppFrame(Image iconImage, String title) {
        super(iconImage, title);
        this.setLayout(null);

        this.rootPanel = new RootPanel();
        this.mainPanel = new Panel(new Rectangle(0, 0, SCREEN_WIDTH, SCREEN_HEIGHT), new BorderLayout(), AppearanceRepository.MAIN_PANEL_APPEARANCE);
        this.titleBar = new TitleBar();
        this.centerPanel = new CenterPanel();
        this.footerPanel = new FooterPanel();

        FrameManager.initManager(this);
        this.createFrameUI();
    }

    private void createFrameUI() {
        this.mainPanel.addComponent(this.titleBar, Position.TOP);
        this.mainPanel.addComponent(this.footerPanel, Position.BOTTOM);

        this.rootPanel.addComponent(this.mainPanel, Position.LOW);

        this.addComponent(this.rootPanel);
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