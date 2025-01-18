package com._2p1team.cmadmin.app.view.components.modals;

import javax.swing.JComponent;
import java.util.List;

/*
* FIXME
* =====
* Things needed in order to connect to a database
* URL:
*       Append to the beginning: jdbc:mysql://
*       Append to the end:       ?useSSL=false&serverTimezone=UTC
* User
* Password
* */
// TODO: Think about whether this is needed or not
public final class DatabaseConnectModal extends AbstractModal {
    public DatabaseConnectModal() {
        super();
    }

    @Override
    public void setUpComponent() {

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