package fa.training.utils;

public class Validator {

  public boolean isValidIsbn(String isbn) {
    String regex = "^(?=(?:\\D*\\d){10}(?:(?:\\D*\\d){0,7})?$)[\\d-]+$";
    return isbn.matches(regex);
  }

  public boolean isValidNameString(String name) {
    String regex = "[\\w\\s]+";
    return name.matches(regex);
  }

}
