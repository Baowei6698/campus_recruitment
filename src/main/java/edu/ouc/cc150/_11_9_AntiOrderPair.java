package edu.ouc.cc150;

import java.util.Arrays;

/**
 * 
题目描述

有一组数，对于其中任意两个数组，若前面一个大于后面一个数字，则这两个数字组成一个逆序对。请设计一个高效的算法，
计算给定数组中的逆序对个数。

给定一个int数组A和它的大小n，请返回A中的逆序对个数。保证n小于等于5000。
测试样例：

[1,2,3,4,5,6,7,0],8

返回：7


 * @author wqx
 *
 */
public class _11_9_AntiOrderPair {

	/**
	 * 归并排序过程中统计逆序对的个数：利用归并过程局部有序的特性
	 * 归并排序的某一个状态：
	 * [6,4,2] [5,3,1];
	 * 
	 * @param A
	 * @param n
	 * @return
	 */
    public int count(int[] A, int n) {
    	mergeSort(A, n, 0, n-1);
    	return sum;
    }
    private int sum = 0;
    public void mergeSort(int[] arr, int n ,int left, int right){
    	if(left < right){
    		int mid = (left + right) / 2;
    		mergeSort(arr, n, left, mid);
    		mergeSort(arr, n, mid+1, right);
    		merge(arr,n,left, mid, right);
    	}
    }
    public void merge(int arr[], int n, int left, int mid, int right){
    	int c[] = new int[right-left+1];
    	int i = left, j = mid+1;
    	int k = 0;
    	while(i <= mid && j <= right){
    		if(arr[i] > arr[j]){//arr[i]大于arr[j]，那么arr[i]大于arr[j]之后的所有元素
    			c[k++] = arr[i++];
    			sum += (right - j + 1);
    		}else{
    			c[k++] = arr[j++];
    		}
    	}
    	while(i <= mid){
    		c[k++] = arr[i++];
    	}
    	while(j <= right){
    		c[k++] = arr[j++];
    	}
    	System.arraycopy(c, 0, arr, left, k);
    }
	public static void main(String[] args) {
		int[] arr = {4,3,6,1,2,5};
		int n = 6;
		_11_9_AntiOrderPair t = new _11_9_AntiOrderPair();
		t.mergeSort(arr, n, 0, n-1);
		System.out.println(Arrays.toString(arr) + ",sum:" + t.sum);
	}

}
