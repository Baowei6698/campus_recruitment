package edu.ouc.cc150;

import edu.ouc.algorithm.tree.TreeNode;

/**
 * 二叉树平衡检查
 * 
题目描述

实现一个函数，检查二叉树是否平衡，平衡的定义如下，对于树中的任意一个结点，其两颗子树的高度差不超过1。

给定指向树根结点的指针TreeNode* root，请返回一个bool，代表这棵树是否平衡。


 * @author wqx
 *
 */
public class _4_1_BalanceTree {

	public boolean isBalance(TreeNode root) {
		// write code here
		if(root == null) return true;
		int left = depth(root.left);
		int right = depth(root.right);
		if(Math.abs(left-right) > 1) return false;
		return isBalance(root.left) && isBalance(root.right);
	}
	public int depth(TreeNode node){
		if(node == null)
			return 0;
		else
			return Math.max(depth(node.left),depth(node.right)) + 1;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
