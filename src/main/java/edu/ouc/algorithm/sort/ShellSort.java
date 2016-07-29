package edu.ouc.algorithm.sort;

import java.util.Arrays;

public class ShellSort {
	public void shellSort(int[] arr,int n) {
		int i,j,gap;

		for(gap = n/2; gap >= 1; gap/=2 ){
			for(i = gap;i < n; i++){
				for(j = i - gap; j >= 0 && arr[j] > arr[j+gap] ; j-=gap){
					swap(arr,j,j+gap);
				}
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
		ShellSort shell = new ShellSort();
		System.out.print("≈≈–Ú«∞:\t");
		shell.printAll(array);
		shell.shellSort(array,array.length);
		System.out.print("≈≈–Ú∫Û:\t");
		shell.printAll(array);
	}
}
