package edu.austral.ingsis.clifford;

import edu.austral.ingsis.clifford.commands.*;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class CLI {
    public Directory root;
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

    public String changeDir(String path) {
        if (path.equals("..")) {
            if (Objects.equals(root.getName(), "/")) {
                return "Changed to '/' directory";
            }
            if (root.getParentDir() != null && root != null) {
                root = root.getParentDir();
                return "Changed to '" + root.getName() + "' directory";
            }
            return "Error: No parent directory";
        }
        String[] pathArray = path.split("/");
        for (String dir: pathArray) {
            if (root == null) return "Error: Directory not found";
            if (root.getChildByName(dir) == null) return "Error: Directory not found";
            root = root.getChildByName(dir);
        }
        return "Changed to '" + pathArray[pathArray.length-1] + "' directory";
    }

    public List<String> getChildsList() {
        return root.getChildrenNames();
    }



}
