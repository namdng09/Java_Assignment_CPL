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
        .setIsbn(inputter.getIsbn("Input the ISBN: "))
        .setAuthors(this.getAuthorName())
        .setPublicationPlace(inputter.getNameString("Input the publication place: "))
        .setPublicationYear(inputter.getInteger("Input the publication year (year > 1900): ", 1900, 9999))
        .setPublisher(inputter.getNameString("Input the name of publisher: "))
        .setPublicationDate(inputter.getDate("Input the publication date (dd-MM-yyyy): "))
        .build();
    return book;
  }

  public Set<String> getAuthorName() {
    Set<String> author = new HashSet<>();
    author.add(inputter.getNameString("Input the author name: "));
    return author;
  }

}
