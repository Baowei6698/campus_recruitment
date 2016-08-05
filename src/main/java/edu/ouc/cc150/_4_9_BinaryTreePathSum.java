package edu.ouc.cc150;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

import edu.ouc.offer.TreeNode;

/**
 * �������к�Ϊĳһֵ��·��
 * 
��Ŀ����
����һ�Ŷ�������һ����������ӡ���������н��ֵ�ĺ�Ϊ��������������·����
·������Ϊ�����ĸ���㿪ʼ����һֱ��Ҷ����������Ľ���γ�һ��·����

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
