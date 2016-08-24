package edu.ouc.cc150;

import java.util.Stack;

/**
 * ��Ŀ����

����һ���ַ����������һ���㷨���ж����Ƿ�Ϊһ���Ϸ������Ŵ���

����һ���ַ���A�����ĳ���n���뷵��һ��boolֵ�������Ƿ�Ϊһ���Ϸ������Ŵ���
����������

"(()())",6

���أ�true

����������

"()a()()",7

���أ�false

 * @author wqx
 *
 */
public class _9_6_CheckParenthesis {

	/**
	 * ����Stack���
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
