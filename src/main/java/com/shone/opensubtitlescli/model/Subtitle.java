package com.shone.opensubtitlescli.model;

import com.squareup.moshi.Json;

public class Subtitle {

    @Json(name = "SubFileName")
    public String fileName;

    @Json(name = "SubLanguageID")
    public String language;

    @Json(name = "SubFormat")
    public String format;

    @Json(name = "SubDownloadLink")
    public String downloadUrl;

    @Json(name = "InfoReleaseGroup")
    public String infoReleaseGroup;

    @Json(name = "InfoFormat")
    public String infoFormat;

    @Json(name = "MovieReleaseName")
    public String movieReleaseName;

    @Json(name = "MovieName")
    public String movieName;

    @Json(name = "MovieYear")
    public String movieYear;

    @Json(name = "MovieKind")
    public String movieKind;

    @Json(name = "SeriesSeason")
    public String seriesSeason;

    @Json(name = "SeriesEpisode")
    public String seriesEpisode;

    public String getFileName() {
        return fileName;
    }

    public String getLanguage() {
        return language;
    }

    public String getFormat() {
        return format;
    }

    public String getDownloadUrl() {
        return downloadUrl;
    }

    public String getInfoReleaseGroup() {
        return infoReleaseGroup;
    }

    public String getInfoFormat() {
        return infoFormat;
    }

    public String getMovieReleaseName() {
        return movieReleaseName;
    }

    public String getMovieName() {
        return movieName;
    }

    public String getMovieYear() {
        return movieYear;
    }

    public String getMovieKind() {
        return movieKind;
    }

    public String getSeriesSeason() {
        return seriesSeason;
    }

    public String getSeriesEpisode() {
        return seriesEpisode;
    }

}
