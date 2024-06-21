package edu.austral.ingsis.clifford.commands;

import edu.austral.ingsis.clifford.CLI;

import java.util.List;

public class Cd implements Command{
    private final CLI CLI;

    public Cd (CLI CLI){
        this.CLI = CLI;
    }

    @Override
    public String run(List<String> flags, List<String> args) {
        return "";
    }
}
