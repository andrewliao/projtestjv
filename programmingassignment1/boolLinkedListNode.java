package programmingassignment1;

public class boolLinkedListNode {
	//this stores the boolean value of the node
	private boolean value;
	//this stores a pointer to the next boolLinkedListNode
	private boolLinkedListNode next;
	//this stores a pointer to the previous boolLinkedListNode
	private boolLinkedListNode prev;
	
	//constructor that creates a boolLinkedListNode with the input boolean value
	//its worst running time is O(1)
	public boolLinkedListNode(boolean value) {
		this.value = value;
	}
	
	//this method sets the pointer of the next boolLinkedListNode
	//its worst running time is O(1)
	public void setNext(boolLinkedListNode next) {
		this.next = next;
	}
	
	//this method returns the next boolLinkedListNode
	//its worst running time is O(1)
	public boolLinkedListNode getNext() {
		return this.next;
	}
	
	//this method sets the pointer of the previous boolLinkedListNode
	//its worst running time is O(1)
	public void setPrev(boolLinkedListNode prev) {
		this.prev = prev;
	}
	
	//this method returns the previous boolLinkedListNode
	//its worst running time is O(1)
	public boolLinkedListNode getPrev() {
		return this.prev;
	}
	
	//this methods returns the value of the current boolLinkedListNode
	//its worst running time is O(1)
	public boolean getValue() {
		return this.value;
	}
	
	//this method sets the value of the boolean element stored in the current boolLinkedListNode
	//its worst running time is O(1)
	public void setValue(boolean value) {
		this.value = value;
	}
	
	
	
}
