/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.shone.opensubtitlescli.command;

import picocli.CommandLine;

@CommandLine.Command(
        name = "search",
        description = "Searches for subtitles"
)
public class SearchCommand implements Runnable {

    @CommandLine.Parameters(arity = "1")
    private String searchQuery;

    @CommandLine.Option(
            names = {"--imdb"},
            description = "signifies that the search query is in fact IMDB ID of the video"
    )
    private boolean isImdbId;

    @CommandLine.Option(
            names = {"-h", "--help"},
            usageHelp = true,
            description = "display this help message"
    )
    boolean usageHelpRequested;

    @Override
    public void run() {
        String msg = "Searching for \"" + searchQuery + "\""
                + (isImdbId ? " by IMDB ID" : "");

        System.out.println(msg);
    }

}
