package fa.training.services;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import fa.training.entities.Book;
import fa.training.entities.Publication;
import fa.training.utils.Inputter;

public class BookService {
  Inputter inputter = new Inputter();

  public void addNewBook(List<Publication> publications) {
    Book book = this.createNewBook();
    publications.add(book);
  }

  public Book createNewBook() {
    Book book = new Book.Builder()
        .setIsbn(this.getIsbn())
        .setAuthors(this.getAuthorName())
        .setPublicationPlace(this.getPublicationPlace())
        .build();
    return book;
  }

  public String getIsbn() {
    return inputter.getIsbn("Input the ISBN: ");
  }

  public String getPublicationPlace() {
    return inputter.getNameString("Input the publication place: ");
  }

  public Set<String> getAuthorName() {
    Set<String> author = new HashSet<>();
    author.add(inputter.getNameString("Input the author name: "));
    return author;
  }

}
