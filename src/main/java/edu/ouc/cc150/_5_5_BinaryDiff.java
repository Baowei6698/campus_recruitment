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

    public static int calcCost(int A, int B) {
    	int res = 0;
    	do{
    		System.out.println("A:" + A + ",B:" + B);
    		if(A % 2 != B % 2)
    			res++;
    		if( A != 0)
    			A /= 2; 
    		if(B != 0)
    			B /= 2;
    	}while(A != 0 || B != 0);
    	
    	return res;
    }
    
	public static void main(String[] args) {
		int A = 10,B = 5;
		System.out.println(calcCost(A,B));
	}

}
