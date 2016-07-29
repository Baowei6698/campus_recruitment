package edu.ouc.algorithm.sort;

import java.util.Arrays;

/**
 * ֱ�Ӳ�������
 * �㷨˼�룺��һ����¼���뵽һ���Ѿ��ź����������У��Ӷ��õ�һ���µġ���¼��+1�������
 * 
 * ʱ�临�Ӷȣ�O(n^2)
 * �ռ临�Ӷȣ�O(1)
 * �ȶ��������㷨
 * @author Administrator
 *
 */
public class InsertSort {
	public static void main(String []args){
		int arr[] = {49,38,65,97,76,13,27,49};
		InsertSort(arr);
		Arrays.sort(arr);
		System.out.println(Arrays.toString(arr));
	}
	public static void InsertSort(int arr[]){
		int len = arr.length;
		int i,j,tmp;
		for(i = 1; i < len; i++){
			if(arr[i] < arr[i-1]){
				System.out.println("arr[i]:" + arr[i]);
				tmp = arr[i];
				for(j = i-1; j >= 0 && tmp < arr[j] ; j--){
					arr[j+1] = arr[j];
				}
				arr[j+1] = tmp;
			}
		}
	}
}
