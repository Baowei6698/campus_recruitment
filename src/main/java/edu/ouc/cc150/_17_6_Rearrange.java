package edu.ouc.cc150;

import java.util.Arrays;

/**
 * 最小调整有序

题目描述

有一个整数数组，请编写一个函数，找出索引m和n，只要将m和n之间的元素排好序，整个数组就是有序的。
注意：n-m应该越小越好，也就是说，找出符合条件的最短序列。

给定一个int数组A和数组的大小n，请返回一个二元组，代表所求序列的起点和终点。
(原序列位置从0开始标号,若原序列有序，返回[0,0])。保证A中元素均为正整数。
测试样例：

[1,4,6,5,9,10],6

返回：[2,3]

 * @author wqx
 *
 */
public class _17_6_Rearrange {

	/**
	 * 思路：可用逆序对来解决，分别求出数组的逆序对数组，
	 * reverse[i]=j：arr[i]的右边比arr[i]小的数的个数
	 * 
	 * @param A
	 * @param n
	 * @return
	 */
	public int[] findSegment(int[] A, int n) {
		int N = 0, M = 0;
		int max = A[0];
		for(int i = 1; i < n; i++){
			if(A[i] >= max){
				max = A[i];
			}else{
				N = i;
			}
		}
		int min = A[n-1];
		for(int i = n-2; i >= 0; i--){
			if(A[i] <= min){
				min = A[i];
			}else{
				M = i;
			}
		}
		int[] res = new int[2];
		res[0] = M;res[1] = N;
		return res;
	}
	public static void main(String[] args) {
		int[] A = {1,2,3,3,8,9};
		int n = 6;
		int res [] = new _17_6_Rearrange().findSegment(A, n);
		System.out.println(res[0] + "," + res[1]);
	}

}
