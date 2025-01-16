package fa.training.utils;

import java.util.List;

import fa.training.entities.Book;
import fa.training.entities.Publication;

public class Validator {

  public boolean isValidIsbn(String isbn) {
    String regex = "^(?=(?:\\D*\\d){10}(?:(?:\\D*\\d){0,7})?$)[\\d-]+$";
    return isbn.matches(regex);
  }

  public boolean isValidNameString(String name) {
    String regex = "[\\w\\s]+";
    return name.matches(regex);
  }

  public boolean isDistinctISBN(List<Publication> publications, String isbn) {
    boolean isDistinct = false;
    for (Publication publication : publications) {
      if (((Book) publication).getIsbn().equalsIgnoreCase(isbn)) {
        isDistinct = true;
        return isDistinct;
      }
    }
    return isDistinct;
  }
}
