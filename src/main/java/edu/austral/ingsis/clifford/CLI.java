package edu.austral.ingsis.clifford;

import edu.austral.ingsis.clifford.commands.*;

import java.util.Arrays;
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

    public String runCommand(String command) {
        String[] args = command.split(" ");
        Command commandType = commands.get(args[0]);
        String[] flags = Arrays.copyOfRange(args, 1, args.length);
        return "commandType.run "; //TODO
    }

    //OTHER METHODS

    public String mkdir(String name, Directory parentDir) {
        Directory newDir = new Directory(name, parentDir);
        return root.addChild(newDir);
    }

    public String touch(String name) {
        File newFile = new File(name);
        return root.addFile(newFile);
    }


}
