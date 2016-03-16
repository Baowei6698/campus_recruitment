package edu.ouc.offer;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 
题目描述
从上往下打印出二叉树的每个节点，同层节点从左至右打印。

 * @author wqx
 *
 */
public class PrintTreeBFS {
	/**
	 * 按层打印二叉树节点
	 * BFS！
	 * 
	 * @param root
	 * @return
	 */
	public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
		ArrayList<Integer> result = new ArrayList<Integer>();
		if(root == null)return result;
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		queue.add(root);
		while(!queue.isEmpty()){
			int size = queue.size();
			for(int i = 0 ; i < size; i++){
				TreeNode node = queue.poll();
				result.add(node.val);
				if(node.left != null)queue.add(node.left);
				if(node.right != null) queue.add(node.right);
			}
		}
		return result;
	}
	/**
	 * 按层打印，每层节点放入一个List中
	 * @param root
	 * @return
	 */
	public ArrayList<ArrayList<Integer>> PrintFromTopToBottom2(TreeNode root) {
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
		if(root == null)return result;
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		queue.add(root);
		while(!queue.isEmpty()){
			int size = queue.size();
			ArrayList<Integer> tmp = new ArrayList<Integer>();
			for(int i = 0 ; i < size; i++){
				TreeNode node = queue.poll();
				tmp.add(node.val);
				if(node.left != null)queue.add(node.left);
				if(node.right != null) queue.add(node.right);
			}
			result.add(tmp);
		}
		return result;
	}
	/**
	 * 请实现一个函数按照之字形打印二叉树，即第一行按照从左到右的顺序打印，
	 * 第二层按照从右至左的顺序打印，
	 * 第三行按照从左到右的顺序打印，
	 * 其他行以此类推。 
	 * 
	 * 同样是BFS，使用双端队列Deque
	 * 
	 * 
	 * @param root
	 * @return
	 */
	public ArrayList<ArrayList<Integer>> PrintFromTopToBottom3(TreeNode root) {
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
		if(root == null)return result;
		Deque<TreeNode> queue = new LinkedList<TreeNode>();
		queue.add(root);
		int level = 1;
		while(!queue.isEmpty()){
			int size = queue.size();
			ArrayList<Integer> tmp = new ArrayList<Integer>();
			//奇数层从左到右打印
			if(level % 2 == 1){
				for(int i = 0 ; i < size; i++){
					TreeNode node =  queue.poll();
					tmp.add(node.val);
					if(node.left != null)queue.add(node.left);
					if(node.right != null) queue.add(node.right);
				}
			}else{
				//从右向左：从队尾取数据
				for(int i = 0 ; i < size; i++){
					TreeNode node = queue.pollLast();
					tmp.add(node.val);
					//将下一层节点从队头插入，先右节点，后左节点
					if(node.right != null) queue.addFirst(node.right);
					if(node.left != null)queue.addFirst(node.left);
				}
			}
			level++;
			result.add(tmp);
		}
		return result;
	}
}
