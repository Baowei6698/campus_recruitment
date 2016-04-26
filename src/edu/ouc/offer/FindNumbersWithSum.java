package edu.ouc.offer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 
题目描述
输入一个递增排序的数组和一个数字S，在数组中查找两个数，使得他们的和正好是S，
如果有多对数字的和等于S，输出两个数的乘积最小的。

输出描述:
对应每个测试案例，输出两个数，小的先输出。

 * @author wqx
 *
 */
public class FindNumbersWithSum {
	public static ArrayList<Integer> FindNumbersWithSum(int [] array,int sum) {
        ArrayList<Integer> result = new ArrayList<Integer>(0);
        int len = array.length;
        int min = Integer.MAX_VALUE,a = 0,b = 0;
        boolean flag = false;
        for(int i = 0; i < len; i++){
        	int index = Arrays.binarySearch(array,i,len,sum-array[i]);
        	if(index > -1){
        		System.out.println("index:" + index);
        		if(a * b < min){
        			flag = true;
        			min = a*b;
            		a = array[i];
            		b = sum-array[i];
        		}
        	}
        }
        if(flag){
        	result.add(a);
        	result.add(b);
        }
        return result;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = {1,2,4,7,11,15};
		int sum = 15;
		List<Integer> list = FindNumbersWithSum(arr,sum);
		for(int i = 0; i < list.size(); i++){
			System.out.print(list.get(i) + ",");
		}
	}

}
