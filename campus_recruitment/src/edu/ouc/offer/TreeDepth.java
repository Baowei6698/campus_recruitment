package edu.ouc.offer;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 
��Ŀ����
����һ�ö����������������ȡ��Ӹ���㵽Ҷ������ξ����Ľ�㣨������Ҷ��㣩�γ�����һ��·�����·���ĳ���Ϊ������ȡ�

 * @author wqx
 *
 */
public class TreeDepth {
	/**
	 * BFS���
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
