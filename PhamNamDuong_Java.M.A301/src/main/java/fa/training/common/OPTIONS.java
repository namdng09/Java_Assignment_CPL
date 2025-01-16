package fa.training.common;

public enum OPTIONS {

  ADD_NEW_BOOK(1, "Add a new book"),
  ADD_NEW_MAGAZINE(2, "Add a new magazine"),
  LIST_SAME_PUBLICATION_YEAR_AND_PUBLISHER(3,
      "List all publications which have same publication's year and publisher"),
  ADD_AN_AUTHOR_TO_BOOK(4, "Add an author to book"),
  TOP_TEN_LARGEST_VOLUME_MAGAZINES(5, "List top ten largest volume magazines"),
  COUNT_PUBLICATION_BY_PUBLICATION_YEAR(6, "Count publications by publication's year"),
  SEARCH_BY_ISBN_OR_AUTHOR_OR_PUBLISHER(7, "Search publications by isbn or author or publisher"),
  EXIT(8, "Exit the program");

  private String message;
  private int key;

  OPTIONS(int key, String message) {
    this.key = key;
    this.message = message;
  }

  public String getMessage() {
    return message;
  }

  public int getKey() {
    return key;
  }
}
