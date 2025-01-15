package com._2p1team.cmadmin.app;

import com._2p1team.cmadmin.app.view.frame.AppFrame;

public final class App {
    public static void main(String[] args) {
        /*
         * TODO: Implement language
         *       Work out a better way for the Settings to be loaded and handled
         *       Work out a better way for size calculations
         *       Add controller to dropdown panel buttons
         *       Create different Appearances for the dropdown panel buttons and optimise their working and
         *          the structure of the controller code
         * */
        AppFrame frame = new AppFrame(null, "CompetitionManager - Admin");
    }
}