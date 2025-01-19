package fa.training.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Inputter {
  private Scanner scanner = new Scanner(System.in);
  private Validator validator = new Validator();

  public boolean askToContinue() {
    String input;
    while (true) {
      System.out.print("Do you want to continue? (yes/no): ");
      input = scanner.nextLine().trim().toLowerCase();

      if (input.equals("yes")) {
        return true;
      } else if (input.equals("no")) {
        return false;
      } else {
        System.out.println("Invalid input. Please enter 'yes' or 'no'.");
      }
    }
  }

  public double getDouble(String message, double min, double max) {
    double input;
    while (true) {
      System.out.print(message);
      try {
        input = Double.parseDouble(scanner.nextLine());
        if (input < min || input > max) {
          throw new IllegalArgumentException(String.format(
              "Invalid number, number must be in range [%.2f, %.2f]",
              min, max));
        }
        return input; // Return the valid input
      } catch (NumberFormatException e) {
        System.out.println("ERROR: Please enter a valid number.");
      } catch (IllegalArgumentException e) {
        System.out.println("ERROR: " + e.getMessage());
      }
    }
  }

  public int getInteger(String message, int min, int max) {
    int input;
    while (true) {
      System.out.print(message);
      try {
        input = Integer.parseInt(scanner.nextLine());
        if (input < min || input > max) {
          throw new Exception(String.format(
              "Invalid number, number must be in range [%d, %d]",
              min, max));
        } else {
          break;
        }
      } catch (Exception e) {
        System.out.println("ERROR: " + e.getMessage());
      }
    }
    return input;
  }

  public String getNameString(String message) {
    String input;
    while (true) {
      System.out.print(message);
      try {
        input = scanner.nextLine();
        if (input.isEmpty()) {
          throw new Exception("Can not leave blank!");
        } else if (!validator.isValidNameString(input)) {
          throw new Exception("The name can not have special word!");
        } else {
          // Return valid string
          return this.formatTo(input);
        }
      } catch (Exception e) {
        System.out.println("ERROR: " + e.getMessage());
      }
    }
  }

  public String getEmail(String message) {
    String input;
    while (true) {
      System.out.print(message);
      try {
        input = scanner.nextLine();
        if (input.isEmpty()) {
          throw new Exception("Can not leave blank!");
        } else if (!validator.isValidEmail(input)) {
          throw new Exception("Invalid email format!");
        } else {
          // Return valid string
          return input;
        }
      } catch (Exception e) {
        System.out.println("ERROR: " + e.getMessage());
      }
    }
  }

  public String getString(String message) {
    String input;
    while (true) {
      System.out.print(message);
      try {
        input = scanner.nextLine();
        if (input.isEmpty()) {
          throw new Exception("Can not leave blank!");
        } else {
          // Return valid string
          return input;
        }
      } catch (Exception e) {
        System.out.println("ERROR: " + e.getMessage());
      }
    }
  }

  public String getValidID(String message) {
    String input;
    while (true) {
      try {
        System.out.print(message);
        input = scanner.nextLine().toUpperCase();
        if (validator.isValidStudentId(input)) {
          return input;
        } else {
          throw new Exception(
              "Invalid ID, Please enter the ID in the form HExxx");
        }
      } catch (Exception e) {
        System.out.println("ERROR: " + e.getMessage());
      }
    }
  }

  public Date getDate(String message) {
    boolean isContinue = true;
    Date result = new Date();

    while (isContinue) {
      SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
      // set lenient to false to apply strict date parsing
      dateFormat.setLenient(false);
      try {
        result = dateFormat.parse(this.getString(message));
        isContinue = false;
      } catch (ParseException e) {
        System.out.println("Invalid date format dd/MM/yyyy.");
      }
    }
    return result;
  }

  public String formatTo(String e) {
    StringBuilder stringBuilder = new StringBuilder();
    String words[] = e.split("\\s+");
    for (String word : words) {
      stringBuilder.append(word.substring(0, 1).toUpperCase()).append(word.substring(1).toLowerCase()).append(" ");
    }
    return stringBuilder.toString().trim();
  }
}
