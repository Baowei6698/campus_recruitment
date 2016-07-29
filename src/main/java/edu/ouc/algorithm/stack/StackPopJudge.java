package edu.ouc.algorithm.stack;

import java.util.Scanner;
import java.util.Stack;

/**
 * 
6
123
132
213
231
312
321
 * @author Administrator
 *
 */
public class StackPopJudge {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String src = "123";
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		while(in.hasNext()){
			String s = in.next();
			if(judge(src,s)){
				System.out.println("YES");
			}else{
				System.out.println("NO");
			}
		}
	}
	static boolean judge(String s1,String s2){
		if(s1 == null || s2 == null)return false;
		if(s1.length() != s2.length()) return false;
		Stack<Character> s = new Stack<>();
		for(int i = 0,j = 0; i < s1.length() ; i++){
			s.push(s1.charAt(i));
			while(!s.isEmpty() && s.peek() == s2.charAt(j)){
				s.pop();
				j++;
			}
		}
		if(!s.isEmpty()){
			return false;
		}
		return true;
	}
}
