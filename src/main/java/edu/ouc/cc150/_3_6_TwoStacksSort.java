package edu.ouc.cc150;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Stack;


/**
 * 双栈排序
题目描述

请编写一个程序，按升序对栈进行排序（即最大元素位于栈顶），要求最多只能使用一个额外的栈存放临时数据，
但不得将元素复制到别的数据结构中。

给定一个int[] numbers(C++中为vector&ltint>)，其中第一个元素为栈顶，请返回排序后的栈。
请注意这是一个栈，意味着排序过程中你只能访问到第一个元素。
测试样例：

[1,2,3,4,5]

返回：[5,4,3,2,1]


 * @author wqx
 *
 */
public class _3_6_TwoStacksSort {
	
	/**
	 * 思路：
	 * 选择排序的过程：
	 * 1.将栈s1元素前n个数移动到s2中，这个过程中记录最小值min，将min压入s1栈底
	 * 2.n--;重复1操作
	 * 
	 * @param numbers
	 * @return
	 */
    public static ArrayList<Integer> twoStacksSort(int[] numbers) {
    	ArrayList<Integer> res = new ArrayList<Integer>();
    	
    	Stack<Integer> s1 = new Stack<Integer>();
    	Stack<Integer> s2 = new Stack<Integer>();
    	
    	for(int i = 0; i < numbers.length; i++){
    		s1.push(numbers[i]);
    	}
    	int len = numbers.length;
    	while(len > 0){
    		//找到最值
    		int min = s1.pop();
    		int i = 1;
    		while(i++ < len){
    			if(min > s1.peek()){
    				s2.push(min);
    				min = s1.pop();
    			}else{
    				s2.push(s1.pop());    				
    			}
    		}
    		//最小值压入栈底
    		s1.push(min);
    		//s2转回到s1
    		while(!s2.isEmpty()){
    			s1.push(s2.pop());
    		}
    		len--;
    	}
    	while(!s1.isEmpty()){
    		res.add(s1.pop());
    	}
    	return res;
    }	
	public static void main(String args[]){
		int arr[] = {54695,46580,6418,52304,5595,5149,51943,11454,23596,6444,61037,94146,50220,98642,97292,57898,11745,7286,31224,5160,41550,25277,59350,53353,68663,9642,30406,5396,3222,67194,7124,54247,15077,97688,36939,62888,80307,65467,6882,97071,39652,38268,88226,89088,92198,39003,9858,73803,83078,24648,49891,34551,57649,24443,30685,68740,55407,53155,87465,89282,41856,96218,37292,24551,67663,31715,46363,25573,61921,56333,69576,55919,19818,26409,21590,70392,67648,36909,89175,74443,41856,11755,24788,25975,25116,57360,80998,62093,40691,91189,29337,68914,57653,64272,53653,5975,27967,59600,25803,13937,93725,26457,16603,18360,79926,63243,94958,45131};
		List<Integer> list = twoStacksSort(arr);
		System.out.println(Arrays.toString(list.toArray()));
		Integer[] arr2 = {1,2,3,4,5};
		Set<List<Integer>> set = new HashSet<List<Integer>>();
		set.add(Arrays.asList(arr2));
		
		System.out.println(set.size());
	}
}
