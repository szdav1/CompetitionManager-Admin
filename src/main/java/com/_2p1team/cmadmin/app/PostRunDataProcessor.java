package com._2p1team.cmadmin.app;

import com._2p1team.cmadmin.general.constants.IOData;
import com._2p1team.cmadmin.general.constants.Language;
import com._2p1team.cmadmin.general.constants.Settings;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;

@AllArgsConstructor(access=AccessLevel.NONE)
public final class PostRunDataProcessor {

    public static void start() {
        Settings.initialize();
        Language.initialize(IOData.LANGUAGE_PATH.getData()+Settings.get("language")+".json");
    }

}