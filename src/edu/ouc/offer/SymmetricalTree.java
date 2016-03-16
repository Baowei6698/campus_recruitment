package edu.ouc.offer;

/**
 * ��ʵ��һ�������������ж�һ�Ŷ������ǲ��ǶԳƵġ�
 * ע�⣬���һ��������ͬ�˶������ľ�����ͬ���ģ�������Ϊ�ԳƵġ�
 *  
 * @author wqx
 *
 */
public class SymmetricalTree {
    boolean isSymmetrical(TreeNode pRoot)
    {
        if(pRoot == null)return true;
        return isSame(pRoot.left,pRoot.right);
    }
    boolean isSame(TreeNode left,TreeNode right){
    	if(left == null ){
    		return right == null;
    	}
    	if(right == null)
    		return false;
    	if(left.val == right.val){
    		return isSame(left.right,right.left) && isSame(left.left,right.right);
    	}else{
    		return false;
    	}
    }
}
