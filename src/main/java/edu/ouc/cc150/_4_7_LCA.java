package edu.ouc.cc150;

/**
 * �����������
 * 
��Ŀ����

��һ���������������������㰴�����һ��һ��ش����������α�ţ��������Ϊ1���������������a��b�������һ���㷨��
���a��b�������������ȵı�š�

��������int a,b��Ϊ�������ı�š��뷵��a��b������������ȵı�š�ע�������㱾��Ҳ����Ϊ�������ȡ�
����������

2��3

���أ�1

 * @author wqx
 *
 */
public class _4_7_LCA {

	/**
	 * ������ȫ���������ʣ�parentId = childId/2;
	 * 
	 * @param a
	 * @param b
	 * @return
	 */
    public static int getLCA(int a, int b) {
    	if(a > b){
    		a = a + b;
    		b = a - b;
    		a = a - b;
    	}
    	while(true){
    		if(a == b)
    			return a;
    		
    		if( a < b){
    			b /= 2;
    			continue;
    		}
    		if(a > b){
    			a /= 2;
    			continue;
    		}
    	}
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(getLCA(5,8));
	}

}
