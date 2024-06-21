package edu.austral.ingsis.clifford.commands;

import edu.austral.ingsis.clifford.CLI;

import java.util.List;

public class Rm implements Command {
    private final CLI CLI;

    public Rm (CLI CLI){
        this.CLI = CLI;
    }

    @Override
    public String run(List<String> flags, List<String> args) {
        return "";
    }
}
