package edu.ouc.cc150;

/**
 * �����Ʋ���
 * 
 * ��Ŀ����

������32λ����n��m�����д�㷨��m�Ķ�������λ���뵽n�Ķ����Ƶĵ�j����iλ,���ж����Ƶ�λ���ӵ�λ������λ����0��ʼ��

����������int n��int m��ͬʱ����int j��int i�����������������뷵�ز������������֤n�ĵ�j����iλ��Ϊ�㣬
��m�Ķ�����λ��С�ڵ���i-j+1��
����������

1024��19��2��6

���أ�1100

 * @author wqx
 *
 */
public class _5_1_BinaryInsert {

    public int binInsert(int n, int m, int j, int i) {
    	int multi = (int)Math.pow(2, j);
    	return n | (m * multi);
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
