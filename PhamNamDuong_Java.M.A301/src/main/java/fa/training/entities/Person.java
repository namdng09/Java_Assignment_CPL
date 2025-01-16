package fa.training.entities;

public abstract class Person {
  private String name;
  private String gender;
  private String phoneNumber;
  private String email;

  public Person() {
  }

  public abstract void purchasePakingPass();

  public String getName() {
      return name;
  }

  public void setName(String name) {
      this.name = name;
  }

  public String getEmail() {
      return email;
  }

  public void setEmail(String email) {
      this.email = email;
  }

  public String getGender() {
      return gender;
  }

  public void setGender(String gender) {
      this.gender = gender;
  }

  public String getPhoneNumber() {
      return phoneNumber;
  }

  public void setPhoneNumber(String phoneNumber) {
      this.phoneNumber = phoneNumber;
  }

  @Override
  public String toString() {
    return "Name: " + name +
    ", Gender: " + gender +
    ", Phone Number: " + phoneNumber +
    ", Email: " + email;
  }
}
