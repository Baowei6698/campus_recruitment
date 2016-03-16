package edu.ouc.netbase;

import java.util.Scanner;

/**
 * С�׾���������������Ϸ.��һ��,������һ�������������Ϸ,���Ľ�ɫ�ĳ�ʼ����ֵΪ a.
 * �ڽ�������һ��ʱ����,��������������n������,ÿ������ķ�����Ϊb1,b2,b3...bn. 
 * ��������Ĺ��������biС�ڵ���С�׵ĵ�ǰ����ֵc,��ô���������ɴ�ܹ���,
 * �� ��ʹ���Լ�������ֵ����bi;���bi����c,����Ҳ�ܴ�ܹ���,����������ֵֻ������bi ��c�����Լ��.
 * ��ô��������,��һϵ�еĶ�����,С�׵���������ֵΪ����?

��������:

����ÿ������,��һ������������n(1��n<100000)��ʾ�����������a��ʾС�׵ĳ�ʼ����ֵ.
�ڶ���n������,b1,b2...bn(1��bi��n)��ʾÿ������ķ�����


�������:

����ÿ������,���һ��.ÿ�н�����һ������,��ʾС�׵���������ֵ


��������:

3 50
50 105 200
5 20
30 20 15 40 100


�������:

110
205
 * @author wqx
 *
 */
public class Boss {
	public static void main(String args[]){
		Scanner in = new Scanner(System.in);
		while(in.hasNext()){
			int n = in.nextInt();
			int power = in.nextInt();
			int exp = 0;
			for(int i = 0; i < n; i++){
				int defanseV = in.nextInt();
				if(power >= defanseV){
					power += defanseV;
				}else{
					power += gcd(power,defanseV);
				}
			}
			System.out.println(power);
		}
	}
	public static int gcd(int a,int b){
		int max = a > b ?a:b;
		int min = a > b ?b:a;
		while(min!=0){
			int t = max%min;
			max = min;
			min = t;
		}
		return max;
	}
}
