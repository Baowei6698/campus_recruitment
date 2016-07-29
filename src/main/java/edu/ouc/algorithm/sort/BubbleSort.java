package edu.ouc.algorithm.sort;

import java.util.Arrays;

public class BubbleSort {

	public static void BubbleSort(int arr[]){
		int tmp;
		int n = arr.length;
		boolean flag = false;
		for(int i = n-1; i >= 0; i--){
			for(int j = 0; j < i; j++){
				if(arr[j] > arr[j+1]){
					tmp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = tmp;
					flag = true;
				}
			}
			if(!flag)
				break;
			System.out.println(Arrays.toString(arr));
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr={5,6,1,3,2};
		BubbleSort(arr);
	}

}
