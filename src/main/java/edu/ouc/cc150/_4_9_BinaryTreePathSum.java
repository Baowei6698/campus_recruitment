package edu.ouc.cc150;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

import edu.ouc.offer.TreeNode;

/**
 * 二叉树中和为某一值的路径
 * 
题目描述
输入一颗二叉树和一个整数，打印出二叉树中结点值的和为输入整数的所有路径。
路径定义为从树的根结点开始往下一直到叶结点所经过的结点形成一条路径。

 * @author wqx
 *
 */
public class _4_9_BinaryTreePathSum {
	
	/**
	 * dfs
	 * 
	 * @param root
	 * @param target
	 * @return
	 */
    public static ArrayList<ArrayList<Integer>> FindPath(TreeNode root,int target) {
    	ArrayList<ArrayList<Integer>>  res = new ArrayList<ArrayList<Integer>>();
    	ArrayList<Integer> path = new ArrayList<>();
    	dfs(root,path,res,target);
    	return res;
    }
    @SuppressWarnings("unchecked")
	public static void dfs(TreeNode root, ArrayList<Integer> path, ArrayList<ArrayList<Integer>> res, int target){
    	if(root == null) return;
    	path.add(root.val);
    	if(root.left == null && root.right == null){
    		int sum = 0;
    		for(int i = 0; i < path.size(); i++){
    			sum += path.get(i);
    		}
    		if(target != sum){
    			return ;
    		}
    		res.add((ArrayList<Integer>) path.clone());
    	}
    	if(root.left != null){
    		dfs(root.left, path, res, target);
    		path.remove(path.size()-1);
    	}
    	if(root.right != null){
    		dfs(root.right, path, res, target);
    		path.remove(path.size()-1);
    	}
    }
	public static void main(String[] args) {
		int arr[] = {10,5,12,4,7};
		TreeNode root = TreeNode.createTree(arr,0);
		ArrayList<ArrayList<Integer>> res = FindPath(root,22);
		System.out.println("size:" + res.size());
		
	}

}
