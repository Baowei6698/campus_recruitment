package edu.ouc.cc150;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 实时中位数
题目描述

现有一些随机生成的数字要将其依次传入，请设计一个高效算法，对于每次传入一个数字后，算出当前所有传入数字的中位数。
(若传入了偶数个数字则令中位数为第n/2小的数字，n为已传入数字个数)。

给定一个int数组A，为传入的数字序列，同时给定序列大小n，请返回一个int数组，代表每次传入后的中位数。
保证n小于等于1000。

测试样例：
[1,2,3,4,5,6],6

返回：[1,1,2,2,3,3]



 * @author wqx
 *
 */
public class _18_9_ConstantMiddle {

	/**
	 * 思路一：每次传入一个数后进行插入排序，对有序序列进行求中位数操作
	 * 
	 * 时间复杂度：传入n个数，每次都需要查找当前数字该插入的位置，所以时间复杂度O(N*N)
	 * 
	 * @param A
	 * @param n
	 * @return
	 */
    public int[] getMiddle(int[] A, int n) {
    	int[] result = new int[n];
    	result[0] = A[0];
    	int[] orderList = new int[n];
    	orderList[0] = A[0];
    	for(int i = 1; i < n; i++){
    		orderList[i] = A[i];
    		if(A[i] < orderList[i-1]){
    			int tmp = A[i];
    			int j = i-1;
    			for(; j >= 0 && tmp < orderList[j]; j--){
    				orderList[j+1] = orderList[j]; 
    			}
    			orderList[j+1] = tmp;
    		}
    		result[i] = orderList[i/2];
    	}
    	System.out.println(Arrays.toString(orderList));
    	return result;
    }
    /**
     * 思路二：
     * 题目要求我们只需要求出中位数，而思路一中求出了整个有序序列，其实我们只需要将传入的数分为两堆，
     * 要求一堆的所有数大于另一堆的所有的数。即一堆中的最小值大于另一堆中的最大值。
     * 
     * 这就想到了堆的应用，我们可以构造两个堆，一个小顶堆heapMin，一个大顶堆heapMax。
     * 其中heapMin的堆顶元素要始终大于heapMax的堆顶元素。
     * 
     * 数据结构选择PriorityQueue
     * 
     * 时间复杂度：每次堆调整时间复杂度：O(logN)，所以整体时间复杂度O(N*logN)
     * 
     * @param A
     * @param n
     * @return
     */
    public int[] getMiddleII(int[] A, int n) {
    	int[] result = new int[n];
    	result[0] = A[0];
    	PriorityQueue<Integer> heapMin = new PriorityQueue<>(n);
    	PriorityQueue<Integer> heapMax = new PriorityQueue<>(n,new Comparator<Integer>(){
			@Override
			public int compare(Integer o1, Integer o2) {
				return o2.compareTo(o1);
			}
    	});
    	for(int i = 0; i < n; i++){
    		if(i % 2 == 0){
    			heapMax.offer(A[i]);
    		}else{
    			heapMin.offer(A[i]);
    		}
    		//堆两个堆进行实时调整
    		if(!heapMin.isEmpty() && !heapMax.isEmpty()){
    			if(heapMin.peek() < heapMax.peek()){
    				int a = heapMin.poll();
    				int b = heapMax.poll();
    				heapMin.offer(b);heapMax.offer(a);
    			}
    		}
    		result[i] = !heapMax.isEmpty() ? heapMax.peek() : heapMin.peek();
    	}
    	System.out.println(Arrays.toString(result));
    	return result;
    }
	public static void main(String[] args) {
		int[] A = {1,2,3,4,5,6};
		int n = 6;
		System.out.println(Arrays.toString(new _18_9_ConstantMiddle().getMiddleII(A, n)));
	}

}
