package fa.training.utils;

import java.util.regex.Pattern;

public class Validator {

  public boolean isValidNameString(String name) {
    String nameRegex = "[\\w\\s]+";
    return Pattern.matches(nameRegex, name);
  }

  public boolean isValidEmail(String email) {
    String emailRegex = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$";
    return Pattern.matches(emailRegex, email);
  }
}
