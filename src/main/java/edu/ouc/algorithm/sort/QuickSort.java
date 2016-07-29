package edu.ouc.algorithm.sort;

public class QuickSort {

	private static int partition(int array[], int low, int high) {
		int key = array[low];
		while(low < high){
			while(low < high && array[high] >= key){
				high--;
			}
			array[low] = array[high];

			while(low < high && array[low] <= key){
				low++;
			}
			array[high] = array[low];
		}
		array[low] = key;
		return low;
	}
	private static void quick_sort(int[] nums,int low,int high){
		if(low < high){
			int pivot = partition(nums,low,high);
			quick_sort(nums,low,pivot-1);
			quick_sort(nums,pivot+1,high);
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int nums[] = {4,4,1,7,1,5};
		quick_sort(nums,0,nums.length-1);
		for(int i = 0; i < nums.length; i++){
			System.out.print(nums[i] + ",");
		}
	}

}
