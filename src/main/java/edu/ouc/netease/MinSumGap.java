package edu.ouc.netease;

import java.util.Arrays;

/**
 * 题目描述
       任意2n个整数，从其中选出n个整数，使得选出的n个整数和同剩下的n个整数之和的差最小。\

 * @author wqx
 *
 */
public class MinSumGap {
	public static int minGap(int[]arr){
		int [] visited = new int[arr.length];
		int sum = 0;
		for(int i = 0; i < arr.length; i++){
			sum += arr[i];
		}
		Arrays.sort(arr);
		int sum1 = 0;
		for(int i = 0; i < arr.length/2; i++){
			sum1 += arr[i];
		}
		return sum1-(sum-sum1);
	}
	public static void main(String args[]){
		int arr[] = {1,3,2,7,5,8};
		System.out.println("minGap:" + minGap(arr));
	}
}
