package com.gmail.kutilandrej.entity;

import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="employees")
public class Employee {

  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name="id")
  @Id
  private int id;
  @Column(name="name")
  private String name;
  @Column(name="surname")
  private String surname;
  @Column(name="department")
  private String department;
  @Column(name="salary")
  private int salary;

  public Employee() {
  }

  public Employee(String name, String surname, String department, int salary) {
    this.name = name;
    this.surname = surname;
    this.department = department;
    this.salary = salary;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getSurname() {
    return surname;
  }

  public void setSurname(String surname) {
    this.surname = surname;
  }

  public String getDepartment() {
    return department;
  }

  public void setDepartment(String department) {
    this.department = department;
  }

  public int getSalary() {
    return salary;
  }

  public void setSalary(int salary) {
    this.salary = salary;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof Employee)) {
      return false;
    }
    Employee employee = (Employee) o;
    return getSalary() == employee.getSalary() && Objects.equals(getId(), employee.getId())
        && Objects.equals(getName(), employee.getName()) && Objects
        .equals(getSurname(), employee.getSurname()) && Objects
        .equals(getDepartment(), employee.getDepartment());
  }

  @Override
  public int hashCode() {
    return Objects.hash(getId(), getName(), getSurname(), getDepartment(), getSalary());
  }

  @Override
  public String toString() {
    return "Employee{" +
        "id=" + id +
        ", name='" + name + '\'' +
        ", surname='" + surname + '\'' +
        ", department='" + department + '\'' +
        ", salary=" + salary +
        '}';
  }
}
