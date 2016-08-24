package edu.ouc.cc150;

import java.util.Stack;

/**
 * 题目描述

对于一个字符串，请设计一个算法，判断其是否为一个合法的括号串。

给定一个字符串A和它的长度n，请返回一个bool值代表它是否为一个合法的括号串。
测试样例：

"(()())",6

返回：true

测试样例：

"()a()()",7

返回：false

 * @author wqx
 *
 */
public class _9_6_CheckParenthesis {

	/**
	 * 利用Stack求解
	 * 
	 * @param A
	 * @param n
	 * @return
	 */
    public static boolean chkParenthesis(String A, int n) {
    	char [] chs = A.toCharArray();
    	Stack<Character> stack = new Stack<>();
    	
    	stack.push(chs[0]);
    	int i = 1;
    	while(i < chs.length){
    		if(chs[i] == '('){
    			stack.push('(');
    		}else if(chs[i] == ')'){
    			if(!stack.isEmpty() && stack.peek() == '('){
    				stack.pop();
    			}else{
    				return false;
    			}
    		}else{
    			return false;
    		}
    		i++;
    	}
    	if(!stack.isEmpty())return false;
    	return true;
    }
    
	public static void main(String[] args) {
		String A = "()()(((())))";
		System.out.println("res:" + chkParenthesis(A,12));
	}

}
