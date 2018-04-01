package com.shone.opensubtitlescli.client;

import com.shone.opensubtitlescli.exception.OpensubtitlesClientErrorResponse;
import com.shone.opensubtitlescli.exception.OpensubtitlesErrorResponse;
import com.shone.opensubtitlescli.model.Subtitle;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.LinkedList;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class Client {

    public static final String REST_ROOT = "https://rest.opensubtitles.org";
    public static final String XMLRPC_ROOT = "http://api.opensubtitles.org/xml-rpc";

    private final OkHttpClient client;

    public Client() {
        this.client = new OkHttpClient();
    }

    public LinkedList<Subtitle> performSearch(String query, boolean isImdbId,
            String language, String season, String episode)
            throws UnsupportedEncodingException, IOException, OpensubtitlesErrorResponse {

        LinkedList<Subtitle> ret = new LinkedList<>();
        String url = buildSearchUrl(query, isImdbId, language, season, episode);
        Request req = new Request.Builder()
                .url(url)
                .build();

        Response res = client.newCall(req).execute();

        if (res.isSuccessful()) {

        } else if (res.code() >= 400 && res.code() < 500) {
            throw new OpensubtitlesClientErrorResponse(req, res);
        } else {
            throw new OpensubtitlesErrorResponse(req, res);
        }

        return ret;
    }

    private String buildSearchUrl(String query, boolean isImdbId,
            String language, String season, String episode)
            throws UnsupportedEncodingException {

        String ret = REST_ROOT + "/search";

        if (isImdbId) {
            ret += "/imdbid-" + query;
        } else {
            String encodedQuery = URLEncoder.encode(query, "UTF-8").replace("+", "%20");
            ret += "query" + encodedQuery;
        }

        if (language != null) {
            ret += "/sublanguageid-" + language;
        }

        if (season != null) {
            ret += "/season-" + season;
        }

        if (episode != null) {
            ret += "/episode-" + episode;
        }

        return ret;
    }
    
    
}
