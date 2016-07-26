package edu.ouc.offer;

import java.util.Stack;

/**
 * 
题目描述
输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的双向链表。要求不能创建任何新的结点，只能调整树中结点指针的指向。

 * @author wqx
 *
 */
public class ConvertTreeToLinkedList {
	/**
	 * 采用树的非递归中序遍历，同时构造双向链表
	 * 
	 * @param pRootOfTree
	 * @return
	 */
    public TreeNode Convert(TreeNode pRootOfTree) {
        if(pRootOfTree == null) return null;
        
        TreeNode head = null,tail = null;
        
        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.push(pRootOfTree);
        TreeNode p = pRootOfTree;
        while(p != null || !stack.isEmpty()){
        	while(p != null){
        		stack.push(p);
        		p = p.left;
        	}
        	
        	p = stack.pop();
        	TreeNode tmp = p.right;
        	if(tail == null){
        		p.right = tail;
        		tail = p;
        		head = p;
        	}else{
        		p.right = tail.right;
        		tail.right = p;
        		p.left = tail;
        		tail = p;
        	}
        	//System.out.println(p.val);
        	p = tmp;
        }
        head.left = tail;
        tail.right = head;
        return head;
    }
}
