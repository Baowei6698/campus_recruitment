package edu.ouc.cc150;

import java.util.Arrays;

/**
 * 
��Ŀ����

��һ�������������������������飬��ǰ��һ�����ں���һ�����֣����������������һ������ԡ������һ����Ч���㷨��
������������е�����Ը�����

����һ��int����A�����Ĵ�Сn���뷵��A�е�����Ը�������֤nС�ڵ���5000��
����������

[1,2,3,4,5,6,7,0],8

���أ�7


 * @author wqx
 *
 */
public class _11_9_AntiOrderPair {

	/**
	 * �鲢���������ͳ������Եĸ��������ù鲢���ֲ̾����������
	 * �鲢�����ĳһ��״̬��
	 * [6,4,2] [5,3,1];
	 * 
	 * @param A
	 * @param n
	 * @return
	 */
    public int count(int[] A, int n) {
    	mergeSort(A, n, 0, n-1);
    	return sum;
    }
    private int sum = 0;
    public void mergeSort(int[] arr, int n ,int left, int right){
    	if(left < right){
    		int mid = (left + right) / 2;
    		mergeSort(arr, n, left, mid);
    		mergeSort(arr, n, mid+1, right);
    		merge(arr,n,left, mid, right);
    	}
    }
    public void merge(int arr[], int n, int left, int mid, int right){
    	int c[] = new int[right-left+1];
    	int i = left, j = mid+1;
    	int k = 0;
    	while(i <= mid && j <= right){
    		if(arr[i] > arr[j]){//arr[i]����arr[j]����ôarr[i]����arr[j]֮�������Ԫ��
    			c[k++] = arr[i++];
    			sum += (right - j + 1);
    		}else{
    			c[k++] = arr[j++];
    		}
    	}
    	while(i <= mid){
    		c[k++] = arr[i++];
    	}
    	while(j <= right){
    		c[k++] = arr[j++];
    	}
    	System.arraycopy(c, 0, arr, left, k);
    }
	public static void main(String[] args) {
		int[] arr = {4,3,6,1,2,5};
		int n = 6;
		_11_9_AntiOrderPair t = new _11_9_AntiOrderPair();
		t.mergeSort(arr, n, 0, n-1);
		System.out.println(Arrays.toString(arr) + ",sum:" + t.sum);
	}

}
