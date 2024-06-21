package edu.austral.ingsis.clifford;

import java.util.ArrayList;
import java.util.List;

public class Directory implements FileSystem {

    private final String name;
    private final List<FileSystem> children;
    private Directory parentDir;

    public Directory(String name, Directory parentDir) {
        this.name = name;
        children = new ArrayList<>();
        this.parentDir = parentDir;
    }

    @Override
    public String getName() {
        return name;
    }

    public List<FileSystem> getChildren() {
        return children;
    }

    public Directory getParentDir() {
        return parentDir;
    }

    public String addChild(FileSystem fileSystem) {
        for (FileSystem child : children) {
            if (child.getName().equals(fileSystem.getName())) {
                return "Directory already exists";
            }
        }
        children.add(fileSystem);
        return "'" + fileSystem.getName() + "' created successfully";
    }

    public String addFile(File file) {
        for (FileSystem child : children) {
            if (child.getName().equals(file.getName())) {
                return "Name already in use";
            }
        }
        children.add(file);
        return "'" + file.getName() + "' created successfully";
    }

    public Directory getChildByName(String name) {
        for (FileSystem child : children) {
            if (child.getName().equals(name)) {
                return (Directory) child;
            }
        }
        return null;
    }

    public List<String> getChildrenNames() {
        List<String> names = new ArrayList<>();
        for (FileSystem child : children) {
            names.add(child.getName());
        }
        return names;
    }

}
