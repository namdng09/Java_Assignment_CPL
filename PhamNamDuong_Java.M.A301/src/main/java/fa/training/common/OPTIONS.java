package fa.training.common;

public enum OPTIONS {

  ADD_PERSON(1, "Add persons"),
  UPDATE_STUDENT(2, "Update student"),
  DISPLAY_TEACHER(3, "Display teacher"),
  REPORT(4, "Report"),
  EXIT(5, "Exit the program");

  private String message;
  private int key;

  OPTIONS(int key, String message) {
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
