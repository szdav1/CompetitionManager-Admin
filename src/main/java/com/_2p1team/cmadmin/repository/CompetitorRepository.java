package com._2p1team.cmadmin.repository;

import com._2p1team.cmadmin.app.dto.competitor.Competitor;
import com._2p1team.cmadmin.app.http.HttpCommunicator;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;

import java.util.List;

@AllArgsConstructor(access=AccessLevel.NONE)
public final class CompetitorRepository {

    public static final List<Competitor> competitors = HttpCommunicator.CompetitorApi.getAllCompetitors();

}