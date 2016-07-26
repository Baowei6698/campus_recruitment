package edu.ouc.offer;

import java.util.Arrays;

/**
 * 每年六一儿童节,NowCoder都会准备一些小礼物去看望孤儿院的小朋友,今年亦是如此。
 * HF作为NowCoder的资深元老,自然也准备了一些小游戏。
 * 其中,有个游戏是这样的:
 * 	     首先,让小朋友们围成一个大圈。然后,他随机指定一个数m,让编号为0的小朋友开始报数。
 * 每次喊到m的那个小朋友要出列唱首歌,然后可以在礼品箱中任意的挑选礼物,并且不再回到圈中,
 * 从他的下一个小朋友开始,继续0...m-1报数....这样下去....直到剩下最后一个小朋友,可以不用表演,
 * 并且拿到NowCoder名贵的“名侦探柯南”典藏版(名额有限哦!!^_^)。请你试着想下,哪个小朋友会得到这份礼品呢？ 
 * 
 * 
 * @author wqx
 *
 */
public class LastRemaining {
	/**
	 * 题目不意思清晰，报数从几开始？
	 * 从1开始报数，报到m出列。返回最后一个同学编号，编号从0到n-1
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
