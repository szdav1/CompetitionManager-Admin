package com._2p1team.cmadmin.app.view.components.modals;

import javax.swing.JComponent;
import java.util.List;

public final class DatabaseConnectModal extends AbstractModal {
    public DatabaseConnectModal() {
        super();
    }

    @Override
    public List<JComponent> getControls() {
        return List.of(this.getCloseButton());
    }
}