package edu.austral.ingsis.clifford;

import edu.austral.ingsis.clifford.commands.*;

import java.util.Map;

public class CLI {
    public final Directory root;
    public final Directory actualDir;
    public final Map<String, Command> commands;

    public CLI(Directory root, Directory actualDir) {
        this.commands = Map.of(
                "cd", new Cd(this),
                "ls", new Ls(this),
                "touch", new Touch(this),
                "mkdir", new Mkdir(this),
                "rm", new Rm(this),
                "pwd", new Pwd(this)
        );
        this.root = root;
        this.actualDir = actualDir;
    }

    public Directory getActualDir() {
        return actualDir;
    }

    public void addChildToDir(Directory dir) {
        actualDir.addChild(dir);
    }

    public void addChild(Directory dir) {

    }

}
