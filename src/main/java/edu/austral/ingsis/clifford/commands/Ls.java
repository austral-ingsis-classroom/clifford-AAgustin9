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
    public String run(List<String> parameters) {
        List<String> children = cli.getChildsList();
        if (parameters.isEmpty()) {
            return String.join(" ", children);
        }
        String orderType = parameters.getFirst();
        if (orderType.equals("--ord=desc")) {
            children.sort(Collections.reverseOrder());
        } else if (orderType.equals("--ord=asc")) {
            Collections.sort(children);
        }
        return String.join(" ", children);
    }
}
