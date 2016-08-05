package edu.ouc.cc150;

import java.util.LinkedList;
import java.util.Queue;

import edu.ouc.offer.ListNode;
import edu.ouc.offer.TreeNode;

/**
 * 
 * ���������

��Ŀ����

����һ�ö������������һ���㷨����������ĳһ��������н�������

�����������ĸ����ָ��TreeNode* root���Լ������Ͻ�����ȣ��뷵��һ������ListNode���������������н���ֵ��
�밴���ϴ������ҵ�˳�����ӣ���֤��Ȳ��������ĸ߶ȣ����Ͻ���ֵΪ�Ǹ������Ҳ�����100000��


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
