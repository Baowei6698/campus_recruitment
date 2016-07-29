package edu.ouc.algorithm.dp;

public class MaxAdjacentDifferNumber {
	public static void differNumber(int nums[]){
		int len = nums.length;
		int min = nums[0],max = nums[0];
		for(int i = 1; i < len; i++){
			if(min > nums[i]){
				min = nums[i];
			}
			if(max < nums[i]){
				max = nums[i];
			}
		}
		int gap = (max-min)/len;
	}
}
