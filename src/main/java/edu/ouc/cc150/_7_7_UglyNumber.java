package edu.ouc.cc150;

/**
 * 
��Ŀ����

��һЩ����������ֻ��3��5��7�������һ���㷨���ҳ����еĵ�k������

����һ����int k���뷵�ص�k��������֤kС�ڵ���100��
����������

3

���أ�7


 * @author wqx
 *
 */
public class _7_7_UglyNumber {

	/**
	 * ˼·��
	 * �����ڳ������㷨��ֻ�ǰ�������2,3,5����3,5,7�ˡ���������һ��һ����
	 * 
	 * �����ǰk��������������k+1��������
	 * 
	 * ����Ҫ�����ֻ����3,5,7���ӣ���ô��K+1����һ����ǰK�����е�ĳһ����3,5��7����
	 * ����Ҫ��ľ��ǵ�������һ�������Լ�������3,5����7����
	 * 
	 * @param k
	 * @return
	 */
	public int findKth(int k){
		int num[] = new int[k+2];
		num[0] = 0;
		num[1] = 1;
		int three = 0,five = 0,seven = 0;//�պô�������������������
		
		for(int i = 1; i <= k; i++){//ÿ���ҳ�һ������
			
			for(int j = 1; j <= i ; j++)
				if((3*num[j-1] <= num[i]) && (3*num[j] > num[i])) three=num[j] * 3;
			
			for(int j = 1; j <= i ; j++)
				if((5*num[j-1] <= num[i]) && (5*num[j] > num[i])) five=num[j] * 5;
			
			for(int j = 1; j <= i ; j++)
				if((7*num[j-1] <= num[i]) && (7*num[j] > num[i])) seven=num[j] * 7;
			
			//�Ƚϳ�����������С��
			System.out.println("three:" + three + ",five:" + five + "seven:" + seven);
			num[i+1] = Math.min(three, Math.min(five, seven));
		}
		return num[k+1];
	}
	public static void main(String[] args) {
		System.out.println(new _7_7_UglyNumber().findKth(3));
	}

}
