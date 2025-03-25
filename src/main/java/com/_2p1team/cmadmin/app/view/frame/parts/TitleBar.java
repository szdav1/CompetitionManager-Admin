package com._2p1team.cmadmin.app.view.frame.parts;

import com._2p1team.cmadmin.app.control.frame.parts.TitleBarController;
import com._2p1team.cmadmin.app.view.components.menu.MenuButton;
import com._2p1team.cmadmin.app.view.frame.FrameManager;
import com._2p1team.cmadmin.app.view.interfaces.ComplexComponent;
import com._2p1team.cmadmin.app.view.interfaces.ControlComponent;
import com._2p1team.cmadmin.app.view.interfaces.KeyControlledComponent;
import com._2p1team.cmadmin.general.constants.AppearanceConstants;
import com._2p1team.cmadmin.general.constants.SizeData;
import static com._2p1team.cmadmin.general.constants.SizeData.*;
import com._2p1team.cmadmin.general.util.AppearanceRepository;
import com._2p1team.cmadmin.swing.override.components.button.Button;
import com._2p1team.cmadmin.swing.override.components.label.Label;
import com._2p1team.cmadmin.swing.override.components.panel.Panel;
import com._2p1team.cmadmin.swing.override.constants.Position;
import com._2p1team.cmadmin.swing.override.graphics.Appearance;
import lombok.Getter;

import javax.swing.JComponent;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.util.List;

@Getter
public final class TitleBar extends Panel implements ComplexComponent, ControlComponent, KeyControlledComponent {

    private final Button exitButton;
    private final Button iconifyButton;

    private final Panel leftPanel;
    private final Panel centerPanel;
    private final Panel rightPanel;

    private final MenuButton fileButton;
    private final MenuButton databaseButton;
    private final MenuButton settingsButton;

    private final Label titleLabel;
    private final TitleBarController controller;

    public TitleBar() {
        this(TITLE_SIZE);
    }

    public TitleBar(final Dimension preferredSize) {
        super(preferredSize, new GridLayout(1, 3), AppearanceRepository.TITLE_BAR_APPEARANCE);

        this.exitButton = new Button(N_BUTTON_SIZE, "x", AppearanceRepository.EXIT_BUTTON_APPEARANCE);
        this.iconifyButton = new Button(N_BUTTON_SIZE, "_", AppearanceRepository.ICONIFY_BUTTON_APPEARANCE);

        this.leftPanel = new Panel(new Dimension(), new FlowLayout(FlowLayout.LEFT, 0, 0), this.getAppearance());
        this.centerPanel = new Panel(new Dimension(), new FlowLayout(FlowLayout.CENTER, 0, 0), this.getAppearance());
        this.rightPanel = new Panel(new Dimension(), new FlowLayout(FlowLayout.RIGHT, 0, 0), this.getAppearance());

        this.fileButton = new MenuButton("File", AppearanceRepository.FILE_MENU_BUTTON_APPEARANCE);
        this.initFileMenu();

        this.databaseButton = new MenuButton("Database", AppearanceRepository.DATABASE_MENU_BUTTON_APPEARANCE);
        this.initDatabaseMenu();

        this.settingsButton = new MenuButton("Settings", AppearanceRepository.SETTINGS_MENU_BUTTON_APPEARANCE);
        this.initSettingsMenu();

        this.titleLabel = new Label(TITLE_TEXT_SIZE, "CompetitionManager", AppearanceRepository.TITLE_TEXT_APPEARANCE);
        this.controller = new TitleBarController(this);

        this.setUpComponent();
    }

