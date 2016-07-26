package edu.ouc.offer;

import java.util.Arrays;
import java.util.Comparator;

/**
 * ����һ�����������飬����������������ƴ�������ų�һ��������ӡ��ƴ�ӳ���������������С��һ����
 * ������������{3��32��321}�����ӡ���������������ųɵ���С����Ϊ321323�� 
 * 
 * @author wqx
 *
 */
public class MinNum {
    public String PrintMinNumber(int [] numbers) {
    	String[] str = new String[numbers.length];
    	for(int i = 0; i < numbers.length; i++){
    		str[i] = String.valueOf(numbers[i]);
    	}
    	Arrays.sort(str,new Comparator<String>(){
			@Override
			public int compare(String o1, String o2) {
				// TODO Auto-generated method stub
				if(o1.equals(o2)) return 0;
				
				if(o1.startsWith(o2)){
					for(int i = o2.length()-1; i < o1.length();i++){
						if(o1.charAt(i) > o2.charAt(0)){
							return 1;
						}
					}
					return -1;
				}
				if(o2.startsWith(o1)){
					for(int i = o1.length()-1; i < o2.length();i++){
						if(o2.charAt(i) > o1.charAt(0)){
							return -1;
						}
					}
					return 1;
				}
				return o1.compareTo(o2);
			}
    	});
    	StringBuilder sb = new StringBuilder();
    	for(int i = 0; i < numbers.length; i++){
    		sb.append(str[i]);
    	}
    	return sb.toString();
    }
    public static void main(String args[]){
    	MinNum c = new MinNum();
    	int nums[] = {3334,3,3333332};
    	System.out.println(c.PrintMinNumber(nums));
    }
}
