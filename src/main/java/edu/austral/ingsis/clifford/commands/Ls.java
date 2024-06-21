package edu.austral.ingsis.clifford.commands;

import edu.austral.ingsis.clifford.Terminal;

import java.util.List;

public class Ls implements Command{
    private final Terminal terminal;

    public Ls (Terminal terminal){
        this.terminal = terminal;
    }

    @Override
    public void run(List<String> flags, List<String> args) {

    }
}
