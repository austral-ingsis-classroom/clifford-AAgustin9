package edu.austral.ingsis.clifford.commands;

import edu.austral.ingsis.clifford.Terminal;

import java.util.List;

public class Pwd implements Command {
    private final Terminal terminal;

    public Pwd (Terminal terminal){
        this.terminal = terminal;
    }

    @Override
    public String run(List<String> flags, List<String> args) {
        return "";
    }
}
