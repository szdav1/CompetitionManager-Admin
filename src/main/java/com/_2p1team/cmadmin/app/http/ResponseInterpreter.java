package com._2p1team.cmadmin.app.http;

import com._2p1team.cmadmin.general.constants.Language;

import java.net.http.HttpResponse;

public final class ResponseInterpreter {

    public static final int RESPONSE_CODE_OK = 200;
    public static final int RESPONSE_CODE_CREATED = 201;
    public static final int RESPONSE_CODE_NO_CONTENT = 204;
    public static final int RESPONSE_CODE_ERROR = 400;
    public static final int RESPONSE_CODE_SERVER_ERROR = 500;

    public static String interpretResponse(final HttpResponse<String> response) {
        return switch (response.statusCode()) {
            case RESPONSE_CODE_ERROR -> response.statusCode()+" "+Language.get("CommunicationFailure")+"\n"+response.body();
            case RESPONSE_CODE_SERVER_ERROR -> response.statusCode()+" "+Language.get("InternalServerError");
            default -> Language.get("UnexpectedError");
        };
    }

}