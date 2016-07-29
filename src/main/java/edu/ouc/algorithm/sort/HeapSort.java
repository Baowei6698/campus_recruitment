package edu.ouc.algorithm.sort;

import java.util.Arrays;

/**
 * 堆排序
 * @author wqx
 *
 */
public class HeapSort {
	public void adjustHeap(int arr[],int s,int m){
		//调整arr[s...m]之间的关键字满足堆定义，构建大顶堆
		int j,tmp;
		tmp = arr[s];
		for(j = 2*s+1; j <= m; j = 2*j+1){
			//j为i的左孩子，比较左右孩子，选择最大的路径
			if(j < m && arr[j] < arr[j+1])j++;
			if(arr[j] > tmp){//孩子比父节点大，需要调整
				arr[s] = arr[j];
				s = j;
			}else{
				break;
			}
		}
		arr[s] = tmp;
	}
	public void heapSort(int arr[],int n){
		for(int i = n/2-1; i >= 0; i--){//构建大顶堆
			adjustHeap(arr,i,n-1);
		}
		swap(arr,0,n-1);
		for(int i = 0; i < n-1; i++){
			adjustHeap(arr,0,n-i-2);
			swap(arr,0,n-i-2);
		}
	}
	public void swap(int[]arr,int a,int b){
		int t = arr[a];
		arr[a] = arr[b];
		arr[b] = t;
	}
	public void printAll(int[] list) {
		System.out.println(Arrays.toString(list));
	}
	public static void main(String[] args) {
		int[] array = { 9, 1, 2, 5, 7, 4};
		HeapSort heap = new HeapSort();
		System.out.print("排序前:\t");
		heap.printAll(array);
		heap.heapSort(array,array.length);
		System.out.print("排序后:\t");
		heap.printAll(array);
	}
}
