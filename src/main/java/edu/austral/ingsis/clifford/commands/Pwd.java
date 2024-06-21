package edu.austral.ingsis.clifford.commands;

import edu.austral.ingsis.clifford.CLI;

import java.util.List;

public class Pwd implements Command {
    private final CLI CLI;

    public Pwd (CLI CLI){
        this.CLI = CLI;
    }

    @Override
    public String run(List<String> flags, List<String> args) {
        return "";
    }
}
