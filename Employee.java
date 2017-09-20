/* A class that represents the employee in our company */
public class Employee extends Object {
	
	private String name;
	private String title;
	private double salary;
	private int employeeNumber;
	
	public String getName() {
		return this.name;
	}
	
	public void setName(String changedName) {
		this.name = changedName;
	}
}
