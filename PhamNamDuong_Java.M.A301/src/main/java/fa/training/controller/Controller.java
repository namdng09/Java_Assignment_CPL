package fa.training.controller;

import java.util.ArrayList;
import java.util.List;

import fa.training.common.OPTIONS;
import fa.training.view.View;

public class Controller {

  public void setup() {
    View view = new View();
    // List<Publication> publications = new ArrayList<>();

    while (true) {
      view.displayMenu(OPTIONS.values());

      OPTIONS choice = (OPTIONS) view.inputOption("Your choice: ", OPTIONS.values());
      switch (choice) {
        case SEARCH_BY_ISBN_OR_AUTHOR_OR_PUBLISHER:
          break;
        default:
          System.exit(0);
      }
    }

  }

}
