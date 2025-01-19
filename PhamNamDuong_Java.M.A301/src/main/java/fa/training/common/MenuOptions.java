package fa.training.common;

public enum MenuOptions {

  ADD_STUDENT(1, "Add new Student"),
  ADD_TEACHER(2, "Add new Teacher"),
  EXIT(3, "Exit");

  private String message;
  private int key;

  MenuOptions(int key, String message) {
    this.key = key;
    this.message = message;
  }

  public String getMessage() {
    return message;
  }

  public int getKey() {
    return key;
  }
}
