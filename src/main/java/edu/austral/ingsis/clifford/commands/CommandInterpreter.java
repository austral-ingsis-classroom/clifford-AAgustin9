package edu.austral.ingsis.clifford.commands;

import edu.austral.ingsis.clifford.Directory;

public class CommandInterpreter {
    private Directory root;

    public CommandInterpreter(Directory root) {
        this.root = root;
    }

    public Directory getRoot() {
        return root;
    }

    public String mkdir(String name, Directory parentDir) {
        //makes new dir
        Directory newDir = new Directory(name, parentDir);
        return root.addChild(newDir);
    }

}
