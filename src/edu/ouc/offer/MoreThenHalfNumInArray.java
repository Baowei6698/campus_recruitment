package edu.ouc.offer;

/**
 * 
题目描述
数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。
例如输入一个长度为9的数组{1,2,3,2,2,2,5,4,2}。由于数字2在数组中出现了5次，
超过数组长度的一半，因此输出2。如果不存在则输出0。

 * @author wqx
 *
 */
public class MoreThenHalfNumInArray {
    public int MoreThanHalfNum_Solution(int [] array) {
        int k = 0,j = 0;
        for(int i = 0; i < array.length; i++){
        	if(j == 0){
        		k = array[i];
        	}
        	if(array[i] == k){
        		j++;
        	}else{
        		j--;
        	}
        }
        int counts = 0;
        for(int i = 0; i < array.length; i++){
        	if(k == array[i]){
        		counts++;
        	}
        }
        if(counts > array.length/2){
        	return k;
        }else{
        	return 0;
        }
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
