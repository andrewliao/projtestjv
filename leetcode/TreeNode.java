package leetcode;

public class TreeNode {
	private int data;
	private TreeNode left, right;
	
	public TreeNode(int data) {
		this.data = data;
	}

	public int getData() {
		return data;
	}

	public void setData(int data) {
		this.data = data;
	}

	public TreeNode getLeft() {
		return left;
	}

	public void setLeft(TreeNode left) {
		this.left = left;
	}

	public TreeNode getRight() {
		return right;
	}

	public void setRight(TreeNode right) {
		this.right = right;
	}
	
	public void insert(int value) {
		if(value <= data) {
			if(getLeft() == null) {
				setLeft(new TreeNode(value));
			} else {
				getLeft().insert(value);
			}
		} else {
			if(getRight() == null) {
				setRight(new TreeNode(value));
			} else {
				getRight().insert(value);
			}
		}
	}
	
	public boolean contains(int value) {
		if(value == data) {
			return true;
		} else if (value < data) {
			if(getLeft() == null) {
				return false;
			} else {
				return getLeft().contains(value);
			}
		} else {
			if(getRight() == null) {
				return false;
			} else {
				return getRight().contains(value);
			}
		}
	}
	
	public void printInOrder() {
		if(getLeft() != null) {
			left.printInOrder();
		}
		System.out.println(data);
		
		if(getRight() != null) {
			right.printInOrder();
		}
	}
	
}
