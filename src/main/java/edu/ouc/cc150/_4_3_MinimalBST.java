package edu.ouc.cc150;

/**
 * 高度最小的BST
 * 
题目描述

对于一个元素各不相同且按升序排列的有序序列，请编写一个算法，创建一棵高度最小的二叉查找树。

给定一个有序序列int[] vals,请返回创建的二叉查找树的高度。


 * @author wqx
 *
 */
public class _4_3_MinimalBST {
	
	/**
	 * 完全二叉树 直接公式计算：log2(vals.length) + 1
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
