package fa.training.entities;

import java.util.HashSet;
import java.util.Set;

public class Book extends Publication {
  private String isbn;
  private Set<String> author;
  private String publicationPlace;

  public Book() {
    this.author = new HashSet<>();
  }

  @Override
  public void display() {
    System.out.println(this);
  }

  @Override
  public String toString() {
    return "Book: " +
        "\nisbn='" + isbn + 
        "\nauthor=" + author +
        "\npublicationPlace='" + publicationPlace +
        "\n" + super.toString();
  }

  public String getIsbn() {
    return isbn;
  }

  public Set<String> getAuthor() {
    return author;
  }

  public String getPublicationPlace() {
    return publicationPlace;
  }

  // Builder class
  public static class Builder {
    private String isbn;
    private Set<String> author = new HashSet<>();
    private String publicationPlace;

    public Builder() {
    }

    public Builder setIsbn(String isbn) {
      this.isbn = isbn;
      return this;
    }

    public Builder addAuthor(String author) {
      this.author.add(author);
      return this;
    }

    public Builder setAuthors(Set<String> authors) {
      this.author = authors;
      return this;
    }

    public Builder setPublicationPlace(String publicationPlace) {
      this.publicationPlace = publicationPlace;
      return this;
    }

    public Book build() {
      Book book = new Book();
      book.isbn = this.isbn;
      book.author = this.author;
      book.publicationPlace = this.publicationPlace;
      return book;
    }
  }
}
