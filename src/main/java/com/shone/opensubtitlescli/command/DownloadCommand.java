package com.shone.opensubtitlescli.command;

import picocli.CommandLine;

@CommandLine.Command(
        name = "download",
        description = "Downloads the subtitle"
)
public class DownloadCommand implements Runnable {

    @CommandLine.Parameters(
            arity = "1",
            description = "ID of the subtitle that is to be downloaded"
    )
    private String subtitleId;

    @CommandLine.Option(
            names = {"-h", "--help"},
            usageHelp = true,
            description = "display this help message"
    )
    boolean usageHelpRequested;

    @Override
    public void run() {
        System.out.println("Downloading subtitle " + this.subtitleId);
    }

}
