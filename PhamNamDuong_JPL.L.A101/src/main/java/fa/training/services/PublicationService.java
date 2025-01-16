package fa.training.services;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import fa.training.entities.Book;
import fa.training.entities.Magazine;
import fa.training.entities.Publication;
import fa.training.utils.Inputter;
import fa.training.utils.Validator;

public class PublicationService {
  Inputter inputter = new Inputter();
  Validator validator = new Validator();

  public PublicationService() {
  }

  public void listSamePublicationYearAndPublisher(List<Publication> publications) {
    int publicationYear = (inputter.getInteger("Input the publication year (year >= 1900): ", 1900, 9999));
    String publisher = inputter.getNameString("Input the name of publisher: ");
    boolean isFound = false;
    for (Publication publication : publications) {
      boolean isEqual = (publication.getPublicationYear() == publicationYear)
          && (publication.getPublisher().equalsIgnoreCase(publisher));
      if (isEqual) {
        publication.display();
        isFound = true;
      }
    }
    if (!isFound) {
      System.out.println("Publication not found\n");
    } else {
      System.out.println("List all publications which have same publication's year and publisher successfully.\n");
    }
  }

  public void countPublicationByPublicationYear(List<Publication> publications) {
    Map<Integer, Integer> map = new HashMap<>();

    for (Publication publication : publications) {
      // if not found then put new
      // or else inc count by 1
      map.compute(publication.getPublicationYear(),
          (k, countOfPublicationYear) -> (countOfPublicationYear == null) ? 1 : countOfPublicationYear + 1);
    }

    if (map.isEmpty()) {
      System.out.println("Publication not found");
      return;
    }

    System.out.println("Year : Count");
    for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
      System.out.println(entry.getKey() + " : " + entry.getValue());
    }
  }

  public void searchPublicationByIsbnOrAuthorOrPublisher(List<Publication> publications) {
    String search = inputter.getString("Enter search term: ");
    Set<Publication> foundPublications = new HashSet<>();
    for (Publication publication : publications) {
      if (publication.getPublisher().equalsIgnoreCase(search)) {
        foundPublications.add(publication);
      }

      if (publication instanceof Book) {
        Book book = (Book) publication;
        if (isMatchingBook(book, search)) {
          foundPublications.add(publication);
        }
      }

      if (publication instanceof Magazine) {
        Magazine magazine = (Magazine) publication;
        if (isMatchingMagazine(magazine, search)) {
          foundPublications.add(publication);
        }
      }
    }

    if (foundPublications.isEmpty()) {
      System.out.println("Publication not found");
      return;
    }

    for (Publication publication : foundPublications) {
      publication.display();
    }
    System.out.println("Search by isbn or author or publisher successfully.");
  }

  public boolean isMatchingMagazine(Magazine magazine, String search) {
    return magazine.getAuthor().equalsIgnoreCase(search);
  }

  public boolean isMatchingBook(Book book, String search) {
    if ((book.getIsbn().equalsIgnoreCase(search))) {
      return true;
    }
    for (String author : book.getAuthor()) {
      if (author.equalsIgnoreCase(search)) {
        return true;
      }
    }
    return false;
  }

  public void inputPublicationYear() {
    inputter.getInteger("Input Publication Year (year > 1900): ", 1900, 9999);
  }

  public void inputPublisher() {
    inputter.getNameString("Input name of the publiser: ");
  }

  public void inputPublicationDate() {
    inputter.getDate("Enter publication date (dd-MM-yyyy): ");
  }

}
