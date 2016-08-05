package edu.ouc.cc150;

import edu.ouc.algorithm.tree.TreeNode;

/**
 * ������ƽ����
 * 
��Ŀ����

ʵ��һ�����������������Ƿ�ƽ�⣬ƽ��Ķ������£��������е�����һ����㣬�����������ĸ߶Ȳ����1��

����ָ����������ָ��TreeNode* root���뷵��һ��bool������������Ƿ�ƽ�⡣


 * @author wqx
 *
 */
public class _4_1_BalanceTree {

	public boolean isBalance(TreeNode root) {
		// write code here
		if(root == null) return true;
		int left = depth(root.left);
		int right = depth(root.right);
		if(Math.abs(left-right) > 1) return false;
		return isBalance(root.left) && isBalance(root.right);
	}
	public int depth(TreeNode node){
		if(node == null)
			return 0;
		else
			return Math.max(depth(node.left),depth(node.right)) + 1;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
