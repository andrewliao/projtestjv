
public class HourlyEmployee extends Employee {
	
	private double hoursWorked;
	private double hourlyRate;
	
	public double getHoursWorked() {
		return hoursWorked;
	}
	
	public double getHourlyRate() {
		return hourlyRate;
	}
	
	public double getSalary() {
		return this.getHourlyRate() * this.getHoursWorked();
	}
	public void setHoursWorked(double hoursWorked) {
		this.hoursWorked = hoursWorked;
	}
	
	public void setHourlyRate(double hourlyRate) {
		this.hourlyRate = hourlyRate;
	}
	/* a constructor for hourly employee */
	public HourlyEmployee(String name) {
		super(name);
	}
}
