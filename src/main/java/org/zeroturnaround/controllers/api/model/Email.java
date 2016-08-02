package org.zeroturnaround.controllers.api.model;

/**
 * Created by shelajev on 02/08/16.
 */
public class Email {
  public String name;
  public String email;

  public Email(String name, String email) {
    this.name = name;
    this.email = email;
  }

  public Email() {
  }

  @Override public String toString() {
    return "Email{" +
      "name='" + name + '\'' +
      ", email='" + email + '\'' +
      '}';
  }

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

  @Override public boolean equals(Object o) {

    if (this == o)
      return true;
    if (o == null || getClass() != o.getClass())
      return false;

    Email email1 = (Email) o;

    if (name != null ? !name.equals(email1.name) : email1.name != null)
      return false;
    return email != null ? email.equals(email1.email) : email1.email == null;

  }

  @Override public int hashCode() {
    int result = name != null ? name.hashCode() : 0;
    result = 31 * result + (email != null ? email.hashCode() : 0);
    return result;
  }
}
