package edu.ouc.offer;

import java.util.ArrayList;
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
}
