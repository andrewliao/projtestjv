package datastructure;

public class LinkedListInt {
	LLNode head;
	public LLNode getHeadNode() {
		return head;
	}
	
	public void setHeadNode(LLNode newHead) {
		head = newHead;
	}
	
	public void rotate(int x) {
		//this will store the start of the new linked list node
		LLNode newHead = getHeadNode();
		//this will store the last node that will be rotated
		LLNode lastElementShifted = null;
		//we count until we reach the the x node in the list
		for(int i = 0; i < x ; i++) {
			if(i == x - 1) {
				lastElementShifted = newHead;
			}
			newHead = newHead.next;
		}
		//we will set the last element rotated to be pointing to nothing
		lastElementShifted.setNext(null);
		//we will store the old head node
		LLNode oldHead = head;
		setHeadNode(newHead);
		//we will iterate until we find the last node of the original list and that node 
		//will point to the old head after the rotation
		while(newHead.getNext() != null) {
			newHead = newHead.getNext();
		}
		newHead.setNext(oldHead);
	}
	
	public static void main(String[] args) {
		LinkedListInt l1 = new LinkedListInt();
		LLNode first = new LLNode(1, new LLNode(2, new LLNode(3, new LLNode(4, new LLNode(5, null)))));
		l1.setHeadNode(first);
		LLNode front = l1.getHeadNode();
		System.out.println(front.getValue());
		front = front.getNext();
		System.out.println(front.getValue());
		front = front.getNext();
		System.out.println(front.getValue());
		front = front.getNext();
		System.out.println(front.getValue());
		front = front.getNext();
		System.out.println(front.getValue());
		
		System.out.println();
		
		l1.rotate(3);
		front = l1.getHeadNode();
		System.out.println(front.getValue());
		front = front.getNext();
		System.out.println(front.getValue());
		front = front.getNext();
		System.out.println(front.getValue());
		front = front.getNext();
		System.out.println(front.getValue());
		front = front.getNext();
		System.out.println(front.getValue());
		
	}
}
