package edu.ouc.cc150;

/**
 * 
题目描述

有一个排过序的字符串数组，但是其中有插入了一些空字符串，请设计一个算法，找出给定字符串的位置。
算法的查找部分的复杂度应该为log级别。

给定一个string数组str,同时给定数组大小n和需要查找的string x，请返回该串的位置(位置从零开始)。
测试样例：

["a","b","","c","","d"],6,"c"

返回：3


 * @author wqx
 *
 */
public class _11_5_FindString {

	/**
	 * 思路：
	 * 		同样是二分查找加条件限制,如果str[mid]是空字符串
	 * 
	 * @param str
	 * @param n
	 * @param x
	 * @return
	 */
    public static int findString(String[] str, int n, String x) {
    	int left = 0, right = n-1;
    	int mid = 0;
    	while(left <= right){
    		mid = findPos(str,n,left,right,x);
    		if(str[mid].equals(x)){
    			return mid;
    		}else if(str[mid].compareTo(x) < 0){
    			left = mid + 1;
    		}else{
    			right = mid - 1;    			
    		}
    	}
    	return -1;
    }
    /**
     * 找到mid，使得A[mid]不为空字符串
     * 
     * @param str
     * @param n
     * @param left
     * @param right
     * @param x
     * @return
     */
    public static int findPos(String [] str, int n, int left , int right, String x){
    	int mid = (left + right) / 2;
    	int i = mid;
    	while(i <= right && str[i].equals("")) i++;
    	if(i <= right && str[i].compareTo(x) <= 0)
    		return i;
    	i = mid;
    	while(i >= left && str[i].equals(""))i--;
    	if(i >= left && str[i].compareTo(x) >= 0)
    		return i;
    	return 0;
    }
	public static void main(String[] args) {
		String[] str = {"","","CFWW","JUNMFCVE","KBVPO","LLQHRIN","P","RDDK","UFEYPGVKFO"};
		int n = 9; 
		String x = "RDDK";
		System.out.println(findString(str,n,x));
	}

}
