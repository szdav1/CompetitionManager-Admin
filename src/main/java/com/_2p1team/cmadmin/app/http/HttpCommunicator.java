package com._2p1team.cmadmin.app.http;

import com._2p1team.cmadmin.app.databasemodels.competitor.Competitor;
import com._2p1team.cmadmin.support.constants.BeforeLaunchExceptionType;
import com._2p1team.cmadmin.support.constants.HttpEndPoints;
import com._2p1team.cmadmin.support.util.BeforeLaunchExceptionQueue;
import com._2p1team.cmadmin.support.util.JsonConverter;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor(access=AccessLevel.NONE)
public final class HttpCommunicator {

    private static HttpRequest request;
    private static final HttpClient client = HttpClient.newHttpClient();
    private static HttpResponse<String> response;

    @AllArgsConstructor(access=AccessLevel.NONE)
    public static final class CompetitorApi {

        public static List<Competitor> getAllCompetitors() {
            try {
                HttpCommunicator.request = HttpRequest.newBuilder()
                    .uri(new URI(HttpEndPoints.GET_ALL_COMPETITORS.getUrl()))
                    .GET()
                    .build();

                HttpCommunicator.response = client.send(request, HttpResponse.BodyHandlers.ofString());

                return JsonConverter.jsonToFencers(response.body());
            }
            catch (Exception exception) {
                BeforeLaunchExceptionQueue.setExceptionType(BeforeLaunchExceptionType.HTTP_COMMUNICATION_EXCEPTION);
            }

            return new ArrayList<>();
        }

    }

}