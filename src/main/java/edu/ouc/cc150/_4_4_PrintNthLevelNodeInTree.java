package edu.ouc.cc150;

import java.util.LinkedList;
import java.util.Queue;

import edu.ouc.offer.ListNode;
import edu.ouc.offer.TreeNode;

/**
 * 
 * 输出单层结点

题目描述

对于一棵二叉树，请设计一个算法，创建含有某一深度上所有结点的链表。

给定二叉树的根结点指针TreeNode* root，以及链表上结点的深度，请返回一个链表ListNode，代表该深度上所有结点的值，
请按树上从左往右的顺序链接，保证深度不超过树的高度，树上结点的值为非负整数且不超过100000。


 * @author wqx
 *
 */
public class _4_4_PrintNthLevelNodeInTree {

	public static ListNode getTreeLevel(TreeNode root, int dep) {
		if(dep <= 0) return new ListNode(0);
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		ListNode begin = new ListNode(0);
		ListNode tail = begin;
		TreeNode p = root;
		queue.offer(p);
		int level = 1;
		while(!queue.isEmpty()){
			int len = queue.size();
			int i = 0;
			if(level == dep){
				while(i < len){
					TreeNode node = queue.poll();
					ListNode n = new ListNode(node.val);
					tail.next = n;
					tail = n;
					i++;
				}
				return begin.next;
			}
			while(i < len){
				TreeNode node = queue.poll();
				if(node.left != null){
					queue.offer(node.left);
				}
				if(node.right != null){
					queue.offer(node.right);
				}
				i++;
			}
		}
		return begin;
	}

	public static void main(String[] args) {
	}
	public static void printList(ListNode node){
		if(node != null){
			System.out.println("," + node.val);
			printList(node.next);
		}
	}
}
