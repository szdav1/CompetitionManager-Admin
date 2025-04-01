package com._2p1team.cmadmin.app.view.components.modals;

import com._2p1team.cmadmin.app.control.components.modal.language.LanguageSelectorModalController;
import com._2p1team.cmadmin.app.view.components.menu.MenuButton;
import com._2p1team.cmadmin.general.constants.Language;
import static com._2p1team.cmadmin.general.constants.SizeData.*;
import com._2p1team.cmadmin.general.io.LanguageOption;
import com._2p1team.cmadmin.general.util.AppearanceRepository;
import com._2p1team.cmadmin.swing.override.components.label.Label;
import com._2p1team.cmadmin.swing.override.graphics.Appearance;
import lombok.Getter;

import javax.swing.JComponent;
import java.awt.Rectangle;
import java.util.List;

@Getter
public final class LanguageSelectorModal extends AbstractModal {

    private final MenuButton selectorButton;
    private final Label informationLabel;
    private final List<LanguageOption> options;

    public LanguageSelectorModal() {
        super();
        this.setTitle(Language.get("SelectLanguage"));
        this.getCenterPanel().setLayout(null);

        this.selectorButton = new MenuButton(Language.get("SelectLanguage"), new Appearance(AppearanceRepository.BASE_BUTTON_APPEARANCE));
        this.selectorButton.setBounds(new Rectangle((this.getWidth()/2)-(W_BUTTON_WIDTH/2), 0, W_BUTTON_WIDTH, BUTTON_HEIGHT));
        this.selectorButton.setDropdownPanelPosition(this.selectorButton.getX(), this.selectorButton.getY()+BUTTON_HEIGHT);

        this.informationLabel = new Label(
            new Rectangle(0, this.selectorButton.getY()+(BUTTON_HEIGHT*6), this.getWidth(), BUTTON_HEIGHT),
            Language.get("RestartInfo"),
            AppearanceRepository.BUILD_LABEL_APPEARANCE
        );

        this.options = List.of(new LanguageOption("English", "English"), new LanguageOption("German", "German"), new LanguageOption("Magyar", "Hun"));

        this.setUpSelector(this.options);
        this.setUpComponent();
        new LanguageSelectorModalController(this);
    }

    private void setUpSelector(final List<LanguageOption> options) {
        options.forEach(option -> this.selectorButton.addButtonToDropdownPanel(option.optionName(), new Appearance(AppearanceRepository.BASE_BUTTON_APPEARANCE)));
    }

    @Override
    public void setUpComponent() {
        this.getCenterPanel().addComponent(this.selectorButton);
        this.getCenterPanel().addComponent(this.selectorButton.getDropdownPanel());
        this.getCenterPanel().addComponent(this.informationLabel);

        this.selectorButton.getDropdownPanel().setVisible(false);
    }

    @Override
    public List<JComponent> getControls() {
        return List.of();
    }

    @Override
    public List<JComponent> getKeyControls() {
        return List.of();
    }

}