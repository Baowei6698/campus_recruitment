package edu.ouc.algorithm.sort;

import java.util.Arrays;

/**
 * 归并排序
 * 将两个有序表合并成一个有序表
 * 
 * 时间复杂度O(nlogn),空间复杂度O(n)
 * 稳定排序
 * 
 * @author wqx
 *
 */
public class MergeSort {

    public static void main(String[] args) {  
  
        int[] nums = { 2, 7, 8, 3, 1, 6, 9, 0, 5, 4 };  
        mergeSort(nums, 0, nums.length-1);  
        System.out.println(Arrays.toString(nums));  
    }
    /**
     * 递归方式
     * @param nums
     * @param low
     * @param high
     */
	public static void mergeSort(int nums[],int low,int high){
		int mid = (low+high)/2;
		if(low < high){
			// 左半边
			mergeSort(nums,low,mid);
			//右半边
			mergeSort(nums,mid+1,high);
			//左右两边有序数组合并
			merge(nums,low,mid,high);
		}
	}
	/**
	 * 非递归方式
	 * @param nums
	 * @param low
	 * @param mid
	 * @param high
	 */
	
	public static void merge(int nums[],int low,int mid,int high){
		int [] tmp = new int[high-low+1];
		int i = low,j = mid+1,k = 0;
		
		while(i <= mid && j <= high){
			if(nums[i] < nums[j]){
				tmp[k++] = nums[i++];
			}else{
				tmp[k++] = nums[j++];
			}
		}
		while(i <= mid){
			tmp[k++] = nums[i++];
		}
		while(j <= high){
			tmp[k++] = nums[j++];
		}
		System.arraycopy(tmp, 0, nums, low, high-low+1);
	}
}
