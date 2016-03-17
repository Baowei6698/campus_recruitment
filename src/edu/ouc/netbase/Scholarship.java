package edu.ouc.netbase;

import java.util.Scanner;

/**
 * 
 * 考虑int型可能溢出
 * 
 * @author wqx
 *
 */
public class Scholarship {
	public static void main(String []args){
		Scanner s = new Scanner(System.in);
		while(s.hasNext()){
			int n = s.nextInt();
			int r = s.nextInt();
			int avg = s.nextInt();
			long reviewTime = 0;
			int[][] tab = new int[n][2];
			boolean [] flags = new boolean[n];
			long gap = avg * n;
			for(int i = 0; i < n; i++){
				tab[i][0] = s.nextInt();
				tab[i][1] = s.nextInt();
				gap -= tab[i][0];
			}
			while(gap > 0){
				int index = selectMin(tab,n,flags);
				if(r - tab[index][0] >= gap){
					reviewTime += gap*tab[index][1];
					break;
				}else{
					reviewTime += (r-tab[index][0])*tab[index][1];
					gap -= (r-tab[index][0]);
				}
				//System.out.println("gap:" + gap);
			}
			System.out.println(reviewTime);
		}
	}
	public static int selectMin(int arr[][],int n,boolean[] flags){
		int result = 0;
		for(int i = 0; i < n; i++){
			if(!flags[i]){
				result = i;
				break;
			}
		}
		for(int i = 0; i < n; i++){
			if(arr[result][1] > arr[i][1] && !flags[i]){
				result = i;
			}
		}
		flags[result] = true;
		return result;
	}
}
