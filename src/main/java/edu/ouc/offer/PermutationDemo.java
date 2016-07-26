package edu.ouc.offer;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

/**
 * 题目描述
输入一个字符串,按字典序打印出该字符串中字符的所有排列。例如输入字符串abc,
则打印出由字符a,b,c所能排列出来的所有字符串abc,acb,bac,bca,cab和cba。 
结果请按字母顺序输出。

输入描述:

输入一个字符串,长度不超过9(可能有字符重复),字符只包括大小写字母。

 * @author wqx
 *
 */
public class PermutationDemo {
	public ArrayList<String> Permutation(String str) {
		if(str == null || "".equals(str)) return new ArrayList<String>(0);
		Set<String> result = new TreeSet<String>();
		nextPermutation(result,str.toCharArray(),0);
		return new ArrayList<String>(result);
	}
	public void nextPermutation(Set<String> result,char[] str,int cur){
		if(cur == str.length){
			result.add(new String(str));
			return ;
		}
		for(int i = cur; i < str.length; i++){
			swap(str,i,cur);
			nextPermutation(result,str,cur+1);
			swap(str,i,cur);	
		}
	}
	public void swap(char[]str,int i,int j){
		if (i != j) {
			char t = str[i];
			str[i] = str[j];
			str[j] = t;
		}
	}
	/**
	 * step1：从右往左找到第一个破坏升序(非严格)的元素，此例中为4.记下标为 i

       step2: 依然从右往左,找到第一个大于4的元素，此例中5，交换4和5.
	
       step3：从i+1到最右端，逆置。6 4 3 2 to 2 3 4 6
	 * @param num
	 */
	void nextPermutation(int[]num) {		 
		if (num.length == 0) return;		 
		int i = num.length-1;		
		int j;		
		while(i>0 && num[i] <= num[i - 1]){
			i--;
		}
		if (i != 0){
			j = num.length - 1;
			while (num[j]<= num[i-1])	
				j--;					
			swap(num,i-1,j);		
		}//if
		j = num.length - 1;		
		while (i< j){			
			swap(num,i,j);	
			i++; j--;		 
		}	
	}	
	void swap(int[] num,int a, int b){		
		int c;
		c = num[a]; num[a] = num[b]; num[b] = c; 
	}
}
