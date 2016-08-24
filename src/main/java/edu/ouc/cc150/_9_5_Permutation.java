package edu.ouc.cc150;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

/**
 * 题目描述

编写一个方法，确定某字符串的所有排列组合。

给定一个string A和一个int n,代表字符串和其长度，请返回所有该字符串字符的排列，
保证字符串长度小于等于11且字符串中字符均为大写英文字符，排列中的字符串按字典序从大到小排序。(不合并重复字符串)
测试样例：

"ABC"

返回：["CBA","CAB","BCA","BAC","ACB","ABC"]

 * @author wqx
 *
 */
public class _9_5_Permutation {

	/**
	 * 思路一：
	 * String next_Permutation(String A):求出字符串A代表的序列的下一个序列。
	 * 循环上面函数即可
	 * 
	 * 时间复杂度：O(n*n!)
	 * 
	 * TLE！！
	 * 
	 * @param A
	 * @return
	 */
    public static ArrayList<String> getPermutation(String A) {
    	ArrayList<String> res = new ArrayList<String>();
    	StringBuilder sb = new StringBuilder(A);
    	String reverse = sb.reverse().toString();
    	String next = nextPermutation(reverse);
    	res.add(reverse);
    	
    	while(true){
    		res.add(next);
    		if(A.equals(next))
    			break;
    		next = nextPermutation(next);
    	}
    	return res;
    }
    public static String nextPermutation(String A){
    	char[] chs = A.toCharArray();
    	int i = chs.length-2 , j = chs.length-1;
    	while(i > 0 && chs[i] <= chs[i+1])i--;
    	
    	while(j > 0 && chs[j] >= chs[i])j--;
    	
    	char tmp = chs[i];
    	chs[i] = chs[j];
    	chs[j] = tmp;
    	
    	i++;
    	j = chs.length-1;
    	while(i < j){
        	tmp = chs[i];
        	chs[i++] = chs[j];
        	chs[j--] = tmp;
    	}
    	return new String(chs);
    }
    /**
     * 思路二：
     * 递归求解
     * 
     * @param A
     * @return
     */
    public static ArrayList<String> getPermutation2(String A) {
        ArrayList<String> list = new ArrayList<>();
        permutation(list, A.toCharArray(), 0);
        Collections.sort(list, new Comparator<String>(){
			@Override
			public int compare(String o1, String o2) {
				return o2.compareTo(o1);
			}
        });
        return list;
    }
    public static void permutation(ArrayList<String> list, char[] arr, int pos){
    	if(pos == arr.length){
    		list.add(new String(arr));
    	}else{
    		for(int i = pos; i < arr.length; i++){
    			swap(arr,pos,i);
    			permutation(list,arr,pos+1);
    			swap(arr,pos,i);
    		}
    	}
    }
    public static void permutation2(ArrayList<String> list, char[] array, int k) {
        if(k == array.length) {
            list.add(new String(array));
            return ;
        }
        for(int i = k; i < array.length; i++) {
            swap(array, i, k);
            permutation(list, array, k + 1);
            swap(array, i, k);
        }
    }
     
    public static void swap(char[] array, int i, int j) {
        if(i != j) {
            char temp = array[i];
            array[i] = array[j];
            array[j] = temp;
        }
    }
    
	public static void main(String[] args) {
		String A = "ABCDE";
		long start = System.currentTimeMillis();
		System.out.println(getPermutation(A));
		System.out.println("time1:" + (System.currentTimeMillis() - start) + "");
		start  = System.currentTimeMillis();
		getPermutation2(A);
		System.out.println("time2:" + (System.currentTimeMillis() - start));
	}

}
