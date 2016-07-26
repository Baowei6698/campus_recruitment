package edu.ouc.offer;

import java.util.Arrays;

/**
 * 
题目描述
输入一个整数数组，实现一个函数来调整该数组中数字的顺序，
使得所有的奇数位于数组的前半部分，所有的偶数位于位于数组的后半部分，
并保证奇数和奇数，偶数和偶数之间的相对位置不变。

 * @author wqx
 *
 */
public class SwapOddAndEven {
	public static void main(String args[]){
		int [] arr = {1,2,3,4,5,6,7};
		reOrderArray(arr);
		System.out.println(Arrays.toString(arr));
	}
    public static void reOrderArray(int [] array) {
    	int oddNum = 0;
    	//统计奇数个数
    	for(int i = 0; i < array.length; i++){
    		if(array[i] % 2 == 1)
    			oddNum++;
    	}
    	int nums[] = new int[array.length];
    	int oddIndex = 0,evenIndex = oddNum;
    	for(int i = 0 ; i < array.length; i++){
    		if(array[i] % 2 == 0){
    			nums[evenIndex++] = array[i];
    		}else{
    			nums[oddIndex++] = array[i];
    		}
    	}
    	for(int i = 0; i < array.length;i++){
    		array[i] = nums[i];
    	}
//    	int low = oddNum-1,high = array.length-1;
//    	while(low >= 0 && high >= oddNum){
//    		while(low >= 0 && array[low]%2 == 1)low--;
//    		while(high >= oddNum && array[high]%2 == 0)high--;
//    		if(low >= 0){
//    			int tmp = array[low];
//    			array[low] = array[high];
//    			array[high] = tmp;
//    		}
//    	}
    }
}
