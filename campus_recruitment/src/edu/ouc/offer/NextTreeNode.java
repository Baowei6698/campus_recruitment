package edu.ouc.offer;

import java.util.Stack;

/**
 * 
题目描述
给定一个二叉树和其中的一个结点，请找出中序遍历顺序的下一个结点并且返回。
注意，树中的结点不仅包含左右子结点，同时包含指向父结点的指针。

 * @author wqx
 *
 */
public class NextTreeNode {
	/**
	 *
	 * 1.二叉树为空，则返回空；
	 * 
	 * 2.节点右孩子存在，则设置一个指针从该节点的右孩子出发，
	 * 一直沿着指向左子结点的指针找到的叶子节点即为下一个节点；
	 * 
	 * 3.节点不是根节点。如果该节点是其父节点的左孩子，则返回父节点；
	 * 否则继续向上遍历其父节点的父节点，重复之前的判断，返回结果。
	 * 
	 * @param pNode
	 * @return
	 */
    public TreeLinkNode GetNext(TreeLinkNode pNode)
    {
    	if(pNode == null) return pNode;
    	if(pNode.right != null){
    		TreeLinkNode p = pNode.right;
    		while(p.left != null){
    			p = p.left;
    		}
    		return p;
    	}
    	while(pNode.next != null){
    		TreeLinkNode p = pNode.next;
    		if(p.left == pNode){
    			return p;
    		}
    		pNode = pNode.next;
    	}
    	return null;
    }
	/**
	 *
	 * 题目改为前序遍历的情况，寻找当前节点下一个节点。
	 * 
	 * 1.二叉树为空，则返回空；
	 * 
	 * 2.节点左孩子存在，则返回左孩子，否则查看有孩子是否存在，若存在则返回右孩子
	 * 
	 * 3.节点不是根节点。如果该节点是其父节点的左孩子，则返回父节点的右孩子；
	 *   否则继续向上遍历其父节点的父节点，重复之前的判断，返回结果。
	 * 
	 * @param pNode
	 * @return
	 */
   public TreeLinkNode GetNext2(TreeLinkNode pNode)
   {
   	if(pNode == null) return pNode;
   	if(pNode.left != null){
   		return pNode.left;
   	}
   	if(pNode.right != null){
   		return pNode.right;
   	}
   	
   	while(pNode.next != null){
   		TreeLinkNode p = pNode.next;
   		if(p.left == pNode && p.right != null){
   			return p.right;
   		}
   		pNode = pNode.next;
   	}
   	return null;
   }
}
