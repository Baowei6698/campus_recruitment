package edu.ouc.cc150;

/**
 * �߶���С��BST
 * 
��Ŀ����

����һ��Ԫ�ظ�����ͬ�Ұ��������е��������У����дһ���㷨������һ�ø߶���С�Ķ����������

����һ����������int[] vals,�뷵�ش����Ķ���������ĸ߶ȡ�


 * @author wqx
 *
 */
public class _4_3_MinimalBST {
	
	/**
	 * ��ȫ������ ֱ�ӹ�ʽ���㣺log2(vals.length) + 1
	 * @param vals
	 * @return
	 */
    public int buildMinimalBST(int[] vals) {
    	return (int)(Math.log(vals.length)/Math.log(2)) + 1;
    }
    
    public int buildMinimalBST2(int[] vals) {
    	int depth = 1;
    	int nums = 1;
    	int len = vals.length;
    	while(nums <= len){
    		depth ++;
    		nums += Math.pow(2, depth-1);
    	}
    	return depth;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
