package edu.ouc.cc150;

/**
 * ����ת��
 * 
��Ŀ����

��дһ��������ȷ����Ҫ�ı伸��λ�����ܽ�����Aת�������B��

������������int A��int B���뷵����Ҫ�ı����λ������
����������

10,5

���أ�4


 * @author wqx
 *
 */
public class _5_5_BinaryDiff {

	/**
	 * ���������õ�res�� ͳ��res��1�ĸ���
	 * 
	 * @param A
	 * @param B
	 * @return
	 */
    public static int calcCost(int A, int B) {
    	int res = A ^ B;
    	int num = 0;
    	do{
    		if((res & 1) != 0){
    			num++;
    		}
    		res >>>= 1;
    	}while(res != 0);
    	return num;
    }
    
	public static void main(String[] args) {
		int A = 10,B = 5;
		System.out.println(calcCost(A,B));
	}

}
