package com.shone.opensubtitlescli;

import com.shone.opensubtitlescli.command.DownloadCommand;
import com.shone.opensubtitlescli.command.SearchCommand;
import java.util.List;
import picocli.CommandLine;
import picocli.CommandLine.Command;
import picocli.CommandLine.Option;

@Command(
        description = "Command line utility for searching and downloading subtitles from opensubtitles.org",
        subcommands = {
            SearchCommand.class,
            DownloadCommand.class
        },
        version = {
            "jOpenSubtitlesCLI 1.0",
            "(c) 2017"
        }
)
public class Main implements Runnable {

    @Option(
            names = {"-h", "--help"},
            usageHelp = true,
            description = "display this help message"
    )
    boolean usageHelpRequested;

    @Option(
            names = {"-v", "--version"},
            versionHelp = true,
            description = "print version information and exit"
    )
    boolean versionRequested;

    public static void main(String[] args) {
        Main m = new Main();
        CommandLine cl = new CommandLine(m);

        List<CommandLine> parsedCommands = cl.parse(args);

        if (m.versionRequested) {
            cl.printVersionHelp(System.out);
        } else if (parsedCommands.size() == 1) {
            CommandLine.usage(m, System.out);
        } else {
            cl.parseWithHandler(new CommandLine.RunAll(), System.err, args);
        }
    }

    @Override
    public void run() {

    }

}
