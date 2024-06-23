package edu.austral.ingsis.clifford;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Directory implements FileSystem {

    private final String name;
    private final List<FileSystem> children;
    private Directory parentDir;

    public Directory(String name) {
        this.name = name;
        children = new ArrayList<>();
    }

    public Directory(String name, Directory parentDir, List<FileSystem> children) {
        this.name = name;
        this.parentDir = parentDir;
        this.children = children;
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
        return "'" + fileSystem.getName() + "' directory created";
    }

    public String addFile(File file) {
        for (FileSystem child : children) {
            if (child.getName().equals(file.getName())) {
                return "Name already in use";
            }
        }
        children.add(file);
        return "'" + file.getName() + "' file created";
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

    public String delete(String name, String flag) {
        if (Objects.equals(flag, "")) return deleteFile(name);
        if (Objects.equals(flag, "--recursive")) {
            for (FileSystem child : children) {
                if (child.getName().equals(name) && child instanceof Directory) {
                    children.remove(child);
                    return "'" + name + "' removed";
                }
            }
        }
        return "cannot remove '" + name + "', is a directory";
    }

    private String deleteFile(String name) {
        for (FileSystem child : children) {
            if (child.getName().equals(name) && child instanceof File) {
                children.remove(child);
                return "'" + name + "' removed";
            }
        }
        return "cannot remove '" + name + "'";
    }
}
