package edu.ouc.cc150;

import java.util.Arrays;

/**
 * ��Ŀ����

���޺���һ����������Ϸ����Ϸ��һ����Ҫվ����һ���˵ļ���ϡ�ͬʱ����Ӧ����������˱�������˸���һ�㡣
��֪�μ���Ϸ��ÿ���˵���ߣ����д�������ͨ��ѡ�������Ϸ���ˣ����Ƕ��ܵ����ٸ��ˡ�
ע��������˶����Ⱥ󵽵ģ���ζ�Ųμ���Ϸ���˵��Ⱥ�˳����ԭ�����е�˳��Ӧ��һ�¡�

����һ��int����men��������������ÿ���˵���ߡ�ͬʱ����������n���뷵������ܵ�����������֤nС�ڵ���500��
����������

[1,6,2,5,3,4],6

���أ�4

 * @author wqx
 *
 */
public class _11_7_LIS {
	
	/**
	 * ˼·��LIS��������������
	 * 
	 * @param men
	 * @param n
	 * @return
	 */
    public int getHeight(int[] men, int n) {
    	int[] f = new int[n];
    	f[0] = 1;//f[i] = j:��men[i]Ԫ�ؽ�β�������������
    	int max = f[0];
    	for(int i = 1; i < n; i++){
    		f[i] = 1;
    		for(int j = 0; j < i; j++){
    			if(men[j] < men[i] && f[j] + 1 > f[i]){
    				f[i] = f[j] + 1;
    				if(f[i] > max){
    					max = f[i];
    				}
    			}
    		}
    	}
    	return max;
    }
	public void LIS(int[] L)
	{
		int n = L.length;
		int[] f = new int[n];//���ڴ��f(i)ֵ��
		f[0]=1;//�Ե�a1ΪĩԪ�ص�����������г���Ϊ1��
		for(int i = 1; i < n; i++)//ѭ��n-1��
		{
			f[i] = 1;//f[i]����СֵΪ1��
			for(int j = 0; j < i; j++)//ѭ��i��
			{
				if(L[j] < L[i] && f[j] + 1 > f[i])
					f[i]=f[j]+1;//����f[i]��ֵ��
			}
		}
	}
	public static void main(String[] args) {
		int[] arr = {1,6,2,5,3,2};
		System.out.println(new _11_7_LIS().getHeight(arr, 6));
	}

}
