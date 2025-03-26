package com._2p1team.cmadmin.app;

import com._2p1team.cmadmin.app.view.frame.AppFrame;
import com._2p1team.cmadmin.general.constants.BeforeLaunchExceptionType;
import com._2p1team.cmadmin.general.util.BeforeLaunchExceptionQueue;
import com._2p1team.cmadmin.general.util.ResourceManager;
import com._2p1team.cmadmin.general.util.Util;

public final class AdminApp {

    // TODO: Implement API connection test before launch
    // TODO: Implement login
    // TODO: Implement error display in new table and new poule modals
    public static void main(String[] args) {
        ResourceManager.setProductionResourceRoot("main");
        PostRunDataProcessor.start();

        AppFrame frame = BeforeLaunchExceptionQueue.getExceptionType() == BeforeLaunchExceptionType.FATAL_EXCEPTION ?
            new AppFrame() :
            new AppFrame(Util.loadImageIcon("/assets/appIcon.png").getImage(), "CompetitionManager - Admin");

        frame.setVisible(true);
    }

}