package edu.ouc.cc150;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 题目描述
有一组单词，请编写一个程序，在数组中找出由数组中字符串组成的最长的串A，
即A是由其它单词组成的(可重复)最长的单词。

给定一个string数组str，同时给定数组的大小n。请返回最长单词的长度，保证题意所述的最长单词存在。
测试样例：

["a","b","c","ab","bc","abc"],6

返回：3

 * @author wqx
 *
 */
public class _18_7_LongestString {

	/**
	 * 思路：找出A，A由数组中其它字符拼接而成（可重复）。
	 * 1.将数组中字符串按长度递减排序。
	 * 2.遍历每个元素，假如当前元素s，从s后一个元素开始，找到一个str，使得s.startWith(str) == true
	 * 3.得到字符串sub,sub为s除去str的后半部
	 * 4.对sub重复2,3操作。
	 * 5.当sub为空字符串时，则代表成功找到目标元素了。
	 * 
	 * 其实本质上就是一个递归查找的过程
	 * 
	 * @param str
	 * @param n
	 * @return
	 */
	public int getLongest(String[] str, int n) {

		Arrays.sort(str,new Comparator<String>(){
			public int compare(String o1, String o2) {
				return o2.length() - o1.length();
			}
		});
		for(int i = 0; i < n; i++){
			if(dfs(str,str[i],i,n-1)){
				return str[i].length();
			}
		}
		return -1;
	}
	public boolean dfs(String[] str,String s,int start, int end){
		if("".equals(s)){
			return true;
		}
		boolean res = false;
		for(int i = start+1; i <= end; i++){
			if(s.startsWith(str[i])){
				res = dfs(str,s.substring(str[i].length()),start,end);
				if(res)return true;
			}
		}
		return res;
	}
	public static void main(String[] args) {
		String[] str = {"rb","erb","rbe","e","g","mcxr"};
		int n = 6;
		System.out.println("res:" + new _18_7_LongestString().getLongest(str, n));
	}

}
