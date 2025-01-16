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
    Book book = this.createNewBook(publications);
    publications.add(book);

    System.out.println("Add a new magazine successfully.\n");
  }

  public Book createNewBook(List<Publication> publications) {
    Book book = new Book.Builder()
        .setIsbn(inputter.getDistinctIsbn("Input the ISBN: ", publications))
        .setAuthors(this.getAuthorName())
        .setPublicationPlace(inputter.getNameString("Input the publication place: "))
        .setPublicationYear(inputter.getInteger("Input the publication year (year >= 1900): ", 1900, 9999))
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

  private Book findBookByIsbn(List<Publication> publications) {
    String isbn = inputter.getIsbn("Input the ISBN: ");
    for (Publication publication : publications) {
      if (((Book) publication).getIsbn().contains(isbn)) {
        return (Book) publication;
      }
    }
    return null;
  }

  public BookService() {
  }

  public boolean isExistedBook(List<Publication> publications) {
    for (Publication publication : publications) {
      if (publication instanceof Book) {
        return true;
      }
    }
    return false;
  }

  public void addAuthorToBook(List<Publication> publications) {

    if (!this.isExistedBook(publications)) {
      System.out.println("Not existed book.");
      return;
    }

    Book book = findBookByIsbn(publications);

    if (book == null) {
      System.out.println("Book not found.");
      return;
    }

    String author = inputter.getNameString("Enter New Author Name: ");
    if (book.getAuthor().add(author)) {
      System.out.println("Add successfully");
    } else {
      System.out.println("Author existed");
    }
  }
}
