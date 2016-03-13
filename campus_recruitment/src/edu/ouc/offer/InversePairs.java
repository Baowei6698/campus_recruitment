package edu.ouc.offer;


/**
 * 
题目描述
在数组中的两个数字，如果前面一个数字大于后面的数字，则这两个数字组成一个逆序对。
输入一个数组，求出这个数组中的逆序对的总数。

 * @author wqx
 *
 */
public class InversePairs {
	/**
	 * 利用归并排序过程中，局部有序特性，减少比较次数
	 * 时间复杂度O（nlogn）
	 * 
	 * @param array
	 * @return
	 */
	private int total;
    public int InversePairs(int [] array) {
    	mergeSort(array,0,array.length-1);
    	return total;
    }
	public void mergeSort(int nums[],int low,int high){
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
	
	public void merge(int nums[],int low,int mid,int high){
		int [] tmp = new int[high-low+1];
		int i = low,j = mid+1,k = 0;
		
		while(i <= mid && j <= high){
			if(nums[i]  > nums[j] ){
				tmp[k] = nums[i];
				total += (high-j+1);
				k++;i++;
			}else {
				tmp[k++] = nums[j++];
			}
		}
		while(i <= mid){
			tmp[k++] = nums[i++];
		}
		while(j <= high){
			tmp[k++] = nums[j++];
		}
		//新的有序数组覆盖旧数组
		for(int p = 0; p < tmp.length; p++){
			nums[low+p] = tmp[p];
		}
	}
}
