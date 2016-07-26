package edu.ouc.offer;

/**
 * ����һ�ö��������жϸö������Ƿ���ƽ��������� 
 * 
 * @author wqx
 *
 */
public class BalanceTree {
    public boolean IsBalanced_Solution(TreeNode root) {
        return getLevel(root) != -1;
    }
    public int getLevel(TreeNode root){
    	if(root == null)return 0;
    	int left = getLevel(root.left);
    	int right = getLevel(root.right);
    	if(left == -1 || right == -1){
    		return -1;
    	}
    	if(Math.abs(left-right) > 1){
    		return -1;
    	}else{
    		return Math.max(left, right)+1;
    	}
    }
}
