package com._2p1team.cmadmin.support.util;

import com._2p1team.cmadmin.app.dto.competitor.Competitor;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;

import java.lang.reflect.Type;
import java.util.List;

@AllArgsConstructor(access=AccessLevel.NONE)
public final class JsonConverter {

    private static final Gson gson = new Gson();

    public static Competitor jsonToFencer(final String jsonObject) {
        return gson.fromJson(jsonObject, Competitor.class);
    }

    public static List<Competitor> jsonToFencers(final String jsonObject) {
        Type type = new TypeToken<List<Competitor>>(){}.getType();
        return gson.fromJson(jsonObject, type);
    }

}