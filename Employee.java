/* A class that represents the employee in our company */
public class Employee extends Object {
	
	private String name;
	private String title;
	private double salary;
	private int employeeNumber;
	
	/* a class field that keeps track of last employee number used */
	private static int lastEmployeeNumberUsed = 0;
	
	/* A constructor that sets the employee name */
	public Employee(String name) {
		this.name = name;
		this.employeeNumber = 
				(lastEmployeeNumberUsed = lastEmployeeNumberUsed + 1);
		
	}
	

	/*A constructor that sets the employee name and salary */
	 public Employee(String name, double salary) {
		 this.name = name;
		 this.salary = salary;
		 this.employeeNumber = 
				 (lastEmployeeNumberUsed = lastEmployeeNumberUsed + 1);
	 }
	
	/* get the name of the employee */
	public String getName() {
		return this.name;
	}
	
	/* change the name of the employee */
	public void setName(String changedName) {
		this.name = changedName;
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
	
	/* set the employee's salary */
	public void setSalary(double salary) {
		this.salary = salary;
	}
	
	/*get the employee number*/
	public int getEmployeeNumber() {
		return employeeNumber;
	}
	
	public static void main(String[] args) {
		Employee e = new Employee();
		
	}

	
	
}
