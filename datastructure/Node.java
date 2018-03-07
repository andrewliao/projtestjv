package datastructure;

public class Node {
	Node left, right;
	int data;
	public Node(int data) {
		this.data = data;
	}
	
	public void insert(int value) {
		if(value <= this.data) {
			if(left == null) {
				this.left = new Node(value);
			} else {
				left.insert(value);
			}
		} else {
			if(right == null) {
				this.right = new Node(value);
			} else {
				right.insert(value);
			}
		}
	}
	
	public boolean contains(int value) {
		if(value == data) {
			return true;
		} else if(value < data) {
			if(left == null) {
				return false;
			} else {
				return left.contains(value);
			}
		} else {
			if(right == null) {
				return false;
			} else {
				return right.contains(value);
			}
		}
	}
	
	public void printInOrder() {
		if(left != null) {
			left.printInOrder();
		} 
		System.out.println(data);
		if(right != null) {
			right.printInOrder();
		}
	}
	
	public static void main(String[] args) {
		System.out.println('a' + 'b');
	}
}