package datastructure;

public class LLNode {
	private int value;
	public LLNode next;
	
	public LLNode(int v, LLNode nextNode) {
		value = v;
		next = nextNode;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public LLNode getNext() {
		return next;
	}

	public void setNext(LLNode next) {
		this.next = next;
	}
	
	
}
