package com._2p1team.cmadmin.support.util;

import com._2p1team.cmadmin.support.constants.appearances.*;
import com._2p1team.cmadmin.swing.override.graphics.Appearance;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;

@AllArgsConstructor(access=AccessLevel.NONE)
public final class AppearanceRepository {

    public static final Appearance ROOT_PANEL_APPEARANCE = new RootPanelAppearance();

    public static final Appearance BACKGROUND_LABEL_APPEARANCE = new BackgroundLabelAppearance();

    public static final Appearance MAIN_PANEL_APPEARANCE = new MainPanelAppearance();

    public static final Appearance TITLE_BAR_APPEARANCE = new TitleBarAppearance();

    public static final Appearance CENTER_PANEL_APPEARANCE = new CenterPanelAppearance();

    public static final Appearance EXIT_BUTTON_APPEARANCE = new ExitButtonAppearance();

    public static final Appearance ICONIFY_BUTTON_APPEARANCE = new IconifyButtonAppearance();

    public static final Appearance TITLE_TEXT_APPEARANCE = new TitleTextAppearance();

    public static final Appearance FILE_MENU_BUTTON_APPEARANCE = new FileMenuButtonAppearance();

    public static final Appearance DATABASE_MENU_BUTTON_APPEARANCE = new DatabaseMenuButtonAppearance();

    public static final Appearance SETTINGS_MENU_BUTTON_APPEARANCE = new SettingsMenuButtonAppearance();

    public static final Appearance DROPDOWN_APPEARANCE = new DropdownAppearance();

    public static final Appearance BASE_BUTTON_APPEARANCE = new BaseButtonAppearance();

    public static final Appearance MODAL_TITLE_BAR_APPEARANCE = new ModalTitleBarAppearance();

    public static final Appearance MODAL_BACKGROUND_APPEARANCE = new ModalBackgroundAppearance();

    public static final Appearance MODAL_APPEARANCE = new ModalAppearance();

    public static final Appearance MODAL_CENTER_PANEL_APPEARANCE = new ModalCenterPanelAppearance();

    public static final Appearance MODAL_TITLE_LABEL_APPEARANCE = new ModalTitleLabelAppearance();

    public static final Appearance EXIT_CONFIRM_LABEL_APPEARANCE = new ExitConfirmLabelAppearance();

    public static final Appearance EXIT_LABEL_APPEARANCE = new ExitLabelAppearance();

    public static final Appearance BASE_LABEL_APPEARANCE = new BaseLabelAppearance();

    public static final Appearance COMPETITOR_COMPONENT_APPEARANCE = new CompetitorComponentAppearance();

    public static final Appearance HTTP_EXCEPTION_LABEL_APPEARANCE = new HttpExceptionLabelAppearance();

    public static final Appearance BASE_SCROLL_PANEL_APPEARANCE = new BaseScrollPanelAppearance();

}