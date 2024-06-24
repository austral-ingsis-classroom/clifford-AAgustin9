package edu.austral.ingsis.clifford.commands;

import edu.austral.ingsis.clifford.CLI;
import java.util.List;

public class Rm implements Command {
  private final CLI cli;

  public Rm(CLI cli) {
    this.cli = cli;
  }

  @Override
  public String run(List<String> parameters) {
    switch (parameters.size()) {
      case 0:
        return "cannot remove '" + cli.actualDir.getName() + "'";
      case 1:
        return cli.delete(parameters.getFirst(), "");
      case 2:
        return cli.delete(parameters.get(1), parameters.getFirst());
      default:
        return "Error: Invalid arguments";
    }
  }
}
