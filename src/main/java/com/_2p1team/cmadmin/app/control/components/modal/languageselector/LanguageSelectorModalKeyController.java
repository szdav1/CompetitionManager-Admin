package com._2p1team.cmadmin.app.control.components.modal.languageselector;

import com._2p1team.cmadmin.app.control.AbstractKeyController;
import com._2p1team.cmadmin.app.view.components.modals.LanguageSelectorModal;
import com._2p1team.cmadmin.app.view.frame.FrameManager;

import javax.swing.AbstractAction;
import javax.swing.JComponent;
import javax.swing.KeyStroke;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

public final class LanguageSelectorModalKeyController extends AbstractKeyController {

    private final LanguageSelectorModal modal;

    public LanguageSelectorModalKeyController(final LanguageSelectorModal keyControlledComponent) {
        super(keyControlledComponent);

        this.modal = keyControlledComponent;

        this.modal.getBackgroundPanel()
            .getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW)
            .put(KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), "CloseLanguageSelectorModalAction");

        this.modal.getBackgroundPanel()
            .getActionMap()
            .put("CloseLanguageSelectorModalAction", new CloseLanguageSelectorModalAction());
    }

    private static final class CloseLanguageSelectorModalAction extends AbstractAction {

        @Override
        public void actionPerformed(ActionEvent e) {
            FrameManager.hideOpenedModal();
        }

    }

}