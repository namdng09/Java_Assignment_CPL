package fa.training.entities;

import java.util.Set;

public class Book extends Publication {
  private String isbn;
  private Set<String> authors;
  private String publicationPlace;

  public Book() {
  }

  @Override
  public void display() {
    System.out.println(this);
  }

  public String getIsbn() {
      return isbn;
  }
  
  public void setIsbn(String isbn) {
      this.isbn = isbn;
  }

  public Set<String> getAuthors() {
      return authors;
  }

  public void setAuthors(Set<String> authors) {
      this.authors = authors;
  }

  public String getPublicationPlace() {
      return publicationPlace;
  }

  public void setPublicationPlace(String publicationPlace) {
      this.publicationPlace = publicationPlace;
  }

}
