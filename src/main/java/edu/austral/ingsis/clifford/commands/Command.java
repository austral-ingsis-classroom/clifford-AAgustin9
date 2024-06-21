package edu.austral.ingsis.clifford.commands;

import java.util.List;

public interface Command {
    String run(List<String> flags, List<String> args);
}
