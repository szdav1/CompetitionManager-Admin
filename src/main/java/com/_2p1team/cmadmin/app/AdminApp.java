package com._2p1team.cmadmin.app;

import com._2p1team.cmadmin.app.view.frame.AppFrame;
import com._2p1team.cmadmin.general.util.ResourceManager;
import com._2p1team.cmadmin.general.util.Util;

public final class AdminApp {

    public static void main(String[] args) {
        ResourceManager.setProductionResourceRoot("main");
        PostRunDataProcessor.start();

        AppFrame appFrame = new AppFrame(Util.loadImageIcon("/assets/appIcon.png").getImage(), "CompetitionManager - Admin");

        appFrame.setVisible(true);
    }

}