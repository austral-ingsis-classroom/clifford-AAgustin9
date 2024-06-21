package edu.austral.ingsis.clifford.commands;

import edu.austral.ingsis.clifford.CLI;

import java.util.List;

public class Touch implements Command {
    private final CLI cli;

    public Touch (CLI cli){
        this.cli = cli;
    }

    @Override
    public String run(List<String> flags, List<String> args) {
        return "";
    }
}
