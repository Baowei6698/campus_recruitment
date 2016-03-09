package edu.ouc.offer;

/**
 * 题目描述
操作给定的二叉树，将其变换为源二叉树的镜像。
输入描述:

二叉树的镜像定义：源二叉树 
    	    8
    	   /  \
    	  6   10
    	 / \  / \
    	5  7 9 11
    	镜像二叉树
    	    8
    	   /  \
    	  10   6
    	 / \  / \
    	11 9 7  5
    	
 * @author wqx
 *
 */
public class MirrorTree {
	/**
	 * 二叉树基本构造
	 * 
	 * @param root
	 */
    public void Mirror(TreeNode root) {
        root = createTree(root);
    }
    public TreeNode createTree(TreeNode root){
    	if(root == null) return root;
    	//暂存root的左子树引用
    	TreeNode node = root.left;
    	root.left = createTree(root.right);
    	root.right = createTree(node);
    	return root;
    }
}
