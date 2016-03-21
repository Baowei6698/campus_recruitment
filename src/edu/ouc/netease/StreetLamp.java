package edu.ouc.netease;

import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.Scanner;

/**
 * һ����l�ı�ֱ�Ľֵ�����n��·�ƣ��������ֵ����Ϊ0���յ�Ϊl����i��·������Ϊai��
 * ÿյ�ƿ��Ը��ǵ�����Զ����Ϊd��Ϊ�������������еƵĵƹ���븲�������֣�
 * ����Ϊ��ʡ�磬Ҫ�����d��С�����ҵ������С��d��

��������:

ÿ�����ݵ�һ����������n��l��n����0С�ڵ���1000��lС�ڵ���1000000000����0����
�ڶ�����n������(�����ڵ���0С�ڵ���l)��Ϊÿյ�Ƶ����꣬���·�ƿ�����ͬһ�㡣

�������:

����𰸣�������λС����


��������:

7 15
15 5 3 7 9 14 0


�������:

2.5

 * @author wqx
 *
 */
public class StreetLamp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		while(s.hasNext()){
			int n = s.nextInt();
			int l = s.nextInt();
			int arr[] = new int[n];
			for(int i = 0; i < n; i++){
				arr[i] = s.nextInt();
			}
			Arrays.sort(arr);
			long maxGap = Math.max(arr[0],l-arr[n-1])*2;
			for(int i = 0; i < n-1; i++){
				if(arr[i+1]-arr[i] > maxGap){
					maxGap = arr[i+1]-arr[i];
				}
			}
			DecimalFormat b = new DecimalFormat("#.00");
			String result = b.format(maxGap/2.0);
			System.out.println(result);
		}
		s.close();
	}
}
