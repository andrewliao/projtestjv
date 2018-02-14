package leetcode;

public class Tree {
	
	public static TreeNode search(int key) {
		return serachHelper(key, root);
		
	}
	
	public static TreeNode searchHelper(int key, TreeNode root) {
		//if the current node is null
				if(root == null) {
					return null;
				} else if(root.getData() == key){ //
					return root;
				} else if(root.getData() < key){
					if(root.getRight() != null) {
						searchHelper(key, root.getRight());
					}
				} else {
					if(root.getLeft() != null) {
						searchHelper(key, root.getLeft());
					} 
				}
	}
	
	
	public static void insert(int key, String data) {
		insertHelper(key, data, root);
	}
	
	public static void insertHelper(int key, String data, Node root) {
		if(root == null) {
			root = 
		}
	}
	
}
