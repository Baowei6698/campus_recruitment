package edu.ouc.offer;

import java.util.Stack;

/**
 * 
��Ŀ����
������ջ��ʵ��һ�����У���ɶ��е�Push��Pop������ �����е�Ԫ��Ϊint���͡�

���룺
["PSH1","PSH2","PSH3","POP","POP","PSH4","POP","PSH5","POP","POP"]
�����
1,2,3,4,5

 * @author wqx
 *
 */
public class ImplementQueueBy2Stack {
	Stack<Integer> stack1 = new Stack<Integer>();
	Stack<Integer> stack2 = new Stack<Integer>();
	/**
	 * 
	 * @param node
	 */
	public void push(int node) {
		stack1.push(node);
	}

	public Integer pop() {
		if(!stack2.isEmpty()) return stack2.pop();
		
		while(!stack1.isEmpty()){
			stack2.push(stack1.pop());
		}
		return stack2.pop();
	}
}
