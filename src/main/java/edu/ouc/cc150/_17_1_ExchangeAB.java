package edu.ouc.cc150;

/**
 * 
��Ŀ����

���дһ�������������ڲ�ʹ���κ���ʱ������ֱ�ӽ�����������ֵ��

����һ��int����AB��������Ԫ�غ͵�һ��Ԫ��Ϊ��������ֵ���뷵�ؽ���������顣
����������

[1,2]

���أ�[2,1]


 * @author wqx
 *
 */
public class _17_1_ExchangeAB {
	
	/**
	 * ˼·������������
	 * 
	 * @param AB
	 * @return
	 */
    public int[] exchangeAB(int[] AB) {
    	AB[0] = AB[0] ^ AB[1];
    	AB[1] = AB[0] ^ AB[1];
    	AB[0] = AB[0] ^ AB[1];
    	return AB;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
