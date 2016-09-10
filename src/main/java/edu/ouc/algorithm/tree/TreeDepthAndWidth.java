package edu.ouc.algorithm.tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * ��������������Ⱥ͹�ȣ����������ڶ�����-������չ���������ͼ��
 * 
 * @author wqx
 *
 */
public class TreeDepthAndWidth {
	
	/**
	 * ����ͼ�������������ԭ����tree����DFS��
	 * ��¼��������ȣ��ҳ����ֵ��������������
	 * 
	 * ˼·һ���ݹ鷽ʽ
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
	 * ˼·�����ǵݹ�
	 * 
	 * �ǵݹ鷽ʽ�������ķǵݹ���������������м�¼���
	 * 
	 * δ�����������
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
