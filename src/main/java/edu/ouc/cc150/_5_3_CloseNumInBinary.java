package edu.ouc.cc150;

/**
 * ��ӽ�����
 * 
��Ŀ����

��һ�������������ҳ�������Ʊ�ʾ��1�ĸ�����ͬ���Ҵ�С��ӽ�������������(һ���Դ�һ����С)

����������int x���뷵��һ��vector�������������������С����ǰ������֤�𰸴��ڡ�
����������

2

���أ�[1,4]


 * @author wqx
 *
 */
public class _5_3_CloseNumInBinary {

	/**
	 * ˼·�����ڸ�������n��
	 * 
	 * c0:���Ҳ���β����0�ĸ���
	 * c1::���Ҳ�0���������1�ĸ���
	 * p�����Ҳ࣬����β��0��λ��
	 * 
	 * ����n=10,�����ƣ�1010
	 * c0=1,c1=1,p=2;
	 * 
	 * 
	 * @param c
	 * @return
	 */
    public int[] getCloseNumber(int x) {
    	int[] res = new int[2];
    	res[0] = getNextMin(x);
    	res[1] = getNextMax(x);
    	return res;
    }
    public int getNextMax(int x){
    	int c0 = 0,c1 = 0,p = 0;
    	int c = x;
    	while((c & 1) == 0 && c != 0){
    		c0++;
    		c >>= 1;
    	}
    	while((c & 1) == 1){
    		c1++;
    		c >>=1;
    	}
    	p = c0 + c1;
    	//pλ����Ϊ1
    	x |= (1 << p);
    	//p�ұ�ȫ����Ϊ0
    	x &= ~((1 << p) - 1);
    	//p�ҷ�����c1-1��1
    	x |= (1 << (c1-1)) - 1;
    	return x;
    }
    public int getNextMin(int x){
    	int c0 = 0,c1 = 0,p = 0;
    	int c = x;
    	//c1����β1�ĸ���
    	while((c & 1) == 1 && c != 0){
    		c1++;
    		c >>= 1;
    	}
    	//c0��������β1���������0�ĸ���
    	while((c & 1) == 0){
    		c0++;
    		c >>=1;
    	}
    	
    	p = c0 + c1;
    	//pλ���Լ��ұ�ȫ����Ϊ0
    	x &= (~0) << (p + 1);
    	
    	//p�����c1+1��1
    	x |= ((1 << (c1 + 1)) - 1) << (c0 - 1);
    	
    	return x;
    }
	public static void main(String[] args) {
		int[] arr = new _5_3_CloseNumInBinary().getCloseNumber(2);
		System.out.println(arr[0] + "," + arr[1]);
	}

}
