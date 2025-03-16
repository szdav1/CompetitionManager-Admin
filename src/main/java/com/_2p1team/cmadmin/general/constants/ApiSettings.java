package com._2p1team.cmadmin.general.constants;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ApiSettings {
    API_DOMAIN("/api/"),

    GET_ALL_COMPETITORS(API_DOMAIN.value+"competitor/"),
    GET_COMPETITOR(API_DOMAIN.value+"competitor/%d"),
    NEW_COMPETITOR(API_DOMAIN.value+"competitor/new"),
    UPDATE_COMPETITOR(API_DOMAIN.value+"competitor/update/%d"),
    DELETE_COMPETITOR(API_DOMAIN.value+"competitor/delete/%d"),

    GET_ALL_COMPETITIONS(API_DOMAIN.value+"competition/"),
    GET_COMPETITION(API_DOMAIN.value+"competition/%d"),
    NEW_COMPETITION(API_DOMAIN.value+"competition/new"),
    UPDATE_COMPETITION(API_DOMAIN.value+"competition/%d"),

    GET_ALL_LEADERBOARDS(API_DOMAIN.value+"leaderboard/"),
    GET_LEADERBOARD(API_DOMAIN.value+"leaderboard/%d"),
    NEW_LEADERBOARD(API_DOMAIN.value+"leaderboard/new"),
    UPDATE_LEADERBOARD(API_DOMAIN.value+"leaderboard/%d"),

    TEST_CONNECTION(API_DOMAIN.value+"test");

    private final String value;
}