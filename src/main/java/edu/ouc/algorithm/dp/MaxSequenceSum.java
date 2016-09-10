package edu.ouc.algorithm.dp;

/**
 * ��������к�
 * 
 * �磺����{5,-3,4,2}����������о��� {5,-3,4,2}�����ĺ���8
 * {5,-6,4,2}�������������{4,2}�����ĺ���6
 * 
 * @author wqx
 *
 */
public class MaxSequenceSum {
	
	/**
	 * ��ǰ�����curSum < 0�Ļ�����curSum = 0
	 * 
	 * begin+1��end��¼������к͵Ŀ�ͷ�ͽ�β
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
