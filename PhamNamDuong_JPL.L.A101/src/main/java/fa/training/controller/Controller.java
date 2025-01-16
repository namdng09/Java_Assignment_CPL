package fa.training.controller;

import java.util.ArrayList;
import java.util.List;

import fa.training.common.OPTIONS;
import fa.training.entities.Publication;
import fa.training.services.BookService;
import fa.training.services.MagazineService;
import fa.training.services.PublicationService;
import fa.training.view.View;

public class Controller {

  public void setup() {
    View view = new View();
    BookService bookService = new BookService();
    MagazineService magazineService = new MagazineService();
    PublicationService publicationService = new PublicationService();

    List<Publication> publications = new ArrayList<>();

    while (true) {
      view.displayMenu(OPTIONS.values());

      OPTIONS choice = (OPTIONS) view.inputOption("Your choice: ", OPTIONS.values());
      switch (choice) {
        case ADD_NEW_BOOK:
          bookService.addNewBook(publications);
          view.showPublications(publications);
          break;
        case ADD_NEW_MAGAZINE:
          magazineService.addNewMagazine(publications);
          view.showPublications(publications);
          break;
        case LIST_SAME_PUBLICATION_YEAR_AND_PUBLISHER:
          publicationService.listSamePublicationYearAndPublisher(publications);
          break;
        case ADD_AN_AUTHOR_TO_BOOK:
          bookService.addAuthorToBook(publications);
          break;
        case TOP_TEN_LARGEST_VOLUME_MAGAZINES:
          magazineService.listTopTenLargestVolumeMagazines(publications);
          break;
        case COUNT_PUBLICATION_BY_PUBLICATION_YEAR:
          publicationService.countPublicationByPublicationYear(publications);
          break;
        case SEARCH_BY_ISBN_OR_AUTHOR_OR_PUBLISHER:
          publicationService.searchPublicationByIsbnOrAuthorOrPublisher(publications);
          break;
        default:
          System.exit(0);
      }
    }

  }

}
