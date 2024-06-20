package edu.austral.ingsis.clifford.commands;

import java.util.List;

public interface Command {
    void run(List<String> flags, List<String> args);
}
