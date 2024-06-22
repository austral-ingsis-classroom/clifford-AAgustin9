package edu.austral.ingsis;

import edu.austral.ingsis.clifford.CLI;

import java.util.ArrayList;
import java.util.List;

public class TestRunnerImpl implements FileSystemRunner{
    private final CLI cli;

    public TestRunnerImpl(CLI cli) {
        this.cli = cli;
    }

    @Override
    public List<String> executeCommands(List<String> commands) {
        List<String> results = new ArrayList<>();
        for (String command: commands) {
            results.add(cli.executeCommand(command));
        }
        return results;
    }
}
