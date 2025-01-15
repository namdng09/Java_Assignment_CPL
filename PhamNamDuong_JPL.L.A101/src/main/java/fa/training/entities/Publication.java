package fa.training.entities;

import java.text.SimpleDateFormat;
import java.util.Date;

public abstract class Publication {
  private int publicationYear;
  private String publisher;
  private Date publicationDate;

  public Publication() {
  }

  public abstract void display();

  public String getPublisher() {
    return publisher;
  }

  public void setPublisher(String publisher) {
    this.publisher = publisher;
  }

  public Date getPublicationDate() {
    return publicationDate;
  }

  public void setPublicationDate(Date publicationDate) {
    this.publicationDate = publicationDate;
  }

  public int getPublicationYear() {
    return publicationYear;
  }

  public void setPublicationYear(int publicationYear) {
    this.publicationYear = publicationYear;
  }

  @Override
  public String toString() {
    SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
    String formattedPublicationDate = dateFormat.format(publicationDate);
    return "PublicationYear=" + publicationYear +
        "\nPublisher='" + publisher +
        "\nPublicationDate=" + formattedPublicationDate;
  }
}
