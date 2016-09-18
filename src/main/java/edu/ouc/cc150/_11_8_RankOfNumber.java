package edu.ouc.cc150;

import java.util.Arrays;


/**
 * 
��Ŀ����

��������Ҫ����һ������ͬʱҪ���ڶ���ÿ������ʱ����������ȣ����ڵ�ǰ������С�ڵ����������ĸ���(������������)��
�����һ����Ч�����ݽṹ���㷨��ʵ��������ܡ�

����һ��int����A��ͬʱ�������Ĵ�Сn���뷵��һ��int���飬Ԫ��Ϊÿ�μ���������ȡ���֤�����СС�ڵ���5000��
����������

[1,2,3,4,5,6,7],7

���أ�[0,1,2,3,4,5,6]


 * @author wqx
 *
 */
public class _11_8_RankOfNumber {

	/**
	 * ˼·��
	 * �����㷨������ʹ�ö���������ṹ,ÿ�ζ�ȡ��һ�����֣����뵽��ǰ�������У�
	 * ��֤�ýڵ������������С�ڸýڵ㣬���������Ǵ��ڸýڵ㡣
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
		//������Ԫ�صĸ���
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
