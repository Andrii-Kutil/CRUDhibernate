package com.gmail.kutilandrej;

import com.gmail.kutilandrej.entity.Employee;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

public class Main {

  public static void main(String[] args) {
    try (SessionFactory factory = new Configuration()
        .configure("hibernate.cfg.xml")
        .addAnnotatedClass(Employee.class)
        .buildSessionFactory()) {
      Session session = factory.getCurrentSession();

      System.out.println("----SAVE----");
      Employee employee = new Employee("Andrii", "Kutil", "IT", 10000);
      session.beginTransaction();
      session.save(employee);
      int employeeId = employee.getId();
      System.out.println("Get id last added employee:" + employeeId);

      System.out.println("----GET----");
      Employee getEmployee = session.get(Employee.class, employeeId);
      System.out.println("Get employee using id: " + getEmployee);

      System.out.println("----SELECT-HQL----");
      List<Employee> employeeList = session.createQuery("from  Employee where name='Andrii' and salary > 900", Employee.class).getResultList();

      System.out.println("----Array of employees----");
      for (Employee emp:employeeList) {
        System.out.println(emp);
      }

      Employee emp2 = session.get(Employee.class, employeeId);
      emp2.setSalary(1500);
      System.out.println("After set salary=1500 to employee with id=1");
      System.out.println(emp2);
      //session.delete(emp2);

      System.out.println("----DELETE----");
      String hql = "delete Employee where id=:id";
      Query<Employee> query = session.createQuery(hql, Employee.class);
      query.setParameter("id", emp2.getId());
      query.executeUpdate();
      System.out.println("delete employee from DB: " + emp2);

      System.out.println("----UPDATE----");
      session.createQuery("update Employee set salary=1000").executeUpdate();
      System.out.println("update salary");
      employeeList = session.createQuery("from  Employee", Employee.class).getResultList();
      for (Object emp:employeeList) {
        System.out.println(emp);
      }

      session.getTransaction().commit();
    }
  }
}
