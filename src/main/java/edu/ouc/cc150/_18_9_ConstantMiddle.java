package edu.ouc.cc150;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * ʵʱ��λ��
��Ŀ����

����һЩ������ɵ�����Ҫ�������δ��룬�����һ����Ч�㷨������ÿ�δ���һ�����ֺ������ǰ���д������ֵ���λ����
(��������ż��������������λ��Ϊ��n/2С�����֣�nΪ�Ѵ������ָ���)��

����һ��int����A��Ϊ������������У�ͬʱ�������д�Сn���뷵��һ��int���飬����ÿ�δ�������λ����
��֤nС�ڵ���1000��

����������
[1,2,3,4,5,6],6

���أ�[1,1,2,2,3,3]



 * @author wqx
 *
 */
public class _18_9_ConstantMiddle {

	/**
	 * ˼·һ��ÿ�δ���һ��������в������򣬶��������н�������λ������
	 * 
	 * ʱ�临�Ӷȣ�����n������ÿ�ζ���Ҫ���ҵ�ǰ���ָò����λ�ã�����ʱ�临�Ӷ�O(N*N)
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
     * ˼·����
     * ��ĿҪ������ֻ��Ҫ�����λ������˼·һ������������������У���ʵ����ֻ��Ҫ�����������Ϊ���ѣ�
     * Ҫ��һ�ѵ�������������һ�ѵ����е�������һ���е���Сֵ������һ���е����ֵ��
     * 
     * ����뵽�˶ѵ�Ӧ�ã����ǿ��Թ��������ѣ�һ��С����heapMin��һ���󶥶�heapMax��
     * ����heapMin�ĶѶ�Ԫ��Ҫʼ�մ���heapMax�ĶѶ�Ԫ�ء�
     * 
     * ���ݽṹѡ��PriorityQueue
     * 
     * ʱ�临�Ӷȣ�ÿ�ζѵ���ʱ�临�Ӷȣ�O(logN)����������ʱ�临�Ӷ�O(N*logN)
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
    		//�������ѽ���ʵʱ����
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
