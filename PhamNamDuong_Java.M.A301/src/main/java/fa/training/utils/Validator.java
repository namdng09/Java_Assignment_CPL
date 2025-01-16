package fa.training.utils;

public class Validator {

  public boolean isValidNameString(String name) {
    String regex = "[\\w\\s]+";
    return name.matches(regex);
  }

  // public boolean isDistinctISBN(List<Publication> publications, String isbn) {
  //   boolean isDistinct = false;
  //   for (Publication publication : publications) {
  //     if (((Book) publication).getIsbn().equalsIgnoreCase(isbn)) {
  //       isDistinct = true;
  //       return isDistinct;
  //     }
  //   }
  //   return isDistinct;
  // }
}
