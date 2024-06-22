package edu.austral.ingsis.clifford.commands;

import edu.austral.ingsis.clifford.CLI;
import edu.austral.ingsis.clifford.Directory;

import java.util.List;

public class Pwd implements Command {
    private final CLI cli;

    public Pwd (CLI cli){
        this.cli = cli;
    }

    @Override
    public String run(List<String> parameters) {
        return pwd(cli.actualDir);
    }

    private String pwd(Directory currentDir) {
        if (currentDir.getParentDir() == null) {
            return currentDir.getName();
        }
        return pwd(currentDir.getParentDir()) + "/" + currentDir.getName();
    }
}
