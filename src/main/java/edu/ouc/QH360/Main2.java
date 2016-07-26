package edu.ouc.QH360;

import java.util.Scanner;

/**
 * Problem Description:
 * 
为考验各自的数学能力，小B和小A经常在一起玩各种数值游戏，这一次他们又有了一种新玩法。每人从指定的数值范围中各自选择一个整数，
记小A选择的数值为a，小B选择的数值为b。他们用一个均匀分布的随机数发生器在该数值范围中随机生成一个整数c，
定义制胜的游戏规则为谁选的数离c近则谁取得胜利。由于小B是女生，特别定义当两人的数与c之间的差值相等时，小B获胜。

由于先前的游戏中，小A为表现绅士风度总是输多赢少，因此他特别渴望这次能够给小B比较深刻的映像，所以向你求助。
你事先已经知道了小B所选的数值和指定的数值范围，小A希望你帮他选择一个数值使得他获胜的概率最大。

输入
输入有若干行，每行为一组数据，包含两个正整数n和b，分别表示数值范围和小B所需的数，其中1<=b<=n<=10^9

输出
对每组输入，在单独的行中输出一个数，为小A所选的数，使得小A获胜的概率最大。若存在多个这样的数，则输出最小的那个

样例输入
3 1
4 3
样例输出
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
