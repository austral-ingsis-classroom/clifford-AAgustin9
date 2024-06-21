package edu.austral.ingsis.clifford.commands;

import edu.austral.ingsis.clifford.Directory;
import edu.austral.ingsis.clifford.CLI;

import java.util.List;

public class Mkdir implements Command {
    private final CLI CLI;

    public Mkdir (CLI CLI){
        this.CLI = CLI;
    }

    @Override
    public String run(List<String> flags, List<String> args) {
        String name = args.get(0);
        Directory newDir = new Directory(name);
        newDir.setParentDir(CLI.getActualDir());
        CLI.addChildToDir(newDir);

        return "";
    }
}
