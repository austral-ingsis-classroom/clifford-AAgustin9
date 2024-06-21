package edu.austral.ingsis.clifford.commands;

import edu.austral.ingsis.clifford.Directory;
import edu.austral.ingsis.clifford.CLI;

import java.util.List;

public class Mkdir implements Command {
    private final CLI cli;

    public Mkdir (CLI cli){
        this.cli = cli;
    }

    @Override
    public String run(List<String> flags, List<String> args) {
        return cli.mkdir(args.getFirst(), cli.actualDir);
    }
}
