package edu.ouc.cc150;

import java.util.Arrays;


/**
 * 
题目描述

现在我们要读入一串数，同时要求在读入每个数的时候算出它的秩，即在当前数组中小于等于它的数的个数(不包括它自身)，
请设计一个高效的数据结构和算法来实现这个功能。

给定一个int数组A，同时给定它的大小n，请返回一个int数组，元素为每次加入的数的秩。保证数组大小小于等于5000。
测试样例：

[1,2,3,4,5,6,7],7

返回：[0,1,2,3,4,5,6]


 * @author wqx
 *
 */
public class _11_8_RankOfNumber {

	/**
	 * 思路：
	 * 在线算法，可以使用二叉查找树结构,每次读取到一个数字，插入到当前二叉树中，
	 * 保证该节点的左子树都是小于该节点，右子树都是大于该节点。
	 * 
	 * @param A
	 * @param n
	 * @return
	 */
	public int[] getRankOfNumber(int[] A, int n) {
		Node root = new Node(A[0]);
		int[] result = new int[n];
		result[0] = 0;
		for(int i = 1; i < n; i++){
			insert(root,A[i]);
			result[i] = getRank(root,A[i]);
		}
		return result;
	}
	public void print(Node root){
		if(root != null){
			System.out.println(root.val);
			print(root.left);
			print(root.right);
		}
	}
	public void insert(Node root,int val){
		if(val > root.val){
			if(root.right == null)
				root.right = new Node(val);
			else
				insert(root.right,val);
		}else{
			root.leftSize++;
			if(root.left == null)
				root.left = new Node(val);
			else{
				insert(root.left,val);
			}
		}
	}
	public int getRank(Node root, int val){
		if(root == null) return 0;
		int cur = root.val;
		if (cur == val)
			return root.leftSize;
		if (cur > val)
			return getRank(root.left,val);
		if (cur < val)
			return root.leftSize + 1 + getRank(root.right,val);
		return 0;    	
	}
	static class Node{
		int val;
		Node left,right;
		//左子树元素的个数
		int leftSize;
		public Node(int v){
			this.val = v;
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] A = {1,2,3,4,5,6,7};
		int n = 7;
		int[] res = new _11_8_RankOfNumber().getRankOfNumber(A, n);
		System.out.println(Arrays.toString(res));
	}

}
