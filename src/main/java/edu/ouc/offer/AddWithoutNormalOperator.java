package edu.ouc.offer;


/**
 * дһ������������������֮�ͣ�Ҫ���ں������ڲ���ʹ��+��-��*��/����������š� 
 * 
 * @author wqx
 *
 */
public class AddWithoutNormalOperator {
	/**
	 * �����üӼ��˳�����λ����
	 * 
	 * @param num1
	 * @param num2
	 * @return
	 */
    public int Add(int num1,int num2) {
        int a,b;
        a = num1^num2;//a����num1��num2���Ľ��
        b = (num1&num2)<<1;//
        while((a&b) != 0){
        	num1 = a;
        	num2 = b;
            a = num1^num2;
            b = (num1&num2)<<1;//
        }
        return a|b;
    }
}
