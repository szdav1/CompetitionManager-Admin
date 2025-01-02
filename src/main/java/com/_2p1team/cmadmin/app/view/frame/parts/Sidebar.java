package com._2p1team.cmadmin.app.view.frame.parts;

import static com._2p1team.cmadmin.support.appdata.SizeData.SIDEBAR_SIZE;
import com._2p1team.cmadmin.support.util.AppearanceRepository;
import com._2p1team.cmadmin.swing.override.components.panel.Panel;

public final class Sidebar extends Panel {
    public Sidebar() {
        super(SIDEBAR_SIZE, AppearanceRepository.SIDEBAR_APPEARANCE);
    }
}