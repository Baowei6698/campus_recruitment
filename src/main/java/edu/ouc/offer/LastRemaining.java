package edu.ouc.offer;

import java.util.Arrays;

/**
 * ÿ����һ��ͯ��,NowCoder����׼��һЩС����ȥ�����¶�Ժ��С����,����������ˡ�
 * HF��ΪNowCoder������Ԫ��,��ȻҲ׼����һЩС��Ϸ��
 * ����,�и���Ϸ��������:
 * 	     ����,��С������Χ��һ����Ȧ��Ȼ��,�����ָ��һ����m,�ñ��Ϊ0��С���ѿ�ʼ������
 * ÿ�κ���m���Ǹ�С����Ҫ���г��׸�,Ȼ���������Ʒ�����������ѡ����,���Ҳ��ٻص�Ȧ��,
 * ��������һ��С���ѿ�ʼ,����0...m-1����....������ȥ....ֱ��ʣ�����һ��С����,���Բ��ñ���,
 * �����õ�NowCoder����ġ�����̽���ϡ���ذ�(��������Ŷ!!^_^)��������������,�ĸ�С���ѻ�õ������Ʒ�أ� 
 * 
 * 
 * @author wqx
 *
 */
public class LastRemaining {
	/**
	 * ��Ŀ����˼�����������Ӽ���ʼ��
	 * ��1��ʼ����������m���С��������һ��ͬѧ��ţ���Ŵ�0��n-1
	 * 
	 * @param n
	 * @param m
	 * @return
	 */
	public static int LastRemaining_Solution(int n, int m) {
		if(n <= 0 || m <= 0) return -1;
		int arr[] = new int[n];
		int remain = n;
		int count = 0,i = 0;

		while(remain != 1){
			if(arr[i] != 1){
				count++;
				if(count == m){
					arr[i] = 1;
					count=0;
					remain--;
				}
			}
			i = (i+1)%n;
		}
		for(i = 0; i < n; i++){
			if(arr[i] == 0){
				return i;
			}
		}
		return -1;
	}
	public static void main(String args[]){
		System.out.println("result:" + LastRemaining_Solution(5,3));
	}
}
