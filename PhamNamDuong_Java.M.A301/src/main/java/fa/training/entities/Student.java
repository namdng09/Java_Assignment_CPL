package fa.training.entities;

public class Student extends Person {

  private String studentId;
  private double theory;
  private double practice;

  public Student() {
  }

  @Override
  public void purchasePakingPass() {
    System.out.println("Student has purchased a parking pass.");
  }

  public double calculateFinalMark() {
    return (theory + practice) / 2;
  }

  public double getTheory() {
    return theory;
  }

  public double getPractice() {
    return practice;
  }

  public String getStudentId() {
    return studentId;
  }

  @Override
  public String toString() {
    return "Student: " +
        ", StudentId= " + studentId +
        ", Theory= " + theory +
        ", Practice= " + practice +
        ", " + super.toString();
  }

  // Builder class
  public static class Builder {
    private String name;
    private String email;
    private String gender;
    private String phoneNumber;
    private String studentId;
    private double theory;
    private double practice;

    public Builder() {
    }

    public Builder setPhoneNumber(String phoneNumber) {
      this.phoneNumber = phoneNumber;
      return this;
    }

    public Builder setName(String name) {
      this.name = name;
      return this;
    }

    public Builder setGender(String gender) {
      this.gender = gender;
      return this;
    }

    public Builder setEmail(String email) {
      this.email = email;
      return this;
    }

    public Builder setStudentId(String studentId) {
      this.studentId = studentId;
      return this;
    }

    public Builder setTheory(double theory) {
      this.theory = theory;
      return this;
    }

    public Builder setPractice(double practice) {
      this.practice = practice;
      return this;
    }

    public Student build() {
      Student student = new Student();
      student.setName(this.name);
      student.setGender(this.gender);
      student.setEmail(this.email);
      student.setPhoneNumber(this.phoneNumber);
      student.studentId = this.studentId;
      student.theory = this.theory;
      student.practice = this.practice;
      return student;
    }
  }
}
