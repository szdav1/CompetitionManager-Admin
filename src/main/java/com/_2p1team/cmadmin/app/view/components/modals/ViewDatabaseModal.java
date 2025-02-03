package com._2p1team.cmadmin.app.view.components.modals;

import com._2p1team.cmadmin.app.model.fencer.Fencer;
import com._2p1team.cmadmin.app.model.http.HttpCommunicator;
import com._2p1team.cmadmin.support.util.Json;

import javax.swing.JComponent;
import java.util.List;

/*
 * Things needed in order to connect to a database
 * URL:
 *       Append to the beginning: jdbc:mysql://
 *       Append to the end:       ?useSSL=false&serverTimezone=UTC
 * User
 * Password
 * */
public final class ViewDatabaseModal extends AbstractModal {

    public ViewDatabaseModal() {
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

    @Override
    public void appear() {
        super.appear();
        Fencer f = Json.convertJsonToFencer(HttpCommunicator.sendGetRequest(String.format("/api/competitor/%d", 1)));
        System.out.println(f);
    }

}