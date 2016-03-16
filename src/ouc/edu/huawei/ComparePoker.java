package ouc.edu.huawei;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class ComparePoker {
	private List<String> table = Arrays.asList("3","4","5","6","7","8","9","10","J","Q","K","A","2");
	
	public static void main(String args[]){
		Scanner in = new Scanner(System.in);
		String input = in.nextLine();
		String left = input.substring(0,input.indexOf('-'));
		String right = input.substring(input.indexOf('-')+1);
		String[] left2 = left.split(" ");
		
		System.out.println("input:" + input);
		System.out.println("left2:" + Arrays.toString(left2));
	}
	public String compare(String a,String b){
		if(a.equals("joker JOKER"))
			return a;
		if(b.equals("joker JOKER"))
			return b;
		String[] left = a.split(" ");
		String[] right = b.split(" ");
		if(a.split(" ").length == 5){
			
		}
		return b;
	}
}
