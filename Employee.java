/* A class that represents and employee in our company */
public class Employee extends Object {

  private String name;            // stores the name
  private String title;           // stores the job title
  private double salary;          // stores the salary
  private int employeeNumber;     // stores the id number
  
  /* a class field that keeps track of last employee number used */
  private static int lastEmployeeNumberUsed = 0;
  
  /* A constructor that sets the employee name */
  public Employee(String name) {
    super();
    this.name = name;
    this.employeeNumber = 
      (lastEmployeeNumberUsed = lastEmployeeNumberUsed + 1);
  }
  
  /* A constructor that sets the employee name and salary */
  public Employee(String name, double salary) {
    this(name);
    this.salary = salary;
  }
  
  /* get the name of the employee */
  public String getName() {
    return name;
  }
  
  /* change the name of the employee */
  public void setName(String name) {
    this.name = name;
  }
  
  /* get the employee title */
  public String getTitle() {
    return title;
  }
  
  /* change the employee title */
  public void setTitle(String title) {
    this.title = title;
  }
  
  /* get the employee's salary */
  public double getSalary() {
    return salary;
  }
  
  /* change the employee's salary */
  public void setSalary(double salary) {
    this.salary = salary;
  }
  
  /* get the employee number */
  public int getEmployeeNumber() {
    return employeeNumber;
  }
  
  /* return true if this employee earns more than the input employee */
  public boolean earnsMoreThan(Employee e) {
    return this.getSalary() > e.getSalary();
  }
}
