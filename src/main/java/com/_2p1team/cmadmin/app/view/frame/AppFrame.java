package com._2p1team.cmadmin.app.view.frame;

import com._2p1team.cmadmin.app.control.frame.FrameController;
import com._2p1team.cmadmin.app.view.components.fencing.poule.PouleCompetitionPanel;
import com._2p1team.cmadmin.app.view.components.fencing.table.TableCompetitionPanel;
import com._2p1team.cmadmin.app.view.components.modals.*;
import com._2p1team.cmadmin.app.view.frame.parts.CenterPanel;
import com._2p1team.cmadmin.app.view.frame.parts.FooterPanel;
import com._2p1team.cmadmin.app.view.frame.parts.RootPanel;
import com._2p1team.cmadmin.app.view.frame.parts.TitleBar;
import static com._2p1team.cmadmin.support.constants.AppearanceConstants.BORDER_RADIUS;
import static com._2p1team.cmadmin.support.constants.SizeData.*;
import com._2p1team.cmadmin.support.constants.CompetitionType;
import com._2p1team.cmadmin.support.constants.states.FrameState;
import com._2p1team.cmadmin.support.util.AppearanceRepository;
import com._2p1team.cmadmin.support.util.BeforeLaunchExceptionQueue;
import com._2p1team.cmadmin.support.util.Util;
import com._2p1team.cmadmin.swing.override.components.label.Label;
import com._2p1team.cmadmin.swing.override.components.panel.Panel;
import com._2p1team.cmadmin.swing.override.constants.Position;
import com._2p1team.cmadmin.swing.override.frame.AbstractFrame;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

import javax.swing.JComponent;
import javax.swing.JFrame;
import java.awt.*;
import java.awt.geom.RoundRectangle2D;


@Getter(AccessLevel.PACKAGE)
public final class AppFrame extends AbstractFrame {

    @Setter(AccessLevel.PACKAGE)
    private CompetitionType competitionType = CompetitionType.NONE;

    private final WindowClosingConfirmationModal closingConfirmationModal;
    private final NewPouleModal newPouleModal;
    private final NewTableModal newTableModal;
    private final ViewCompetitorsModal viewCompetitorsModal;
    private final HttpExceptionModal httpConnectionHttpExceptionModal;

    private final RootPanel rootPanel;
    private final Panel mainPanel;
    private final TitleBar titleBar;
    private final CenterPanel centerPanel;
    private final FooterPanel footerPanel;

    @Setter(AccessLevel.PACKAGE)
    private FrameState frameState;

    @Setter(AccessLevel.PACKAGE)
    private AbstractModal previousModal;

    @Setter(AccessLevel.PACKAGE)
    private AbstractModal openedModal;

    private final PouleCompetitionPanel pouleCompetitionPanel;
    private final TableCompetitionPanel tableCompetitionPanel;

    public AppFrame() {
        super(Util.loadImageIcon("/assets/appIcon.png").getImage(), "Http Communication Error");

        Label fatalErrorLabel = new Label(X_BUTTON_SIZE, "Fatal Error: Server is unreachable", AppearanceRepository.HTTP_EXCEPTION_MESSAGE_APPEARANCE);
        Panel shade = new Panel(new Dimension(MODAL_WIDTH, MODAL_HEIGHT), new GridLayout(1, 1), AppearanceRepository.MODAL_BACKGROUND_APPEARANCE);

        this.setSize(MODAL_WIDTH, MODAL_HEIGHT);
        this.setExtendedState(JFrame.NORMAL);
        this.setLocationRelativeTo(null);
        this.setShape(new RoundRectangle2D.Double(0.0, 0.0, MODAL_WIDTH, MODAL_HEIGHT, BORDER_RADIUS, BORDER_RADIUS));

        this.closingConfirmationModal = null;
        this.newPouleModal = null;
        this.newTableModal = null;
        this.viewCompetitorsModal = null;
        this.httpConnectionHttpExceptionModal = null;

        this.rootPanel = new RootPanel(MODAL_WIDTH, MODAL_HEIGHT);
        this.mainPanel = new Panel(new Rectangle(0, 0, MODAL_WIDTH, MODAL_HEIGHT), new BorderLayout(), AppearanceRepository.MAIN_PANEL_APPEARANCE);
        this.titleBar = new TitleBar(new Dimension(MODAL_WIDTH, BUTTON_HEIGHT));
        this.centerPanel = new CenterPanel();
        this.footerPanel = new FooterPanel(new Dimension(MODAL_WIDTH, BUTTON_HEIGHT));

        this.pouleCompetitionPanel = null;
        this.tableCompetitionPanel = null;

        this.titleBar.getLeftPanel().removeAll();
        this.titleBar.getRightPanel().removeComponent(this.titleBar.getIconifyButton());

        this.titleBar.getExitButton().addActionListener(e -> {
            this.dispose();
            System.exit(1);
        });

        shade.add(fatalErrorLabel, 1);

        this.centerPanel.setLayout(new GridLayout(1, 1));
        this.centerPanel.add(shade);

        this.mainPanel.addComponent(this.titleBar, Position.TOP);
        this.mainPanel.addComponent(this.centerPanel, Position.CENTER);
        this.mainPanel.addComponent(this.footerPanel, Position.BOTTOM);

        this.rootPanel.addComponent(this.mainPanel, Position.LOW);

        this.addComponent(this.rootPanel, Position.LOW);

        FrameManager.initManager(this);
    }

