package fa.training.view;

import fa.training.common.OPTIONS;
import fa.training.utils.Inputter;

public class View {
  private Inputter inputter = new Inputter();

  public static final int YES_OPTION = 1;
  public static final int NO_OPTION = 0;

  public void displayMenu(OPTIONS[] options) {
    System.out.println("WELCOME TO LIBRARY MANAGEMENT");
    for (OPTIONS option : options) {
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

  // public void showPublications(List<Publication> publications) {
  //   for (Publication publication : publications) {
  //     System.out.println(publication.toString());
  //   }
  // }
}
