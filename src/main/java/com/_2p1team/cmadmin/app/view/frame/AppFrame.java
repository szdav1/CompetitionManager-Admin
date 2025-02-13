package com._2p1team.cmadmin.app.view.frame;

import com._2p1team.cmadmin.app.control.frame.FrameController;
import com._2p1team.cmadmin.app.view.components.modals.*;
import com._2p1team.cmadmin.app.view.frame.parts.CenterPanel;
import com._2p1team.cmadmin.app.view.frame.parts.FooterPanel;
import com._2p1team.cmadmin.app.view.frame.parts.RootPanel;
import com._2p1team.cmadmin.app.view.frame.parts.TitleBar;
import static com._2p1team.cmadmin.support.constants.SizeData.FRAME_HEIGHT;
import static com._2p1team.cmadmin.support.constants.SizeData.FRAME_WIDTH;
import com._2p1team.cmadmin.support.constants.states.FrameState;
import com._2p1team.cmadmin.support.util.AppearanceRepository;
import com._2p1team.cmadmin.support.util.BeforeLaunchExceptionQueue;
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


@Getter(AccessLevel.PACKAGE)
public final class AppFrame extends AbstractFrame {

    private final WindowClosingConfirmationModal closingConfirmationModal;
    private final NewPouleModal newPouleModal;
    private final ViewCompetitorsModal viewCompetitorsModal;
    private final ExceptionModal httpConnectionExceptionModal;

    private final RootPanel rootPanel;
    private final Panel mainPanel;
    private final TitleBar titleBar;
    private final CenterPanel centerPanel;
    private final FooterPanel footerPanel;

    private final PouleExceptionModal pouleExceptionModal;

    @Setter(AccessLevel.PACKAGE)
    private FrameState frameState;

    @Setter(AccessLevel.PACKAGE)
    private AbstractModal previousModal;

    @Setter(AccessLevel.PACKAGE)
    private AbstractModal openedModal;

    public AppFrame(Image iconImage, String title) {
        super(iconImage, title);
        this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        this.setLayout(null);

        this.frameState = FrameState.DEFAULT;

        this.closingConfirmationModal = new WindowClosingConfirmationModal();
        this.newPouleModal = new NewPouleModal();
        this.viewCompetitorsModal = new ViewCompetitorsModal();
        this.httpConnectionExceptionModal = new ExceptionModal();

        this.openedModal = null;

        this.rootPanel = new RootPanel();
        this.mainPanel = new Panel(new Rectangle(0, 0, FRAME_WIDTH, FRAME_HEIGHT), new BorderLayout(), AppearanceRepository.MAIN_PANEL_APPEARANCE);
        this.titleBar = new TitleBar();
        this.centerPanel = new CenterPanel();
        this.footerPanel = new FooterPanel();

        this.pouleExceptionModal = new PouleExceptionModal();

        new FrameController(this);

        FrameManager.initManager(this);
        this.createFrameUI();
        this.handleBeforeLaunchQueuedException();
    }

    private void handleBeforeLaunchQueuedException() {
        switch (BeforeLaunchExceptionQueue.getExceptionType()) {
            case HTTP_COMMUNICATION_EXCEPTION -> FrameManager.displayHttpConnectionExceptionModal();
            default -> {
                // NONE
            }
        }
    }

    private void createFrameUI() {
        this.mainPanel.addComponent(this.titleBar, Position.TOP);
        this.mainPanel.addComponent(this.centerPanel, Position.CENTER);
        this.mainPanel.addComponent(this.footerPanel, Position.BOTTOM);

        this.rootPanel.addComponent(this.mainPanel, Position.LOW);

        this.titleBar.setUpFileMenu();
        this.titleBar.setUpDatabaseMenu();
        this.titleBar.setUpSettingsMenu();

        this.rootPanel.addComponent(this.pouleExceptionModal.getBackgroundPanel(), Position.HIGH);

        this.rootPanel.addComponent(this.closingConfirmationModal.getBackgroundPanel(), Position.HIGH);
        this.rootPanel.addComponent(this.newPouleModal.getBackgroundPanel(), Position.HIGH);
        this.rootPanel.addComponent(this.viewCompetitorsModal.getBackgroundPanel(), Position.HIGH);
        this.rootPanel.addComponent(this.httpConnectionExceptionModal.getBackgroundPanel(), Position.HIGH);

        this.pouleExceptionModal.disappear();

        this.closingConfirmationModal.disappear();
        this.newPouleModal.disappear();
        this.viewCompetitorsModal.disappear();
        this.httpConnectionExceptionModal.disappear();

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