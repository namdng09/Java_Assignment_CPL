package fa.training.entities;

public class Teacher extends Person {

  private double basicSalary;
  private double subsidy;

  public Teacher() {
  }

  @Override
  public void purchasePakingPass() {
    System.out.println("Teacher has purchased a parking pass.");
  }

  public double calculateSalary() {
    return basicSalary + subsidy;
  }

  public double getBasicSalary() {
    return basicSalary;
  }

  public double getSubsidy() {
    return subsidy;
  }

  @Override
  public String toString() {
    return "Teacher: " +
        ", BasicSalary= " + basicSalary +
        ", Subsidy= " + subsidy +
        ", " + super.toString();
  }

  // Builder class
  public static class Builder {
    private String name;
    private String email;
    private String gender;
    private String phoneNumber;
    private double basicSalary;
    private double subsidy;

    public Builder() {
    }

    public Builder setPhoneNumber(String phoneNumber) {
      this.phoneNumber = phoneNumber;
      return this;
    }

    public Builder setGender(String gender) {
      this.gender = gender;
      return this;
    }

    public Builder setName(String name) {
      this.name = name;
      return this;
    }

    public Builder setEmail(String email) {
      this.email = email;
      return this;
    }

    public Builder setBasicSalary(double basicSalary) {
      this.basicSalary = basicSalary;
      return this;
    }

    public Builder setSubsidy(double subsidy) {
      this.subsidy = subsidy;
      return this;
    }

    public Teacher build() {
      Teacher teacher = new Teacher();
      teacher.setName(this.name);
      teacher.setEmail(this.email);
      teacher.setGender(this.gender);
      teacher.setPhoneNumber(this.phoneNumber);
      teacher.basicSalary = this.basicSalary;
      teacher.subsidy = this.subsidy;
      return teacher;
    }
  }
}
