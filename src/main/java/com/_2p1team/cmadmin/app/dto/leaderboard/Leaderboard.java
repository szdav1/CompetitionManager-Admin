package com._2p1team.cmadmin.app.dto.leaderboard;

public record Leaderboard(
    long competitionId,
    long competitorId,
    int placement
) {

}