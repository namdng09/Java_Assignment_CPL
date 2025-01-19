package fa.training.services;

import java.util.List;

import fa.training.common.MenuOptions;
import fa.training.entities.Person;
import fa.training.entities.Student;
import fa.training.utils.Inputter;
import fa.training.view.View;

public class PersonService {
  View view = new View();
  StudentService studentService = new StudentService();
  TeacherService teacherService = new TeacherService();
  Inputter inputter = new Inputter();

  public void addPerson(List<Person> persons) {
    boolean isContinue = true;
    while (isContinue) {
      view.displayMenu(MenuOptions.values());
      MenuOptions choice = (MenuOptions) view.inputOption("Your choice: ", MenuOptions.values());
      switch (choice) {
        case ADD_STUDENT:
          persons.add(studentService.addAttributeStudent());
          break;
        case ADD_TEACHER:
          persons.add(teacherService.addNewTeacher());
          break;
        default:
          isContinue = false;
          break;
      }

      if (!isContinue) {
        break;
      }

      if (persons.size() >= 10) {
        System.out.println("10 Person have added to the program!");
        isContinue = false;
      }

      if (!inputter.askToContinue()) {
        isContinue = false;
      }
    }
  }

  public void updateStudent(List<Person> persons) {
    Student student = studentService.findStudentById(persons, inputter.getValidID("Input the student ID (HExxx): "));
    if (student == null) {
      System.out.println("Student not found");
      return;
    }
    System.out.println("\nUPDATE STUDENT");
    student = studentService.addAttributeStudent();
    System.out.println("UPDATE SUCCESSFULLY!");
  }
}
