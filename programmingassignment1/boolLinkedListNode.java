package programmingassignment1;

public class boolLinkedListNode {
	private boolean value;
	private boolLinkedListNode next;
	private boolLinkedListNode prev;
	
	public boolLinkedListNode(boolean value) {
		
	}
	
	public void setNext(boolLinkedListNode next) {
		this.next = next;
	}
	
	public boolLinkedListNode getNext() {
		return this.next;
	}
	
	public void setPrev(boolLinkedListNode prev) {
		this.prev = prev;
	}
	
	public boolLinkedListNode getPrev() {
		return this.prev;
	}
	
	public boolean getValue() {
		return this.value;
	}
	
	public void setValue(boolean value) {
		this.value = value;
	}
	
	
	
}