    private void initFileMenu() {
        this.fileButton.addButtonToDropdownPanel("Competition [F1]", new Appearance(AppearanceRepository.BASE_BUTTON_APPEARANCE));
        this.fileButton.addButtonToDropdownPanel("Poule [F3]", new Appearance(AppearanceRepository.BASE_BUTTON_APPEARANCE));
        this.fileButton.addButtonToDropdownPanel("Table [F5]", new Appearance(AppearanceRepository.BASE_BUTTON_APPEARANCE));

        this.fileButton.getButtons()
            .forEach(button -> {
                button.setBorder(new EmptyBorder(0, AppearanceConstants.PADDING, 0, 0));
                button.setHorizontalAlignment(SwingConstants.LEFT);
            });
    }

    private void initDatabaseMenu() {
        this.databaseButton.getDropdownPanel().setSize(X_BUTTON_WIDTH, BUTTON_HEIGHT*4);
        this.databaseButton.addButtonToDropdownPanel("View [F2]", new Appearance(AppearanceRepository.BASE_BUTTON_APPEARANCE));
        this.databaseButton.addButtonToDropdownPanel("Add Competitor [F4]", new Appearance(AppearanceRepository.BASE_BUTTON_APPEARANCE));
        this.databaseButton.addButtonToDropdownPanel("Update Competitor [F6]", new Appearance(AppearanceRepository.BASE_BUTTON_APPEARANCE));
        this.databaseButton.addButtonToDropdownPanel("Remove Competitor [F8]", new Appearance(AppearanceRepository.BASE_BUTTON_APPEARANCE));

        this.databaseButton.getButtons()
            .forEach(button -> {
                button.setBorder(new EmptyBorder(0, AppearanceConstants.PADDING, 0, 0));
                button.setHorizontalAlignment(SwingConstants.LEFT);
            });
    }

    private void initSettingsMenu() {
        this.settingsButton.addButtonToDropdownPanel("Window", new Appearance(AppearanceRepository.BASE_BUTTON_APPEARANCE));
        this.settingsButton.addButtonToDropdownPanel("Language", new Appearance(AppearanceRepository.BASE_BUTTON_APPEARANCE));
        this.settingsButton.addButtonToDropdownPanel("About", new Appearance(AppearanceRepository.BASE_BUTTON_APPEARANCE));

        this.settingsButton.getButtons()
            .forEach(button -> {
                button.setBorder(new EmptyBorder(0, AppearanceConstants.PADDING, 0, 0));
                button.setHorizontalAlignment(SwingConstants.LEFT);
            });
    }

    public void setUpFileMenu() {
        this.fileButton.setDropdownPanelPosition(0, 0);
        FrameManager.addToFrame(this.fileButton.getDropdownPanel(), Position.HIGH);
        this.fileButton.getDropdownPanel()
            .setVisible(false);
    }

    public void setUpDatabaseMenu() {
        this.databaseButton.setDropdownPanelPosition(SizeData.BUTTON_WIDTH, 0);
        FrameManager.addToFrame(this.databaseButton.getDropdownPanel(), Position.HIGH);
        this.databaseButton.getDropdownPanel()
            .setVisible(false);
    }

    public void setUpSettingsMenu() {
        this.settingsButton.setDropdownPanelPosition(SizeData.BUTTON_WIDTH*2, 0);
        FrameManager.addToFrame(this.settingsButton.getDropdownPanel(), Position.HIGH);
        this.settingsButton.getDropdownPanel()
            .setVisible(false);
    }

    @Override
    public void setUpComponent() {
        this.leftPanel.addComponent(this.fileButton);
        this.leftPanel.addComponent(this.databaseButton);
        this.leftPanel.addComponent(this.settingsButton);

        this.centerPanel.addComponent(this.titleLabel);

        this.rightPanel.addComponent(this.iconifyButton);
        this.rightPanel.addComponent(this.exitButton);

        this.addComponent(this.leftPanel);
        this.addComponent(this.centerPanel);
        this.addComponent(this.rightPanel);
    }

    @Override
    public List<JComponent> getControls() {
        return List.of(this.exitButton, this.iconifyButton, this.fileButton, this.databaseButton, this.settingsButton);
    }

    @Override
    public List<JComponent> getKeyControls() {
        return List.of(this.exitButton);
    }

}