package com._2p1team.cmadmin.support.constants;

import lombok.Getter;

@Getter
public enum HttpEndPoints {
    GET_ALL_COMPETITORS(ApiSettings.GET_ALL_COMPETITORS.getValue()),
    GET_COMPETITOR(ApiSettings.GET_COMPETITOR.getValue()),
    NEW_COMPETITOR(ApiSettings.NEW_COMPETITOR.getValue()),
    UPDATE_COMPETITOR(ApiSettings.UPDATE_COMPETITOR.getValue()),
    DELETE_COMPETITOR(ApiSettings.DELETE_COMPETITOR.getValue()),

    GET_ALL_COMPETITIONS(ApiSettings.GET_ALL_COMPETITIONS.getValue()),
    GET_COMPETITION(ApiSettings.GET_COMPETITION.getValue()),
    NEW_COMPETITION(ApiSettings.NEW_COMPETITION.getValue()),
    UPDATE_COMPETITION(ApiSettings.UPDATE_COMPETITION.getValue()),

    GET_ALL_LEADERBOARDS(ApiSettings.GET_ALL_LEADERBOARDS.getValue()),
    GET_LEADERBOARD(ApiSettings.GET_LEADERBOARD.getValue()),
    NEW_LEADERBOARD(ApiSettings.NEW_LEADERBOARD.getValue()),
    UPDATE_LEADERBOARD(ApiSettings.UPDATE_LEADERBOARD.getValue());

    private final String url;

    HttpEndPoints(final String url) {
        this.url = HttpConnectionSettings.SETUP.getValue()+url;
    }
}