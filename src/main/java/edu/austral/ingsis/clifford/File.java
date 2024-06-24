package edu.austral.ingsis.clifford;

public class File implements FileSystem {
  private final String name;

  public File(String name) {
    this.name = name;
  }

  @Override
  public String getName() {
    return name;
  }
}
