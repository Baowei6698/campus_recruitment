package edu.ouc.offer;

/**
 * ��1+2+3+...+n��Ҫ����ʹ�ó˳�����for��while��
 * if��else��switch��case�ȹؼ��ּ������ж���䣨A?B:C����
 * 
 *  
 * @author wqx
 *
 */
public class Sum {
	/**
	 * ɶѭ�������ã�ֻ�ܵݹ�ʵ���ˡ�����
	 * 
	 * @param n
	 * @return
	 */
    public int Sum_Solution(int n) {
    	if(n == 0)return 0;
    	if(n == 1) return 1;
       return n + Sum_Solution(n-1);
    }
}
