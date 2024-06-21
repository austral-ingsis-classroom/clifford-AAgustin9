package edu.austral.ingsis.clifford.commands;

import edu.austral.ingsis.clifford.CLI;

import java.util.List;

public class Ls implements Command{
    private final CLI cli;

    public Ls (CLI cli){
        this.cli = cli;
    }

    @Override
    public String run(List<String> flags, List<String> args) {
        return "";
    }
}
