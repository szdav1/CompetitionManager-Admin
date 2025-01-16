package com._2p1team.cmadmin.app.view.components.modals;

import javax.swing.JComponent;
import java.util.List;

public final class WindowClosingConfirmationModal extends AbstractModal {
    @Override
    public List<JComponent> getControls() {
        return List.of(this.getCloseButton());
    }

    @Override
    public List<JComponent> getKeyControls() {
        return List.of(this.getCloseButton());
    }
}