package edu.ouc.offer;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 
��Ŀ����
�������´�ӡ����������ÿ���ڵ㣬ͬ��ڵ�������Ҵ�ӡ��

 * @author wqx
 *
 */
public class PrintTreeBFS {
	/**
	 * �����ӡ�������ڵ�
	 * BFS��
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
