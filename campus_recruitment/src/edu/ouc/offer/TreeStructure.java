package edu.ouc.offer;

/**
 * 
��Ŀ����
�������Ŷ�����A��B���ж�B�ǲ���A���ӽṹ��

 * @author wqx
 *
 */
public class TreeStructure {
	/**
	 * ˼·������������A���ҵ���B��root�ڵ���ȵĽڵ㣬���ж����������Ƿ�һ��
	 * 
	 * @param root1
	 * @param root2
	 * @return
	 */
	private boolean hasSubTree = false;
    public boolean HasSubtree(TreeNode root1,TreeNode root2) {
    	preTraverse(root1,root2);
    	return hasSubTree;
    }
    public void preTraverse(TreeNode node,TreeNode root){
    	if(hasSubTree) return;
    	if(node == null)return;
    	if(node != null && root != null && node.val == root.val){
    		hasSubTree = isSameTree(node,root);
    	}
    	System.out.println("ndoe:" + node.val);
    	preTraverse(node.left,root);
    	if(hasSubTree)return ;
    	preTraverse(node.right,root);
    }
    public boolean isSameTree(TreeNode node,TreeNode root){
    	if(root == null ){
    		return true;
    	}
    	if(node == null){
    		return false;
    	}
    	
    	if(root.val == node.val){
    		return isSameTree(node.right,root.right) && isSameTree(node.left,root.left);
    	}else{
    		return false;
    	}
    }
}
