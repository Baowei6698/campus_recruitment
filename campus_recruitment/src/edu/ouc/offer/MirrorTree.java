package edu.ouc.offer;

/**
 * ��Ŀ����
���������Ķ�����������任ΪԴ�������ľ���
��������:

�������ľ����壺Դ������ 
    	    8
    	   /  \
    	  6   10
    	 / \  / \
    	5  7 9 11
    	���������
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
	 * ��������������
	 * 
	 * @param root
	 */
    public void Mirror(TreeNode root) {
        root = createTree(root);
    }
    public TreeNode createTree(TreeNode root){
    	if(root == null) return root;
    	//�ݴ�root������������
    	TreeNode node = root.left;
    	root.left = createTree(root.right);
    	root.right = createTree(node);
    	return root;
    }
}
