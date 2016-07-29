package edu.ouc.algorithm.sort;

import java.util.Arrays;

/**
 * 直接插入排序
 * 算法思想：将一个记录插入到一个已经排好序的有序表中，从而得到一个新的、记录数+1的有序表。
 * 
 * 时间复杂度：O(n^2)
 * 空间复杂度：O(1)
 * 稳定的排序算法
 * @author Administrator
 *
 */
public class InsertSort {
	public static void main(String []args){
		int arr[] = {49,38,65,97,76,13,27,49};
		InsertSort(arr);
		Arrays.sort(arr);
		System.out.println(Arrays.toString(arr));
	}
	public static void InsertSort(int arr[]){
		int len = arr.length;
		int i,j,tmp;
		for(i = 1; i < len; i++){
			if(arr[i] < arr[i-1]){
				System.out.println("arr[i]:" + arr[i]);
				tmp = arr[i];
				for(j = i-1; j >= 0 && tmp < arr[j] ; j--){
					arr[j+1] = arr[j];
				}
				arr[j+1] = tmp;
			}
		}
	}
}
