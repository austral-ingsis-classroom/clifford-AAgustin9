package edu.austral.ingsis.clifford;

import java.util.ArrayList;
import java.util.List;

public class Directory implements FileSystem {

    private final String name;
    private final List<FileSystem> children;
    private Directory parentDir;

    public Directory(String name) {
        this.name = name;
        children = new ArrayList<>();
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
    public Directory setParentDir(Directory parentDir) {
        this.parentDir = parentDir;
        return this;
    }
}
