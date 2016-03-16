package edu.ouc.offer;

/**
 * 
题目描述
一个整型数组里除了两个数字之外，其他的数字都出现了两次。请写程序找出这两个只出现一次的数字。

 * @author wqx
 *
 */
public class FindNumsAppearOnce {
	/**
	 * num1,num2分别为长度为1的数组。传出参数
	 * 将num1[0],num2[0]设置为返回结果
	 * 
	 * 1.全部元素进行异或运算，得到的结果result为两个只出现一次的数（n1,n2）的异或结果（其它出现两次的数异或为0）
	 * 2.找出result二进制表示中为1的位置pos（异或为1，表示n1和n2在这个位置上bit不相同）
	 * 3.按pos位置上是1还是0进行划分，然后对两组数分别进行异或，结果就是n1，和n2
	 * 
	 * @param array
	 * @param num1
	 * @param num2
	 */
    public void FindNumsAppearOnce(int [] array,int num1[] , int num2[]) {
        if(array.length < 2) return;
        int result = 0;
        for(int i = 0; i < array.length; i++){
        	result ^= array[i];
        }
        int pos = 0;
        while((result & 1) == 0){
        	result >>>= 1;
        	pos++;
        }
        num1[0] = num2[0] = 0;
        for(int i = 0; i < array.length; i++){
        	if(isPositive(array[i],pos)){
        		num1[0] ^= array[i];
        	}else{
        		num2[0] ^= array[i];
        	}
        }
    }
    /**
     * 判断数字num的pos位置上是1还是0
     * 
     * @param num
     * @param pos
     * @return
     */
    public boolean isPositive(int num,int pos){
    	num >>>= pos;
    	return (num & 1) == 1;
    }
}
