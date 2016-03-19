package edu.ouc.offer;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

/**
 * ��Ŀ����
����һ���ַ���,���ֵ����ӡ�����ַ������ַ����������С����������ַ���abc,
���ӡ�����ַ�a,b,c�������г����������ַ���abc,acb,bac,bca,cab��cba�� 
����밴��ĸ˳�������

��������:

����һ���ַ���,���Ȳ�����9(�������ַ��ظ�),�ַ�ֻ������Сд��ĸ��

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
	 * step1�����������ҵ���һ���ƻ�����(���ϸ�)��Ԫ�أ�������Ϊ4.���±�Ϊ i

       step2: ��Ȼ��������,�ҵ���һ������4��Ԫ�أ�������5������4��5.
	
       step3����i+1�����Ҷˣ����á�6 4 3 2 to 2 3 4 6
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
