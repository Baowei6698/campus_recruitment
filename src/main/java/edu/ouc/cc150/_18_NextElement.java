package edu.ouc.cc150;

import java.util.Arrays;
import java.util.Stack;

/**
 * ��Ŀ����
����������һ��int���飬�����ҳ�������ÿ��Ԫ�ص���һ���������Ԫ�ء�

����һ��int����A������Ĵ�Сn���뷵��һ��int���飬����ÿ��Ԫ�ر��������һ��Ԫ��,����������Ϊ-1��
��֤������Ԫ�ؾ�Ϊ��������

����������

[11,13,10,5,12,21,3],7

���أ�[13,21,12,12,21,-1,-1]

 * @author wqx
 *
 */
public class _18_NextElement {
	
	/**
	 * ˼·��
	 * ����arr=[11,13,10,5,12,21,3]
	 * ����һ��ջstack��ջ�д�ŵ���һ���ݼ����У�ջ����С����ʼֵstack.push(11);
	 * ��next = 13�����next > stack.peek(),��ôջ��Ԫ���Ҳ�������ֵ����next�ˡ�
	 * ��ջ��Ԫ�س�ջ����ջ��Ϊ�գ�next����һ��ջ��Ԫ����ͬ���Ƚϣ�ֱ��ջ�գ���next < stack.peek().
	 * ��nextѹջ��������һ��ѭ����
	 * 
	 * Ϊ�˷��㣬ջ�д��Ԫ����������ʼ��ջ��stack.push(0)��
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
