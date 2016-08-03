package edu.ouc.cc150;

import java.util.Stack;

import edu.ouc.algorithm.tree.TreeNode;


/**
 * 检查是否为BST
题目描述

请实现一个函数，检查一棵二叉树是否为二叉查找树。

给定树的根结点指针TreeNode* root，请返回一个bool，代表该树是否为二叉查找树。


 * @author wqx
 *
 */
public class _4_5_CheckBST {
	
	/**
	 * 中序遍历是顺序的
	 * 
	 * @param root
	 * @return
	 */
	public boolean checkBST(TreeNode root) {
		Stack<TreeNode> stack = new Stack<TreeNode>();
		
		TreeNode p = root , pre = null;
		
		while(p != null || !stack.empty())  
		{  
			while(p != null)  
			{  
				stack.push(p);
				pre = p;
				p = p.left;  
			}
			p = stack.peek();
			//pre为null说明是第一个元素
			if(pre != null && pre.val > p.val){
				return false;
			}else{
				pre = p;
			}
			stack.pop();  
			p = p.right;  
		} 
		return true;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
			
	}

}
