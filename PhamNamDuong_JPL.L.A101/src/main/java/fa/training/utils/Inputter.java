package fa.training.utils;

import java.util.Scanner;

public class Inputter {
  private Scanner scanner = new Scanner(System.in);

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
        } else if (!input.matches("[\\w\\s]+")) {
          throw new Exception("Name of student can not have special word!");
        } else {
          // Return valid string
          return this.formatTo(input);
        }
      } catch (Exception e) {
        System.out.println("ERROR: " + e.getMessage());
      }
    }
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
