package com._2p1team.cmadmin.support.util;

import com._2p1team.cmadmin.app.model.fencer.Fencer;
import com.google.gson.Gson;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;

@AllArgsConstructor(access = AccessLevel.NONE)
public final class Json {

    private static Gson gson = new Gson();

    public static Fencer convertJsonToFencer(final String jsonObject) {
        return gson.fromJson(jsonObject, Fencer.class);
    }

}