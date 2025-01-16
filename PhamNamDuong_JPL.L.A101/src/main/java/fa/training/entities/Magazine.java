package fa.training.entities;

public class Magazine extends Publication {

  private String author;
  private int volumn;
  private int edition;

  public Magazine() {
  }

  @Override
  public void display() {
    System.out.println(this);
  }

  @Override
  public String toString() {
    return "Magazine: " +
        ", author= " + author +
        ", volumn= " + volumn +
        ", edition= " + edition +
        ", " + super.toString();
  }

  public String getAuthor() {
    return author;
  }

  public int getVolumn() {
    return volumn;
  }

  public int getEdition() {
    return edition;
  }

  // Builder class
  public static class Builder {
    private String author;
    private int volumn;
    private int edition;

    // Fields inherited from Publication
    private int publicationYear;
    private String publisher;
    private java.util.Date publicationDate;

    public Builder() {
    }

    public Builder setAuthor(String author) {
      this.author = author;
      return this;
    }

    public Builder setVolumn(int volumn) {
      this.volumn = volumn;
      return this;
    }

    public Builder setEdition(int edition) {
      this.edition = edition;
      return this;
    }

    public Builder setPublicationYear(int publicationYear) {
      this.publicationYear = publicationYear;
      return this;
    }

    public Builder setPublisher(String publisher) {
      this.publisher = publisher;
      return this;
    }

    public Builder setPublicationDate(java.util.Date publicationDate) {
      this.publicationDate = publicationDate;
      return this;
    }

    public Magazine build() {
      Magazine magazine = new Magazine();
      magazine.author = this.author;
      magazine.volumn = this.volumn;
      magazine.edition = this.edition;

      // Set inherited fields
      magazine.setPublicationYear(this.publicationYear);
      magazine.setPublisher(this.publisher);
      magazine.setPublicationDate(this.publicationDate);

      return magazine;
    }
  }
}
