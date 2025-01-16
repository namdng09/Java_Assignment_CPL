package fa.training.controller;

import java.util.ArrayList;
import java.util.List;

import fa.training.common.OPTIONS;
import fa.training.entities.Person;
import fa.training.services.PersonService;
import fa.training.services.StudentService;
import fa.training.view.View;

public class Controller {

  public void setup() {
    View view = new View();
    List<Person> persons = new ArrayList<>();
    StudentService studentService = new StudentService();
    PersonService personService = new PersonService();

    while (true) {
      view.displayMenu(OPTIONS.values());

      OPTIONS choice = (OPTIONS) view.inputOption("Your choice: ", OPTIONS.values());
      switch (choice) {
        case ADD_PERSON:
          personService.addPerson(persons);
          break;
        case UPDATE_STUDENT:
          break;
        case DISPLAY_TEACHER:
          break;
        case REPORT:
          break;
        default:
          System.exit(0);
      }
    }

  }

}
