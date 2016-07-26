package edu.ouc.cc150;

import java.util.Arrays;

/**
 * 题目描述

给定两个字符串，请编写程序，确定其中一个字符串的字符重新排列后，能否变成另一个字符串。这里规定大小写为不同字符，且考虑字符串重点空格。

给定一个string stringA和一个string stringB，请返回一个bool，代表两串是否重新排列后可相同。保证两串的长度都小于等于5000。
测试样例：

"This is nowcoder","is This nowcoder"

返回：true

"Here you are","Are you here"

返回：false

 * @author wqx
 *
 */
public class checkSamString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}
	/**
	 * 方法一：将两字符串转为字节数组，重排序，再判是否相等
	 * 
	 * 时间复杂度O(nlogn)
	 * 
	 * @param stringA
	 * @param stringB
	 * @return
	 */
    public boolean checkSam(String stringA, String stringB) {
        
        int lenA = stringA.length();
        int lenB = stringB.length();
        if(lenA != lenB) return false;
        
        byte[] byteA = stringA.getBytes();
        byte[] byteB = stringB.getBytes();
        
        Arrays.sort(byteA);
        Arrays.sort(byteB);
        
        for(int i = 0; i < lenA; i++){
        	if(byteA[i] != byteB[i]){
        		return false;
        	}
        }
        return true;
    }
    
    /**
     * 方法二：比较两字符串中每个字符出现的次数，如果都相同，则一定可以重排序得到对方。
     * 时间复杂度O(n)
     * 空间复杂度O(1)
     * 
     * @param stringA
     * @param stringB
     * @return
     */
    public boolean checkSam2(String stringA, String stringB) {
        int lenA = stringA.length();
        int lenB = stringB.length();
        if(lenA != lenB) return false;
        
        int[] a = new int[256];
        int[] b = new int[256];
        
        for(int i = 0; i < lenA; i++){
        	a[stringA.charAt(i)]++;
        }
        for(int i = 0; i < lenB; i++){
        	b[stringB.charAt(i)]++;
        }
        for(int i = 0; i < 256; i++){
        	if(b[i] != a[i]){
        		return false;
        	}
        }
        return true;
    }
}
