package com._2p1team.cmadmin.app.http;

import com._2p1team.cmadmin.app.dto.admins.Admins;
import com._2p1team.cmadmin.app.dto.competition.Competition;
import com._2p1team.cmadmin.app.dto.competitor.Competitor;
import com._2p1team.cmadmin.app.dto.competitor.CompetitorUploadModel;
import com._2p1team.cmadmin.app.dto.leaderboard.Leaderboard;
import com._2p1team.cmadmin.general.constants.BeforeLaunchExceptionType;
import com._2p1team.cmadmin.general.constants.HttpEndPoints;
import com._2p1team.cmadmin.general.util.BeforeLaunchExceptionQueue;
import com._2p1team.cmadmin.general.util.JsonConverter;
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

                return JsonConverter.jsonToCompetitors(response.body());
            }
            catch (Exception exception) {
                BeforeLaunchExceptionQueue.setExceptionType(BeforeLaunchExceptionType.HTTP_COMMUNICATION_EXCEPTION);
            }

            return new ArrayList<>();
        }

        public static HttpResponse<String> uploadCompetitor(final CompetitorUploadModel competitorUploadModel) {
            try {
                HttpCommunicator.request = HttpRequest.newBuilder()
                    .uri(new URI(HttpEndPoints.NEW_COMPETITOR.getUrl()))
                    .POST(HttpRequest.BodyPublishers.ofString(JsonConverter.competitorUploadModelToJson(competitorUploadModel)))
                    .setHeader("Content-Type", "application/json")
                    .build();

                HttpCommunicator.response = client.send(request, HttpResponse.BodyHandlers.ofString());
            }
            catch (Exception exception) {
                exception.printStackTrace();
            }

            return HttpCommunicator.response;
        }

        public static HttpResponse<String> updateCompetitor(long id, final CompetitorUploadModel competitorUploadModel) {
            try {
                HttpCommunicator.request = HttpRequest.newBuilder()
                    .uri(new URI(String.format(HttpEndPoints.UPDATE_COMPETITOR.getUrl(), id)))
                    .PUT(HttpRequest.BodyPublishers.ofString(JsonConverter.competitorUploadModelToJson(competitorUploadModel)))
                    .setHeader("Content-Type", "application/json")
                    .build();

                HttpCommunicator.response = client.send(request, HttpResponse.BodyHandlers.ofString());
            }
            catch (Exception exception) {
                exception.printStackTrace();
            }

            return HttpCommunicator.response;
        }

        public static HttpResponse<String> deleteCompetitor(long id) {
            try {
                HttpCommunicator.request = HttpRequest.newBuilder()
                    .uri(new URI(String.format(HttpEndPoints.DELETE_COMPETITOR.getUrl(), id)))
                    .DELETE()
                    .build();

                HttpCommunicator.response = client.send(request, HttpResponse.BodyHandlers.ofString());
            }
            catch (Exception exception) {
                exception.printStackTrace();
            }

            return HttpCommunicator.response;
        }

    }

    @AllArgsConstructor(access=AccessLevel.NONE)
    public static final class CompetitionApi {

        public static HttpResponse<String> uploadCompetition(final Competition competition) {
            try {
                HttpCommunicator.request = HttpRequest.newBuilder()
                    .uri(new URI(HttpEndPoints.NEW_COMPETITION.getUrl()))
                    .POST(HttpRequest.BodyPublishers.ofString(JsonConverter.competitionToJson(competition)))
                    .setHeader("Content-Type", "application/json")
                    .build();

                HttpCommunicator.response = client.send(request, HttpResponse.BodyHandlers.ofString());
            }
            catch (Exception exception) {
                exception.printStackTrace();
            }

            return HttpCommunicator.response;
        }

    }

    @AllArgsConstructor(access=AccessLevel.NONE)
    public static final class LeaderboardApi {

        public static HttpResponse<String> uploadResult(final Leaderboard leaderboard) {
            try {
                HttpCommunicator.request = HttpRequest.newBuilder()
                    .uri(new URI(HttpEndPoints.NEW_LEADERBOARD.getUrl()))
                    .POST(HttpRequest.BodyPublishers.ofString(JsonConverter.leaderboardToJson(leaderboard)))
                    .setHeader("Content-Type", "application/json")
                    .build();

                HttpCommunicator.response = client.send(request, HttpResponse.BodyHandlers.ofString());
            }
            catch (Exception exception) {
                exception.printStackTrace();
            }

            return HttpCommunicator.response;
        }

    }

    @AllArgsConstructor(access=AccessLevel.NONE)
    public static final class AdminsApi {

        public static List<Admins> getAllAdmins() {
            try {
                HttpCommunicator.request = HttpRequest.newBuilder()
                    .uri(new URI(HttpEndPoints.GET_ALL_ADMINS.getUrl()))
                    .GET()
                    .build();

                HttpCommunicator.response = client.send(request, HttpResponse.BodyHandlers.ofString());

                return JsonConverter.jsonToAdminsList(response.body());
            }
            catch (Exception exception) {
                BeforeLaunchExceptionQueue.setExceptionType(BeforeLaunchExceptionType.HTTP_COMMUNICATION_EXCEPTION);
            }

            return new ArrayList<>();
        }

    }

}