package edu.ouc.netbase;

import java.util.Scanner;

/**
 * ��N*M�Ĳݵ���,��Ī����K��Ģ��,Ģ����ը����������,��������óȻȥ��,
 * ����Ģ�������ε�.ֻ ��һ�ֽ���ɨ��͸������Ʒ����ɨ������ε�Ģ��,
 * ����������һ��ս��ѧԺ,����2��ɨ��͸��,һ�� ɨ��͸������ɨ���(3*3)���������е�Ģ��,
 * Ȼ�������Ϳ��������һЩ���ε�Ģ��. ��:����������������ٸ�Ģ��?

��������:

��һ����������:N,M,K,(1��N,M��20,K��100),N,M�����˲ݵصĴ�С;
������K��,ÿ����������x,y(1��x��N,1��y��M).����(x,y)����Ī����һ��Ģ��.
һ����������������Ģ��.

�������:

���һ��,����һ�����һ������,��������������������ٸ�Ģ��.

 * @author wqx
 *
 */
public class Mushroom {
	public static void main(String args[]){
		Scanner in = new Scanner(System.in);

		int N = in.nextInt();
		int M = in.nextInt();
		int K = in.nextInt();
		int[][] map = new int[N+1][M+1];
		for(int i = 0; i < K;i++){
			int x = in.nextInt();
			int y = in.nextInt();
			map[x][y]++;
		}
		int mushroomV = 0;
		if(N <= 3 && M <= 3){
			for(int i = 1; i <= N ;i++){
				for(int j = 1; j <= M;j++){
					mushroomV += map[i][j];
				}
			}
			System.out.println(mushroomV);
		}else if(N > 3 && M < 3){
			
		}
		
		int power = in.nextInt();
	}
}
