package com._2p1team.cmadmin.general.util;

import com._2p1team.cmadmin.app.dto.admins.Admins;
import com._2p1team.cmadmin.app.dto.competition.Competition;
import com._2p1team.cmadmin.app.dto.competition.CompetitionTransfer;
import com._2p1team.cmadmin.app.dto.competitor.Competitor;
import com._2p1team.cmadmin.app.dto.competitor.CompetitorUploadModel;
import com._2p1team.cmadmin.app.dto.leaderboard.Leaderboard;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;

import java.lang.reflect.Type;
import java.util.List;

@AllArgsConstructor(access=AccessLevel.NONE)
public final class JsonConverter {

    private static final Gson converter = new Gson();

    public static Competitor jsonToCompetitor(final String jsonObject) {
        return converter.fromJson(jsonObject, Competitor.class);
    }

    public static List<Competitor> jsonToCompetitors(final String jsonObject) {
        Type type = new TypeToken<List<Competitor>>() {}.getType();
        return converter.fromJson(jsonObject, type);
    }

    public static String competitorUploadModelToJson(final CompetitorUploadModel competitorUploadModel) {
        return converter.toJson(competitorUploadModel);
    }

    public static String competitionToJson(final Competition competition) {
        return converter.toJson(competition);
    }

    public static CompetitionTransfer jsonToCompetition(final String jsonObject) {
        return converter.fromJson(jsonObject, CompetitionTransfer.class);
    }

    public static String leaderboardToJson(final Leaderboard leaderboard) {
        return converter.toJson(leaderboard);
    }

    public static List<Admins> jsonToAdminsList(final String jsonObject) {
        Type type = new TypeToken<List<Admins>>() {}.getType();
        return converter.fromJson(jsonObject, type);
    }

}