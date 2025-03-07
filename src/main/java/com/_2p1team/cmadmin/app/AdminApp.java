package com._2p1team.cmadmin.app;

import com._2p1team.cmadmin.app.view.frame.AppFrame;
import com._2p1team.cmadmin.support.constants.BeforeLaunchExceptionType;
import com._2p1team.cmadmin.support.util.BeforeLaunchExceptionQueue;
import com._2p1team.cmadmin.support.util.Util;

public final class AdminApp {

    // TODO: Merge the poule and the table together to create the competition
    public static void main(String[] args) {
//        HttpCommunicator.ConnectionTester.testApiConnection();

        AppFrame frame = BeforeLaunchExceptionQueue.getExceptionType() == BeforeLaunchExceptionType.FATAL_ERROR ?
            new AppFrame() :
            new AppFrame(Util.loadImageIcon("/assets/appIcon.png").getImage(), "CompetitionManager - Admin");

        frame.setVisible(true);
    }

}