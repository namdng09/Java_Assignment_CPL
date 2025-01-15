package fa.training.controller;

import java.util.ArrayList;
import java.util.List;

import fa.training.common.OPTIONS;
import fa.training.entities.Publication;
import fa.training.view.View;

public class Controller {

  public void setup() {
    View view = new View();

    List<Publication> publications = new ArrayList<>();

    while (true) {
      view.displayMenu(OPTIONS.values());

      OPTIONS choice = (OPTIONS) view.inputOption("Your choice: ", OPTIONS.values());
      switch (choice) {
        case ADD_NEW_BOOK:
          break;
        case ADD_NEW_MAGAZINE:
          break;
        case LIST_SAME_PUBLICATION_YEAR_AND_PUBLISHER:
          break;
        case ADD_AN_AUTHOR_TO_BOOK:
          break;
        case TOP_TEN_LARGEST_VOLUME_MAGAZINES:
          break;
        case COUNT_PUBLICATION_BY_PUBLICATION_YEAR:
          break;
        case SEARCH_BY_ISBN_OR_AUTHOR_OR_PUBLISHER:
          break;
        default:
          System.exit(0);
      }
    }

  }

}
