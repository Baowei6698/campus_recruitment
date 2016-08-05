package edu.ouc.algorithm.tree;

public class CheckAVL {
	
	public boolean checkAVL(TreeNode root) {
		if(root == null) return true;
		int left = depth(root.left);
		int right = depth(root.right);
		if(Math.abs(left-right) > 1) return false;
		return checkAVL(root.left) && checkAVL(root.right);
	}
	public int depth(TreeNode node){
		if(node == null)
			return 0;
		else
			return Math.max(depth(node.left),depth(node.right)) + 1;
	}
}
