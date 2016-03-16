package edu.ouc.offer;

import java.util.ArrayList;
import java.util.Deque;
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
	/**
	 * �����ӡ��ÿ��ڵ����һ��List��
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
	 * ��ʵ��һ����������֮���δ�ӡ������������һ�а��մ����ҵ�˳���ӡ��
	 * �ڶ��㰴�մ��������˳���ӡ��
	 * �����а��մ����ҵ�˳���ӡ��
	 * �������Դ����ơ� 
	 * 
	 * ͬ����BFS��ʹ��˫�˶���Deque
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
			//����������Ҵ�ӡ
			if(level % 2 == 1){
				for(int i = 0 ; i < size; i++){
					TreeNode node =  queue.poll();
					tmp.add(node.val);
					if(node.left != null)queue.add(node.left);
					if(node.right != null) queue.add(node.right);
				}
			}else{
				//�������󣺴Ӷ�βȡ����
				for(int i = 0 ; i < size; i++){
					TreeNode node = queue.pollLast();
					tmp.add(node.val);
					//����һ��ڵ�Ӷ�ͷ���룬���ҽڵ㣬����ڵ�
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
