package edu.ouc.offer;

import java.util.Arrays;

/**
 * 
��Ŀ����
����һ���������飬ʵ��һ�����������������������ֵ�˳��
ʹ�����е�����λ�������ǰ�벿�֣����е�ż��λ��λ������ĺ�벿�֣�
����֤������������ż����ż��֮������λ�ò��䡣

 * @author wqx
 *
 */
public class SwapOddAndEven {
	public static void main(String args[]){
		int [] arr = {1,2,3,4,5,6,7};
		reOrderArray(arr);
		System.out.println(Arrays.toString(arr));
	}
    public static void reOrderArray(int [] array) {
    	int oddNum = 0;
    	//ͳ����������
    	for(int i = 0; i < array.length; i++){
    		if(array[i] % 2 == 1)
    			oddNum++;
    	}
    	int nums[] = new int[array.length];
    	int oddIndex = 0,evenIndex = oddNum;
    	for(int i = 0 ; i < array.length; i++){
    		if(array[i] % 2 == 0){
    			nums[evenIndex++] = array[i];
    		}else{
    			nums[oddIndex++] = array[i];
    		}
    	}
    	for(int i = 0; i < array.length;i++){
    		array[i] = nums[i];
    	}
//    	int low = oddNum-1,high = array.length-1;
//    	while(low >= 0 && high >= oddNum){
//    		while(low >= 0 && array[low]%2 == 1)low--;
//    		while(high >= oddNum && array[high]%2 == 0)high--;
//    		if(low >= 0){
//    			int tmp = array[low];
//    			array[low] = array[high];
//    			array[high] = tmp;
//    		}
//    	}
    }
}
