package edu.ouc.cc150;

import java.util.Arrays;
import java.util.Stack;

/**
 * 题目描述
现在我们有一个int数组，请你找出数组中每个元素的下一个比它大的元素。

给定一个int数组A及数组的大小n，请返回一个int数组，代表每个元素比他大的下一个元素,若不存在则为-1。
保证数组中元素均为正整数。

测试样例：

[11,13,10,5,12,21,3],7

返回：[13,21,12,12,21,-1,-1]

 * @author wqx
 *
 */
public class _18_NextElement {
	
	/**
	 * 思路：
	 * 数据arr=[11,13,10,5,12,21,3]
	 * 构造一个栈stack，栈中存放的是一个递减序列，栈顶最小。初始值stack.push(11);
	 * 令next = 13，如果next > stack.peek(),那么栈顶元素右侧比它大的值就是next了。
	 * 将栈顶元素出栈，如栈不为空，next和下一个栈顶元素做同样比较，直到栈空，或next < stack.peek().
	 * 将next压栈，进行下一个循环。
	 * 
	 * 为了方便，栈中存放元素索引，初始化栈：stack.push(0)，
	 * 
	 * 
	 * @param A
	 * @param n
	 * @return
	 */
    public int[] findNext(int[] A, int n) {
    	Stack<Integer> stack = new Stack<Integer>();
    	int[] res = new int[n];
    	stack.push(0);
    	int top,next;
    	for(int i = 1; i < n; i++){
    		next = A[i];
    		top = A[stack.peek()];
    		while(!stack.isEmpty() && next > top){
    			res[stack.pop()] = next;
    			if(!stack.isEmpty())
    				top = A[stack.peek()];
    		}
    		stack.push(i);
    	}
    	while(!stack.isEmpty()){
    		res[stack.pop()] = -1;
    	}
    	System.out.println(Arrays.toString(res));
    	return res;
    }
    
	public static void main(String[] args) {
		int[] A = {11,13,10,5,12,21,3};
		int n = 7;
		new _18_NextElement().findNext(A, n);
	}

}
