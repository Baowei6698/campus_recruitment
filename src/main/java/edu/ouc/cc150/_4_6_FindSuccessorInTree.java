package edu.ouc.cc150;

import java.util.Stack;

import edu.ouc.offer.TreeNode;

/**
 * 
题目描述

请设计一个算法，寻找二叉树中指定结点的下一个结点（即中序遍历的后继）。

给定树的根结点指针TreeNode* root和结点的值int p，请返回值为p的结点的后继结点的值。
保证结点的值大于等于零小于等于100000且没有重复值，若不存在后继返回-1。


 * @author wqx
 *
 */
public class _4_6_FindSuccessorInTree {
	
	/**
	 * 思路:
	 * 非递归中序遍历，记录发现p的标志
	 * 
	 * @param root
	 * @param p
	 * @return
	 */
    public int findSucc(TreeNode root, int p) {
    	TreeNode q = root;
    	Stack<TreeNode> s = new Stack<TreeNode>();
    	boolean flag = false;
    	
    	while(q != null || !s.isEmpty()){
    		
    		while(q != null){
    			s.push(q);
    			q = q.left;
    		}
    		if(flag){
    			return s.peek().val;
    		}
    		if( p == s.peek().val){
    			flag = true;
    		}
    		q = s.pop().right;
    	}
    	return -1;
    }
	public static void main(String[] args) {
		
	}

}
