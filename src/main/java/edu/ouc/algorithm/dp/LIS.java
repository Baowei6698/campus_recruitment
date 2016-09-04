package edu.ouc.algorithm.dp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Stack;

/**
 * 最大递增子序列
 * 
 * @author wqx
 *
 */
public class LIS {
	/**
	 * 求出最大递增子序列长度，并打印出序列包含的值
	 * 
	 * @param arr
	 * @param n
	 * @return
	 */
	public List<Integer> LIS(int arr[], int n){
		List<Integer> res = new ArrayList<>(0);
		int f[] = new int[n];
		int index[] = new int[n+1];
		int maxIndex = 1;
		f[0] = 1;
		for(int i = 1; i < n; i++){
			for(int j = 0; j < i; j++){
				if(arr[j] < arr[i] && f[i] < f[j] + 1){
					f[i] = f[j] + 1;
					index[i+1] = j+1;
					if(f[maxIndex-1] < f[i]){
						maxIndex = i+1;
					}
				}
			}
		}
		Stack<Integer> stack = new Stack<>();
		while(maxIndex > 0){
			stack.push(arr[maxIndex-1]);
			maxIndex = index[maxIndex];
		}
		while(!stack.isEmpty()){
			res.add(stack.pop());
		}
		return res;
	}
	public static void main(String[] args) {
		int [] arr = {1,5,8,2,3,2};
		int n = 6;
		List<Integer> res = new LIS().LIS(arr, n);
		for(Integer i : res){
			System.out.print(i + " ");
		}
	}

}
