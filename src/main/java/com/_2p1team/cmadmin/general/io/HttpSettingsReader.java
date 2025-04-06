package com._2p1team.cmadmin.general.io;


import com._2p1team.cmadmin.general.constants.IOData;

import java.util.Map;

public final class HttpSettingsReader extends AbstractReader {

    public Map<String, String> readHttpSettings() {
        return this.read(IOData.HTTP_SETTINGS_PATH.getData());
    }

}