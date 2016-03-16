package edu.ouc.offer;

/**
 * 输入某二叉树的前序遍历和中序遍历的结果，请重建出该二叉树。
 * 
 * @author wqx
 *
 */
public class RebuildBinaryTree {
	public static void main(String args[]){
		int [] pre = {1,2,3,4,5,6,7};
		int [] in = {3,2,4,1,6,5,7};
		reConstructBinaryTree(pre,in);
	}
    public static TreeNode reConstructBinaryTree(int [] pre,int [] in) {
    	return reBuildTree(pre,0,pre.length-1,in,0,in.length-1);
    }
    public static TreeNode reBuildTree(int[] pre,int s1,int e1,int[] in,int s2,int e2){
    	if(s1 > e1) return null;
    	int rootV = pre[s1];
    	int pos = s2;
    	for(;in[pos] != rootV; pos++);
    	TreeNode root = new TreeNode(rootV);
    	root.left = reBuildTree(pre,s1+1,s1+(pos-s2),in,s2,pos-1);
    	root.right = reBuildTree(pre,s1+(pos-s2)+1,e1,in,pos+1,e2);
    	return root;
    }
}
