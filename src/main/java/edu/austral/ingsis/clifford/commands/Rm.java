package edu.austral.ingsis.clifford.commands;

import edu.austral.ingsis.clifford.CLI;

import java.util.List;

public class Rm implements Command {
    private final CLI cli;

    public Rm (CLI cli){
        this.cli = cli;
    }

    @Override
    public String run(List<String> flags, List<String> args) {
        switch (flags.size() + args.size()) {
            case 0:
                return "Error: No arguments";
            case 1:
                return cli.delete(flags.getFirst(), "");
            case 2:
                return cli.delete(flags.get(1), flags.getFirst());
            default:
                return "Error: Invalid arguments";
        }
    }
}
