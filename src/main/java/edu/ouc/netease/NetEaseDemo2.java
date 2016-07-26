package edu.ouc.netease;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class NetEaseDemo2 {
	public static void main(String args[]){
		Scanner in = new Scanner(System.in);
		String line1,line2;
		
		while(in.hasNext()){
			line1 = in.nextLine();
			line2 = in.nextLine();
			String[] strs1 = line1.split(" ");
			String[] strs2 = line1.split(" ");
			int [] arr1 = new int[strs1.length];
			int [] arr2 = new int[strs2.length];
			
			Map<Integer,Integer> maps = new HashMap<Integer,Integer>();
			for(int i = 0; i < arr2.length; i++){
				maps.put(arr2[i],1);
			}
			for(int i = 0; i < arr1.length; i++){
				if(maps.get(arr1[i]) == null){
					System.out.print(arr1[i] + " ");
				}
			}
		}
	}
}
