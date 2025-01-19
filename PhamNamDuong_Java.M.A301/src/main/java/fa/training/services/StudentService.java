package fa.training.services;

import java.util.List;

import fa.training.entities.Person;
import fa.training.entities.Student;
import fa.training.utils.Inputter;

public class StudentService {

  Inputter inputter = new Inputter();

  public Student addAttributeStudent() {
    return new Student.Builder()
        .setStudentId(inputter.getValidID("Input the student ID (HExxx): "))
        .setName(inputter.getNameString("Input name of student: "))
        .setGender(inputter.getString("Input gender of student: "))
        .setPhoneNumber(inputter.getString("Input phone number of student: "))
        .setEmail(inputter.getEmail("Input email of student: "))
        .setTheory(inputter.getDouble("Input the theory: ", 0, 10))
        .setPractice(inputter.getDouble("Input the practice: ", 0, 10))
        .build();
  }

  public Student findStudentById(List<Person> persons, String studentId) {
    for (Person person : persons) {
      if (person instanceof Student) {
        Student student = (Student) person;
        if (student.getStudentId().toLowerCase().contains(studentId.toLowerCase())) {
          return student;
        }
      }
    }
    return null;
  }

  public void report(List<Person> persons) {
    for (Person person : persons) {
      if (person instanceof Student) {
        Student student = (Student) person;
        if (student.calculateFinalMark() >= 6) {
          System.out.println(student);
        }
      }
    }
  }
}
