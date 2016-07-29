package edu.ouc.algorithm.sort;

import java.util.Arrays;

public class SelectSort {
	public void selectSort(int arr[],int n){
		for(int i = 0; i < n; i++){
			int k = i;		//记录最小值的索引
			for(int j = i+1; j < n; j++){
				if(arr[j] < arr[k]){
					k = j;
				}
			}
			if(k != i){
				swap(arr,k,i);
			}
		}
	}
	public void swap(int arr[],int a,int b){
		int tmp = arr[a];
		arr[a] = arr[b];
		arr[b] = tmp;
	}
	public void printAll(int[] list) {
		System.out.println(Arrays.toString(list));
	}
	public static void main(String[] args) {
		int[] array = { 9, 1, 2, 5, 7, 4, 8, 6, 3, 5 };
		SelectSort select = new SelectSort();
		System.out.print("排序前:\t");
		select.printAll(array);
		select.selectSort(array,array.length);
		System.out.print("排序后:\t");
		select.printAll(array);
	}
}
