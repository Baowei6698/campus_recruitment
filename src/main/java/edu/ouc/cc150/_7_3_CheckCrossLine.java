package edu.ouc.cc150;

import java.math.BigDecimal;

/**
 * �ж�ֱ���ཻ
 * 
��Ŀ����

����ֱ������ϵ�ϵ�����ֱ�ߣ�ȷ��������ֱ�߻᲻���ཻ��

�߶���б�ʺͽؾ����ʽ��������double s1��double s2��double y1��double y2��
�ֱ����ֱ��1��2��б��(��s1,s2)�ͽؾ�(��y1,y2)���뷵��һ��bool���������������ֱ���Ƿ��ཻ��������ֱ���غ�Ҳ��Ϊ�ཻ��
����������

3.14,1,3.14,2

���أ�false



 * @author wqx
 *
 */
public class _7_3_CheckCrossLine {
	
	/**
	 * y = kx + c
	 * 
	 * @param s1
	 * @param s2
	 * @param y1
	 * @param y2
	 * @return
	 */
    public boolean checkCrossLine(double s1, double s2, double y1, double y2) {
        if(s1 == s2 && Math.abs(y1-y2) <= 0.00000001){
        	return false;
        }
        return true;
    }
	public static void main(String[] args) {
		BigDecimal dec = null;
	}

}
