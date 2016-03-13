package edu.ouc.offer;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 
题目描述
输入一棵二叉树，求该树的深度。从根结点到叶结点依次经过的结点（含根、叶结点）形成树的一条路径，最长路径的长度为树的深度。

 * @author wqx
 *
 */
public class TreeDepth {
	/**
	 * BFS求解
	 * 
	 * @param root
	 * @return
	 */
    public int TreeDepth(TreeNode root) {
    	if(root == null)return 0;
        int level = 0;
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        while(!queue.isEmpty()){
        	int size = queue.size();
        	for(int i = 0; i < size; i++){
        		TreeNode node = queue.poll();
        		if(node.left != null) queue.offer(node.left);
        		if(node.right != null) queue.offer(node.right);
        	}
        	level++;
        }
        return level;
    }
}
