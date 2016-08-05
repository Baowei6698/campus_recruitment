package edu.ouc.offer;

import java.util.Arrays;

public class TreeNode {
	public int val;
	public TreeNode right;
	public TreeNode left;
	public TreeNode(int x){val = x;}

	public static TreeNode createTree(int arr[], int index){
		if(arr.length <= 0 || index >= arr.length || "#".equals(arr[index])) return null;
		
		int val = arr[index];
		TreeNode root = new TreeNode(val);
		root.left = createTree(arr, 2*index + 1);
		root.right = createTree(arr, 2*index + 2);
		return root;
	}
	public static void main(String args[]){
		int arr[] = {1,2,33,4,5};
		TreeNode root = createTree(arr,0);
		System.out.println("root:" + root.val);
		PrintTreeBFS print = new PrintTreeBFS();
		System.out.println(Arrays.toString(print.PrintFromTopToBottom(root).toArray()));
	}
}
