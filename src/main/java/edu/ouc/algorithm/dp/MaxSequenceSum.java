package edu.ouc.algorithm.dp;

/**
 * 最大子序列和
 * 
 * 如：比如{5,-3,4,2}的最大子序列就是 {5,-3,4,2}，它的和是8
 * {5,-6,4,2}的最大子序列是{4,2}，它的和是6
 * 
 * @author wqx
 *
 */
public class MaxSequenceSum {
	
	/**
	 * 当前数组和curSum < 0的话，令curSum = 0
	 * 
	 * begin+1和end记录最大序列和的开头和结尾
	 * 
	 * @param arr
	 * @param n
	 * @return
	 */
	public long maxSeqSum(int arr[], int n){
		
		long curSum = 0, maxSum = 0;
		int begin = -1, end = 0;
		for(int i = 0; i < n; i++){
			curSum += arr[i];
			if(curSum < 0){
				curSum = 0;
				begin = i;
			}
			if(curSum > maxSum){
				maxSum = curSum;
				end = i;
			}
		}
		System.out.println("maxSum:" + maxSum + ",begin:" + begin + ",end:" + end);
		for(int i = begin+1; i <= end; i++){
			System.out.print(arr[i] + " ");
		}
		return maxSum;
	}
	public static void main(String[] args) {
		int arr[] = {-1,2,4,2};
		int n = 4;
		new MaxSequenceSum().maxSeqSum(arr, n);
	}

}
