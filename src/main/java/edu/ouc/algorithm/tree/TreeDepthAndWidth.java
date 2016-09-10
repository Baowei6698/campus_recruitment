package edu.ouc.algorithm.tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * 给定二叉树的深度和广度（不仅仅限于二叉树-可以扩展到多叉树或图）
 * 
 * @author wqx
 *
 */
public class TreeDepthAndWidth {
	
	/**
	 * 按照图的深度优先搜索原理，对tree进行DFS，
	 * 记录搜索的深度，找出最大值，即树的最大深度
	 * 
	 * 思路一：递归方式
	 * 
	 * @param root
	 */
	public int depthRecursive(TreeNode root){
		if(root == null){
			return 0;
		}else{
			return Math.max(depthRecursive(root.left),depthRecursive(root.right)) + 1;
		}
	}
	/**
	 * 思路二：非递归
	 * 
	 * 非递归方式利用树的非递归遍历，遍历过程中记录深度
	 * 
	 * 未完待续。。。
	 * 
	 * @param root
	 * @return
	 */
	public int depthNonRecursive(TreeNode root){
		int maxDepth = 0, curDepth = 0;
		
		Stack<TreeNode> stack = new Stack<>();
		
		TreeNode node = root;
		
		while(!stack.isEmpty() || node != null){
			//visited(node);
			if(node == null){
				node = stack.pop();
			}
			if(node.right != null){
				stack.push(node.right);
			}
			node = node.right;
		}
		
		return maxDepth;
	}
	public int maxWidth(TreeNode root){
		TreeNode node = root;
		int curWidth = 0, maxWidth = 0;
		Queue<TreeNode> queue = new LinkedList<>();
		queue.offer(node);
		while(!queue.isEmpty()){
			curWidth = queue.size();
			if(curWidth > maxWidth){
				maxWidth = curWidth;
			}
			for(int i = 0; i < curWidth; i++){
				TreeNode n = queue.poll();
				//visited(n);
				if(n.left != null){
					queue.offer(n.left);
				}
				if(n.right != null){
					queue.offer(n.right);
				}
			}
		}
		return maxWidth;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
