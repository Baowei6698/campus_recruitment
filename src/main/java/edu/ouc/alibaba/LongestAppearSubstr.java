package edu.ouc.alibaba;

import java.util.Scanner;

/**
 * 题目描述
给定一个 query 和一个 text,均由小写字母组成。要求在 text 中找出以同样的顺序连 续出现在 query 中的最长连续字母序列的长度。
例如, query 为“acbac”,text 为 “acaccbabb”,那么 text 中的“cba”为最长的连续出现在 query 中的字母序列,
因此, 返回结果应该为其长度 3。请注意程序效率。

 * @author wqx
 * 
 */
public class LongestAppearSubstr {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		String query,text;
		while(in.hasNext()){
			query = in.next();
			text = in.next();
			System.out.println("maxLength:" + maxLength(query,text));
		}
	}
	public static int maxLength(String query,String text){
		int maxLen = 0;
		boolean flag;
		
		for(int i = 0; i < query.length(); i++){
			flag = false;
			for(int j = query.length(); j > i; j--){
				String sub = query.substring(i,j);
				if(text.contains(sub)){//第一次找到，必定是以query[i]开头的字符串中最长的子串
					flag = true;
					maxLen = maxLen > sub.length() ? maxLen : sub.length();
				}
				if(flag){
					break;
				}
			}
		}
		return maxLen;
	}
}
