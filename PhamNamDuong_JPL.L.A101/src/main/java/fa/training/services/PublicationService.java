package fa.training.services;

import java.util.Date;

import fa.training.utils.Inputter;
import fa.training.utils.Validator;

public class PublicationService {
  Inputter inputter = new Inputter();
  Validator validator = new Validator();

  public PublicationService() {
  }

  public void inputPublicationYear(int number) {
    inputter.getInteger("Input Publication Year (year > 1900): ", 1900, 9999);
  }

  public void inputPublisher() {
    inputter.getNameString("Input name of the publiser: ");
  }

  public void inputPublicationDate(Date date) {
    inputter.getDate("Enter publication date (dd-MM-yyyy): ", date);
  }

}
