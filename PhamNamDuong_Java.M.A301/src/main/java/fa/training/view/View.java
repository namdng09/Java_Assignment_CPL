package fa.training.view;

import java.util.List;

import fa.training.common.MenuOptions;
import fa.training.common.OPTIONS;
import fa.training.entities.Person;
import fa.training.utils.Inputter;

public class View {
  private Inputter inputter = new Inputter();

  public static final int YES_OPTION = 1;
  public static final int NO_OPTION = 0;

  public void displayMenu(OPTIONS[] options) {
    System.out.println("\nWELCOME TO LIBRARY MANAGEMENT");
    for (OPTIONS option : options) {
      System.out.println(option.getKey() + ". " + option.getMessage());
    }
  }

  public void displayMenu(MenuOptions[] options) {
    System.out.println("\nStudent or Teacher:");
    for (MenuOptions option : options) {
      System.out.println(option.getKey() + ". " + option.getMessage());
    }
  }

  public Object inputOption(String message, Object[] options) {
    Object option;
    option = options[inputter.getInteger(message, 1, options.length) - 1];
    return option;
  }

  public int inputYesNoOption(String message) {
    return inputter.getInteger(message, NO_OPTION, YES_OPTION);
  }

    public void showPersons(List<Person> persons) {
        for (Person person : persons) {
            System.out.println(person.toString());
        }
    }
}
