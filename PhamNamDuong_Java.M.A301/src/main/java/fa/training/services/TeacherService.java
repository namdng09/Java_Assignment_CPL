package fa.training.services;

import fa.training.entities.Teacher;
import fa.training.utils.Inputter;

public class TeacherService {

  Inputter inputter = new Inputter();

  public Teacher addNewTeacher() {
    return new Teacher.Builder()
        .setName(inputter.getNameString("Input name of teacher: "))
        .setGender(inputter.getString("Input gender of teacher: "))
        .setPhoneNumber(inputter.getString("Input gender of teacher: "))
        .setEmail(inputter.getEmail("Input email of teacher: "))
        .setBasicSalary(inputter.getDouble("Input basic salary of teacher: ", 0, 100000))
        .setSubsidy(inputter.getDouble("Input subsidy of teacher: ", 0, 100000))
        .build();
  }
}
