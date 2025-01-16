package fa.training.services;

import fa.training.entities.Student;
import fa.training.utils.Inputter;

public class StudentService {

  Inputter inputter = new Inputter();

  public Student addNewStudent() {
    return new Student.Builder()
        .setStudentId(inputter.getValidID("Input the student ID: "))
        .setName(inputter.getNameString("Input name of student: "))
        .setGender(inputter.getString("Input gender of student: "))
        .setPhoneNumber(inputter.getString("Input phone number of student: "))
        .setEmail(inputter.getEmail("Input email of student: "))
        .setTheory(inputter.getDouble("Input the theory: ", 0, 10))
        .setPractice(inputter.getDouble("Input the practice: ", 0, 10))
        .build();
  }
}
