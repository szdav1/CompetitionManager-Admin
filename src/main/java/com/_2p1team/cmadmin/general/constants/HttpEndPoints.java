package com._2p1team.cmadmin.general.constants;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum HttpEndPoints {
    GET_ALL_COMPETITORS(HttpConnectionSettings.SETUP.getValue()+ApiSettings.GET_ALL_COMPETITORS.getValue()),
    GET_COMPETITOR(HttpConnectionSettings.SETUP.getValue()+ApiSettings.GET_COMPETITOR.getValue()),
    NEW_COMPETITOR(HttpConnectionSettings.SETUP.getValue()+ApiSettings.NEW_COMPETITOR.getValue()),
    UPDATE_COMPETITOR(HttpConnectionSettings.SETUP.getValue()+ApiSettings.UPDATE_COMPETITOR.getValue()),
    DELETE_COMPETITOR(HttpConnectionSettings.SETUP.getValue()+ApiSettings.DELETE_COMPETITOR.getValue()),

    GET_ALL_COMPETITIONS(HttpConnectionSettings.SETUP.getValue()+ApiSettings.GET_ALL_COMPETITIONS.getValue()),
    GET_COMPETITION(HttpConnectionSettings.SETUP.getValue()+ApiSettings.GET_COMPETITION.getValue()),
    NEW_COMPETITION(HttpConnectionSettings.SETUP.getValue()+ApiSettings.NEW_COMPETITION.getValue()),
    UPDATE_COMPETITION(HttpConnectionSettings.SETUP.getValue()+ApiSettings.UPDATE_COMPETITION.getValue()),

    GET_ALL_LEADERBOARDS(HttpConnectionSettings.SETUP.getValue()+ApiSettings.GET_ALL_LEADERBOARDS.getValue()),
    GET_LEADERBOARD(HttpConnectionSettings.SETUP.getValue()+ApiSettings.GET_LEADERBOARD.getValue()),
    NEW_LEADERBOARD(HttpConnectionSettings.SETUP.getValue()+ApiSettings.NEW_LEADERBOARD.getValue()),
    UPDATE_LEADERBOARD(HttpConnectionSettings.SETUP.getValue()+ApiSettings.UPDATE_LEADERBOARD.getValue()),

    GET_ALL_ADMINS(HttpConnectionSettings.SETUP.getValue()+ApiSettings.GET_ALL_ADMINS.getValue()),

    TEST_CONNECTION(HttpConnectionSettings.SETUP.getValue()+ApiSettings.TEST_CONNECTION.getValue());

    private final String url;
}