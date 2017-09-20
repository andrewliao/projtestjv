public class Circle {
	public static final double PI = 3.14;
	// An instance field that holds the radius of the circle
	private double r;
	private double field;

	//The constructor: initialize the radius field
	
	public Circle() {
		this(1.0);
	}
    
    public Circle(double r) {
		this.r = r;
	}


	//
	public double getR() {
		System.out.println("You called the getR method");
		return r;
	}

	public double field(){
		return field;
	}

	//The instance methods: compute the values based on the radius
	public double circumferance() {
		return 2 * PI * r;
	}
	public double area() {
		return PI * r * r;
	}
	public double radius() {
		return r;
	}


}