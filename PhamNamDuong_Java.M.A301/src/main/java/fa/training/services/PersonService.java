package fa.training.services;

import java.util.List;

import fa.training.common.MenuOptions;
import fa.training.entities.Person;
import fa.training.view.View;

public class PersonService {
  View view = new View();
  StudentService studentService = new StudentService();
  TeacherService teacherService = new TeacherService();

  public void addPerson(List<Person> persons) {
    boolean isContinue = true;
    while (isContinue) {
      view.displayMenu(MenuOptions.values());
      MenuOptions choice = (MenuOptions) view.inputOption("Your choice: ", MenuOptions.values());
      switch (choice) {
        case ADD_STUDENT:
          persons.add(studentService.addNewStudent());
          break;
        case ADD_TEACHER:
          persons.add(teacherService.addNewTeacher());
          break;
        default:
          isContinue = false;
      }

      if (persons.size() >= 10) {
        System.out.println("The ");
        isContinue = false;
      }
    }
  }
}
