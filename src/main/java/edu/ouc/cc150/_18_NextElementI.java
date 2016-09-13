package edu.ouc.cc150;

import java.util.Arrays;
import java.util.Stack;

/**
题目描述

现在有一个数组，请找出数组中每个元素的后面比它大的最小的元素，若不存在则为-1。

给定一个int数组A及数组的大小n，请返回每个元素所求的值组成的数组。保证A中元素为正整数，且n小于等于1000。
测试样例：

[11,13,10,5,12,21,3],7

[12,21,12,12,21,-1,-1]



 * @author wqx
 *
 */
public class _18_NextElementI {
	
	/**
	 * 时间复杂度：O(N*N)
	 *  
	 * @param A
	 * @param n
	 * @return
	 */
    public int[] findNext(int[] A, int n) {
    	int[] res = new int[n];
    	for(int i = 0; i < n; i++){
    		int min = Integer.MAX_VALUE;
    		for(int j = i+1; j < n; j++){
    			if(A[j] > A[i] && min > A[j]){
    				min = A[j];
    			}
    		}
    		res[i] = min == Integer.MAX_VALUE ? -1 : min;
    	}
    	System.out.println(Arrays.toString(res));
    	return res;
    }
    
	public static void main(String[] args) {
		int[] A = {11,13,10,5,12,21,3};
		int n = 7;
		new _18_NextElementI().findNext(A, n);
	}

}
