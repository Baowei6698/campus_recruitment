package edu.ouc.cc150;

/**
 * �׳�β��
 * 
��Ŀ����

�����һ���㷨������n�Ľ׳��ж��ٸ�β���㡣

����һ��int n���뷵��n�Ľ׳˵�β���������֤nΪ��������
����������

5

���أ�1

 * @author wqx
 *
 */
public class _17_3_Factor {

	/**
	 * �ܵ�0�Ľ��ֻ��2*5������5�ĸ�������
	 * 
	 * @param n
	 * @return
	 */
    public int getFactorSuffixZero(int n) {
    	
    	int count = 0;
    	for(int i = 5; n/i > 0; i *= 5)
    		count += n/i;
    	return count;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
