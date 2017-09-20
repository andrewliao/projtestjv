public class Dictionary extends Book {
	private int definitions = 52500;
	public int z;

	public Dictionary(int x, int y, int z) {
		super(x,y);
		this.z = z;
	}

	public void getVariables() {
		System.out.print(this.x + " " + this.y + " " + this.z);
	}
	public double computeRatio() {
		return (double) definitions / pages;
	}

	public void setDefinitions(int numDefinitions) {
		definitions = numDefinitions;
	}

	public int getDefinitions() {
		return definitions;
	}
}