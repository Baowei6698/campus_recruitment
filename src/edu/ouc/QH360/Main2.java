package edu.ouc.QH360;

import java.util.Scanner;

/**
 * Problem Description:
 * 
Ϊ������Ե���ѧ������СB��СA������һ���������ֵ��Ϸ����һ������������һ�����淨��ÿ�˴�ָ������ֵ��Χ�и���ѡ��һ��������
��СAѡ�����ֵΪa��СBѡ�����ֵΪb��������һ�����ȷֲ���������������ڸ���ֵ��Χ���������һ������c��
������ʤ����Ϸ����Ϊ˭ѡ������c����˭ȡ��ʤ��������СB��Ů�����ر��嵱���˵�����c֮��Ĳ�ֵ���ʱ��СB��ʤ��

������ǰ����Ϸ�У�СAΪ������ʿ����������Ӯ�٣�������ر��������ܹ���СB�Ƚ���̵�ӳ����������������
�������Ѿ�֪����СB��ѡ����ֵ��ָ������ֵ��Χ��СAϣ�������ѡ��һ����ֵʹ������ʤ�ĸ������

����
�����������У�ÿ��Ϊһ�����ݣ���������������n��b���ֱ��ʾ��ֵ��Χ��СB�������������1<=b<=n<=10^9

���
��ÿ�����룬�ڵ������������һ������ΪСA��ѡ������ʹ��СA��ʤ�ĸ�����������ڶ�������������������С���Ǹ�

��������
3 1
4 3
�������
2
2

 * @author wqx
 *
 */
public class Main2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		int n,b;
		while(in.hasNext()){
			n = in.nextInt();
			b = in.nextInt();
			if(b == 1 && n == 1){
                System.out.println(1);
				continue;
            }
			
			if(b <= n/2 ){
				System.out.println(b+1);
				continue;
			}
			if(b > n/2){
				System.out.println(b-1);
				continue;
			}

		}
	}
}
