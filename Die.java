public class Die extends Object {

	// a field to store the number of sides of this die
	private final int numberOfSides;

	//a field to remember the current value
	private int currentValue = 1;

	//a constructor for Die that takes the number of sides
	public Die(int numberOfSides) {
		this.numberOfSides = numberOfSides;
	}

	public Die() {
		this.numberOfSides = 6;
	}

	//roll the die and return the value rolled;
	public int roll() {
		this.currentValue = (int) (Math.random() * this.numberOfSides + 1);
		return this.currentValue;
	}

	//read the value of the die
	public int getCurrentValue() {
		return this.currentValue;
	}

	//set the currentvalue of the die
	public void setCurrentValue(int topFace) {
		this.currentValue = topFace;
	}

}

/*
public class Die {
	private final int MAX = 6;
 
	private int faceValue;

	public int automatic;

	public Die() {
		faceValue = 1;
	}

	public int roll() {
		faceValue = (int) (Math.random() * MAX) + 1;

		return faceValue;
	}

	public void setFaceValue(int value) {
		faceValue = value;
	}

	public int getFaceVAlue() {
		return faceValue;
	}

	public String toString() {
		String result = Integer.toString(faceValue);

		return result;
	}
*/