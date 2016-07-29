package edu.ouc.algorithm.sort;

import java.util.Arrays;

/**
 * �鲢����
 * �����������ϲ���һ�������
 * 
 * ʱ�临�Ӷ�O(nlogn),�ռ临�Ӷ�O(n)
 * �ȶ�����
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
     * �ݹ鷽ʽ
     * @param nums
     * @param low
     * @param high
     */
	public static void mergeSort(int nums[],int low,int high){
		int mid = (low+high)/2;
		if(low < high){
			// ����
			mergeSort(nums,low,mid);
			//�Ұ��
			mergeSort(nums,mid+1,high);
			//����������������ϲ�
			merge(nums,low,mid,high);
		}
	}
	/**
	 * �ǵݹ鷽ʽ
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
