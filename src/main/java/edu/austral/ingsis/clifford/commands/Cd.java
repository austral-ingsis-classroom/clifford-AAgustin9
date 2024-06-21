package edu.austral.ingsis.clifford.commands;

import edu.austral.ingsis.clifford.Terminal;

import java.util.List;

public class Cd implements Command{
    private final Terminal terminal;

    public Cd (Terminal terminal){
        this.terminal = terminal;
    }

    @Override
    public String run(List<String> flags, List<String> args) {
        return "";
    }
}
