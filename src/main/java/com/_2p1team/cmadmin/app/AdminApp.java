package com._2p1team.cmadmin.app;

import com._2p1team.cmadmin.app.view.frame.AppFrame;
import com._2p1team.cmadmin.support.util.Util;

public final class AdminApp {

    // TODO: Start making the table
    // TODO: After completing the table, merge the poule and the table together to create the competition
    public static void main(String[] args) {
        AppFrame frame = new AppFrame(Util.loadImageIcon("/assets/appIcon.png").getImage(), "CompetitionManager - Admin");
    }

}