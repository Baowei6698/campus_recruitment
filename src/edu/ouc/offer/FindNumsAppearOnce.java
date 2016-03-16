package edu.ouc.offer;

/**
 * 
��Ŀ����
һ�����������������������֮�⣬���������ֶ����������Ρ���д�����ҳ�������ֻ����һ�ε����֡�

 * @author wqx
 *
 */
public class FindNumsAppearOnce {
	/**
	 * num1,num2�ֱ�Ϊ����Ϊ1�����顣��������
	 * ��num1[0],num2[0]����Ϊ���ؽ��
	 * 
	 * 1.ȫ��Ԫ�ؽ���������㣬�õ��Ľ��resultΪ����ֻ����һ�ε�����n1,n2����������������������ε������Ϊ0��
	 * 2.�ҳ�result�����Ʊ�ʾ��Ϊ1��λ��pos�����Ϊ1����ʾn1��n2�����λ����bit����ͬ��
	 * 3.��posλ������1����0���л��֣�Ȼ����������ֱ������򣬽������n1����n2
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
     * �ж�����num��posλ������1����0
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
