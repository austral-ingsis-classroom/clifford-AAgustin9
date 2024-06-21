package edu.austral.ingsis.clifford.commands;

import edu.austral.ingsis.clifford.CLI;

import java.util.Collections;
import java.util.List;

public class Ls implements Command{
    private final CLI cli;

    public Ls (CLI cli){
        this.cli = cli;
    }

    @Override
    public String run(List<String> flags, List<String> args) {
        List<String> children = cli.getChildsList();
        if (flags.isEmpty() || args.isEmpty()) {
            return String.join(" ", children);
        }
        String orderType = flags.getFirst();
        if (orderType.equals("--ord=desc")) {
            children.sort(Collections.reverseOrder());
        } else if (orderType.equals("--ord=asc")) {
            Collections.sort(children);
        }
        return String.join(" ", children);
    }
}
