package edu.ouc.cc150;

import java.util.Arrays;
import java.util.concurrent.CountDownLatch;

/**
 * 
��Ŀ����

Լɪ��������һ��������Ȥ�⡣�������������޸�һ�¹�����n����վ��һ�С�����ͷ��β�����Ǳ�ţ�
��һ���˱��Ϊ1��Ȼ���ͷ��ʼ��������һ�����α�1��2��1��2...Ȼ�󱨵�2���˳��֡�
���ŵڶ����ٴ���һ�����һ���������˿�ʼ���α�1��2��3��1��2��3...����2��3���˳��֡�
�Դ�����ֱ��ʣ���Ժ�һ���ˡ�������Ҫ��ļ�������˵ı�š�

����һ��int n��������Ϸ���������뷵�����һ���˵ı��
����������

5

���أ�5

 * @author wqx
 *
 */
public class _10_2_JosephII {

	/**
	 * ˼·һ��
	 * ��������ʵ�֣�����JosephI�İ취��m�ǿɱ�ġ�
	 * 1. ÿ�ζ�����һ�����һ����ʼ����������Ҫ��¼��һ�����һ���������˵�λ�ã���Ϊlast����ʼֵΪ0��
	 * 2. ÿ�ֽ����ı�־����
	 * 
	 * @param n
	 * @return
	 */
	
	public static int getResult(int n) {
		int arr[] = new int[n];
		int remain = n;
		int step = 1, i = 0;
		int gap = 2;
		int stopPos = 0 , last = 0;
		while(remain > 1){
			i = last;
			step = 1;
			do{
				if(arr[i] == 0 && step == gap){
					arr[i] = 1;
					step = 1;
				}else if(arr[i] == 0){
					if(step != 1){
						arr[i] = 1;
					}else{
						last = i;//��¼���һ����������
					}
					step++;
				}
				i = nextStep(i,n);
			}while(i != stopPos);//һ�ֱ����Ƿ����
			stopPos = lastStep(last,n);//��һ��ֹͣλ�ã���һ�����һ���������˵�ǰһ��λ��
			remain = clearVisited(arr);
			gap++;
		}

		for(i = 0; i < n; i++){
			if(arr[i] == 0)
				return i+1;
		}
		return 0;
	}
	/**
	 * �������������,����ʣ������
	 */
	public static int clearVisited(int arr[]){
		int remain = 0;
		for(int i = 0; i < arr.length; i++){
			if(arr[i] == 1){
				arr[i] = -1;
			}else if(arr[i] == 0){
				remain++;
			}
		}
		return remain;
	}
	public static int nextStep(int i, int n){
		return (i+1) % n;
	}
	public static int lastStep(int i, int n){
		return (i+n-1) % n;
	}
	public static void main(String[] args) {
		int n = 5;
		System.out.println(getResult(n));
	}

}
