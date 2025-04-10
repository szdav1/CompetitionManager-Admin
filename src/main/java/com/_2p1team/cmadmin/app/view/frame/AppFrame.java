package com._2p1team.cmadmin.app.view.frame;

import com._2p1team.cmadmin.app.control.frame.FrameController;
import com._2p1team.cmadmin.app.dto.competition.Competition;
import com._2p1team.cmadmin.app.view.components.fencing.poule.PouleCompetitionPanel;
import com._2p1team.cmadmin.app.view.components.fencing.table.TableCompetitionPanel;
import com._2p1team.cmadmin.app.view.components.modals.*;
import com._2p1team.cmadmin.app.view.frame.parts.CenterPanel;
import com._2p1team.cmadmin.app.view.frame.parts.FooterPanel;
import com._2p1team.cmadmin.app.view.frame.parts.RootPanel;
import com._2p1team.cmadmin.app.view.frame.parts.TitleBar;
import static com._2p1team.cmadmin.general.constants.AppearanceConstants.BORDER_RADIUS;
import com._2p1team.cmadmin.general.constants.CompetitionType;
import com._2p1team.cmadmin.general.constants.Language;
import static com._2p1team.cmadmin.general.constants.SizeData.*;
import com._2p1team.cmadmin.general.constants.states.FrameState;
import com._2p1team.cmadmin.general.util.AppearanceRepository;
import com._2p1team.cmadmin.general.util.BeforeLaunchExceptionQueue;
import com._2p1team.cmadmin.general.util.Util;
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
import java.net.http.HttpResponse;


@Getter(AccessLevel.PACKAGE)
public final class AppFrame extends AbstractFrame {

    public static final String VERSION = Language.get("Version")+" 1.2.1";
    private final int build;
    private final String buildDate;

    @Setter(AccessLevel.PACKAGE)
    private CompetitionType competitionType = CompetitionType.NONE;

    @Setter(AccessLevel.PACKAGE)
    private HttpResponse<String> lastApiResponse;

    @Getter
    @Setter(AccessLevel.PACKAGE)
    private Competition currentCompetition;

    private final WindowClosingConfirmationModal closingConfirmationModal;
    private final NewPouleModal newPouleModal;
    private final NewTableModal newTableModal;
    private final ViewCompetitorsModal viewCompetitorsModal;
    private final AddCompetitorModal addCompetitorModal;
    private final UpdateCompetitorModal updateCompetitorModal;
    private final DeleteCompetitorModal deleteCompetitorModal;
    private final HttpExceptionModal httpConnectionHttpExceptionModal;
    private final ResourcesNotFoundExceptionModal resourcesNotFoundExceptionModal;
    private final ApiResponseModal apiResponseModal;
    private final LanguageSelectorModal languageSelectorModal;
    private final AppResponseModal appResponseModal;
    private final AboutModal aboutModal;
    private final LoginModal loginModal;

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

        this.build = this.hashCode();
        this.buildDate = "2025-04-04";

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
        this.addCompetitorModal = null;
        this.updateCompetitorModal = null;
        this.deleteCompetitorModal = null;
        this.httpConnectionHttpExceptionModal = null;
        this.resourcesNotFoundExceptionModal = null;
        this.apiResponseModal = null;
        this.languageSelectorModal = null;
        this.appResponseModal = null;
        this.aboutModal = null;
        this.loginModal = null;

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

        FrameManager.init(this);
    }

    public AppFrame(Image iconImage, String title) {
        super(iconImage, title);
        this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        this.setLayout(null);

        this.build = this.hashCode();
        this.buildDate = "2025-04-04";

        this.closingConfirmationModal = new WindowClosingConfirmationModal();
        this.newPouleModal = new NewPouleModal();
        this.newTableModal = new NewTableModal();
        this.viewCompetitorsModal = new ViewCompetitorsModal();
        this.addCompetitorModal = new AddCompetitorModal();
        this.updateCompetitorModal = new UpdateCompetitorModal();
        this.deleteCompetitorModal = new DeleteCompetitorModal();
        this.httpConnectionHttpExceptionModal = new HttpExceptionModal();
        this.resourcesNotFoundExceptionModal = new ResourcesNotFoundExceptionModal();
        this.apiResponseModal = new ApiResponseModal();
        this.languageSelectorModal = new LanguageSelectorModal();
        this.appResponseModal = new AppResponseModal();
        this.aboutModal = new AboutModal();
        this.loginModal = new LoginModal();

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

        FrameManager.init(this);
        this.createFrameUI();
        this.handleBeforeLaunchQueuedException();
        FrameManager.displayLoginModal();
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
            case RESOURCE_NOT_FOUND_EXCEPTION -> FrameManager.displayResourceNotFoundExceptionModal();
        }
    }

    private void createFrameUI() {
        this.footerPanel.setData();

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
        this.rootPanel.addComponent(this.addCompetitorModal.getBackgroundPanel(), Position.HIGH);
        this.rootPanel.addComponent(this.updateCompetitorModal.getBackgroundPanel(), Position.HIGH);
        this.rootPanel.addComponent(this.deleteCompetitorModal.getBackgroundPanel(), Position.HIGH);
        this.rootPanel.addComponent(this.httpConnectionHttpExceptionModal.getBackgroundPanel(), Position.HIGH);
        this.rootPanel.addComponent(this.resourcesNotFoundExceptionModal.getBackgroundPanel(), Position.HIGH);
        this.rootPanel.addComponent(this.apiResponseModal.getBackgroundPanel(), Position.HIGH);
        this.rootPanel.addComponent(this.languageSelectorModal.getBackgroundPanel(), Position.HIGH);
        this.rootPanel.addComponent(this.appResponseModal.getBackgroundPanel(), Position.HIGH);
        this.rootPanel.addComponent(this.aboutModal.getBackgroundPanel(), Position.HIGH);
        this.rootPanel.addComponent(this.loginModal.getBackgroundPanel(), Position.HIGH);

        this.aboutModal.setUpBuildDisplay();

        this.closingConfirmationModal.disappear();
        this.newPouleModal.disappear();
        this.newTableModal.disappear();
        this.viewCompetitorsModal.disappear();
        this.addCompetitorModal.disappear();
        this.updateCompetitorModal.disappear();
        this.deleteCompetitorModal.disappear();
        this.httpConnectionHttpExceptionModal.disappear();
        this.resourcesNotFoundExceptionModal.disappear();
        this.apiResponseModal.disappear();
        this.languageSelectorModal.disappear();
        this.appResponseModal.disappear();
        this.aboutModal.disappear();
        this.loginModal.disappear();

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