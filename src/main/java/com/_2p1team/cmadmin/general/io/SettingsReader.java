package com._2p1team.cmadmin.general.io;

import com._2p1team.cmadmin.general.constants.IOData;

import java.util.Map;

public final class SettingsReader extends AbstractReader {

    public Map<String, String> readSettings() {
        return this.read(IOData.SETTINGS_PATH.getData());
    }

}