    public AppFrame(Image iconImage, String title) {
        super(iconImage, title);
        this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        this.setLayout(null);

        this.closingConfirmationModal = new WindowClosingConfirmationModal();
        this.newPouleModal = new NewPouleModal();
        this.newTableModal = new NewTableModal();
        this.viewCompetitorsModal = new ViewCompetitorsModal();
        this.httpConnectionHttpExceptionModal = new HttpExceptionModal();

        this.rootPanel = new RootPanel();
        this.mainPanel = new Panel(new Rectangle(0, 0, FRAME_WIDTH, FRAME_HEIGHT), new BorderLayout(), AppearanceRepository.MAIN_PANEL_APPEARANCE);
        this.titleBar = new TitleBar();
        this.centerPanel = new CenterPanel();
        this.footerPanel = new FooterPanel();

        this.frameState = FrameState.DEFAULT;
        this.openedModal = null;

        this.pouleCompetitionPanel = new PouleCompetitionPanel();
        this.tableCompetitionPanel = new TableCompetitionPanel();

        new FrameController(this);

        FrameManager.initManager(this);
        this.createFrameUI();
        this.handleBeforeLaunchQueuedException();
    }

    void disableMenuButtons() {
        this.titleBar.getFileButton().setEnabled(false);
        this.titleBar.getDatabaseButton().setEnabled(false);
        this.titleBar.getSettingsButton().setEnabled(false);
    }

    void enableMenuButtons() {
        this.titleBar.getFileButton().setEnabled(true);
        this.titleBar.getDatabaseButton().setEnabled(true);
        this.titleBar.getSettingsButton().setEnabled(true);
    }

    private void handleBeforeLaunchQueuedException() {
        switch (BeforeLaunchExceptionQueue.getExceptionType()) {
            case HTTP_COMMUNICATION_EXCEPTION -> FrameManager.displayHttpConnectionExceptionModal();
        }
    }

    private void createFrameUI() {
        this.centerPanel.addComponent(this.pouleCompetitionPanel);
        this.pouleCompetitionPanel.setVisible(false);

        this.centerPanel.addComponent(this.tableCompetitionPanel);
        this.tableCompetitionPanel.setVisible(false);

        this.mainPanel.addComponent(this.titleBar, Position.TOP);
        this.mainPanel.addComponent(this.centerPanel, Position.CENTER);
        this.mainPanel.addComponent(this.footerPanel, Position.BOTTOM);

        this.rootPanel.addComponent(this.mainPanel, Position.LOW);

        this.titleBar.setUpFileMenu();
        this.titleBar.setUpDatabaseMenu();
        this.titleBar.setUpSettingsMenu();

        this.rootPanel.addComponent(this.closingConfirmationModal.getBackgroundPanel(), Position.HIGH);
        this.rootPanel.addComponent(this.newPouleModal.getBackgroundPanel(), Position.HIGH);
        this.rootPanel.addComponent(this.newTableModal.getBackgroundPanel(), Position.HIGH);
        this.rootPanel.addComponent(this.viewCompetitorsModal.getBackgroundPanel(), Position.HIGH);
        this.rootPanel.addComponent(this.httpConnectionHttpExceptionModal.getBackgroundPanel(), Position.HIGH);

        this.closingConfirmationModal.disappear();
        this.newPouleModal.disappear();
        this.newTableModal.disappear();
        this.viewCompetitorsModal.disappear();
        this.httpConnectionHttpExceptionModal.disappear();

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