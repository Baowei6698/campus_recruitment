package edu.ouc.cc150;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Stack;


/**
 * ˫ջ����
��Ŀ����

���дһ�����򣬰������ջ�������򣨼����Ԫ��λ��ջ������Ҫ�����ֻ��ʹ��һ�������ջ�����ʱ���ݣ�
�����ý�Ԫ�ظ��Ƶ�������ݽṹ�С�

����һ��int[] numbers(C++��Ϊvector&ltint>)�����е�һ��Ԫ��Ϊջ�����뷵��������ջ��
��ע������һ��ջ����ζ�������������ֻ�ܷ��ʵ���һ��Ԫ�ء�
����������

[1,2,3,4,5]

���أ�[5,4,3,2,1]


 * @author wqx
 *
 */
public class _3_6_TwoStacksSort {
	
	/**
	 * ˼·��
	 * ѡ������Ĺ��̣�
	 * 1.��ջs1Ԫ��ǰn�����ƶ���s2�У���������м�¼��Сֵmin����minѹ��s1ջ��
	 * 2.n--;�ظ�1����
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
    		//�ҵ���ֵ
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
    		//��Сֵѹ��ջ��
    		s1.push(min);
    		//s2ת�ص�s1
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
