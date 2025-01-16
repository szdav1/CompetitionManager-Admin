package com._2p1team.cmadmin.app.view.frame;

import com._2p1team.cmadmin.app.control.frame.FrameController;
import com._2p1team.cmadmin.app.view.components.modals.AbstractModal;
import com._2p1team.cmadmin.app.view.components.modals.DatabaseConnectModal;
import com._2p1team.cmadmin.app.view.components.modals.WindowClosingConfirmationModal;
import com._2p1team.cmadmin.app.view.frame.parts.CenterPanel;
import com._2p1team.cmadmin.app.view.frame.parts.FooterPanel;
import com._2p1team.cmadmin.app.view.frame.parts.RootPanel;
import com._2p1team.cmadmin.app.view.frame.parts.TitleBar;
import static com._2p1team.cmadmin.support.constants.SizeData.*;
import com._2p1team.cmadmin.support.constants.states.FrameState;
import com._2p1team.cmadmin.support.util.AppearanceRepository;
import com._2p1team.cmadmin.swing.override.components.panel.Panel;
import com._2p1team.cmadmin.swing.override.constants.Position;
import com._2p1team.cmadmin.swing.override.frame.AbstractFrame;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

import javax.swing.JComponent;
import javax.swing.JFrame;
import java.awt.BorderLayout;
import java.awt.Image;
import java.awt.Rectangle;


public final class AppFrame extends AbstractFrame {
    @Getter
    @Setter(AccessLevel.PACKAGE)
    private FrameState frameState;

    @Getter(AccessLevel.PACKAGE)
    private final WindowClosingConfirmationModal closingConfirmationModal;
    @Getter(/*AccessLevel.PACKAGE*/) // TODO: For testing purposes only
    private final DatabaseConnectModal databaseConnectModal;

    @Getter(AccessLevel.PACKAGE)
    @Setter(AccessLevel.PACKAGE)
    private AbstractModal openedModal;

    @Getter(AccessLevel.PACKAGE)
    private final RootPanel rootPanel;
    @Getter(AccessLevel.PACKAGE)
    private final Panel mainPanel;
    private final TitleBar titleBar;
    @Getter(AccessLevel.PACKAGE)
    private final CenterPanel centerPanel;
    private final FooterPanel footerPanel;

    public AppFrame(Image iconImage, String title) {
        super(iconImage, title);
        this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        this.setLayout(null);
        this.setBounds(new Rectangle(
            (SCREEN_WIDTH/2)-(FRAME_WIDTH/2),
            (SCREEN_HEIGHT/2)-(FRAME_HEIGHT/2),
            FRAME_WIDTH,
            FRAME_HEIGHT
        ));

        this.frameState = FrameState.DEFAULT;

        this.closingConfirmationModal = new WindowClosingConfirmationModal();
        this.databaseConnectModal = new DatabaseConnectModal();

        this.openedModal = null;

        this.rootPanel = new RootPanel();
        this.mainPanel = new Panel(new Rectangle(0, 0, FRAME_WIDTH, FRAME_HEIGHT), new BorderLayout(), AppearanceRepository.MAIN_PANEL_APPEARANCE);
        this.titleBar = new TitleBar();
        this.centerPanel = new CenterPanel();
        this.footerPanel = new FooterPanel();

        new FrameController(this);

        FrameManager.initManager(this);
        this.createFrameUI();
    }

    private void createFrameUI() {
        this.mainPanel.addComponent(this.titleBar, Position.TOP);
        this.mainPanel.addComponent(this.centerPanel, Position.CENTER);
        this.mainPanel.addComponent(this.footerPanel, Position.BOTTOM);

        this.rootPanel.addComponent(this.mainPanel, Position.LOW);

        this.titleBar.setUpFileMenu();
        this.titleBar.setUpDatabaseMenu();
        this.titleBar.setUpSettingsMenu();

        this.rootPanel.addComponent(this.closingConfirmationModal.getBackgroundPanel(), Position.HIGH);
        this.rootPanel.addComponent(this.databaseConnectModal.getBackgroundPanel(), Position.HIGH);

        this.closingConfirmationModal.disappear();
        this.databaseConnectModal.disappear();

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