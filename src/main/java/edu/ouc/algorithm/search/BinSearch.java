package edu.ouc.algorithm.search;

import java.util.Arrays;

public class BinSearch {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = {13, 27, 38, 49, 49, 65, 76, 97};
		int key = 45;
		int pos = binSearch(arr,key);
		if(pos != -1)
			System.out.println("pos:" + pos + ",arr[pos]:" + arr[pos]);
		else{
			System.out.println("not found");
		}
	}
	public static int binSearch(int arr[],int key){
		int low = 0,high = arr.length-1,mid;
		while(low <= high){
			mid = (low+high)/2;
			if(arr[mid] == key) return mid;
			else if(arr[mid] < key) low = mid+1;
			else high = mid-1;
		}
		return -1;
	}
}
