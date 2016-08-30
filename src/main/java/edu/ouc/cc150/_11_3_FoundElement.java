package edu.ouc.cc150;

/**
 * 
题目描述

有一个排过序的数组，包含n个整数，但是这个数组向左进行了一定长度的移位，例如，原数组为[1,2,3,4,5,6]，
向左移位5个位置即变成了[6,1,2,3,4,5],现在对于移位后的数组，需要查找某个元素的位置。
请设计一个复杂度为log级别的算法完成这个任务。

给定一个int数组A，为移位后的数组，同时给定数组大小n和需要查找的元素的值x，请返回x的位置(位置从零开始)。
保证数组中元素互异。

测试样例：

[6,1,2,3,4,5],6,6

返回：0

 * @author wqx
 *
 */
public class _11_3_FoundElement {

	/**
	 * 思路：
	 * 移位前可以通过二分查找实现logn级别时间复杂度
	 * 
	 * 
	 * @param A
	 * @param n
	 * @param x
	 * @return
	 */
    public static int findElement(int[] A, int n, int x) {
    	int left,right;
    	left = 0;right = n-1;
    	while(left <= right){
    		int mid = (left + right) / 2;
    		if(x == A[mid])
    			return mid;
    		else if(x < A[mid]){//x未必一定在left-mid直接，可能在mid右边
    			if(A[mid] > A[left] && x < A[left] ){
    				left = mid + 1;
    			}else{
    				right = mid - 1;    				
    			}
    		}else{
    			if(A[mid] < A[right] && x > A[right]){
    				right = mid - 1;    				
    			}else{
    				left = mid + 1;
    			}
    		}
    	}
    	return -1;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {43,44,45,46,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30,31,32,33,34,35,36,37,38,39,40,41,42};
		System.out.println(findElement(arr, 46, 5));
	}

}
