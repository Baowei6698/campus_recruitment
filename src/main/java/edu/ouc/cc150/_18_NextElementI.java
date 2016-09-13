package edu.ouc.cc150;

import java.util.Arrays;
import java.util.Stack;

/**
��Ŀ����

������һ�����飬���ҳ�������ÿ��Ԫ�صĺ�����������С��Ԫ�أ�����������Ϊ-1��

����һ��int����A������Ĵ�Сn���뷵��ÿ��Ԫ�������ֵ��ɵ����顣��֤A��Ԫ��Ϊ����������nС�ڵ���1000��
����������

[11,13,10,5,12,21,3],7

[12,21,12,12,21,-1,-1]



 * @author wqx
 *
 */
public class _18_NextElementI {
	
	/**
	 * ʱ�临�Ӷȣ�O(N*N)
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
