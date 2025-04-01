package com._2p1team.cmadmin.app.control.components.modal.language;

import com._2p1team.cmadmin.app.control.AbstractController;
import com._2p1team.cmadmin.app.view.components.menu.MenuButton;
import com._2p1team.cmadmin.app.view.components.modals.LanguageSelectorModal;
import com._2p1team.cmadmin.general.constants.IOData;
import com._2p1team.cmadmin.general.io.LanguageOption;
import com._2p1team.cmadmin.general.io.LanguageWrite;
import com._2p1team.cmadmin.general.util.ResourceManager;
import com._2p1team.cmadmin.swing.override.components.button.Button;
import com.google.gson.Gson;

import java.awt.event.ActionEvent;
import java.io.FileWriter;
import java.util.List;

public final class LanguageSelectorModalController extends AbstractController {

    private final LanguageSelectorModal modal;
    private final MenuButton selectorButton;
    private final List<Button> buttons;
    private final Gson converter;

    public LanguageSelectorModalController(final LanguageSelectorModal component) {
        super(component);

        this.modal = component;
        this.selectorButton = modal.getSelectorButton();
        this.buttons = this.selectorButton.getButtons();
        this.converter = new Gson();

        this.addListeners();
        new LanguageSelectorModalKeyController(modal);
    }

    private void addListeners() {
        this.selectorButton.addActionListener(this);
        this.buttons.forEach(button -> button.addActionListener(this));
    }

    private void handleDropdownPanel() {
        this.selectorButton.getDropdownPanel().setVisible(this.selectorButton.isToggled());
        this.modal.repaint();
    }

    private LanguageOption getSelectedLanguageOption(final String language) {
        return this.modal.getOptions()
            .stream()
            .filter(option -> option.optionName().equalsIgnoreCase(language))
            .toList()
            .getFirst();
    }

    private void writeSelectedLanguageToSettingsFile(final LanguageOption languageOption) {
        try (FileWriter writer = new FileWriter(ResourceManager.get(IOData.SETTINGS_PATH.getData()))) {
            this.converter.toJson(new LanguageWrite(languageOption.filePath()), writer);
        }
        catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(this.selectorButton)) {
            this.selectorButton.setToggled(!this.selectorButton.isToggled());
            this.handleDropdownPanel();
        }
        else {
            this.buttons.stream()
                .filter(button -> e.getSource().equals(button))
                .forEach(button -> {
                    this.selectorButton.setToggled(!this.selectorButton.isToggled());
                    this.handleDropdownPanel();
                    this.writeSelectedLanguageToSettingsFile(this.getSelectedLanguageOption(button.getText()));
                });
        }
    }

}