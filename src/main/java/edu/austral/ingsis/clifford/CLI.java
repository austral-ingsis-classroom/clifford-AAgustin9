package edu.austral.ingsis.clifford;

import edu.austral.ingsis.clifford.commands.*;

import java.util.*;
import java.util.stream.Collectors;

public class CLI {
    public Directory root;
    public final Directory actualDir;
    public final Map<String, Command> commands;

    public CLI(Directory root) {
        this.commands = Map.of(
                "cd", new Cd(this),
                "ls", new Ls(this),
                "touch", new Touch(this),
                "mkdir", new Mkdir(this),
                "rm", new Rm(this),
                "pwd", new Pwd(this)
        );
        this.root = root;
        this.actualDir = root;
    }

    public String executeCommand(String command) {
        String[] args = command.split(" ");
        Command commandType = commands.get(args[0]);
        String[] parameters = Arrays.copyOfRange(args, 1, args.length);

        return commandType.run(Arrays.stream(parameters).collect(Collectors.toList()));
    }

    //OTHER METHODS

    public String mkdir(String name, Directory parentDir) {
        Directory newDir = new Directory(name, parentDir, new ArrayList<>());
        return root.addChild(newDir);
    }

    public String touch(String name) {
        File newFile = new File(name);
        return root.addFile(newFile);
    }

    public String changeDir(String path) {
        if (path.equals("..")) {
            if (Objects.equals(root.getName(), "/")) {
                return "moved to directory '/'";
            }
            if (root.getParentDir() != null && root != null) {
                root = root.getParentDir();
                return "moved to directory '" + root.getName() + "'";
            }
            return "Error: No parent directory";
        }
        String[] pathArray = path.split("/");
        for (String dir: pathArray) {
            if (root == null) return "Error: Directory not found";
            if (root.getChildByName(dir) == null) return "Error: Directory not found";
            root = root.getChildByName(dir);
        }
        return "moved to directory '" + pathArray[pathArray.length-1] + "'";
    }

    public List<String> getChildsList() {
        return root.getChildrenNames();
    }

    public String delete(String name, String flag) {
        return root.delete(name, flag);
    }

    public String getPath() {
        List<String> dirs = new ArrayList<>();
        Directory currentDir = root;
        dirs.add(currentDir.getName());
        while (currentDir.getParentDir() != null) {
            currentDir = currentDir.getParentDir();
            if (!Objects.equals(currentDir.getName(), "/")) {
                dirs.add(currentDir.getName());
            }
        }
        List<String> invertedDirs = new ArrayList<>();
        for (int i = dirs.size()-1; i >= 0; i--) {
            invertedDirs.add(dirs.get(i));
        }
        return String.join("/", invertedDirs);
    }
}
