package fa.training.services;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import fa.training.entities.Magazine;
import fa.training.entities.Publication;
import fa.training.utils.Inputter;

public class MagazineService {

  Inputter inputter = new Inputter();

  public void addNewMagazine(List<Publication> publications) {
    Magazine magazine = this.createNewMagazine(publications);
    publications.add(magazine);

    publications.sort(Comparator.comparing(Publication::getPublicationDate));

    System.out.println("Add a new magazine successfully.\n");
  }

  public Magazine createNewMagazine(List<Publication> publications) {
    Magazine magazine = new Magazine.Builder()
        .setAuthor(inputter.getNameString("Input the name of author: "))
        .setVolumn(inputter.getInteger("Input the volumn: ", 0, 999))
        .setEdition(inputter.getInteger("Input the edition: ", 0, 999))
        .setPublicationYear(inputter.getInteger("Input the publication year (year >= 1900): ", 1900, 9999))
        .setPublisher(inputter.getNameString("Input the name of publisher: "))
        .setPublicationDate(inputter.getDate("Input the publication date (dd-MM-yyyy): "))
        .build();
    return magazine;
  }

  public void listTopTenLargestVolumeMagazines(List<Publication> publications) {
    List<Publication> magazines = publications.stream().filter(p -> p instanceof Magazine)
        .sorted((o1, o2) -> ((Magazine) o2).getVolumn() - ((Magazine) o1).getVolumn()).collect(Collectors.toList());

    if (magazines.isEmpty()) {
      System.out.println("No magazines found.");
      return;
    }
    System.out.println("Top 10 magazines found.");
    int i = 0;
    while (i < 10 && i < magazines.size()) {
      magazines.get(i).display();
      i++;
    }
  }
}
