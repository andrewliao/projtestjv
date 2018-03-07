package programmingassignment2;

public class HuffmanNode {
	private Character inChar;
	private int frequency;
	private HuffmanNode left;
	private HuffmanNode right;
	
	public HuffmanNode(Character inChar, int frequency) {
		this.inChar = inChar;
		this.frequency = frequency;
	}
	
	public HuffmanNode getLeft() {
		return left;
	}

	public void setLeft(HuffmanNode left) {
		this.left = left;
	}

	public HuffmanNode getRight() {
		return right;
	}

	public void setRight(HuffmanNode right) {
		this.right = right;
	}

	public char getInChar() {
		return inChar;
	}

	public void setInChar(char inChar) {
		this.inChar = inChar;
	}

	public int getFrequency() {
		return frequency;
	}

	public void setFrequency(int frequency) {
		this.frequency = frequency;
	}
	
	
}
