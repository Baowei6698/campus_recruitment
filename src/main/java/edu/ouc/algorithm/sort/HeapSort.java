package edu.ouc.algorithm.sort;

import java.util.Arrays;

/**
 * ������
 * @author wqx
 *
 */
public class HeapSort {
	public void adjustHeap(int arr[],int s,int m){
		//����arr[s...m]֮��Ĺؼ�������Ѷ��壬�����󶥶�
		int j,tmp;
		tmp = arr[s];
		for(j = 2*s+1; j <= m; j = 2*j+1){
			//jΪi�����ӣ��Ƚ����Һ��ӣ�ѡ������·��
			if(j < m && arr[j] < arr[j+1])j++;
			if(arr[j] > tmp){//���ӱȸ��ڵ����Ҫ����
				arr[s] = arr[j];
				s = j;
			}else{
				break;
			}
		}
		arr[s] = tmp;
	}
	public void heapSort(int arr[],int n){
		for(int i = n/2-1; i >= 0; i--){//�����󶥶�
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
		System.out.print("����ǰ:\t");
		heap.printAll(array);
		heap.heapSort(array,array.length);
		System.out.print("�����:\t");
		heap.printAll(array);
	}
}
